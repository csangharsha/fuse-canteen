package np.com.csangharsha.fusecanteen.domains.menu_category;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.csangharsha.fusecanteen.base.BaseEntity;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu_category")
@Setter
@Getter
@NoArgsConstructor
public class MenuCategory extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "menuCategory")
    private Set<MenuItem> menuItem = new HashSet<>();

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "added_date", updatable = false)
    private LocalDateTime addedDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

}
