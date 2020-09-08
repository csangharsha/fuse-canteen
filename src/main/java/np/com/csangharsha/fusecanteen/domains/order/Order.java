package np.com.csangharsha.fusecanteen.domains.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.csangharsha.fusecanteen.base.BaseEntity;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItem;
import np.com.csangharsha.fusecanteen.domains.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order extends BaseEntity {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_by")
    private User orderBy;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<>();

    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

}
