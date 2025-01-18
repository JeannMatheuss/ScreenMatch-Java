package br.com.alura.screenmatch.principal;

// Importa as bibliotecas necessárias para entrada/saída, manipulação de URI, cliente HTTP e JSON.
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Inicializa um Scanner para ler a entrada do usuário.
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para a busca: ");
        var busca = leitura.nextLine(); // Lê o nome do filme digitado pelo usuário.

        // Monta a URL de busca utilizando a API OMDB e a entrada do usuário.
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=3493ff3d";

        try {
            // Cria um cliente HTTP para realizar a requisição.
            HttpClient client = HttpClient.newHttpClient();
            
            // Cria uma requisição HTTP utilizando a URL gerada.
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

            // Envia a requisição e obtém a resposta como uma string.
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            
            // Obtém o corpo da resposta (JSON) em formato de string.
            String json = response.body();
            System.out.println(json); // Exibe o JSON retornado pela API.

            // Configura o Gson para lidar com nomes de campos em UpperCamelCase.
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            
            // Converte o JSON recebido em um objeto da classe TituloOmdb.
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb); // Exibe o objeto convertido.

            
                // Tenta criar um objeto da classe Titulo a partir do TituloOmdb.
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo ja convertido");
                System.out.println(meuTitulo); // Exibe o objeto convertido para a classe Titulo.
            } catch (NumberFormatException e) {
                // Captura exceções relacionadas à conversão de número e exibe uma mensagem de erro.
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        
        // Indica o término bem-sucedido do programa.
        System.out.println("O programa finalizou corretamente!");
    }
}
