package com.madadata.Goddess;


import com.madadata.Goddess.dao.Goddessdao;
import com.madadata.Goddess.dto.Goddess;
import com.madadata.Goddess.resource.GoddessResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

/**
 * Created by lixinyi on 16/3/21.
 */
public class GoddessApplication extends Application<GoddessConfiguration> {
    public static void main(String[] args) throws Exception{
        new GoddessApplication().run(args);

    }

    @Override
    public void run(GoddessConfiguration config, Environment environment){
        final DBIFactory factory=new DBIFactory();
        final DBI jdbi=factory.build(environment,config.getDataSourceFactory(),"sqlite");
        final Goddessdao gdao=jdbi.onDemand(Goddessdao.class);
        gdao.creategoldnesstable();
        Goddess g1=new Goddess(0,"mary","li",22,"396275915@qq.com",168,120,"15828006196");
        Goddess g2=new Goddess(1,"mary","wang",21,"sfagffdg@qq.com",169,115,"18001350693");
        gdao.add(g1);
        gdao.add(g2);
        environment.jersey().register(new GoddessResource(gdao));

    }

}
