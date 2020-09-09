package np.com.csangharsha.fusecanteen.domains.menu_item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.csangharsha.fusecanteen.base.BaseEntity;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_item")
@Setter
@Getter
@NoArgsConstructor
public class MenuItem extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menu_category_id")
    private MenuCategory menuCategory;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "added_date", updatable = false)
    private LocalDateTime addedDate;


    @UpdateTimestamp
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

}
