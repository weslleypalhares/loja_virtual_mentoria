package jdev.mentoria.lojavirtual.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*riar a autenticação e retornar também a autenticação JWT*/
@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/*Token de validade de 11 dias*/
	private static final long EXPIRATION_TIME = 959990000;
	
	/*Chave de senha para juntar com o JWT*/
	private static final String SECRET = "ss/-*-*sds565dsd-s/d-s*dsds";
	
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Gera o token e da a resposta para o cliente com JWT*/
	public void addAuthentication(HttpServletResponse response, String username) throws Exception{
		
		/*Montagem do Token*/
		
		String JWT = Jwts.builder()./*Chama o gerador de token*/
				setSubject(username)/*Adiciona o user*/
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))/*Temp de expiração*/
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		/*Ex: Bearer /g*hdjyfgt4hj4fgh*dj4gh*j7/4gh*f4j/4/4j4ghf*d4/749dj485464djd64jd64 */
		String token = TOKEN_PREFIX + " " + JWT;
		
		/*Dá a resposta pra tela e para o cliente, outra API, navegador, aplicativo, javascript, outra chamada java*/
		response.addHeader(HEADER_STRING, token);
		
		
		/*Usado para ver no Postmam para teste*/
		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
	}

}
