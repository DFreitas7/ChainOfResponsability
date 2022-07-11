package tsi.chainofresponsability;

public class VerificadorSenhaTamanhoMaximo extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (usuario.getSenha().length() > 16)
            throw new Exception("Senha deve conter no maximo 16 caracteres");
            
        super.verificar(usuario);
    }
}
