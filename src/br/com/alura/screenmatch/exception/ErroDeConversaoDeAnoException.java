package br.com.alura.screenmatch.exception;

// Define uma classe de exceção personalizada que estende RuntimeException.
public class ErroDeConversaoDeAnoException extends RuntimeException {

    // Atributo privado para armazenar uma mensagem de erro específica.
    private String mensagem;

    // Construtor que recebe uma mensagem como argumento e a inicializa.
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem; // Define a mensagem personalizada da exceção.
    }

    // Sobrescreve o método getMessage() para retornar a mensagem de erro armazenada.
    @Override
    public String getMessage() {
        return this.mensagem; // Retorna a mensagem de erro personalizada.
    }
}
