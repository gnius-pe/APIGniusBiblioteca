package com.biblioteca.biblioteca.configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfiguracion {

 /*
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.gnius.service.bibliotecaunas"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
*/
    @Bean
    public OpenAPI getApiInfo(){
        /*
        return new ApiInfo("Gnius-Code for the Biblioteca UNAS",
                "API's para el sistema Bibliotecario",
                "1.0",
                "http://gnius-terminos.com",
                new Contact("igor", "https://gnius-igor-rc.netlify.app/", "igor.ramos.cruzado.w@gmail.com"),
                "Gnius-Code",
                "http://gnius-code/license.com",
                Collections.emptyList());
        */
        return new OpenAPI().info(new Info()
                .title("API's para Biblioteca UNAS")
                .version("1.0")
                .description("API REST FULL, esto proporciona acceso a las funcionalidades del sistema web bibliotecario. Los desarrolladores pueden utilizar estas API's para realizar operaciones relacionadas con la gestión de libros, usuarios, préstamos y devoluciones dentro de la biblioteca.")
                .termsOfService("http://gnius-terminos.com")
                .license(new License().name("Gnius-Code").url("http://gnius-code/licence.com"))
                .contact(new Contact()
                        .name("Igor")
                        .url("https://gnius-igor-rc.netlify.app")
                        .email("igor.ramos.cruzado.w@gmail.com")));
    }
}
