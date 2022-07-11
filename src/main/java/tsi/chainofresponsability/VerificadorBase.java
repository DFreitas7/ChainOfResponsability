package tsi.chainofresponsability;

public class VerificadorBase implements VerificadorUsuario {
    private VerificadorUsuario proximo;

    @Override
    public void setProximo(VerificadorUsuario proximo) {
        this.proximo = proximo;
    }

    @Override
    public void verificar(Usuario usuario) throws Exception {
        if (proximo != null)
            proximo.verificar(usuario);
    }
}
