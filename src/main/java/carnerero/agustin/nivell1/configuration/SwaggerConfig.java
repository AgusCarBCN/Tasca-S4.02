package carnerero.agustin.nivell1.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Component
@EnableWebMvc
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(

				"Tasca S4.02",
				"programa de gestió d'empleats molt senzill on depenent de la feina de l'empleat se li assignarà un salari "
				+ "automàticament. D'un treballador identifiquem el nom i la seva feina, estaria bé tenir un identificador "
				+ "únic per aquest treballador. Les feines són fixes, depenent de la feina s'assignarà un salari a l'empleat "
				+ "un cop es crea.  ",
				"1.0", null, null, null, null, Collections.emptyList());
	}
}
