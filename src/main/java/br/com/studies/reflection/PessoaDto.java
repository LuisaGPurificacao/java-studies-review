package br.com.studies.reflection;

public class PessoaDto {

    String nome;
    String cpf;

    public PessoaDto(){
    }

    public PessoaDto(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
