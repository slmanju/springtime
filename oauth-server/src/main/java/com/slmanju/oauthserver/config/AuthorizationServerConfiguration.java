package com.slmanju.oauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final TokenStore tokenStore;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;

    @Autowired
    public AuthorizationServerConfiguration(TokenStore tokenStore, AuthenticationManager authenticationManager, PasswordEncoder encoder) {
        this.tokenStore = tokenStore;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer
                .inMemory()
                .withClient("manjula")
                .secret(encoder.encode("manjula"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(60 * 60)
                .refreshTokenValiditySeconds(60 * 60);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
    }

}
