package cloud.chrubasik.ordersprocessingrestclient.cli.commands;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import cloud.chrubasik.ordersprocessingrestclient.api.OrderControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.model.Order;
import cloud.chrubasik.ordersprocessingrestclient.model.OrderToPost;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "order", description = "call to order endpoints", subcommands = { OrderCommand.ListCommand.class,
        OrderCommand.DetailCommand.class, OrderCommand.PostCommand.class, OrderCommand.DeleteCommand.class }, mixinStandardHelpOptions = true)
public class OrderCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("please supply call method");
        return null;
    }

    @Component
    @Command(name = "list", description = "list all orders")
    static class ListCommand implements Callable<Integer> {

        @Autowired
        private final OrderControllerApi orderControllerApi;

        @Parameters(index = "0", description = "id of customer")
        private Long customerIdParam;

        public ListCommand(OrderControllerApi orderControllerApi) {
            this.orderControllerApi = orderControllerApi;
        }

        @Override
        public Integer call() throws Exception {
            List<Order> orders = orderControllerApi.all1(this.customerIdParam);
            System.out.println(orders);
            return 23;
        }

    }

    @Component
    @Command(name = "detail", description = "detail of one order")
    static class DetailCommand implements Callable<Integer> {

        @Autowired
        private final OrderControllerApi orderControllerApi;

        @Parameters(index = "0", description = "id of customer")
        private Long customerIdParam;

        @Parameters(index = "1", description = "id of order")
        private Long orderIdParam;

        public DetailCommand(OrderControllerApi orderControllerApi) {
            this.orderControllerApi = orderControllerApi;
        }

        @Override
        public Integer call() throws Exception {
            Order order = orderControllerApi.one1(this.customerIdParam, this.orderIdParam);
            System.out.println(order);
            return 23;
        }
    }

    @Component
    @Command(name = "post", description = "post order for customer id")
    static class PostCommand implements Callable<Integer> {

        @Autowired
        private final OrderControllerApi orderControllerApi;

        @Parameters(index = "0", description = "id of customer")
        private Long customerIdParam;

        @Parameters(index = "1", description = "order description")
        private String orderDescriptionParam;

        public PostCommand(OrderControllerApi orderControllerApi) {
            this.orderControllerApi = orderControllerApi;
        }

        @Override
        public Integer call() throws Exception {
            OrderToPost otp = new OrderToPost().description(this.orderDescriptionParam);
            ResponseEntity<Order> resOrder = orderControllerApi.postOrderWithHttpInfo(this.customerIdParam, otp);
            System.out.println(resOrder);
            return 23;
        }
    }

    @Component
    @Command(name = "delete", description = "delete order for customer id")
    static class DeleteCommand implements Callable<Integer> {

        @Autowired
        private final OrderControllerApi orderControllerApi;

        @Parameters(index = "0", description = "id of customer")
        private Long customerIdParam;

        @Parameters(index = "1", description = "order description")
        private Long orderIdParam;

        public DeleteCommand(OrderControllerApi orderControllerApi) {
            this.orderControllerApi = orderControllerApi;
        }

        @Override
        public Integer call() throws Exception {
            ResponseEntity<Order> resOrder = orderControllerApi.deleteOrderWithHttpInfo(this.customerIdParam,
                    this.orderIdParam);
            System.out.println(resOrder);
            return 23;
        }
    }

}
