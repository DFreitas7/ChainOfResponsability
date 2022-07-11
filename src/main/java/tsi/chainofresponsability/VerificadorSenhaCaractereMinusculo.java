package tsi.chainofresponsability;

public class VerificadorSenhaCaractereMinusculo extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (!usuario.getSenha().matches(".*[a-z].*"))
            throw new Exception("Senha deve conter pelo menos um caractere minúsculo");
            
        super.verificar(usuario);
    }
}
