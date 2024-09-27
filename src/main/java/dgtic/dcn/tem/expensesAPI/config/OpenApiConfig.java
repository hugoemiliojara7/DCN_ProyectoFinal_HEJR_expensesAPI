package dgtic.dcn.tem.expensesAPI.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Travel Expense Manager - Daiyl Expenses API", 
			description = "Proyecto final - Diplomado de Desarrollo "
					+ "y Despliegue de Aplicaciones Cloud Native "
					+ " - Daily expenses Endpoints", 
			contact = @Contact(
				name = "Hugo Emilio Jara Rivera", 
				url = "https://github.com/hugoemiliojara7", 
			email = "hugoejara7@gmail.com")))
public class OpenApiConfig {

}
