package br.com.microservices.apigateway.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    @Lazy(false) // to make sure the routes are already loaded
    public List<GroupedOpenApi> apis(
            SwaggerUiConfigParameters swaggerUiConfigParameters,
            RouteDefinitionLocator routeDefinitionLocator) {
        var definitions = routeDefinitionLocator.getRouteDefinitions().collectList().block();

        // filter routes that have "service" in the name
        assert definitions != null;
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId();
                    swaggerUiConfigParameters.addGroup(name);
                    GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
                });

        return new ArrayList<>();
    }
}
