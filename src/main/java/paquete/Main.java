package paquete;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Main {

	/*Según puedo observar, la ejecución sigue el siguiente orden:
		1 --> Se ejecuta en primer lugar el print de la primera clase declarada, que utiliza la anotación @PostConstruct
		2 --> Se ejecuten los argumentos pasados por la tercera clase
		3 --> Se ejecutan los prints de la segunda y tercera clase respectivamente, en el orden en el que han sido instanciadas de manera secuencial
	 */

	public static String[] argumentos;
	public static void main(String[] args) {
		argumentos = args;
		SpringApplication.run(Main.class, args);
	}

	@PostConstruct
	public void ejecutate() {
		System.out.println("Hola desde clase inicial");
	}

	@Bean
	CommandLineRunner ejecutate2() {
		return new SegundaClase();
	}

	@Bean
	CommandLineRunner ejecutate3()	{
		Arrays.asList(argumentos).forEach(System.out::println);
		return new TerceraClase();
	}
}

