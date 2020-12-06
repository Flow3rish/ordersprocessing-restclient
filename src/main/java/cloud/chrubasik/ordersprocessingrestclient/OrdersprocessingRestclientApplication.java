package cloud.chrubasik.ordersprocessingrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OrdersprocessingRestclientApplication {

	public static void main(String[] args) {
		System.exit(
			SpringApplication.exit(
				SpringApplication.run(OrdersprocessingRestclientApplication.class, args)
			)
		);
	}

}
