package np.com.csangharsha.fusecanteen.auth.service;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.auth.models.UserPrincipal;
import np.com.csangharsha.fusecanteen.domains.user.User;
import np.com.csangharsha.fusecanteen.domains.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuseCanteenUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Email doesn't exists")
        );
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User doesn't exists")
        );
        return UserPrincipal.create(user);
    }
}
