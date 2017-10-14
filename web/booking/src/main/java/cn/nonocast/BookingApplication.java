package cn.nonocast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookingApplication {
	@RequestMapping("/")
	public String home() {
		return "quick booking system";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
