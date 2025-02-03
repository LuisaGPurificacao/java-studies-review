package br.com.studies.service;

import br.com.studies.dto.PessoaDto;
import br.com.studies.model.Pessoa;
import br.com.studies.repository.PessoaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {

    public List<PessoaDto> list() {
        List<Pessoa> modelList = new PessoaRepository().list();
        return modelList.stream().map(PessoaService::toDto).collect(Collectors.toList());
    }

    private static PessoaDto toDto(Pessoa model) {
        return new PessoaDto(model.getNome(), model.getCpf());
    }

}
