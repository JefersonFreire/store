package dio.santander.store;

import dio.santander.store.entity.Cliente;
import dio.santander.store.entity.Endereco;
import dio.santander.store.entity.Produto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.math.BigDecimal;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
public class LojaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LojaApplication.class, args);
    }
}