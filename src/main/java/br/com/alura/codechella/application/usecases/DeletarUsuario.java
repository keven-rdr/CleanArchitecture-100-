package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;

public class DeletarUsuario {

    private final RepositorioDeUsuario repositorio;

    public DeletarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void deletar(String cpf) {
        repositorio.deletarUsuario(cpf);
    }

}
