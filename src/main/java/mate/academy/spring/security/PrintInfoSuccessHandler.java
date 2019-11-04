package mate.academy.spring.security;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class PrintInfoSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = Logger.getLogger(PrintInfoSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth)
            throws IOException, ServletException {
        String username = auth.getName();
        logger.info("User " + username + " was logged successful with roles: ");
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            System.out.println(authority);
        }
        response.sendRedirect("/");

    }
}
