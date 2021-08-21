package com.JamesSSH;
/* INPORTANT INFORMATION
CLIENTID=h-KEIo3Fz3LrAmd2QMcR63f8CxOEzIVum340kJS8xc_jgUF3BQWvATOIlTNL2oRv
SECRET=RMHOiBdHkpqd9PxCe33a3wMEoORAB5O6bVmz2GYY6-92GEBz90_xM6-FgC2zTX7dRvhrh4RZpYd63j0zo3Xi0Q
ACCESSTOKEN=uKGy9_3qDGp3aSD-VbbDyRDwWs6jgjwDi88eW1sWO7AMocgGXKt7gVk1DkU5GVoS
 */


import com.github.scribejava.apis.GeniusApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    final static String ClientID = "h-KEIo3Fz3LrAmd2QMcR63f8CxOEzIVum340kJS8xc_jgUF3BQWvATOIlTNL2oRv";
    final static String SecretKey = "RMHOiBdHkpqd9PxCe33a3wMEoORAB5O6bVmz2GYY6-92GEBz90_xM6-FgC2zTX7dRvhrh4RZpYd63j0zo3Xi0Q";
    final static String AccessToken = "uKGy9_3qDGp3aSD-VbbDyRDwWs6jgjwDi88eW1sWO7AMocgGXKt7gVk1DkU5GVoS";
    final static String SecretState = "65535"; //Change me

    public static void main(String[] Args)throws java.io.IOException, java.lang.InterruptedException, java.util.concurrent.ExecutionException{
        final OAuth20Service service = new ServiceBuilder(ClientID)
                .apiSecret(SecretKey)
                .userAgent("ScribeJava")
                .build(GeniusApi.instance());
        final String authorisationURL = service.getAuthorizationUrl(SecretState);
        System.out.println(authorisationURL);
        final String code;
        final String value;
        try (Scanner input = new Scanner(System.in, StandardCharsets.UTF_8)){
            code = input.nextLine();
            System.out.println("\n");
            System.out.println("printState");
            value = input.nextLine();
        }
        if (SecretState.equals(value)){

        } else {
            System.out.println("Ooops, state value does not match!");
            System.out.println("Expected = " + SecretState);
            System.out.println("Got      = " + value);
            System.out.println();
        }
        final OAuth2AccessToken accessToken = service.getAccessToken(code);


    }
}
