package np.com.csangharsha.fusecanteen.auth;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.auth.jwt.JwtTokenProvider;
import np.com.csangharsha.fusecanteen.auth.models.AuthenticationRequest;
import np.com.csangharsha.fusecanteen.auth.models.AuthenticationResponse;
import np.com.csangharsha.fusecanteen.auth.models.UserPrincipal;
import np.com.csangharsha.fusecanteen.base.BaseResource;
import np.com.csangharsha.fusecanteen.domains.user.User;
import np.com.csangharsha.fusecanteen.domains.user.UserMapper;
import np.com.csangharsha.fusecanteen.domains.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseResource.BASE_URL + AuthResource.BASE_URL)
public class AuthResource {

    public static final String BASE_URL = "/auth";

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserMapper userMapper;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = "Bearer " + jwtTokenProvider.generateAccessToken(authentication);

        User user = userRepository.findUserByEmail(((UserPrincipal) authentication.getPrincipal()).getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));

        return ResponseEntity.ok().body(new AuthenticationResponse(accessToken, userMapper.toDto(user)));
    }
}
