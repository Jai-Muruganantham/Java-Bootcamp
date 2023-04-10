//package babysitting.nannyservice.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.catalina.UserDatabase;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import java.io.IOException;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//
//@Component
//public class JwtAthFilter extends OncePerRequestFilter {
//    private final UserDetailsService userDetailsService;
//
//    public JwtAthFilter(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request
//            , HttpServletResponse response
//            , FilterChain filterChain) throws ServletException, IOException {
//
//        final String authHeader= request.getHeader(AUTHORIZATION);
//        final String userEmail;
//        final String jwtToken;
//        if(authHeader==null || !authHeader.startsWith("Bearer"))
//        {
//            filterChain.doFilter(request,response);
//            return;
//        }
//        jwtToken = authHeader.substring(7);
//        userEmail = "something";// TODO to be implemented;
//        if(userEmail!= null && SecurityContextHolder.getContext().getAuthentication()==null)
//        {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//            // rest of your code
//        }
//
//    }
//}
//
//
