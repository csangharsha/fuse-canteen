package np.com.csangharsha.fusecanteen.auth.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.auth.models.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.accessToken.secretKey}")
    private String accessTokenSecretKey;

    public String generateAccessToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .signWith(SignatureAlgorithm.HS512, accessTokenSecretKey)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(accessTokenSecretKey)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateAccessToken(String accessToken)
            throws SignatureException, MalformedJwtException, ExpiredJwtException, UnsupportedOperationException, IllegalArgumentException {
        Jwts.parser().setSigningKey(accessTokenSecretKey).parseClaimsJws(accessToken);
        return true;
    }
}
