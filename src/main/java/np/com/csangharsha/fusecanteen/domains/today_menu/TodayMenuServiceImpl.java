package np.com.csangharsha.fusecanteen.domains.today_menu;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodayMenuServiceImpl implements TodayMenuService {

    private final TodayMenuRepository repository;

    public TodayMenuServiceImpl(TodayMenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodayMenu save(TodayMenu todayMenu) {
        return repository.save(todayMenu);
    }

    @Override
    public List<TodayMenu> getTodayMenu() {
        return repository.getAllByTodayMenuId_TodayDate(LocalDate.now());
    }

    @Override
    public void delete(TodayMenu todayMenu) {
        repository.delete(todayMenu);
    }
}
