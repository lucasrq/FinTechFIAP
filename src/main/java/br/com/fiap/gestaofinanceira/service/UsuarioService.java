package br.com.fiap.gestaofinanceira.service;

import br.com.fiap.gestaofinanceira.model.Usuario;
import br.com.fiap.gestaofinanceira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void excluir(Long id){
        Optional<Usuario> usuario =  usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.deleteById(id);
        }else{
            throw new RuntimeException("usuario não encontrado");
        }
    }


    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            return usuario.get();
        }else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }


    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Optional<Usuario> usuarioAtual = usuarioRepository.findById(id);

        if(usuarioAtual.isPresent()){
            return usuarioRepository.save(usuario);
        }else{
            throw new RuntimeException("Usuario não localizado");
        }
    }



}
