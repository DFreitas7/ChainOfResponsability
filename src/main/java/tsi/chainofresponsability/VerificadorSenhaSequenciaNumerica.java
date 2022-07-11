package tsi.chainofresponsability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorSenhaSequenciaNumerica extends VerificadorBase {
    @Override
    public void verificar(Usuario usuario) throws Exception {
        try {
            Pattern regexSequenciaNumerica = Pattern.compile("[0-9]{3}");
            Matcher matcher = regexSequenciaNumerica.matcher(usuario.getSenha());

            for(int i = 0; i < usuario.getSenha().length(); i++) {
                matcher.find(i);
                char[] textoGrupoNumerico = matcher.group().toCharArray();

                if (textoGrupoNumerico[0] == textoGrupoNumerico[1] - 1 &&
                    textoGrupoNumerico[1] == textoGrupoNumerico[2] - 1) {
                  throw new Exception("Senha não pode conter uma sequencia de 3 numeros");   
                }
            }
        } catch (Exception e){
            
        }
            
        super.verificar(usuario);
    }
}
