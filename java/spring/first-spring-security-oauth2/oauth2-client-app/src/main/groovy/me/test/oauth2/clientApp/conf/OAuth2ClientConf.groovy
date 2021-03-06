package me.test.oauth2.clientApp.conf

import me.test.oauth2.common.MyOAuth2Properties

//import me.test.oauth2.client.MyOAuth2Properties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.OAuth2ClientContext
import org.springframework.security.oauth2.client.OAuth2RestTemplate
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails
import org.springframework.security.oauth2.client.token.AccessTokenProvider
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client
import org.springframework.security.oauth2.http.converter.FormOAuth2AccessTokenMessageConverter
import org.springframework.security.oauth2.http.converter.FormOAuth2ExceptionHttpMessageConverter
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate

/**
 *
 */
@Configuration
@EnableOAuth2Client
public class OAuth2ClientConf {

    @Autowired
    private MyOAuth2Properties myOAuth2Props

    @Bean
    MyOAuth2Properties myOAuth2Properties() {
        return new MyOAuth2Properties()
    }

    // ---------------------------------------------  OAuth2 : authorization code

    @Bean
    public OAuth2ProtectedResourceDetails oAuthCodeResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("RSC_ID_rsc_server");

        details.setClientId("CLIENT_ID_client_app");
        details.setClientSecret("CLIENT_PWD_client_app");
        details.setScope(["read"]);

        details.setAccessTokenUri("http://a.localhost:10001/oauth/token");
        details.setUserAuthorizationUri("http://a.localhost:10001/oauth/authorize");

        return details;
    }

    @Bean
    public OAuth2RestTemplate oAuthCodeRestTemplate(OAuth2ClientContext clientContext,
                                                    AccessTokenProvider accessTokenProvider) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oAuthCodeResourceDetails(), clientContext);
        restTemplate.setAccessTokenProvider(accessTokenProvider)
        return restTemplate;
    }

    // ---------------------------------------------  OAuth2 : implicit

    // 注意：OAuth2 implicit 主要用于运行再浏览器内的应用，或 native 应用
    // 请参考 ImplicitAccessTokenProvider 的java注释
    // 分析 ImplicitResponseExtractor 代码可以看到其通过 URI#getFragment() 来解析 AT
    @Bean
    public OAuth2ProtectedResourceDetails oImplicitResourceDetails() {
        ImplicitResourceDetails details = new ImplicitResourceDetails();
        details.setId("RSC_ID_rsc_server");

        details.setClientId("CLIENT_ID_client_app");
        details.setClientSecret("CLIENT_PWD_client_app");
        details.setScope(["read"]);

        details.setAccessTokenUri("http://a.localhost:10001/oauth/token");
        details.setUserAuthorizationUri("http://a.localhost:10001/oauth/authorize");

        details.setPreEstablishedRedirectUri("http://c.localhost:10003/implicit.html")
        return details;
    }

    @Bean
    public OAuth2RestTemplate oImplicitRestTemplate(OAuth2ClientContext clientContext,
                                                    AccessTokenProvider accessTokenProvider) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oImplicitResourceDetails(), clientContext);
        restTemplate.setAccessTokenProvider(accessTokenProvider)
        return restTemplate;
    }

    // ---------------------------------------------  OAuth2 : client

    @Bean
    public OAuth2ProtectedResourceDetails oPasswordResourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();

        details.setId("RSC_ID_rsc_server");

        details.setClientId("CLIENT_ID_client_app");
        details.setClientSecret("CLIENT_PWD_client_app");
        details.setScope(["read"]);

        details.setAccessTokenUri("http://a.localhost:10001/oauth/token");


        return details;
    }

    @Bean
    public OAuth2RestTemplate oPasswordRestTemplate(OAuth2ClientContext clientContext,
                                                    AccessTokenProvider accessTokenProvider) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oPasswordResourceDetails(), clientContext);
        restTemplate.setAccessTokenProvider(accessTokenProvider)
        return restTemplate;
    }

    // ---------------------------------------------  OAuth2 : password

    @Bean
    public OAuth2ProtectedResourceDetails oClientResourceDetails() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();

        details.setId("RSC_ID_rsc_server");

        details.setClientId("CLIENT_ID_client_app");
        details.setClientSecret("CLIENT_PWD_client_app");
        details.setScope(["read"]);

        details.setAccessTokenUri("http://a.localhost:10001/oauth/token");


        details.setUsername("a_admin")
        details.setPassword("a_admin")
        return details;
    }

    @Bean
    public OAuth2RestTemplate oClientRestTemplate(OAuth2ClientContext clientContext,
                                                  AccessTokenProvider accessTokenProvider) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oPasswordResourceDetails(), clientContext);
        restTemplate.setAccessTokenProvider(accessTokenProvider)
        return restTemplate;
    }

    // 以下配置是为了让 OAuth2RestTemplate 使用统一的 RestTemplateBuilder 接口

    @Bean
    FormOAuth2AccessTokenMessageConverter FormOAuth2AccessTokenMessageConverter() {
        return new FormOAuth2AccessTokenMessageConverter();
    }

    @Bean
    FormOAuth2ExceptionHttpMessageConverter FormOAuth2ExceptionHttpMessageConverter() {
        return new FormOAuth2ExceptionHttpMessageConverter();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        return new JwtAccessTokenConverter()
    }

    // FIXME : 公用的话，是否有问题？
    @Bean
    AccessTokenProvider accessTokenProvider(RestTemplateBuilder restTemplateBuilder) {
        return new AccessTokenProviderChain(Arrays.asList(
                new AuthorizationCodeAccessTokenProvider() {
                    @Override
                    protected RestOperations getRestTemplate() {
                        RestTemplate restTemplate = restTemplateBuilder.build();
                        restTemplate.setErrorHandler(getResponseErrorHandler())
                        setMessageConverters(restTemplate.getMessageConverters());
                        return restTemplate
                    }
                },
                new ImplicitAccessTokenProvider(){
                    @Override
                    protected RestOperations getRestTemplate() {
                        RestTemplate restTemplate = restTemplateBuilder.build();
                        restTemplate.setErrorHandler(getResponseErrorHandler())
                        setMessageConverters(restTemplate.getMessageConverters());
                        return restTemplate
                    }
                },
                new ResourceOwnerPasswordAccessTokenProvider(){
                    @Override
                    protected RestOperations getRestTemplate() {
                        RestTemplate restTemplate = restTemplateBuilder.build();
                        restTemplate.setErrorHandler(getResponseErrorHandler())
                        setMessageConverters(restTemplate.getMessageConverters());
                        return restTemplate
                    }
                },
                new ClientCredentialsAccessTokenProvider(){
                    @Override
                    protected RestOperations getRestTemplate() {
                        RestTemplate restTemplate = restTemplateBuilder.build();
                        restTemplate.setErrorHandler(getResponseErrorHandler())
                        setMessageConverters(restTemplate.getMessageConverters());
                        return restTemplate
                    }
                }
        ));
    }

}