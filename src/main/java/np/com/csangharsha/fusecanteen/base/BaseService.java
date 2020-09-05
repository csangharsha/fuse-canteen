package np.com.csangharsha.fusecanteen.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T save(T t);

    T update(T t);

    List<T> findAll();

    Optional<T> findOne(Long id);

    void delete(Long id);

}
