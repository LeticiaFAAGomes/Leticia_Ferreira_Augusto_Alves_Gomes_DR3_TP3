package br.edu.infnet.HotelApi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.HotelApi.model.domain.Reserva;
import br.edu.infnet.HotelApi.model.domain.TipoReserva;
import br.edu.infnet.HotelApi.model.service.ReservaService;

@Component
public class ReservaDataLoader implements ApplicationRunner {

    private final ReservaService reservaService;

    public ReservaDataLoader(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Override
    public void run(ApplicationArguments args) {
        String arquivo = "files/reserva.txt";

        System.out.println("[INFO] Iniciando o carregamento de reservas...");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {

            bufferedReader.readLine(); 
            String linha = bufferedReader.readLine();

            while (linha != null) {
                try {
                    String[] campos = linha.split(";");

                    String titular = campos[1];
                    int idadeTitular = Integer.parseInt(campos[2]);
                    TipoReserva tipoReserva = TipoReserva.valueOf(campos[3].toUpperCase());
                    boolean ehAtiva = Boolean.parseBoolean(campos[4]);
                    LocalDateTime checkIn = LocalDateTime.parse(campos[5]);
                    double valorTotal = Double.parseDouble(campos[6]);

                    Reserva reserva = new Reserva(titular, idadeTitular, tipoReserva, ehAtiva, checkIn, valorTotal);
                    reservaService.incluir(reserva);

                } catch (NumberFormatException  e) {
                    System.err.println("[ERRO] Formato inválido: " + linha);
                    System.err.println("Motivo: " + e.getMessage());
                    
                } catch (IllegalArgumentException e) {
                    System.err.println("[ERRO] Argumento inválido: " + linha);
                    System.err.println("Motivo: " + e.getMessage());
                }

                linha = bufferedReader.readLine();
            }

	    } catch (FileNotFoundException e) {
	        System.err.println("[ERRO] O arquivo não foi encontrado: " + e.getMessage());
	        
	    } catch (IOException e) {
	        System.err.println("[ERRO] Houve problemas durante a abertura/fechamento do arquivo: " + e.getMessage());
	    }

        for (Reserva reserva: reservaService.obterLista()) {
        	System.out.println("# " + reserva);
        	System.out.println();
        }    
    }
}
