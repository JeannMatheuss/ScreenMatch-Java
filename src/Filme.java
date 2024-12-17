public class Filme {
    public String nome;
    public int anoDeLancamento;
    public boolean incluidoNoPlano;
    public double somaDasAvaliacoes;
    public int totalDeAvaliacoes;
    public int duracaoEmMinutos;

    // criando um metodo
    void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
