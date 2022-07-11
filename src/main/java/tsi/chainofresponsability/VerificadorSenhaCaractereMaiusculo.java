package tsi.chainofresponsability;

public class VerificadorSenhaCaractereMaiusculo extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (!usuario.getSenha().matches(".*[A-Z].*"))
            throw new Exception("Senha deve conter pelo menos um caractere maiúsculo");
            
        super.verificar(usuario);
    }
}
