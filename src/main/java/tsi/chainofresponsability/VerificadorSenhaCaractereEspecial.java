package tsi.chainofresponsability;

public class VerificadorSenhaCaractereEspecial extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (!usuario.getSenha().matches(".*[=!@#$%^&*()_+-].*"))
            throw new Exception("Senha deve conter pelo menos um caractere especial");
            
        super.verificar(usuario);
    }
}
