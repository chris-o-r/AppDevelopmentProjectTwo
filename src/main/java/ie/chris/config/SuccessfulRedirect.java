package ie.chris.config;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessfulRedirect extends SimpleUrlAuthenticationSuccessHandler 
implements AuthenticationSuccessHandler {

	public void RefererRedirectionAuthenticationSuccessHandler() {
		setUseReferer(true);
	}
}

