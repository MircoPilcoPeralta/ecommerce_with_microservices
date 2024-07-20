package bo.enterprisesample.ecommerce.service.product;

import bo.enterprisesample.ecommerce.domain.exception.BusinessException;
import bo.enterprisesample.ecommerce.domain.request.PurchaseRequest;
import bo.enterprisesample.ecommerce.domain.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClientImpl implements IProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requests) {
        // Create the request
        // Define Headers content type
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        // Define body to send
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requests, headers);

        // define the response expected
        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};

        // exchange data
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );

        if( responseEntity.getStatusCode().isError()) {
            throw new BusinessException(" An error occured while trying to retrieve the list of purchases "
                    + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }
}
