package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .map(mapper::toDomain);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario){
        UsuarioEntity existente = repository.findByCpf(usuario.getCpf())
                        .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        existente.setEmail(usuario.getEmail());
        existente.setNome(usuario.getNome());
        existente.setNascimento(usuario.getNascimento());

        UsuarioEntity salvo = repository.save(existente);
        return mapper.toDomain(salvo);
    }

    @Override
    public void deletarUsuario(String cpf) {
        UsuarioEntity existente = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        repository.delete(existente);
    }
}
