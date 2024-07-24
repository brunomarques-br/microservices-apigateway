package br.com.microservices.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    /*
    *
    * Name: httpbin.org
    * Addresses:
    * 18.235.70.76:80
    * 54.87.89.151:80
    * 44.207.203.25:80
    * 3.221.196.38:80
    *
    * */
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/anything")
                        .uri("http://18.235.70.76:80"))
                .build();
    }
}
