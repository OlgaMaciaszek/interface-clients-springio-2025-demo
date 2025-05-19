package company;

import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;

public class CustomHttpServiceGroupConfigurer implements RestClientHttpServiceGroupConfigurer {

	@Override
	public void configureGroups(Groups<RestClient.Builder> groups) {
		groups.filterByName("company").configure(
				(_, builder) ->
						builder.requestInterceptor((request, body, execution) -> {
									request.getHeaders().add("Custom-Header", "custom-header-value");
									return execution.execute(request, body);
								}
						),
				(_, builder) ->
						builder.conversionService(new FormattingConversionService()));
	}

}
