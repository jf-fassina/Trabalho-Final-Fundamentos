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
    e) buscarPratoIngrediente: recebe o nome do ingrediente
     e retorna um vetor com os pratos em que este
    ingrediente faça parte;
    f) buscarValorCardapio: retorna o somatório do valor de todos os pratos do restaurante;
    g) buscarPratoEconomico: retorna o prato que possui o menor valor;
    h) mostrarPratos: mostra os dados dos pratos do cardápio.
    */

    private Prato[] pratos;

    public Cardapio(int qntPratos) {
        pratos = new Prato[qntPratos];
    }


    public boolean adicionarPrato(Prato prato) {
// a) adicionarPrato: insere um objeto prato no vetor e para isto, recebe o objeto prato e retorna true
//    se a inserção pode ser realizada ou false se a inserção não foi possível;

        for (int i = 0; i <= this.pratos.length - 1; i++)
            if (this.pratos[i] == null) {
                this.pratos[i] = prato;
                return true;
            }
        return false;
    }

    public boolean reorganizaVetorPratos(int indexRemovido) {
        if (this.pratos[indexRemovido] == null) {// se null
            for (int i = indexRemovido; i < this.pratos.length - 1; i++) {
                this.pratos[i] = this.pratos[i + 1];
            }
            this.pratos[this.pratos.length - 1] = null; // limpa a última posição
            return true;
        }
        return false;
    }

    public boolean removerPrato(String nome) {
// b) removerPrato: recebe o nome do prato e, caso ele exista, remove o prato do cardápio,
//    reorganiza os objetos e retorna true se a remoção foi realizada com sucesso ou false se a
//    remoção não foi possível;
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i].getNome().equals(nome)) {
                this.pratos[i].setVetIngredientes(null);//limpa memória ingredientes
                this.pratos[i] = null;//limpa memória pratos
                reorganizaVetorPratos(i);
                return true;
            }
        }
        return false;
    }

    public Prato buscarPratoPorNome(String nome) {
// c) buscarPratoPorNome: recebe o nome do prato e retorna o prato que possui este nome;
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i].getNome().equals(nome)) {
                return pratos[i];
            }
        }
        return null;
    }

    public int buscarPosicao(Prato prato) {
// d) buscarPosicao: recebe o prato e retorna a posição do vetor em que este prato está armazenado.
//    Caso não esteja armazenado, retorna o valor -1;
        for (int i = 0; i < this.pratos.length; i++)
            if (this.pratos[i] == prato) {
                return i;
            }
        return -1;
    }

    public Prato[] buscarPratoIngrediente(String nome) {
// e) buscarPratoIngrediente: recebe o nome do Ingrediente e retorna um vetor com os pratos em que este
//    ingrediente faça parte;
        //profa corrigiu o trabalho de prato → ingrediente
        Prato[] temIngrediente;
        Prato[] buffer = new Prato[this.pratos.length];
        //Aloca memória para o cardápio inteiro

        int count = 0;
        for (int i = 0; i < this.pratos.length && this.pratos[i] != null; i++)//pratos
            for (int j = 0; j < this.pratos[i].getVetIngredientes().length; j++)//ingredientes
                if (this.pratos[i].getVetIngredientes()[j].getNome().equals(nome)) buffer[count++] = this.pratos[i];
        //Erro: buffer[i] → trocado para buffer[count++]

        //Aloca a memória para o número de pratos com o ingrediente
        temIngrediente = new Prato[count];
        if (count != 0) for (int i = 0; i < temIngrediente.length; i++)
            temIngrediente[i] = buffer[i];
        //não pode usar adicionarPrato pq o método adiciona no this.pratos e não no temIngrediente!
        return temIngrediente;
    }

    public double buscarValorCardapio() {
// f) buscarValorCardapio: retorna o somatório do valor de todos os pratos do restaurante;
        double soma = 0;
        for (int i = 0; i < this.pratos.length; i++)
            soma += this.pratos[i].getValor();
        return soma;
    }

    public Prato buscarPratoEconomico() {
// g) buscarPratoEconomico: retorna o prato que possui o menor valor;
        Prato menor = new Prato("", Double.MAX_VALUE, 0);
        for (int i = 0; i < this.pratos.length && this.pratos[i] != null; i++)
            if (this.pratos[i].getValor() < menor.getValor()) menor = this.pratos[i];
        return menor;
    }

    public void mostrarPratos() {
// h) mostrarPratos: mostra os dados dos pratos do cardápio.
        for (int i = 0; i < this.pratos.length; i++) {
            if (this.pratos[i] == null) return;//significa q a partir daqui tudo é null
            System.out.printf("Nome:\t%s\nValor:\t%.2f\n", this.pratos[i].getNome(), this.pratos[i].getValor());
        }
    }

}
