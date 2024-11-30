package br.com.alura;

public class CommandRegistry {

    public static Command getCommand(int opcao) {
        return switch (opcao) {
            case 1 -> new ListarAbrigoCommand();
            case 2 -> new CadastrarAbrigoCommand();
            case 3 -> new ListarPetsDoAbrigoCommand();
            case 4 -> new ImportarPetsDoAbrigoCommand();
            default -> null;
        };
    }
}
