package br.com.apPedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.apPedido.clients")
public class ApPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApPedidoApplication.class, args);
	}

}
