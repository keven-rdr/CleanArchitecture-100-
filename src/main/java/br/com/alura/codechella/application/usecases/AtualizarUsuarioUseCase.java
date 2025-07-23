package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AtualizarUsuarioUseCase {

    private final RepositorioDeUsuario repositorio;

    public AtualizarUsuarioUseCase(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario executar(Usuario usuario) {
        return repositorio.atualizarUsuario(usuario);
    }
}
