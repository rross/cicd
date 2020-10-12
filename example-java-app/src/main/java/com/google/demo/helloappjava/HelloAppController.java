package com.google.demo.helloappjava;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.text.SimpleDateFormat;  
import java.util.Date;  

@RestController
public class HelloAppController {
    private static final String HTML_BODY = 
	    "<html>\n" + 
	    "  <head>\n" +
	    "   <title style=\"font-size: 48px; font-weight: bold; \">\n" + 
	    "     Welcome to CI/CD in the Cloud\n" + 
	    "   </title>\n" + 
	    "  </head>\n" + 
	    "  <body style=\"font-size: 24px;\">\n" + 
	    "    %s\n" + // the message
	    "  </body>\n" + 
	    "</html>\n";

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        String hostname;
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
        } catch (UnknownHostException e) {
            hostname = "error";
        }
	    
	return String.format(HTML_BODY, "Hello World!<br>Version: 1.2.1<br>Hostname: <b>"+hostname+"</b><br>Date: "+currentDateAsString()+"<br>";
    }
	
	private String currentDateAsString()
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		return formatter.format(new Date());
	}
}
