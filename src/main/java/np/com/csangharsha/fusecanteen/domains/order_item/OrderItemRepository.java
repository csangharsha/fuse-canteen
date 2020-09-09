package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseRepository;
import np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends BaseRepository<OrderItem> {

    @Query(value = "SELECT " +
            "new np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItem(oi.menuItem, SUM(oi.quantity)) " +
            "from OrderItem oi " +
            "LEFT JOIN oi.order o " +
            "WHERE o.status = 'PENDING' " +
            "GROUP BY oi.menuItem " +
            "ORDER BY SUM(oi.quantity) DESC")
    List<PopularPendingOrderItem> getPopularPendingOrderItem();

}
