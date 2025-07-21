package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDevCadastrarUsuarioComCpfComFormatoInvalido(){
        //quero que der um excesso de error
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Jaqueline", LocalDate.parse("1999-09-08"), "email@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456789-99", "Jaqueline", LocalDate.parse("1999-09-08"), "email@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456.789-99", "Jaqueline", LocalDate.parse("1999-09-08"), "email@gmail.com"));
    }
}
