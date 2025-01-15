package br.com.alura.screenmatch.modelos;

// Importa a anotação para personalizar o mapeamento de nomes de campos no JSON.
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    
    // Define o mapeamento dos campos no JSON para os atributos da classe.
    @SerializedName("Title")
    private String nome; // Nome do título (ex.: nome do filme).
    
    @SerializedName("Year")
    private int anoDeLancamento; // Ano de lançamento do título.

    private boolean incluidoNoPlano; // Indica se o título está incluído em um plano (ex.: streaming).
    private double somaDasAvaliacoes; // Soma total das avaliações recebidas.
    private int totalDeAvaliacoes; // Número total de avaliações recebidas.
    private int duracaoEmMinutos; // Duração do título em minutos.

    // Construtor principal para inicializar um título com nome e ano de lançamento.
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    // Construtor que recebe um objeto da classe `TituloOmdb` e converte para `Titulo`.
    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title(); // Pega o título do objeto OMDB.
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year()); // Converte o ano de string para inteiro.
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2)); 
        // Extrai os primeiros dois caracteres da duração em minutos (ex.: "120 min").
    }

    // Métodos de acesso (getters) para obter os valores dos atributos privados.
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

    // Métodos de modificação (setters) para alterar os valores dos atributos privados.
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

    // Método para exibir a ficha técnica do título.
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    // Método para avaliar o título, somando a nota e aumentando o contador de avaliações.
    public void avalia(double nota) {
        somaDasAvaliacoes += nota; // Adiciona a nota à soma total.
        totalDeAvaliacoes++; // Incrementa o número total de avaliações.
    }

    // Método para calcular e retornar a média das avaliações.
    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes; // Média = soma das notas / total de avaliações.
    }

    // Implementação do método `compareTo` para permitir a comparação entre títulos.
    // A comparação é feita com base no nome do título (ordem alfabética).
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    // Sobrescreve o método `toString` para fornecer uma representação em texto do título.
    @Override
    public String toString() {
        return "Titulo [nome= " + nome + 
        ", anoDeLancamento= " + anoDeLancamento + ", " +
        "Duração: " + duracaoEmMinutos + "]";
    }
}
