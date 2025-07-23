package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AtualizarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final RepositorioDeUsuario repositorioDeUsuario;
    private final DeletarUsuario deletarUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AtualizarUsuarioUseCase atualizarUsuarioUseCase, RepositorioDeUsuario repositorioDeUsuario, DeletarUsuario deletarUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
        this.repositorioDeUsuario = repositorioDeUsuario;
        this.deletarUsuario = deletarUsuario;
    }


    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto){
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(),  dto.nome(), dto.nascimento(), dto.email()));

        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios(){
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto dto) {
        Usuario usuario = new Usuario(cpf, dto.nome(), dto.nascimento(), dto.email());
        Usuario atualizado = atualizarUsuarioUseCase.executar(usuario);
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void deletarUsuario(@PathVariable String cpf){
        deletarUsuario.deletar(cpf);
    }


}
