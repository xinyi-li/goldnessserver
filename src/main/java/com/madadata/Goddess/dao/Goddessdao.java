package com.madadata.Goddess.dao;

import com.madadata.Goddess.dto.Goddess;
import com.madadata.Goddess.dto.GoddessMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by lixinyi on 16/3/21.
 */
public interface Goddessdao {
    @SqlUpdate("create table if not exists goddess (" +
            "id long primary key not null," +
            "firstname varchar(20) not null," +
            "lastname varchar(20) not null," +
            "age int not null," +
            "email varchar(20) not null," +
            "height int(5) not null," +
            "weight int(4) not null," +
            "mobilephone varchar(15))")
    void creategoldnesstable();

    @SqlUpdate ("insert into goddess" +
            "(id,firstname,lastname,age,email,height,weight,mobilephone" +
            "values(:id,:firstName,:lastName,:age,:email,:height,:weight,:mobilePhone)")
    void add(@BindBean Goddess goddess);

    @SqlUpdate("delete from goddess" +
            "where id=:id")
    void deletebyid(@Bind("id") int id);

    @SqlQuery("select id, firstname,lastname,age,email,height,weight,mobilphone from goddess" +
            "where id=:id")
    Goddess showoneGoddessinfo(@Bind("id") int id);

//    @SqlQuery("select id, firstname,lastname,age,email,height,weight,mobilphone from goddess" +
//            "where lastname=:lastname")
//    List<Goddess> showseverGoddessinfo(@Bind("lastname")String lastname) ;//??第二个lastname?
//
    @RegisterMapper(GoddessMapper.class)
    @SqlQuery("select * from goddess")
    public List<Goddess> showall();


}
