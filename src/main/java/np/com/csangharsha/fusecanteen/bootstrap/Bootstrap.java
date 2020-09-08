package np.com.csangharsha.fusecanteen.bootstrap;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategory;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategoryRepository;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemRepository;
import np.com.csangharsha.fusecanteen.domains.role.Role;
import np.com.csangharsha.fusecanteen.domains.role.RoleRepository;
import np.com.csangharsha.fusecanteen.domains.today_menu.TodayMenu;
import np.com.csangharsha.fusecanteen.domains.today_menu.TodayMenuId;
import np.com.csangharsha.fusecanteen.domains.today_menu.TodayMenuRepository;
import np.com.csangharsha.fusecanteen.domains.user.User;
import np.com.csangharsha.fusecanteen.domains.user.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemRepository menuItemRepository;

    private final TodayMenuRepository todayMenuRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        initUserAndRole();
        initMenuCategoryAndItem();
        initTodayMenu();

    }

    private void initTodayMenu() {
        // Add Today's Menu
        TodayMenu menu1 = new TodayMenu();
        TodayMenuId menuId1 = new TodayMenuId();
        menuId1.setTodayDate(LocalDate.now());
        menuId1.setMenuItemId(1L);
        menu1.setTodayMenuId(menuId1);
        menu1.setMenuItem(menuItemRepository.getOne(1L));
        todayMenuRepository.save(menu1);

        TodayMenu menu2 = new TodayMenu();
        TodayMenuId menuId2 = new TodayMenuId();
        menuId2.setTodayDate(LocalDate.now());
        menuId2.setMenuItemId(4L);
        menu2.setTodayMenuId(menuId2);
        menu2.setMenuItem(menuItemRepository.getOne(4L));
        todayMenuRepository.save(menu2);

        // Add Yesterday's menu
        TodayMenu menu3 = new TodayMenu();
        TodayMenuId menuId3 = new TodayMenuId();
        menuId3.setTodayDate(LocalDate.now().minusDays(1));
        menuId3.setMenuItemId(5L);
        menu3.setTodayMenuId(menuId3);
        menu3.setMenuItem(menuItemRepository.getOne(5L));
        todayMenuRepository.save(menu3);
    }

    private void initMenuCategoryAndItem() {
        // save menu Category
        MenuCategory momo = new MenuCategory();
        momo.setId(1L);
        momo.setName("Mo:Mo:");
        menuCategoryRepository.save(momo);

        MenuCategory chowmein = new MenuCategory();
        chowmein.setId(2L);
        chowmein.setName("Chowmein");
        menuCategoryRepository.save(chowmein);

        // save menu Item
        MenuItem vegMomo = new MenuItem();
        vegMomo.setId(1L);
        vegMomo.setName("Veg. Mo:Mo:");
        vegMomo.setPrice(80.0);
        vegMomo.setMenuCategory(momo);
        menuItemRepository.save(vegMomo);

        MenuItem chickenMomo = new MenuItem();
        chickenMomo.setId(2L);
        chickenMomo.setName("Chicken Mo:Mo:");
        chickenMomo.setPrice(120.0);
        chickenMomo.setMenuCategory(momo);
        menuItemRepository.save(chickenMomo);

        MenuItem buffMomo = new MenuItem();
        buffMomo.setId(3L);
        buffMomo.setName("Buff Mo:Mo:");
        buffMomo.setPrice(100.0);
        buffMomo.setMenuCategory(momo);
        menuItemRepository.save(buffMomo);

        MenuItem vegChowmein = new MenuItem();
        vegChowmein.setId(4L);
        vegChowmein.setName("Veg. Chowmein");
        vegChowmein.setPrice(90.0);
        vegChowmein.setMenuCategory(chowmein);
        menuItemRepository.save(vegChowmein);

        MenuItem chickenChowmein = new MenuItem();
        chickenChowmein.setId(5L);
        chickenChowmein.setName("Chicken Chowmein");
        chickenChowmein.setPrice(100.0);
        chickenChowmein.setMenuCategory(chowmein);
        menuItemRepository.save(chickenChowmein);
    }

    private void initUserAndRole() {
        // save roles
        Role adminRole = new Role("ROLE_ADMIN");
        Role employeeRole = new Role("ROLE_EMPLOYEE");

        // save admin user
        User admin = new User("Canteen Admin", "admin@fusecanteen.com", passwordEncoder.encode("Nepal@123"));
        admin.getRoles().add(adminRole);

        User employee = new User("Sangharsha Chaulagain", "schaulagain@fusecanteen.com", passwordEncoder.encode("Nepal@123"));
        employee.getRoles().add(employeeRole);

        roleRepository.save(adminRole);
        roleRepository.save(employeeRole);
        userRepository.save(admin);
        userRepository.save(employee);
    }

}
