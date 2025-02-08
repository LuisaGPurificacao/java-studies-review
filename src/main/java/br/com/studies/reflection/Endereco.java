package br.com.studies.reflection;

public class Endereco {

    private Integer id;
    private String rua;
    private Integer numero;

    public Endereco(Integer id, String rua, Integer numero) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
