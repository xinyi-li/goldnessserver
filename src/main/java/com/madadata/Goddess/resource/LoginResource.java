package com.madadata.Goddess.resource;

import com.madadata.Goddess.dao.UserDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by lixinyi on 16/3/21.
 */

@Path("/")
@Produces("text/html")
public class LoginResource {
    private final UserDao udao;

    public LoginResource(UserDao udao) {
        this.udao = udao;
    }
    @POST

}
