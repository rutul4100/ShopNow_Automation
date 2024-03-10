package com.Shopnow.utlities;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import com.sun.mail.util.BASE64DecoderStream;
import com.testing.framework.EmailUtils;


public class ReadEmail {
	private static String extractOTP(String text) {
		 Pattern pattern = Pattern.compile("Your OTP: (\\d+)");
	        Matcher matcher = pattern.matcher(text);

	        // Check if pattern is found and extract OTP
	        if (matcher.find()) {
	            return matcher.group(1);
	        } else {
	            return "OTP not found";
	        }
	    }
public static String getOtp() throws Exception {
	EmailUtils e=new EmailUtils();
	Properties prop=new Properties();
	prop.load(new FileInputStream("./src/test/resources/config/mailConfig.properties"));
	Store connection=e.connectToGmail(prop);
	e.getUnreadMessages(connection, "Inbox");
	
	
	List<String> emailtext= e.getUnreadMessageByFromEmail(connection, "Inbox", "noreply@nct.flipkart.com","Flipkart Account");
	
	
	
	if(emailtext.size()<1) {
		throw new Exception("no email received");
	}else {
		String otp = extractOTP(emailtext.get(0));
        System.out.println("OTP: " + otp);	
		return otp;
		
	}
}
	    
}
