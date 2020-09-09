package np.com.csangharsha.fusecanteen.domains.order_item.projections;

import lombok.Data;
import lombok.NoArgsConstructor;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;

@Data
@NoArgsConstructor
public class PopularPendingOrderItem {

    private MenuItem menuItem;
    private Long totalOrder;

    public PopularPendingOrderItem(MenuItem menuItem, Long totalOrder) {
        this.menuItem = menuItem;
        this.totalOrder = totalOrder;
    }
}
