package cloud.chrubasik.ordersprocessingrestclient.cli.commands;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cloud.chrubasik.ordersprocessingrestclient.api.CustomerControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.api.OrderControllerApi;
import cloud.chrubasik.ordersprocessingrestclient.model.Customer;
import picocli.CommandLine.Command;

@Component
@Command(name = "op-client", mixinStandardHelpOptions = true, description = "call to api endpoints", subcommands = {CustomerCommand.class, OrderCommand.class})
public class CliCommand implements Callable<Integer> {
    // @Autowired
    // private final CustomerControllerApi customerControllerApi;

    // @Autowired
    // private final OrderControllerApi orderControllerApi;


    // public CliCommand(CustomerControllerApi customerControllerApi, OrderControllerApi orderControllerApi) {
    //     this.customerControllerApi = customerControllerApi;
    //     this.orderControllerApi = orderControllerApi;
    // }


    @Override
    public Integer call() throws Exception {
        return 0;
    }
    
}