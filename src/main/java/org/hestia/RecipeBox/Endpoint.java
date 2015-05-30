package org.hestia.RecipeBox;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {

    @Value("${message:World}")
    private String msg;

    @GET
    public String message() {
        return "Hello " + this.msg;
    }

}
