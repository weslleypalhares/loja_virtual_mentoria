package jdev.mentoria.lojavirtual.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/*Criar a autenticação e retornar tambem a autenticação JWT*/
@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/*TOKEM DE VALIDADE DE 11 DIAS*/
	private static final long EXPIRATION_TIME = 959990000;
	
	/*Chave de senha para juntar com o JWT*/
	private static final String SECRET = "ss/*-*-*-ssjfdguhskfvw-s-*qwdxwxd";

	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Gera o token e da a resposta para o cliente com o JWT*/
	public void addAuthentication(HttpServletResponse response, String username) throws Exception{
		
		/*Montagem do Token*/
		
		String JWT = Jwts.builder()./*Chama o gerador de token*/
				setSubject(username)/*Adiciona o user*/
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) 
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();/*Tempo de expiraçção*/
		
		/*Ex: Bearer *-*ergh*-*bgh-fb**-fg*db-fdgbn*f-dgnb*fdgnbdfg*ndf-n*fd-ndf*n-dfn*/
		String token = TOKEN_PREFIX + " " + JWT;
		
		/*Dá a resposta para a tela e para o cliente, outra API, navegador, aplicativo, javascript, outra chamada java*/
		response.addHeader(HEADER_STRING, token);
		
		/*Usado para ver no Postman para teste*/
		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
	}
	
}
