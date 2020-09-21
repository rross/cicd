package com.google.demo.helloappjava;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloAppController {

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
        return "Hello World!<br>Version: 1.0.0<br>Hostname: "+hostname+"<br>";
    }
}
