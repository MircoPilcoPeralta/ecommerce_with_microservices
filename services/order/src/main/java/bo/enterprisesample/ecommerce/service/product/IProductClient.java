package bo.enterprisesample.ecommerce.service.product;

import bo.enterprisesample.ecommerce.domain.request.PurchaseRequest;
import bo.enterprisesample.ecommerce.domain.response.PurchaseResponse;

import java.util.List;

public interface IProductClient {

    List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requests);

}
