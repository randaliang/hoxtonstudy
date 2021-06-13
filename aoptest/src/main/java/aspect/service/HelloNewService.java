package aspect.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class HelloNewService {
//	@Autowired
//	JdbcTemplate jd;
	public String getHelloMessage() {
		
//		List list = jd.queryForList("	SELECT * FROM role ");
//		return list.toString();
		return "gethello";
	}
}
