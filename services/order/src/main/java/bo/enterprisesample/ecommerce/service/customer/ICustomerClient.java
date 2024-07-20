package bo.enterprisesample.ecommerce.service.customer;

import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface ICustomerClient {
    @GetMapping("/{customer-id}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("customer-id") String customerId);
}
