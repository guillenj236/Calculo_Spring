package br.com.springAtividade.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "br.com.springAtividade.demo")
@EntityScan(basePackages = "br.com.springAtividade.demo.entity")
public class SpringAtividadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAtividadeApplication.class, args);
	}

}
