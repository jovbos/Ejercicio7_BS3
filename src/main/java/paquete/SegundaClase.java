package paquete;

import org.springframework.boot.CommandLineRunner;

public class SegundaClase implements CommandLineRunner {

    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Hola desde clase secundaria");
    }
}
