package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@MapperScan({"com.java"})
//鍖呮壂鎻忥細鎵弿controller:service
//@SpringBootApplication(scanBasePackages = {"com.java"})
//寮�鍚痵prinngboot鐨勯粯璁ら厤缃�
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.java"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	/*澶栫疆tomcat浣跨敤*/
	/*@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
		return application.sources(Application.class);
	}*/

    
    public static void main(String[] args) {
        // 鍐呯疆浜唗omcat锛屽洜姝pringboot鍙互涓嶇敤鍙戝竷鍦ㄥ閮ㄧ殑tomcat鏈嶅姟鍣ㄤ腑
        // spring灏辨槸绠�鍖栦簡ssm妗嗘灦鐨勬惌寤�,绫讳技浜庝笉鐢ㄤ功鍐檚sm鐨勬墍鏈夐厤缃枃浠�
        SpringApplication.run(Application.class, args);
    }
    
}
