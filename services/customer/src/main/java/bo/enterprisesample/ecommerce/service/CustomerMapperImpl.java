package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.request.CreateCustomerRequest;
import bo.enterprisesample.ecommerce.domain.entities.Customer;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements ICustomerMapper {
    @Override
    public Customer toCustomer(CreateCustomerRequest request) {
        if (request == null) return null;
        return Customer
                .builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
        }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if(customer == null) return null;
        return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAddress());
    }
}
