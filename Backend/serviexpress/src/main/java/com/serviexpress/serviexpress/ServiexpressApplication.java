/*
nota IMPORTANTE:

install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar
istala el driver para la conexion oracle
siempre y cuando exista el ojdbc7 en la carpeta de inicio del proyecto

- dependiendo de la version de MYSQL en la base de datos deberemos cambiar en las dependencias por la version necesarioa en el archivo pom.xml
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.43</version> <!--poner 8.0.11 en caso de que la variable de innodb sea 8.0.X  -->
	</dependency>

docker run -p 3306:3306 --name serviexpress -v C:\DockerImages:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=serviexpress -d mysql:8.0 --character-set-server=utf8 --collation-server=utf8_bin
docker start serviexpress
docker exec -it serviexpress mysql -uroot -p
127.0.0.1 
password:serviexpress
docker stop serviexpress 

para detenerlo daaah!

# Backup
- docker exec serviexpress /usr/bin/mysqldump -u root --password=serviexpress serviexpress > backup.sql
- docker exec CONTAINER /usr/bin/mysqldump -u root --password=root DATABASE > backup.sql

#generar contenedor con la imagen de docker de esta aplicacion
- ejecutar en maven build el siguiente comando :  clean install docker:build
- para subir la imagen a docker hub estando logueado en docker mediante consola usar el sig comando: docker push NOMBREIMAGENCREADA
- el comando para descargar la imagen subida al docker hub es el siguiente: docker pull NOMBREIMAGENCREADA

- docker run -d --name servi2 --add-host=mysql_server:172.17.0.1 -p 8080:8080 timaeus8/serviexpress:latest

# Restore
cat backup.sql | docker exec -i CONTAINER /usr/bin/mysql -u root --password=root DATABASE


Para conectarse con UNA BASE DE DATOS MYSQL
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.43</version><!--poner 8.0.15 en caso de que la variable de innodb sea 8.0.X ver la variable en la base de datos poniendo ' SHOW VARIABLES LIKE "%version%"; ' -->
</dependency>
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
