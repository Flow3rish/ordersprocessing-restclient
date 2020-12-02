package cloud.chrubasik.ordersprocessingrestclient.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cloud.chrubasik.ordersprocessingrestclient.api.CustomerControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.api.OrderControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.model.Customer;
import cloud.chrubasik.ordersprocessingrestclient.model.OrderToPost;
import cloud.chrubasik.ordersprocessingrestclient.model.Order;

@Component
public class CliRestClient implements CommandLineRunner {
    private final OrderControllerApi orderControllerApi;
    private final CustomerControllerApi customerControllerApi;


    public CliRestClient(OrderControllerApi orderControllerApi, CustomerControllerApi customerControllerApi) {
        this.orderControllerApi = orderControllerApi;
        this.customerControllerApi = customerControllerApi;
    }


    @Override
    public void run(String... args) throws Exception {
        // TODO implement interactivity -> get cli args and route to methods
        final OrderToPost orderToPost = new OrderToPost().description("100x hlavkovy salat");
        final Customer customer = customerControllerApi.one(2L);


        final Order addedOrder = orderControllerApi.postOrder(customer.getId(), orderToPost);
        System.out.printf("new order has id '%d'\n", addedOrder.getId());
    }


}
