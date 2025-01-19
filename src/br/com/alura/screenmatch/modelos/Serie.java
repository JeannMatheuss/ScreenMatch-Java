package br.com.alura.screenmatch.modelos;

// Classe Serie que estende a classe Titulo.
public class Serie extends Titulo {
    // Atributos específicos de uma série.
    private int temporadas; // Número de temporadas da série.
    private boolean ativa; // Indica se a série ainda está em exibição.
    private int episodiosPorTemporada; // Número de episódios em cada temporada.
    private int minutosPorEpisodio; // Duração média de cada episódio, em minutos.

    // Construtor que inicializa a série com nome e ano de lançamento.
    // Utiliza o construtor da classe base (Titulo) com o uso do `super`.
    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // Getter para o número de temporadas.
    public int getTemporadas() {
        return temporadas;
    }

    // Setter para definir o número de temporadas.
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Getter para verificar se a série está ativa.
    public boolean isAtiva() {
        return ativa;
    }

    // Setter para alterar o status ativo da série.
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    // Getter para o número de episódios por temporada.
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    // Setter para definir o número de episódios por temporada.
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    // Getter para a duração média de cada episódio.
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // Setter para definir a duração média de cada episódio.
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    // Sobrescreve o método getDuracaoEmMinutos da classe base.
    // Calcula a duração total da série em minutos (temporadas * episódios por temporada * minutos por episódio).
    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    // Sobrescreve o método toString para fornecer uma representação textual da série.
    @Override
    public String toString() {
        return "Serie: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
