import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        try {
            System.out.println("Digite o primeiro parâmetro: ");
            int parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro: ");
            int parametroDois = terminal.nextInt();

            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        } finally {
            terminal.close(); // Fechar o scanner no bloco finally
        }
    }

    // Exceção personalizada deve ser estática se for usada em um contexto estático
    static class ParametrosInvalidosException extends Exception {
        public ParametrosInvalidosException(String mensagem) {
            super(mensagem);
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é maior ou igual a parametroDois e lançar a exceção
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        // Calcular a contagem de números a serem impressos
        int contagem = parametroDois - parametroUm + 1; // +1 para incluir o parametroDois

        // Realizar o loop para imprimir os números do primeiro ao segundo parâmetro
        for (int i=1; i < contagem; i++) {
            // Imprime o número começando do parametroUm e adicionando o índice do loop
            System.out.println(i);
        }
    }
}
