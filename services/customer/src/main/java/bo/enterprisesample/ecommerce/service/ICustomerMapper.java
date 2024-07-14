package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.request.CreateCustomerRequest;
import bo.enterprisesample.ecommerce.domain.entities.Customer;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;

public interface ICustomerMapper {
    Customer toCustomer(CreateCustomerRequest request);
    CustomerResponse toCustomerResponse(Customer customer);
}
