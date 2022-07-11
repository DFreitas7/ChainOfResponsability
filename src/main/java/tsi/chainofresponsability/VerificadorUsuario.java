package tsi.chainofresponsability;

public interface VerificadorUsuario {
    public void setProximo(VerificadorUsuario proximo);
    public void verificar(Usuario usuario) throws Exception ;
}
