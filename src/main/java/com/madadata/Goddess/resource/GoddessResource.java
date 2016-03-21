package com.madadata.Goddess.resource;

import com.codahale.metrics.annotation.Timed;
import com.madadata.Goddess.dao.Goddessdao;
import com.madadata.Goddess.dto.Goddess;
import io.dropwizard.jersey.params.IntParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by lixinyi on 16/3/21.
 */

@Path("/database")
@Produces(MediaType.APPLICATION_JSON)
public class GoddessResource  {
    private final Goddessdao gdao;

    public GoddessResource(Goddessdao gdao) {
        this.gdao=gdao;
    }
    @GET
    @Path("/showall")
    @Timed
    public List<Goddess> showall(){
        return gdao.showall();
    }


    @GET
    @Path("/delete")
    @Timed
    public void delete(@QueryParam("id") IntParam id){ gdao.deletebyid(id.get());}

    //@Path("/insert")

    @Path("/showone")
    @GET
    @Timed
    public void showone(@QueryParam("id") IntParam id){gdao.showoneGoddessinfo(id.get());}
    //@Path("/showlist")
}
