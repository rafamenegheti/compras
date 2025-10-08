package io.github.rafamenegheti.icompras.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.github.rafamenegheti.icompras.pedidos.client")
public class ClientsConfig {
}
