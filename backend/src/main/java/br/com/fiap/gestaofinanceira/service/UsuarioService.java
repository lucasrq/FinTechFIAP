package br.com.fiap.gestaofinanceira.service;

import br.com.fiap.gestaofinanceira.model.Usuario;
import br.com.fiap.gestaofinanceira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluir(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("usuario não encontrado");
        }
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> optionalUsuarioExistente = usuarioRepository.findById(id);

        if (optionalUsuarioExistente.isPresent()) {
            Usuario usuarioExistente = optionalUsuarioExistente.get();

            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
            usuarioExistente.setRendaMensal(usuarioAtualizado.getRendaMensal());

            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario não localizado");
        }
    }

    public Optional<Usuario> login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}