package com.example.mytransaction.servcie;


import com.example.mytransaction.domain.RdlLog;
import com.example.mytransaction.domain.RdlUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 事务测试
 * @author randaliang
 * @date 2021-10-21 19:03
 **/
@Service
public class TransService {
    private Logger logger = LoggerFactory.getLogger(TransService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LogService logService;

    /**
     *新增用户
     * @param user
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public void saveUser(RdlUser user){

        RdlLog log = new RdlLog();
        log.setLog_id(UUID.randomUUID().toString());
        log.setLog_content("新增用户，用户编码为"+user.getUser_code());
        try{
            this.saveLog(log);
        }catch (Exception e){
            logger.info("保存日志异常!",e);
        }
        try{
            String sql = "insert into rdl_user(user_id,user_code,user_name)values(?,?,?)";
            jdbcTemplate.update(sql,user.getUser_id(),user.getUser_code(),user.getUser_name());
        }catch (Exception e){
            logger.info("保存用户异常!",e);
        }


    }


    /**
     *新增用户
     * @param user
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public void saveUser2(RdlUser user){
        RdlLog log = new RdlLog();
        log.setLog_id(UUID.randomUUID().toString());
        log.setLog_content("新增用户，用户编码为"+user.getUser_code());
        try{
            logService.saveLog(log);
        }catch (Exception e){
            logger.error("保存日志异常！",e);
        }

        String sql = "insert into rdl_user(user_id,user_code,user_name)values(?,?,?)";
        jdbcTemplate.update(sql,user.getUser_id(),user.getUser_code(),user.getUser_name());
    }


    @Transactional(propagation=Propagation.REQUIRED)
    public void saveLog(RdlLog log){
        String sql = "insert into rdl_log(log_id,log_content)values(?,?)";
        jdbcTemplate.update(sql,log.getLog_id(),log.getLog_content());
    }
}