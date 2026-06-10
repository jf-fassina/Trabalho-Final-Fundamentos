import java.util.Scanner;

public class Sistema {
    //Inicia uma interface em terminal (TUI)
    private String nome;
    private Scanner input = new Scanner(System.in);
    private final String SENHA = "$enha123";


    public Sistema(String nome) {
        this.nome = nome;
    }


    //Loop principal, ou seja, roda o tempo inteiro
    private void update(char tipo) {
        int entrada = Integer.MIN_VALUE;
        while (entrada != -1) {//-1 significa sair do sistema

        if(tipo == 'c'){


        } else if(tipo == 'f'){

        } else {
            System.err.printf("Erro! Tipo '%c' não encontrado\n", tipo);
        }


        }
    }

    //inicia o "Sistema"
    public void start() {

        System.out.printf("""
                 =====================================
                 \s
                 \tBem-Vindo ao Restaurante %s\s\s
                 \s
                 =====================================
                \s""", nome);

        char tipo = selecionarTipo(input.nextInt());

        update(tipo);

        System.out.printf("Fechando o sistema de %s", this.nome);

    }

    private char selecionarTipo(int n) {
        input.next();//para limpar cache e evitar erros
        char c = 'e';
        //caractere 'e' significa erro!
        do {
            switch (n) {
                case 0:
                    //cliente
                    c = 'c';
                    break;
                case 1:
                    //funcionario
                    if (isFuncionario()) c = 'f';
                    else n = 67;
                    break;
                default:
                    System.err.print("Selecione um tipo válido!\n");
                    break;
            }
        } while (n != 0 || n != 1);
        return c;
    }

    public boolean isFuncionario() {
        System.out.printf("\nDigite a senha de Funcionário($enha123): ");

        if (input.nextLine().equals(this.SENHA)) {
            System.out.printf("\nSenha correta!\n");
            return true;
        }
        System.err.printf("\nSenha incorreta!\n");
        return false;
    }


}
