package com.madadata.Goddess.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by lixinyi on 16/3/21.
 */
public interface UserDao {
    @SqlUpdate("create table " +
            "if not exist user(" +
            "username varchar(30) primary key not null," +
            "password varchar(30) not null)")
    void createusertable();

    @SqlUpdate("insert into user (username,password) values (:username,:password)")
    void insert(@Bind("username")String username, @Bind("password")String password);

    @SqlQuery("select password from user where username=:username")
    void findpassword(@Bind("username") String username);

    @SqlUpdate("delect from user where username=:username")
    void deleteuser(@Bind("username") String username);
}
