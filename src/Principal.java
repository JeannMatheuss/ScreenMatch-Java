// importando o pacote
import br.com.alura.screenmatch.modelos.Filme;

// classe Principal
public class Principal {
    public static void main(String[] args) throws Exception {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoEmMinutos(180);

        // chamando o metodo para exibir a fichaTecnica
        meuFilme.exibeFichaTecnica();

        // notas para fazer a avaliação
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
    }
}
