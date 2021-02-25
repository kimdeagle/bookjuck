package com.test.bookjuck.admin.curationletter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthentication extends Authenticator {
		
		PasswordAuthentication pa;
		
		public MyAuthentication(){
    		pa=new PasswordAuthentication("bookjuckbookjuck@gmail.com","iwjhnmgdcpfxzqet");        
  		}
  
		@Override
  		protected PasswordAuthentication getPasswordAuthentication() {
    		return pa;
  		}
}
