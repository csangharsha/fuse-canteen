package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Order> getOrderHistory(Long userId) {
        return repository.getOrderHistory(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT), userId);
    }

    @Override
    public List<Order> getPendingOrder(Long userId) {
        return repository.getAllByStatusAndOrderBy_Id(OrderStatus.PENDING, userId);
    }
}
