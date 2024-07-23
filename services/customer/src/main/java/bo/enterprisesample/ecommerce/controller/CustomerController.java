package bo.enterprisesample.ecommerce.controller;

import bo.enterprisesample.ecommerce.domain.request.CreateCustomerRequest;
import bo.enterprisesample.ecommerce.domain.request.EditCustomerRequest;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import bo.enterprisesample.ecommerce.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImpl service;

    public CustomerController(CustomerServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return new ResponseEntity<>(service.findAllCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid EditCustomerRequest request
    ) {
        service.updateCustomer(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> customerExists(
            @PathVariable("customer-id") String id
    ) {
        return ResponseEntity.ok(service.existsById(id));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> getCustomerById(
            @PathVariable("customer-id") String id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer-id") String id) {
        service.deleteCustomerById(id);
        return ResponseEntity.ok().build();

    }

}
