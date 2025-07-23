package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario atualizarUsuario(Usuario usuario);

    Optional<Usuario> buscarPorCpf(String cpf);

    void deletarUsuario(String usuario);
}
