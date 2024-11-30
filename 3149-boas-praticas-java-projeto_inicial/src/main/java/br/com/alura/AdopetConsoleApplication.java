package br.com.alura;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");

        CommandExecutor executor = new CommandExecutor();
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                if (opcaoEscolhida == 5) {
                    System.out.println("Finalizando o programa...");
                    return;
                }

                Command command = CommandRegistry.getCommand(opcaoEscolhida);

                if (command != null) {
                    executor.invoker(command);
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                    opcaoEscolhida = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
