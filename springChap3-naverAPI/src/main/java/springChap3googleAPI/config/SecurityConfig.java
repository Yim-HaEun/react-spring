package springChap3googleAPI.config;
//네이버 인증
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(authorizeHttpRequests ->
			authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			
			.oauth2Login(oauth2Login ->
			oauth2Login
				.successHandler(new SimpleUrlAuthenticationSuccessHandler("/loginSuccess")));
		return http.build();
	}
	//인증 통합 관리하는 매니저
		@Bean
		//클라이언트 인증 처리
		public OAuth2AuthorizedClientManager authorizedClientManager(
				ClientRegistrationRepository clientRegistrationRepository,
				OAuth2AuthorizedClientRepository authorizedClientRepository) {
			OAuth2AuthorizedClientProvider authorizedClientProvider = 
					OAuth2AuthorizedClientProviderBuilder.builder().authorizationCode().build();
			//클라이언트 등록정보와 인증된 클라이언트 저장소를 설정
			DefaultOAuth2AuthorizedClientManager authorizedClientManager = 
					new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository);
			authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
			
			return authorizedClientManager;
		}
		
	//추후 네이버 등록한 정보를 저장 
	@Bean
	//네이버 클라이언트의 등록 정보를 생성하는 메서드
	//클라이언트 아이디와 시크릿, 인증 후 리다이렉트 URI 설정
	//네이버에서 인증하고나서 OAuth2 엔드포인트 설정 
	public ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(
				naverClientRegistration(),
				googleClientRegistration());
	}
	public ClientRegistration naverClientRegistration() {
		return ClientRegistration.withRegistrationId("naver")
				.clientId("Q3WSpVdBuFM0nXY5aruN")
				/*.clientId("https://developers.naver.com/apps/#/myapps/ 에 적혀있는 네이버 Client ID 가져오기")*/
				.clientSecret("a1__UNFOsV")
				
				//네이버에서 인증하고나서 OAuth2 엔드포인트 설정 
				.redirectUri("http://localhost:8080/login/oauth2/code/naver")
				.clientName("Naver")
				.authorizationUri("https://nid.naver.com/oauth2.0/authorize")
				.tokenUri("https://nid.naver.com/oauth2.0/token")
				.userInfoUri("https://openapi.naver.com/v1/nid/me")
				.userNameAttributeName("response")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.build();
	}
	@Bean
	//구글 클라이언트의 등록 정보를 생성하는 메서드
	//클라이언트 아이디와 시크릿, 인증 후 리다이렉트 URI 설정
	//구글에서 인증하고나서 OAuth2 엔드포인트 설정 
	
	public ClientRegistration googleClientRegistration() {
		return ClientRegistration.withRegistrationId("google")
				.clientId("930485580425-renfk67vufsnvr2bq2ht4vjclr8vebio.apps.googleusercontent.com")
				/*.clientId("구글 Client ID 가져오기")*/
				.clientSecret("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")
				
				//구글에서 인증하고나서 OAuth2 엔드포인트 설정 
				.redirectUri("http://localhost:8080/login/oauth2/code/google")
				.clientName("Google")
				.authorizationUri("https://accounts.google.com/o/oauth2/auth")
				.tokenUri("https://www.googleapis.com/oauth2/v4/token")
				.userInfoUri("https://www.googleapis.com.oauth2/v3/userinfo")
				.userNameAttributeName("sub")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.scope("openid","profile","email")
				.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
				.build();
	}
	

}
