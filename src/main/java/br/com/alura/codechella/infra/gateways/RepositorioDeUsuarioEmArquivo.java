package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    //Apenas uma lista de Usuarios em memoria
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public void deletarUsuario(String usuario) {

    }

    public void gravaEmArquivo(String nomeArquivo){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
