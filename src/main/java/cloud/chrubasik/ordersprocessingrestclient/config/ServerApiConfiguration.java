package cloud.chrubasik.ordersprocessingrestclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import cloud.chrubasik.ordersprocessingrestclient.ApiClient;
import cloud.chrubasik.ordersprocessingrestclient.api.OrderControllerApi;


@Configuration
public class ServerApiConfiguration {
    @Value("$restserver.address")
    public String serverAddress;

    @Bean
    public OrderControllerApi orderControllerApi(ApiClient apiClient) {
        return new OrderControllerApi(apiClient);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
