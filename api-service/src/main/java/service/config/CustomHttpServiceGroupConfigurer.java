package service.config;

import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;

/**
 * @author Olga Maciaszek-Sharma
 */
public class CustomHttpServiceGroupConfigurer implements RestClientHttpServiceGroupConfigurer {

	@Override
	public void configureGroups(Groups<RestClient.Builder> groups) {
		groups.configureClient((group, clientBuilder) ->
		{
			// Apply to selected groups
			if ("company-service".equals(group.name())) {
				// Customise RestClient.Builder
				clientBuilder.requestInterceptor(
						(request, body, execution) -> {
							request.getHeaders()
									.add("Custom-Header", "custom-header-value");
							return execution.execute(request, body);
						}
				);
			}
		});
		groups.configureProxyFactory((group, proxyFactoryBuilder) ->
				{
					if ("company-service".equals(group.name())) {
						// Customise HttpServiceProxyFactoryBuilder
						proxyFactoryBuilder.conversionService(
								new FormattingConversionService());
					}
				}
		);
	}
}
