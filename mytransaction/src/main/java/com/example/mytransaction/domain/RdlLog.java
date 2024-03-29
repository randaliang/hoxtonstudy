package com.example.mytransaction.domain;

import lombok.Data;

/**
 * @author randaliang
 * @date 2021-10-21 19:05
 **/
@Data
public class RdlLog {
    /**
     * 日志id
     */
    private String log_id;
    /**
     * 日志内容
     */
    private String log_content;
}