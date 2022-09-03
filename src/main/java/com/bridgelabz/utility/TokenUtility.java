package com.bridgelabz.utility;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;

@Component
public class TokenUtility {
	
	private static final String TOKEN_SECRET = "Arun";
	
	
	public String createToken(Long id) {
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		String token = JWT.create().withClaim("id", id).sign(algorithm);
		return token;
	}
	
	public Long decodeToken(String token) {
		Long id;
		Verification verification = null;
		verification =JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
		JWTVerifier jwtVerifier = verification.build();
		DecodedJWT decodedJWT = jwtVerifier.verify(token);
		Claim claim = decodedJWT.getClaim("id");
		id =claim.asLong();
		return id;
	}  

}
