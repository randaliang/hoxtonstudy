package com.example.mytransaction.servcie;


import com.example.mytransaction.domain.RdlLog;
import com.example.mytransaction.domain.RdlUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 事务测试
 * @author randaliang
 * @date 2021-10-21 19:03
 **/
public class TransService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *新增用户
     * @param user
     */
    public void saveUser(RdlUser user){

    }

    public void saveLog(RdlLog log){

    }
}