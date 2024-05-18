package br.com.bluesburguer.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/** 
 * 
*/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "br.com.bluesburguer.menu" })
public class BluesBurguerMenuApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BluesBurguerMenuApplication.class, args);
	}
}
