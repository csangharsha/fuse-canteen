package np.com.csangharsha.fusecanteen.domains.user;

import np.com.csangharsha.fusecanteen.base.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findUserByEmail(String email);

}
