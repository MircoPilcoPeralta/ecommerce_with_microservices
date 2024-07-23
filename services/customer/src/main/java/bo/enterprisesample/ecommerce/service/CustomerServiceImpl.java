package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entities.Customer;
import bo.enterprisesample.ecommerce.domain.exceptions.CustomerNotFoundException;
import bo.enterprisesample.ecommerce.domain.repository.CustomerRepository;
import bo.enterprisesample.ecommerce.domain.request.CreateCustomerRequest;
import bo.enterprisesample.ecommerce.domain.request.EditCustomerRequest;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository repository;
    private final ICustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, ICustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = repository.save(mapper.toCustomer(request));
        return mapper.toCustomerResponse(customer);
    }

    @Override
    public void updateCustomer(EditCustomerRequest request) {
        Customer customer = repository.findById(request.id()).orElseThrow(()-> new CustomerNotFoundException(
                String.format("Cannot update customer with id %s", request.id())
        ));
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String id) {
        return repository.findById(id).isPresent();
    }

    @Override
    public CustomerResponse findById(String id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot update customer with id %s", id)
        ));
        return mapper.toCustomerResponse(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        repository.deleteById(id);
    }

    private void mergeCustomer(Customer customer, EditCustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstname(request.firstName());
        }
        if(StringUtils.isNotBlank(request.firstName())) {
            customer.setLastname(request.firstName());
        }
        if(StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}
