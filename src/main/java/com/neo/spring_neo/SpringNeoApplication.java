package com.neo.spring_neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.neo.spring_neo.repositories")
public class SpringNeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNeoApplication.class, args);
	}

}
