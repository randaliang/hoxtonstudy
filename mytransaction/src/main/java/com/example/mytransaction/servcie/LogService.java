package com.example.mytransaction.servcie;

import com.example.mytransaction.domain.RdlLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author randaliang
 * @date 2021-10-30 15:54
 **/
@Service
public class LogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void saveLog(RdlLog log){
        String sql = "insert into rdl_log(log_id,log_content)values(?,?)";
        jdbcTemplate.update(sql,log.getLog_id(),log.getLog_content());
    }
}