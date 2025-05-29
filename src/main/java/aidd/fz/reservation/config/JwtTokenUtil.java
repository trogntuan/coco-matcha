package aidd.fz.reservation.config;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtTokenUtil {

    public static Integer getEmployeeIdFromAccessToken(JwtAuthenticationToken authentication) {
        Jwt jwt = authentication.getToken();
        return jwt.getClaim("employee_id"); // Assuming the JWT contains an employee_id claim
    }
}
