package np.com.csangharsha.fusecanteen.domains.user;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {

}
