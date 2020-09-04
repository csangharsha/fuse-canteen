package np.com.csangharsha.fusecanteen.domains.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    List<User> toEntity(Iterable<UserDto> dtoList);

    List<UserDto> toDto(Iterable<User> entityList);

}
