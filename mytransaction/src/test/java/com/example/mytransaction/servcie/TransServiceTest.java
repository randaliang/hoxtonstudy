package com.example.mytransaction.servcie;

import com.example.mytransaction.MytransactionApplication;
import com.example.mytransaction.domain.RdlUser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes=MytransactionApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TransServiceTest {

    private Logger logger = LoggerFactory.getLogger(TransServiceTest.class);

    @Autowired
    private TransService transService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeAll
    public static void setup(){

    }


    @Test
    public void saveCommonUser(){
        RdlUser user = new RdlUser();
        user.setUser_id(UUID.randomUUID().toString());
        user.setUser_code(UUID.randomUUID().toString());
        user.setUser_name(UUID.randomUUID().toString());
        transService.saveUser( user );
    }

    @Test
    public void saveExceptionUser(){
        RdlUser user = new RdlUser();
        user.setUser_id(UUID.randomUUID().toString());
        user.setUser_code(UUID.randomUUID().toString());
        user.setUser_name(UUID.randomUUID().toString());
        transService.saveUser( user );
        Integer oldLogNum = jdbcTemplate.queryForObject("select count(*) from rdl_log",Integer.class);
        Integer oldUserNum = jdbcTemplate.queryForObject("select count(*) from rdl_user",Integer.class);


        logger.info("保存前用户数{}，日志数{}",oldUserNum,oldLogNum);
        try{
            user.setUser_id(UUID.randomUUID().toString());
            transService.saveUser( user );
        }catch(Exception e){
//            e.printStackTrace();
        }
        Integer newLogNum = jdbcTemplate.queryForObject("select count(*) from rdl_log",Integer.class);
        Integer newUserNum = jdbcTemplate.queryForObject("select count(*) from rdl_user",Integer.class);

        logger.info("保存后用户数{}，日志数{}",newUserNum,newLogNum);
        Assertions.assertNotEquals(oldLogNum,newLogNum,"日志没有保存");
        Assertions.assertEquals(oldUserNum,newUserNum,"用户没有保存成功");
    }


    @Test
    public void saveUser2(){
        RdlUser user = new RdlUser();
        user.setUser_id(UUID.randomUUID().toString());
        user.setUser_code(UUID.randomUUID().toString());
        user.setUser_name(UUID.randomUUID().toString());
        transService.saveUser2( user );
        Integer oldLogNum = jdbcTemplate.queryForObject("select count(*) from rdl_log",Integer.class);
        Integer oldUserNum = jdbcTemplate.queryForObject("select count(*) from rdl_user",Integer.class);


        logger.info("保存前用户数{}，日志数{}",oldUserNum,oldLogNum);
        try{
            user.setUser_id(UUID.randomUUID().toString());
            transService.saveUser2( user );
        }catch(Exception e){
//            e.printStackTrace();
        }
        Integer newLogNum = jdbcTemplate.queryForObject("select count(*) from rdl_log",Integer.class);
        Integer newUserNum = jdbcTemplate.queryForObject("select count(*) from rdl_user",Integer.class);

        logger.info("保存后用户数{}，日志数{}",newUserNum,newLogNum);
        Assertions.assertNotEquals(oldLogNum,newLogNum,"日志没有保存");
        Assertions.assertEquals(oldUserNum,newUserNum,"用户没有保存成功");
    }

}