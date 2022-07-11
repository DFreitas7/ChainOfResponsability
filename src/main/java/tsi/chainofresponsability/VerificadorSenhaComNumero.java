package tsi.chainofresponsability;

public class VerificadorSenhaComNumero extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (!usuario.getSenha().matches(".*[0-9].*"))
            throw new Exception("Senha deve conter pelo menos um caractere especial");
            
        super.verificar(usuario);
    }
}
