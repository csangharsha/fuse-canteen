package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItem;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Set<OrderItem> saveAll(Set<OrderItem> orderItems) {
        return new HashSet<>(repository.saveAll(orderItems));
    }

    @Override
    public List<PopularPendingOrderItem> getPopularPendingOrderItem() {
        return repository.getPopularPendingOrderItem();
    }
}
