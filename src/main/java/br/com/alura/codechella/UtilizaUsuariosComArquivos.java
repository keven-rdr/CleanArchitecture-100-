package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("121.121.121-43", "João",
                LocalDate.parse("2002-06-12"), "joao@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("121.121.121-43", "Maria",
                LocalDate.parse("2002-06-12"), "maria@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("121.121.121-43", "Vinicius",
                LocalDate.parse("2002-06-12"), "vinicius@gmail.com"));

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("121.121.121-43", "Rafael",
                LocalDate.parse("2002-06-12"), "rafael@gmail.com"));


//       System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuario.txt");
    }

}
