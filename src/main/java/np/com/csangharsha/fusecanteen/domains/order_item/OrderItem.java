package np.com.csangharsha.fusecanteen.domains.order_item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.csangharsha.fusecanteen.base.BaseEntity;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;
import np.com.csangharsha.fusecanteen.domains.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Setter
@Getter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @Column(name = "quantity")
    private Double quantity;

}
