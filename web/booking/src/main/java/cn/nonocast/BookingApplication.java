package cn.nonocast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookingApplication extends SpringBootServletInitializer {
	@RequestMapping("/")
	public String home() { return "hello world, booking"; }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookingApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
