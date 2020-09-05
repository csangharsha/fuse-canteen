package np.com.csangharsha.fusecanteen.domains.today_menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodayMenuRepository extends JpaRepository<TodayMenu, TodayMenuId> {

    List<TodayMenu> getAllByTodayMenuId_TodayDate(LocalDate todayDate);

}
