package tsi.chainofresponsability;

import java.util.HashMap;
import java.util.Scanner;

public class ChainOfResponsability {

    public static void main(String[] args) {
        HashMap<String, Usuario> usuariosCadastrados = new HashMap<>();
        
        VerificadorBase verificadorUsuario = new VerificadorLoginDisponivel(usuariosCadastrados);
        configurarVerificadorUsuario(verificadorUsuario);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem vindo ao sistema de validação de login");
        do {
            System.out.println("Entre com o nome de usuário cadastrado:");
            String login = scanner.nextLine();
            System.out.println("Digite a senha:");
            String senha = scanner.nextLine();
            
            try {
                Usuario novoUsuario = new Usuario(login, senha);

                verificadorUsuario.verificar(novoUsuario);
                usuariosCadastrados.put(login, novoUsuario);
                System.out.println("Usuário " + login + " cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while(true);
    }
    
    private static void configurarVerificadorUsuario(VerificadorBase verificadorUsuario) {
        VerificadorSenhaCaractereEspecial verificadorSenhaCaractereEspecial = new VerificadorSenhaCaractereEspecial();
        VerificadorSenhaCaractereMaiusculo verificadorSenhaCaractereMaiusculo = new VerificadorSenhaCaractereMaiusculo();
        VerificadorSenhaCaractereMinusculo verificadorSenhaCaractereMinusculo = new VerificadorSenhaCaractereMinusculo();
        VerificadorSenhaComNumero verificadorSenhaComNumero = new VerificadorSenhaComNumero();
        VerificadorSenhaSequenciaNumerica verificadorSenhaSequenciaNumerica = new VerificadorSenhaSequenciaNumerica();
        VerificadorSenhaTamanhoMinimo verificadorSenhaTamanhoMinimo = new VerificadorSenhaTamanhoMinimo();
        VerificadorSenhaTamanhoMaximo verificadorSenhaTamanhoMaximo = new VerificadorSenhaTamanhoMaximo();
        
        verificadorUsuario.setProximo(verificadorSenhaCaractereEspecial);
        verificadorSenhaCaractereEspecial.setProximo(verificadorSenhaCaractereMaiusculo);
        verificadorSenhaCaractereMaiusculo.setProximo(verificadorSenhaCaractereMaiusculo);
        verificadorSenhaCaractereMaiusculo.setProximo(verificadorSenhaCaractereMinusculo);
        verificadorSenhaCaractereMinusculo.setProximo(verificadorSenhaComNumero);
        verificadorSenhaComNumero.setProximo(verificadorSenhaSequenciaNumerica);
        verificadorSenhaSequenciaNumerica.setProximo(verificadorSenhaTamanhoMinimo);
        verificadorSenhaTamanhoMinimo.setProximo(verificadorSenhaTamanhoMaximo);
    }
}
