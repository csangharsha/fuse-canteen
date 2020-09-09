package np.com.csangharsha.fusecanteen.domains.order_item.projections;

import lombok.Data;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemDto;

@Data
public class PopularPendingOrderItemDto {

    private MenuItemDto menuItem;
    private Long totalOrder;

}
