package np.com.csangharsha.fusecanteen.auth.models;

import lombok.Data;
import np.com.csangharsha.fusecanteen.domains.user.UserDto;

@Data
public class AuthenticationResponse {

    private String accessToken;

    private UserDto user;

    public AuthenticationResponse(String accessToken, UserDto user) {
        this.accessToken = accessToken;
        this.user = user;
    }

}
