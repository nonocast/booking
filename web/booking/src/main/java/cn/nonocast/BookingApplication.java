package cn.nonocast;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
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


	@RequestMapping("/sendmail")
	public String sendmail() {
		Email email = new EmailBuilder()
				.from("caohui", "caohui@shgbit.com")
				.to("caohui", "caohui@shgbit.com")
				.subject("hello world, from simple java mail")
				.text("We should meet up! ;)")
				.build();

		new Mailer(
				new ServerConfig("smtp.exmail.qq.com", 465, "caohui@shgbit.com", ""),
				TransportStrategy.SMTP_SSL
		).sendMail(email);
		return "Sent.";
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookingApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
