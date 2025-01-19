// Pacote principal do projeto ScreenMatch.
package br.com.alura.screenmatch.principal;

// Importa as bibliotecas necessárias para entrada/saída, manipulação de URI, cliente HTTP e manipulação de JSON.
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Inicializa o Scanner para capturar a entrada do usuário pelo console.
        Scanner leitura = new Scanner(System.in);

        // Lista para armazenar os objetos da classe Titulo.
        List<Titulo> titulos = new ArrayList<>();

        // Configuração do Gson para manipulação de JSON:
        // 1. Define a política de nomenclatura dos campos como UpperCamelCase.
        // 2. Configura o pretty printing para formatar o JSON de saída.
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        // Laço principal que continua enquanto o usuário não digitar "sair".
        String busca = "";
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para a busca: ");
            busca = leitura.nextLine(); // Lê a entrada do usuário.

            // Verifica se o usuário deseja encerrar o programa.
            if (busca.equalsIgnoreCase("sair")) {
                break; // Sai do laço.
            }

            // Monta a URL para a requisição à API OMDB, substituindo espaços por "+".
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=3493ff3d";

            try {
                // Cria um cliente HTTP para enviar a requisição.
                HttpClient client = HttpClient.newHttpClient();

                // Configura a requisição HTTP utilizando a URL montada.
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

                // Envia a requisição e obtém a resposta como uma string.
                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

                // Corpo da resposta (JSON) retornado pela API.
                String json = response.body();
                System.out.println(json); // Exibe o JSON retornado.

                // Converte o JSON em um objeto da classe TituloOmdb.
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb); // Exibe os dados do objeto convertido.

                // Converte o objeto TituloOmdb para um objeto Titulo.
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo ja convertido");
                System.out.println(meuTitulo); // Exibe os dados do objeto Titulo.

                // Adiciona o objeto Titulo à lista de títulos.
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                // Captura e trata erros de conversão de número.
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Captura e trata erros relacionados a argumentos inválidos.
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                // Captura e trata erros específicos de conversão de ano (exceção customizada).
                System.out.println(e.getMessage());
            }
        }

        // Exibe todos os títulos processados.
        System.out.println(titulos);

        // Escreve os dados dos títulos em um arquivo JSON.
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos)); // Converte a lista de títulos para JSON e escreve no arquivo.
        escrita.close(); // Fecha o arquivo.

        // Mensagem final indicando o término bem-sucedido do programa.
        System.out.println("O programa finalizou corretamente!");
    }
}
