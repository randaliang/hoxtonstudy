/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aspect.service;

import aspect.common.model.User;
import aspect.config.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class HelloWorldService implements IHelloWorldService {

	@Autowired
    HelloNewService hns;
	
	 @Autowired
	 private People people;
	
//	@Autowired
//	JdbcTemplate jd;
	
	@Value("${name:World}")
	private String name;

	int i = 0;
	/* (non-Javadoc)
	 * @see aspect.service.IHelloWorldService#getHelloMessage(java.lang.String)
	 */
	@Override
	@AnnotationTag
	public String getHelloMessage( String name ) {
//		if( "exception".equals(name) ){
//			throw new RuntimeException("有异常了！！");
//		}
		String s =  "Hello " + name + "test!" + (i++) +people.getName() + ":"  +people.getAge();
		System.out.println("invoke" + s );
		return s;
	}

	/* (non-Javadoc)
	 * @see aspect.service.IHelloWorldService#getHelloMessage()
	 */
	@Override
	@AnnotationTag
//	@Transactional
	public String getHelloMessage() {
		
//		List list = jd.queryForList("	SELECT * FROM role WHERE id IN(1) ");
//		list.size();
		if( "exception".equals(name) ){
			throw new RuntimeException("有异常了！！");
		}
		i++;
		String s =  "Hello " + name + "test!" + i;
//		return "Hello " + name + "test!";
		System.out.println("=============================invoke" + hns.getHelloMessage() );
		
		return s ;
	}

	@Override
	public User addUser(User user) {
		user.setCode(UUID.randomUUID().toString());
		return user;
	}
}
