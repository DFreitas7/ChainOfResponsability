package tsi.chainofresponsability;

public class VerificadorSenhaTamanhoMinimo extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (usuario.getSenha().length() < 8)
            throw new Exception("Senha deve conter pelo menos 8 caracteres");
            
        super.verificar(usuario);
    }
}
