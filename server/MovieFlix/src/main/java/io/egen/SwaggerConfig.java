package io.egen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}


	private ApiInfo apiInfo() {
		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("admin", "http://gen.io", "developer@egen.io");
		ApiInfo info = new ApiInfo("Spring Rest",
				"MovieFlix Demo",
				"1.0.0",
				"T&C",
				contact,
				"MIT",
				"https://opensource.org/licenses/MIT");
		return info;
	}
}