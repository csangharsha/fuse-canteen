package np.com.csangharsha.fusecanteen.auth.models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;

    private String password;

}
