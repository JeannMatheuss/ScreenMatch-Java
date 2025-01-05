package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(8);
        Filme filmeDoJeanzada = new Filme("Homem-Aranha 2", 2004);
        filmeDoJeanzada.avalia(10);
        Serie lost = new Serie("Lost", 2004);
        
        //Filme f1 = filmeDoJeanzada;

        ArrayList<Titulo> listaAssistidos = new ArrayList<>();
        listaAssistidos.add(meuFilme);
        listaAssistidos.add(outroFilme);
        listaAssistidos.add(filmeDoJeanzada);
        listaAssistidos.add(lost);

        for (Titulo item : listaAssistidos) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
            System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Tom Hanks");
        buscaPorArtista.add("Leonardo DiCaprio");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: ");
        System.out.println(buscaPorArtista);

        System.out.println("Lista de filmes assistidos ordenados: ");
        Collections.sort(listaAssistidos);
        System.out.println(listaAssistidos);

        listaAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando pelo ano de lançamento: ");
        System.out.println(listaAssistidos);
    }
}

