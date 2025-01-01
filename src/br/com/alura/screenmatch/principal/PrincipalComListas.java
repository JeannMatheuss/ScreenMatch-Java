package br.com.alura.screenmatch.principal;

import java.util.ArrayList;

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
        //lost.avalia(9);

        ArrayList<Titulo> listaAssistidos = new ArrayList<>();
        listaAssistidos.add(meuFilme);
        listaAssistidos.add(outroFilme);
        listaAssistidos.add(filmeDoJeanzada);
        listaAssistidos.add(lost);

        for (Titulo item : listaAssistidos) {
            System.out.println(item.getNome());
            Filme filme = (Filme) item;
            System.out.println("Classificação: " + filme.getClassificacao());
        }
    }
}

