package np.com.csangharsha.fusecanteen.domains.user;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.utils.APIConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(APIConstant.BASE_URL + UserResource.BASE_URL)
@RequiredArgsConstructor
public class UserResource {

    public static final String BASE_URL = "/users";

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(userMapper.toDto(users));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        User user = userMapper.toEntity(userDto);
        user = userService.save(user);
        UserDto newDto = userMapper.toDto(user);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto, @PathVariable Long id) {
        if (dto.getId() == null || !dto.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        User user = userMapper.toEntity(dto);
        user = userService.update(user);
        UserDto newDto = userMapper.toDto(user);
        return ResponseEntity.ok().body(newDto);
    }

}
