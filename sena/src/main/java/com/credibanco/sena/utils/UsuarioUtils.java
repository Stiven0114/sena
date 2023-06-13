package com.credibanco.sena.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import com.credibanco.sena.entity.Usuario;

public class UsuarioUtils {
	/*
	
	public static String cardNumEncrypt (String numberCard) {

        byte[] byteCard = numberCard.getBytes();

        byte[] byteEcrypt = Base64.getEncoder().encode(byteCard);

        String cardEncrypt = new String(byteEcrypt);

        return cardEncrypt;

    }
    */

    public static String cardEncryptChar (String cardNumber) {

        StringBuilder cardEncryptChar = new StringBuilder();

/*        
        for(int i = 0 ; i < cardNumber.length(); i++) {
            if (i >= 2 && i <= cardNumber.length() - 3) {
                cardEncryptChar.append("*");
            }else {
                cardEncryptChar.append(cardNumber.charAt(i));
            }
        }      */

        String primTwoNums = cardNumber.substring(0,2);
        String ultTwoNums = cardNumber.substring(cardNumber.length() -2);
        String middleNums = cardNumber.substring(2, cardNumber.length() -2);
        String numsEncrypt = "*".repeat(middleNums.length());

        cardEncryptChar.append(primTwoNums);
        cardEncryptChar.append(numsEncrypt);
        cardEncryptChar.append(ultTwoNums);

        return cardEncryptChar.toString(); 
    }



	
			
		public String encode(String s) {
			String respuesta = "error";
			try {
			respuesta = new String(Base64.getEncoder().encode(s.getBytes("UTF8")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			}
			return respuesta;
			}
		
		public String decode(String s) throws UnsupportedEncodingException {
			String respuesta = "error";
			try {
			respuesta = new String(Base64.getDecoder().decode(s.getBytes("UTF8")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			}
			return respuesta;
			}
			
	}
	


