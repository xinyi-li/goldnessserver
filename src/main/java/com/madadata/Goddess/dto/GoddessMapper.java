package com.madadata.Goddess.dto;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lixinyi on 16/3/21.
 */
public class GoddessMapper implements ResultSetMapper<Goddess> {
    public Goddess map(int index, ResultSet r, StatementContext ctx) throws SQLException{
        return new Goddess(r.getLong("id"),r.getString("firstname"),r.getString("lastname"),
               r.getInt("age"), r.getString("email"),r.getInt("height"),r.getInt("weight"),r.getString("mobilephone") );
    }
}
