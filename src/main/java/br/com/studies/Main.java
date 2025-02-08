package br.com.studies;

import br.com.studies.reflection.ObjectToJson;
import br.com.studies.reflection.Pessoa;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "João", "12345");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
    }

}