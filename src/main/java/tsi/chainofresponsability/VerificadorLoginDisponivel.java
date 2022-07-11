package tsi.chainofresponsability;

import java.util.HashMap;

public class VerificadorLoginDisponivel extends VerificadorBase {
    private HashMap<String, Usuario> usuariosCadastrados;

    public VerificadorLoginDisponivel(HashMap<String, Usuario> usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (usuariosCadastrados.get(usuario.getLogin()) != null)
            throw new Exception("Nome de usuário já está cadastrado no sistema!");
        
        super.verificar(usuario);
    }
    
    
}
