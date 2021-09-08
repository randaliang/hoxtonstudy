import java.util.regex.Pattern;

/**
 * @author randaliang
 * @date 2021-07-08 10:37
 **/
public class MyTest {
    public static void main( String argsp[] ){
//        String reg = "([ ]+|')(and|AND|or|OR)([ ]+|')";
        String reg = ".*?[//\\s](and|AND|or|OR)[\\s].*?";
        String s = "admdivCode=430000'/**/and/**/'1=1 and 4711=4711 and 'wqne'='wqne";
        String s1 = "admdivCode=430000' 1=1 and 4711=4711 and 'wqne'='wqne";

        String s2 = "[\"urgent_flag\",\"realpay_voucher_code\",\"pay_amount\",\"payee_account_no\",\"payee_account_name\",\"payee_account_bank\",\"payee_account_bank_no\",\"pay_account_no\",\"pay_account_name\",\"pay_account_bank\",\"fund_type_code\",\"fund_type_name\",\"pay_type_code\",\"pay_type_name\",\"pay_summary_code\",\"pay_summary_name\",\"print_num\",\"print_date\",\"voucherflag\",\"task_id\",\"bill_type_id\",\"realpay_voucher_id\",\"return_reason\",\"create_date\",\"pb_set_mode_code\",\"pb_set_mode_name\",\"last_ver\",\"urgent_flag\",\"add_word\"]";

        System.out.println(s.matches(reg));
        System.out.println(s1.matches(reg));
        System.out.println(s2.matches(reg));
        Pattern p = null;
        p.matcher("ddd").matches();
    }
}