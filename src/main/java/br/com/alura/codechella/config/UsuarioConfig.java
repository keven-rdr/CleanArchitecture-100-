package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AtualizarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.CriarUsuario;

import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    public RepositorioDeUsuario repositorioDeUsuario(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(repository, mapper);
    }

    @Bean
    public UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    public ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    public AtualizarUsuarioUseCase atualizarUser(RepositorioDeUsuario repositorioDeUsuario){
        return new AtualizarUsuarioUseCase(repositorioDeUsuario);
    }

    @Bean
    public DeletarUsuario deletar(RepositorioDeUsuario repositorioDeUsuario){
        return  new DeletarUsuario(repositorioDeUsuario);
    }
}