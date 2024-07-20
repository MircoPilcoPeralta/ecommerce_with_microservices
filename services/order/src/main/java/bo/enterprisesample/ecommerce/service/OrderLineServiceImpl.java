package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.repository.IOrderLineRepository;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements IOrderLineService {

    private final IOrderLineRepository repository;
    private final IOrderMapper orderMapper;

    @Override
    public OrderLine createOrderLine(OrderLineRequest request) {
        OrderLine orderLine = orderMapper.toOrderLine(request);
        return repository.save(orderLine);
    }
}
