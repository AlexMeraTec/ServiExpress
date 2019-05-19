/*
docker run -p 3306:3306 --name serviexpress -v C:\DockerImages:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=serviexpress -d mysql:8.0 --character-set-server=utf8 --collation-server=utf8_bin
docker start serviexpress
docker exec -it serviexpress mysql -uroot -p
127.0.0.1 
password:serviexpress
docker stop serviexpress
*/
package com.serviexpress.serviexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiexpressApplication {
//run as maven build usando el comando clean install spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(ServiexpressApplication.class, args);
		
	}

}
