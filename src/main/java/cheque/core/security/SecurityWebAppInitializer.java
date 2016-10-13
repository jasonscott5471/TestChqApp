package cheque.core.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by finwebmailer on 8/9/2016.
 */

//this is what we need to tell spring security to set up chain filter on all URLS
    //provides preprocessing before allowing to hit resources/controllers/servlets etc

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
}
