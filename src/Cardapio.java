public class Cardapio {

    /*
    O gerenciamento dos pratos deve ser feito na classe Cardapio que também deve ser criada. Nesta
    classe, serão armazenados os pratos do restaurante. Crie um construtor que recebe a quantidade
    de pratos que o restaurante possui e cria o cardápio (vetor de pratos – você define quantos pratos
    haverá no cardápio). Além do construtor, esta classe deve ter os seguintes métodos:
    a) adicionarPrato: insere um objeto prato no vetor e para isto, recebe o objeto prato e retorna true
    se a inserção pode ser realizada ou false se a inserção não foi possível;
    b) removerPrato: recebe o nome do prato e, caso ele exista, remove o prato do cardápio,
    reorganiza os objetos e retorna true se a remoção foi realizada com sucesso ou false se a
    remoção não foi possível;
    c) buscarPratoPorNome: recebe o nome do prato e retorna o prato que possui este nome;
    d) buscarPosicao: recebe o prato e retorna a posição do vetor em que este prato está armazenado.
    Caso não esteja armazenado, retorna o valor -1;
    e) buscarPratoIngrediente: recebe o nome do prato e retorna um vetor com os pratos em que este
    ingrediente faça parte;
    f) buscarValorCardapio: retorna o somatório do valor de todos os pratos do restaurante;
    g) buscarPratoEconomico: retorna o prato que possui o menor valor;
    h) mostrarPratos: mostra os dados dos pratos do cardápio.
    */

    private Prato[] pratos;

    public boolean adicionarPrato(Prato prato) {
// a) adicionarPrato: insere um objeto prato no vetor e para isto, recebe o objeto prato e retorna true
//    se a inserção pode ser realizada ou false se a inserção não foi possível;

        for (int i = 0; i <= this.pratos.length - 1; i++)
            if (this.pratos[i] == null) {
                this.pratos[i] = prato;
                System.out.printf("%s foi adicionado com sucesso!\n", prato.getNome());
                return true;
            }
        System.out.printf("Erro: Não foi possível adicionar %s, vetor está cheio!\n", prato.getNome());
        return false;
    }

    public boolean reorganizaVetorPratos(int indexRemovido) {
        if (this.pratos[indexRemovido] == null) {
            for (int i = indexRemovido; i < this.pratos.length; i++) {
                this.pratos[i] = this.pratos[i + 1];
            }
            System.out.printf("Reorganizado a partir do índice '%d'\n", indexRemovido);
            return true;
        }
        System.out.printf("Index '%d' não é um valor nulo\n", indexRemovido);
        return false;
    }

    public boolean removerPrato(String nome) {
// b) removerPrato: recebe o nome do prato e, caso ele exista, remove o prato do cardápio,
//    reorganiza os objetos e retorna true se a remoção foi realizada com sucesso ou false se a
//    remoção não foi possível;
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i].getNome().equals(nome)) {
                this.pratos[i] = null;
                System.out.printf("Sucesso ao remover %s ao vetor!\n", nome);
                reorganizaVetorPratos(i);
                return true;
            }
        }
        System.out.printf("Nenhum prato '%s' encontrado!\n", nome);
        return false;
    }

    public Prato buscarPratoPorNome(String nome) {
// c) buscarPratoPorNome: recebe o nome do prato e retorna o prato que possui este nome;
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i].getNome().equals(nome)) {
                System.out.printf("Sucesso ao buscar %s no vetor!\nIndex encontrado: %d", nome, i);
                return pratos[i];
            }
        }
        System.out.printf("Nenhum prato '%s' encontrado!\n", nome);
        return null;
    }

    public int buscarPosicao(Prato prato) {
// d) buscarPosicao: recebe o prato e retorna a posição do vetor em que este prato está armazenado.
//    Caso não esteja armazenado, retorna o valor -1;
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i] == prato) {
                System.out.printf("Sucesso ao buscar %s no vetor!\nIndex encontrado: %d", prato.getNome(), i);
                return i;
            }
        }
        System.out.printf("Nenhum prato '%s' encontrado!\n", prato.getNome());
        return -1;
    }

    public Prato[] buscarPratoIngrediente(String nome) {
// e) buscarPratoIngrediente: recebe o nome do prato e retorna um vetor com os pratos em que este
//    ingrediente faça parte;
        for (int i = 0; i < this.pratos.length; i++) {

        }
        return null;
    }

    public double buscarValorCardapio() {
// f) buscarValorCardapio: retorna o somatório do valor de todos os pratos do restaurante;
    }

    public double buscarPratoEconomico() {
// g) buscarPratoEconomico: retorna o prato que possui o menor valor;
    }

    public void mostrarPratos() {
// h) mostrarPratos: mostra os dados dos pratos do cardápio.
        for (int i = 0; i < this.pratos.length; i++)
            System.out.printf("Nome:\t%s\nValor:\t%.2d", pratos[i].getNome(), pratos[i].getValor());
    }

}
