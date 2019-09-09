package com.clientui.web.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {


        if(response.status() == 400){
            return new ProductNotFoundException(
                    "requête incorrecte"
            );
        }
        return defaultErrorDecoder.decode(s, response);
    }
}
