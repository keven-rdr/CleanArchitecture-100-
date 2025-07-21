package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.FabricaDeUsuario;
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

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Jaqueline", "123.456.789-99", LocalDate.parse("2001-02-23"));

        //primeiro é o que eu expero, e o que realmente veio
        Assertions.assertEquals("Jaqueline", usuario.getNome());

        usuario = fabrica.incluiEndereco("12312-999", 40,"apto 201");

        //primeiro é o que eu expero, e o que realmente veio
        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarSendoMenordeIdade(){
        LocalDate dataMenorDeIdade = LocalDate.now().minusYears(17);
       Assertions.assertThrows(IllegalArgumentException.class,
               () -> new Usuario("123.456.789-99", "Jaqueline", dataMenorDeIdade,"email@gmail.com" ));
    }
}
