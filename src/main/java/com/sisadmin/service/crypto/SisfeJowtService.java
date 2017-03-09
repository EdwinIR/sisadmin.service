package com.sisadmin.service.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Calendar;

import net.minidev.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.joda.time.Instant;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

@Component
public class SisfeJowtService {
	private static final String ISSUER = "com.cimait.invoicec.portal";
	private static final char[] HEX_CHARS = {'0', '1', '2', '3',
		   '4', '5', '6', '7',
		   '8', '9', 'a', 'b',
		   'c', 'd', 'e', 'f',};	
	
	String singingKey = "y5/ITIn4sP9XADUgPE5mqK/95PrULqCQHqhRxVgHR3k=";
	static String sharedSecret = "y5/ITIn4sP9XADUgPE5mqK/95PrULqCQHqhRxVgHR3k=";
	
	private String secretKey() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[32];
        random.nextBytes(bytes);	        
        String saltAsString = new String(Base64.encodeBase64(bytes));
        return saltAsString;
	}
	
	private String claveSHA256() {
			String passwordUsuario = "secretPassOnlyKnowByUserCimaItPESanBorja";
			String passwordEncriptada = encodeToBase64(asHex(hashSHA1 (passwordUsuario)));
			System.out.println("La password como sera salvada en BD " + passwordEncriptada);
			return passwordEncriptada;
	}		
	
	
	public static String encodeToBase64(String word) { return new String(Base64.encodeBase64(word.getBytes()));	}
	
	public static String decodeFromBase64(String word)	{ return new String(Base64.decodeBase64(word.getBytes()));}

	public static String asHex (byte hash[]) {
		char buf[] = new char[hash.length * 2];
		for (int i = 0, x = 0; i < hash.length; i++) {
			buf[x++] = HEX_CHARS[(hash[i] >>> 4) & 0xf];
			buf[x++] = HEX_CHARS[hash[i] & 0xf];
		}
		return new String(buf);
	}

	/**
	* Aplica el Secure Hash Algorithm, util para encriptar un dato que no debe ser puesto en texto nunca, por ejemplo 
	* las password del usuario.  
	*/
	
	public static byte[] hashSHA1(String word) {
		MessageDigest digester= null;
		byte[] resultado= null;
		try	{
			digester= MessageDigest.getInstance("SHA-1");
	        resultado= digester.digest(word.getBytes());
		} catch (NoSuchAlgorithmException e) { throw new RuntimeException(e); } 
		catch (Exception e) { e.printStackTrace(); }
		return resultado;
	}
	
	public static String encriptar(String text){
			return encodeToBase64(asHex(hashSHA1 (text)));
	}
	
	
	
	
	
	
	public String createJsonWebToken(String userId, String ip, Long durationDays) throws JOSEException{
		JWSSigner signer = new MACSigner(sharedSecret);
		
		Calendar cal = Calendar.getInstance();
		JSONObject jo = new JSONObject();
		jo.put("userId", userId);
		jo.put("issuer", ISSUER);
		jo.put("sourceIP", ip);
		
		Instant issuedAt = new org.joda.time.Instant(cal.getTimeInMillis());
		Instant expiresAt = new org.joda.time.Instant(cal.getTimeInMillis()+ 1000L * 60L * 60L * 24L * durationDays);
		
		jo.put("issuedAt", issuedAt.toString());
		jo.put("expiresAt", expiresAt.toString());
		
		JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload(jo));
		jwsObject.sign(signer);
		return jwsObject.serialize();
	}
	
	public JSONObject verify(String s) throws ParseException, JOSEException {
		JWSObject jwsObject = JWSObject.parse(s);
		JWSVerifier verifier = new MACVerifier(sharedSecret);
		if (jwsObject.verify(verifier)) {
			return jwsObject.getPayload().toJSONObject();
		}  
		return null;
	}
	
	public boolean userInToken(String userId, String token) throws ParseException, JOSEException { 
		JSONObject jo = verify(token);
		 return ((String) jo.get("userId")).trim().equals(userId.trim());
	}
	
	
	public static void main(String[] args) {
				
		
				/** generar una clave secreta random **/	
				/**
				AuthHelper util = new AuthHelper();	
				String salt = util.secretKey();
				System.out.println("salt " + salt);
				**/
				
			/**
			try {
				// Generate random 256-bit (32-byte) shared secret
				//SecureRandom random = new SecureRandom();
				//byte[] sharedSecret = new byte[32];
				//random.nextBytes(sharedSecret);
				
				//AuthHelper util = new AuthHelper();				
				//String sharedSecret = util.secretKey();
				//System.out.println("sharedSecret es " + sharedSecret);
				
				
				
				// Create HMAC signer
				JWSSigner signer = new MACSigner(sharedSecret);

				// Prepare JWS object with "Hello, world!" payload
				JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload("Hello, world!"));

				// Apply the HMAC
				jwsObject.sign(signer);

				// To serialize to compact form, produces something like
				// eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
				String s = jwsObject.serialize();

				// To parse the JWS and verify it, e.g. on client-side
				JWSObject jwsObject2 = JWSObject.parse(s);
				JWSVerifier verifier = new MACVerifier(sharedSecret);
				jwsObject2.verify(verifier);

				String pay = jwsObject2.getPayload().toString();
				System.out.println(pay);
			} catch (Exception e) {e.printStackTrace();}	
			**/	
		
		
			try {
				
				/**AuthHelper util = new AuthHelper();
				String jwt = util.createJsonWebToken("mario", "oliverTwist", new Long(2));
				System.out.println("jwt es " + jwt);
				JSONObject userProfile =  util.verify(jwt);
				System.out.println("EL profile que meti era " + userProfile.toJSONString());**/
				
				SisfeJowtService util = new SisfeJowtService();
				String passwordEncriptada = encodeToBase64(asHex(hashSHA1 ("sisfe")));
				System.out.println(passwordEncriptada);
				//String cimaitEncriptado = "NjE4ZTIzNWYzMzM1NGE2ZWU5YWE2NGNiYjMxNzY2ZjdkZmYzYzdjMg==";
				
			} catch(Exception e) {}
			
		
	}

}
