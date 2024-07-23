package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.request.CreateCustomerRequest;
import bo.enterprisesample.ecommerce.domain.request.EditCustomerRequest;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);

    void updateCustomer(EditCustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String id);

    CustomerResponse findById(String id);

    void deleteCustomerById(String id);
}