package br.com.studies.reflection.service;

import br.com.studies.reflection.Pessoa;
import br.com.studies.reflection.PessoaDto;
import br.com.studies.reflection.Transformator;
import br.com.studies.reflection.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {

    public List<PessoaDto> list() {
        List<Pessoa> modelList = new PessoaRepository().list();
        return modelList.stream().map(PessoaService::toDto).collect(Collectors.toList());
    }

    public List<PessoaDto> listWithReflections() {
        List<Pessoa> modelList = new PessoaRepository().list();
        return modelList.stream().map(m -> (PessoaDto) new Transformator().transform(m)).collect(Collectors.toList());
    }

    private static PessoaDto toDto(Pessoa model) {
        return new PessoaDto(model.getNome(), model.getCpf());
    }

}
