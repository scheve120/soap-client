package eu.additude.ConsummingZeep;

import eu.additude.ConsummingZeep.consumingwebservice.PersoonClient;
import eu.additude.ConsummingZeep.wsdl.GetPersoonResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsummingZeepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsummingZeepApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(PersoonClient quoteClient) {
		return args -> {
			Long id = 2L;

			if (args.length > 0) {
				id = Long.parseLong(args[0]);
			}
			GetPersoonResponse response = quoteClient.getPersoon(id);
			System.err.println(response.getPersoon().getNaam());
		};
	}
}
