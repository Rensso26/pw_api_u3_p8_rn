package uce.edu.web.api.controller;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;

@Path("/generate")
public class TokenController {

    @GET
    @Path("")
    public String generar(){
        return Jwt.issuer("http://uce.edu.ec").
                upn("rncorreo@uce.edu.ec").groups("admin")
                .expiresIn(Duration.ofSeconds(30)).sign();
    }
}
