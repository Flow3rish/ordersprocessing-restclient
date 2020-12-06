package cloud.chrubasik.ordersprocessingrestclient.cli.commands;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cloud.chrubasik.ordersprocessingrestclient.api.CustomerControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.model.Customer;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;


@Component
@Command(name = "customer", description = "call to customer endpoints", subcommands = {CustomerCommand.ListCommand.class, CustomerCommand.DetailCommand.class}, mixinStandardHelpOptions = true)
public class CustomerCommand implements Callable<Integer> {
        @Autowired
        private final CustomerControllerApi customerControllerApi;



        public CustomerCommand(CustomerControllerApi customerControllerApi) {
            this.customerControllerApi = customerControllerApi;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("please supply call method");
            return 22;
        }

        @Component
        @Command(name = "list", description = "list all customers")
        static class ListCommand implements Callable<Integer> {

            @Autowired
            private final CustomerControllerApi customerControllerApi;


            public ListCommand(CustomerControllerApi customerControllerApi) {
                this.customerControllerApi = customerControllerApi;
            }


            @Override
            public Integer call() throws Exception {
                List<Customer> customers = customerControllerApi.all();
                System.out.println(customers);
                return 23;
            }

        }

        @Component
        @Command(name = "detail", description = "detail of one customer")
        static class DetailCommand implements Callable<Integer> {
            @Autowired
            private final CustomerControllerApi customerControllerApi;

            @Parameters(index = "0", description = "id of customer")
            private Long customerIdParam;


            public DetailCommand(CustomerControllerApi customerControllerApi) {
                this.customerControllerApi = customerControllerApi;
            }


            @Override
            public Integer call() throws Exception {
                Customer customer = customerControllerApi.one(this.customerIdParam);
                System.out.println(customer);
                return 23;
            }
        }
        
}
