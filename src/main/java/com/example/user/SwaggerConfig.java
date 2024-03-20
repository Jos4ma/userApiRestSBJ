// import org.springdoc.core.GroupedOpenApi;
// import org.springdoc.core.OpenAPI;
// import org.springdoc.core.customizers.OpenApiCustomiser;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;


// public class SwaggerConfig {
//     @Bean
//     GroupedOpenApi publicApi(){
//         return GroupedOpenApi.builder()
//             .group("public-apis")
//             .pathsToMatch("/**")
//             .build();
//     }
//     OpenApi customOpenAPI(){
//         return new OpenAPI()
//             .info(new Info().title("API title").version("API version"))
//             .addSecurityItem(new SecurityRequiriment().addList("bearerAuth"))
//             .components(
//                 new Components()
//                 .addSecuritySchemes("bearerAuth", new SecurityScheme()
//                     .type(SecurityScheme.Type.HTTP)
//                     .scheme("bearer")
//                     .bearerFormat("JWT"))
//             );
//     }
// }




// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;


// @Configuration
// @EnableSwagger2
// public class SwaggerConfig {

//     @Bean
//     public Docket api() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .select()
//                 .apis(RequestHandlerSelectors.basePackage("com.example.user")) // Cambia este paquete al paquete donde se encuentra tu controlador
//                 .paths(PathSelectors.any())
//                 .build();
//     }
// }
