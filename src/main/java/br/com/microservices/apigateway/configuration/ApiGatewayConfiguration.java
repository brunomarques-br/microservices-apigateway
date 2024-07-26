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
    public RouteLocator gatewayRouterTest(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://18.235.70.76:80"))
                .build();
    }

    /*
     * gateway routes for book-service and cambio-service to be accessed through the gateway
     * */

//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/get")
//                        .filters(f -> f
//                                .addRequestHeader("Hello", "World")
//                                .addRequestParameter("Hello", "World")
//                        )
//                        .uri("http://18.235.70.76:80"))
//                .route(p -> p
//                        .path("/cambio-service/**")
//                        .uri("lb://cambio-service") //lb = load balance + service name (eureka)
//                )
//                .route(p -> p
//                        .path("/book-service/**")
//                        .uri("lb://book-service") //lb = load balance + service name (eureka)
//                )
//                .build();
//    }
}
