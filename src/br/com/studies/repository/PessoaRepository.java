package br.com.studies.repository;

import br.com.studies.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    public List<Pessoa> list() {
        return new ArrayList<>(List.of(new Pessoa(1, "Carol", "052.591.021-74"),
                new Pessoa(2, "Lívia", "435.127.076-62")));
    }

}
