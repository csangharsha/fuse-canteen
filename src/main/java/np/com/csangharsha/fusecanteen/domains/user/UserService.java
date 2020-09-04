package np.com.csangharsha.fusecanteen.domains.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User t);

    User update(User t);

    List<User> findAll();

    Optional<User> findOne(Long id);

}
