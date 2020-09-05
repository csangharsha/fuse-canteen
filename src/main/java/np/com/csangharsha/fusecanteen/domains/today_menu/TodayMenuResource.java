package np.com.csangharsha.fusecanteen.domains.today_menu;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(BaseResource.BASE_URL + TodayMenuResource.BASE_URL )
public class TodayMenuResource {

    public static final String BASE_URL = "/today-menu";

    private final TodayMenuService service;
    private final TodayMenuMapper mapper;

    public TodayMenuResource(TodayMenuService service, TodayMenuMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Iterable<TodayMenuDto>> getTodayMenu() {
        List<TodayMenu> todayMenus = service.getTodayMenu();
        return ResponseEntity.ok().body(mapper.toDto(todayMenus));
    }

    @PostMapping
    public ResponseEntity<TodayMenuDto> create(@RequestBody TodayMenuDto todayMenuDto) throws URISyntaxException {
        if (todayMenuDto.getMenuItem() == null || todayMenuDto.getTodayDate() == null) {
            return ResponseEntity.badRequest().build();
        }
        TodayMenu todayMenu = service.save(mapper.toEntity(todayMenuDto));
        return ResponseEntity
                .created(new URI(BASE_URL + "/" + todayMenu.getMenuItem().getId()))
                .body(mapper.toDto(todayMenu));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody TodayMenuDto todayMenuDto) {
        if (todayMenuDto.getMenuItem() == null || todayMenuDto.getTodayDate() == null) {
            return ResponseEntity.badRequest().build();
        }
        service.delete(mapper.toEntity(todayMenuDto));
        return ResponseEntity.ok().build();
    }

}
