package br.com.studies.reflection;


import org.junit.Test;

import static org.junit.Assert.*;

public class TransformatorTest {

    Transformator transformator = new Transformator();

    @Test
    public void shouldTransform() {
        Pessoa model = getPessoa();

        PessoaDto dto = transformator.transform(model);

        assertEquals(PessoaDto.class, dto.getClass());
        assertEquals("Carol", dto.getNome());
        assertEquals("123.654.345-99", dto.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Endereco model = getEndereco();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> transformator.transform(model));

        assertEquals("Error while trying to transform items", exception.getMessage());
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() {
        Pessoa model = getPessoa();
        model.setCpf(null);

        PessoaDto dto = transformator.transform(model);

        assertEquals(PessoaDto.class, dto.getClass());
        assertEquals("Carol", dto.getNome());
        assertNull(dto.getCpf());
    }

    private Pessoa getPessoa() {
        return new Pessoa(1, "Carol", "123.654.345-99");
    }

    private Endereco getEndereco() {
        return new Endereco(1, "Rua Tanana", 290);
    }

}