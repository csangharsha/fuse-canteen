package np.com.csangharsha.fusecanteen.domains.menu_category;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuCategoryMapper extends BaseMapper<MenuCategoryDto, MenuCategory> {
}
