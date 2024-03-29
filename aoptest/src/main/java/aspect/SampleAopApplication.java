/*
 * Copyright 2012-2018 the original author or authors.
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

package aspect;


import aspect.service.IHelloWorldService;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableTransactionManagement
public class SampleAopApplication implements CommandLineRunner {

	// Simple example shows how an application can spy on itself with AOP

	@Autowired
	private IHelloWorldService helloWorldService;

	@Override
	public void run(String... args) {
//		System.out.println(this.helloWorldService.getHelloMessage("world"));
		System.out.println(this.helloWorldService.getHelloMessage());
		AnnotationAwareAspectJAutoProxyCreator a =null;
//		a.postProcessAfterInitialization(null,null);
	}

	public static void main(String ... args) {
		System.out.println("===========");
		SpringApplication.run(SampleAopApplication.class, args);
	}

	public void test() {
		AnnotationAwareAspectJAutoProxyCreator a =null;
		a.postProcessAfterInitialization(null,null);
		ExposeInvocationInterceptor e = null;
		DispatcherServlet d = null;
	}
	

}
