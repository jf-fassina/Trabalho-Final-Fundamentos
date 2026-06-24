import java.util.Scanner;

public class Sistema {
  // Inicia uma interface em terminal (TUI)
  private String nome;
  private Scanner input = new Scanner(System.in);
  private final String SENHA = "$enha123";

  public Sistema(String nome) {
    this.nome = nome;
  }

  // Loop principal, ou seja, roda o tempo inteiro
  private void update(char tipo, Cardapio cardapio) {
    boolean loop = true;
    while (loop) {
      switch (tipo) {
        case 'c':
          loop = cliente(cardapio);
          break;
        case 'f':
          loop = funcionario(cardapio);
          break;
        default:
          System.err.printf("Erro! Tipo '%c' não encontrado\n", tipo);
          loop = false;
          break;
      }
    }
  }

  // inicia o "Sistema"
  public void start(Cardapio cardapio) {
    System.out.printf("""
         ========================================================================
         \s
         \t\tBem-Vindo ao Restaurante %s
         \s
         ========================================================================
        \s\n""", nome);

    int entrada;
    char tipo;
    do {
      System.out.printf("[0] Cliente\n[1] Funcionário\nSelecione sua função: ");
      entrada = input.nextInt();
      input.nextLine(); // consome o '\n' que ficou no buffer após nextInt()
      tipo = selecionarTipo(entrada);
    } while (tipo == 'e'); // repete enquanto não houver um tipo válido

    System.out.printf("\n");
    update(tipo, cardapio);
    System.out.printf("Fechando o sistema de %s", this.nome);
  }

  private boolean cliente(Cardapio cardapio) {
    System.out.printf("Digite o nome do prato a pedir:\n");
    cardapio.mostrarPratos();
    cardapio.buscarPratoPorNome(input.nextLine());
    return false; // volta ao menu principal após o pedido
  }

  private boolean funcionario(Cardapio cardapio) {
    System.out.printf("\n[0] Adicionar Prato\n[1] Remover Prato\n[2] Adicionar Ingrediente\n[3] Remover Ingrediente\nSelecione sua ação: ");
    entrada = input.nextInt();
    return false;
  }

  private char selecionarTipo(int n) {
    char c = 'e';
    // caractere 'e' significa erro!
    switch (n) {
      case 0:
        // cliente
        c = 'c';
        break;
      case 1:
        // funcionario
        if (isFuncionario())
          c = 'f';
        break;
      default:
        System.err.print("Selecione um tipo válido!\n");
        break;
    }
    return c;
  }

  public boolean isFuncionario() {
    System.out.printf("\nDigite a senha de Funcionário: ");
    if (input.nextLine().equals(this.SENHA)) {
      System.out.printf("Senha correta!\n");
      return true;
    }
    System.err.printf("Senha incorreta!\n");
    return false;
  }
}
