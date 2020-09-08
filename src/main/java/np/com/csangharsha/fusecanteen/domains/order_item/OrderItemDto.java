package np.com.csangharsha.fusecanteen.domains.order_item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import np.com.csangharsha.fusecanteen.base.BaseDto;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderItemDto extends BaseDto {

    private Long orderId;

    private MenuItemDto menuItem;

    private Double quantity;
}
