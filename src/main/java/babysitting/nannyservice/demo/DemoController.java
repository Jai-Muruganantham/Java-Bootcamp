package babysitting.nannyservice.demo;

import babysitting.nannyservice.config.CustomUserDetailsService;
import babysitting.nannyservice.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import babysitting.nannyservice.config.JwtService;


@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
  private final CustomUserDetailsService userDetailsService;
  private final UserRepository userRepository;

  public DemoController(CustomUserDetailsService userDetailsService, UserRepository userRepository) {
    this.userDetailsService = userDetailsService;
    this.userRepository = userRepository;
  }

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

  @GetMapping("/secure-endpoint")
  @Operation(summary = "Secure endpoint", description = "Returns a secure message")
  public ResponseEntity<String> secureEndpoint(
          @Parameter(
                  name = "Authorization",
                  description = "JWT token for authorization",
                  required = true,
                  in = ParameterIn.HEADER,
                  schema = @Schema(type = "string", format = "JWT")
          ) @RequestHeader("Authorization") String authorizationHeader) {

    JwtService jwtService = new JwtService();
    CustomUserDetailsService userDetailsService = new CustomUserDetailsService(userRepository);

    // Extract the username from the authorization header
    String username = jwtService.extractUsername(authorizationHeader);

    // Load the UserDetails object for the given username
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

    // Check if the authorization header is present and contains a valid JWT token
    if (!jwtService.isTokenValid(authorizationHeader, userDetails)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // Return the HTML page as a string
    String htmlPage = "<html><body><h1>Welcome to the secure endpoint!</h1></body></html>";
    return ResponseEntity.ok(htmlPage);
  }
}
