package br.com.microservices.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;


/*
*
* Objective: Log importants information
*
* */
@Component
public class LoggingFilter implements GlobalFilter {

    private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Original request path: " + exchange.getRequest().getPath());
        return chain.filter(exchange);
    }

    public void info(String message) {
        logger.info(message);
    }

}
