package cn.jastz.mall.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

/**
 * @author zhiwen
 */
@Configuration
public class Oauth2ClientConfig {


    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public OAuth2ProtectedResourceDetails oauth2ProtectedResourceDetails() {
        return new ResourceOwnerPasswordResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate restTemplate(OAuth2ClientContext oauth2ClientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(oauth2ProtectedResourceDetails(), oauth2ClientContext);
        return template;
    }
}
