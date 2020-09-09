package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {

    @Query(value = "SELECT o FROM Order o WHERE o.orderDate < :time AND o.orderBy.id = :userId")
    List<Order> getOrderHistory(@Param("time") LocalDateTime time, @Param("userId") Long userId);

    List<Order> getAllByStatusAndOrderBy_Id(OrderStatus status, Long userId);

}
