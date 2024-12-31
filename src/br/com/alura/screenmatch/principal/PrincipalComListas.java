package br.com.alura.screenmatch.principal;

import java.util.ArrayList;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        Filme outroFilme = new Filme("Avatar", 2023);
        Filme filmeDoJeanzada = new Filme("Homem-Aranha 2", 2004);
        Serie lost = new Serie("Lost", 2004);

        ArrayList<Filme> listaAssistidos = new ArrayList<>();
        listaAssistidos.add(meuFilme);
        listaAssistidos.add(outroFilme);
        listaAssistidos.add(filmeDoJeanzada);

    }
}
