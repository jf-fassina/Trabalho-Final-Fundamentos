public class Prato {
    /*
    Criar, também, uma classe Prato que terá os seguintes atributos: nome (String), valor (double),
    vetIngredientes (vetor de Ingredientes) e index (int) que servirá para gerenciar as inserções e
    remoções dos ingredientes no vetIngredientes. O construtor desta classe deverá receber como
    parâmetro o nome, o valor do prato e a quantidade de ingredientes que o prato possui. Ainda no
    construtor devem ser atribuídos os valores aos atributos, inicializar o atributo index e instanciar o
    vetor de ingredientes (vetIngredientes) com a quantidade de ingredientes que o prato possui. Crie
    os demais métodos básicos necessários para a classe (estejam atentos ao atributo index que apenas
    a classe deve ter acesso a ele e ao atributo veIngredientes que terá seus próprios métodos de
    acesso, relacionados abaixo). Além do construtor e dos métodos básicos, a classe Prato deve possuir
    os seguintes métodos:

    a) adicionarIngrediente que recebe um Ingrediente e, se houver espaço, adiciona-o ao vetor de
    ingredientes, retorna true se a inserção pode ser realizada ou false se a inserção não foi possível;
    b) consultarIngrediente que recebe o nome do ingrediente, procura-o no vetor de ingredientes e
    o retorna;
    c) removerIngrediente que recebe o nome do ingrediente, consulta-o no vetor de ingredientes e,
    ao encontrá-lo, o remove do vetor de ingredientes, fazendo a reorganização do vetor de
    ingredientes. Retorna true se a remoção foi realizada com sucesso ou false se a remoção não foi
    possível;
    d) buscarPosicao que recebe o nome do ingrediente e retorna a posição em que ele está
    armazenado no vetor de ingredientes. Caso não esteja armazenado, retorna -1;

   */

    private String nome;
    private Ingrediente[] vetIngredientes;
    private int index;

    public Prato(String nome, Ingrediente[] vetIngredientes, int index) {
        this.nome = nome;
        this.vetIngredientes = vetIngredientes;
        this.index = index;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ingrediente[] getVetIngredientes() {
        return vetIngredientes;
    }

    public void setVetIngredientes(Ingrediente[] vetIngredientes) {
        this.vetIngredientes = vetIngredientes;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
