package np.com.csangharsha.fusecanteen.domains.today_menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Embeddable
public class TodayMenuId implements Serializable {
    @Column(name = "menu_item_id")
    private Long menuItemId;

    @Column(name = "today_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate todayDate;
}
