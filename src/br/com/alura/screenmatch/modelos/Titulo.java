package br.com.alura.screenmatch.modelos;

// Importa uma classe de exceção personalizada para tratar erros específicos de conversão.
import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;

// Define a classe Titulo, que implementa a interface Comparable para permitir comparações.
public class Titulo implements Comparable<Titulo> {
    
    // Atributos privados que representam as propriedades de um título.
    private String nome; // Nome do título (ex.: filme ou série).
    private int anoDeLancamento; // Ano de lançamento do título.
    private boolean incluidoNoPlano; // Indica se o título está disponível em algum plano (ex.: streaming).
    private double somaDasAvaliacoes; // Soma total das avaliações recebidas.
    private int totalDeAvaliacoes; // Quantidade total de avaliações realizadas.
    private int duracaoEmMinutos; // Duração do título em minutos.

    // Construtor principal, que inicializa o título com nome e ano de lançamento.
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    // Construtor alternativo, que converte um objeto TituloOmdb em um objeto Titulo.
    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title(); // Define o nome a partir do título retornado pelo OMDB.

        // Verifica se o ano de lançamento tem mais de 4 dígitos e lança uma exceção personalizada se for o caso.
        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano, pois tem mais de 4 algarismos");
        }
        
        // Converte o ano de lançamento de String para int.
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        
        // Extrai os primeiros dois caracteres da duração em minutos e converte para inteiro.
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    // Métodos getters para acessar os valores dos atributos privados.
    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    // Métodos setters para modificar os valores dos atributos privados.
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    // Método para exibir a ficha técnica do título no console.
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    // Método para registrar uma avaliação ao título.
    public void avalia(double nota) {
        somaDasAvaliacoes += nota; // Adiciona a nota à soma total de avaliações.
        totalDeAvaliacoes++; // Incrementa o contador de avaliações.
    }

    // Método para calcular e retornar a média das avaliações.
    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes; // Média = soma das avaliações / número de avaliações.
    }

    // Implementação do método `compareTo`, que define a lógica de ordenação de títulos.
    // Os títulos são comparados com base no nome em ordem alfabética.
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    // Sobrescrita do método `toString` para fornecer uma representação textual do objeto.
    @Override
    public String toString() {
        return "Titulo [nome= " + nome + 
        ", anoDeLancamento= " + anoDeLancamento + ", " +
        "Duração: " + duracaoEmMinutos + "]";
    }
}
