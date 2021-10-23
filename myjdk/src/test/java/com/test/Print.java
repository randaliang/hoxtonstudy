package com.test;

/**
 * @author randaliang
 * @date 2021-09-29 18:02
 **/
public class Print {
    public static void main(String[] args) {
        String s = "{\"ifResult\":\"0\",\"ifResultInfo\":\"{\"head\":{\"message\":\"接口调用成功\",\"status\":0},\"data\":{\"total\":1,\"dataList\":[{\"certificateID\":\"1.2.156.3005.2.360000102HB0808.360000102.2b0cf89c-a66b-4ebb-a18c-4008891e8ee5.1.W\",\"certificateType\":\"营业执照\",\"issueDept\":\"省工商局\",\"certificateNumber\":\"913700001630477270\",\"issueDate\":\"2018年10月12日\"}]}}\",\"msgId\": \"\"}";

        System.out.println(s);
    }
}