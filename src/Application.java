public class Application {

    /*
    Crie uma classe Application que deverá ter o método main com as seguintes funcionalidades que
    deverão acionar o(s) métodos adequados para a realização da operação escolhida.
    1 – Adicionar prato no cardápio
    2 – Remover prato do cardápio
    3 – Consultar cardápio
    4 – Adicionar ingrediente no prato
    5 – Remover ingrediente do prato
    6 – Prato mais econômico
    7 – Pratos que contém um determinado ingrediente
    8 – VOCÊ DEFINE E IMPLEMENTA ESTA FUNCIONALIDADE
    10 – Sair do programa
     */

    public static void main(String[] args) {

        Cardapio cardapio = new Cardapio(4);

        Prato arrozEfeijao = new Prato("Arroz e Feijão", 20, 2);
        Prato bifeDeGado = new  Prato("Bife de Gado", 25, 1);
        Prato marmita = new Prato("Marmita Completa", 30, 3);
        Prato estragado =  new Prato("Estragado",  0, 2);

        Ingrediente arroz = new Ingrediente("Arroz", "70g", 10);
        Ingrediente feijao = new Ingrediente("Feijão", "70g", 10);
        Ingrediente bife = new Ingrediente("Bife de Gado", "150g", 10);

        Ingrediente podre = new  Ingrediente("Podre", "70g", 1);
        Ingrediente extra = new Ingrediente("Extra", "70g", 1);

        arrozEfeijao.adicionarIngrediente(arroz);
        arrozEfeijao.adicionarIngrediente(feijao);
        arrozEfeijao.adicionarIngrediente(extra);
        //vai retornar false, erro ao adicionar ingrediente
        bifeDeGado.adicionarIngrediente(bife);

        marmita.adicionarIngrediente(arroz);
        marmita.adicionarIngrediente(feijao);
        marmita.adicionarIngrediente(bife);

        estragado.adicionarIngrediente(podre);
        estragado.adicionarIngrediente(extra);

        estragado.removerIngrediente(extra.getNome());


        cardapio.adicionarPrato(arrozEfeijao);
        cardapio.adicionarPrato(estragado);
        cardapio.adicionarPrato(bifeDeGado);
        cardapio.adicionarPrato(marmita);

        cardapio.removerPrato(estragado.getNome());

        System.out.printf("Prato com menor valor:\n%s\n", cardapio.buscarPratoEconomico().toString());

        Prato[] comFeijao = cardapio.buscarPratoIngrediente(feijao.getNome());
        System.out.println("----------");
        for (int i = 0; i < comFeijao.length; i++)
            System.out.printf("%s\n", comFeijao[i].toString());
        //claude code foi utilizado para entender o porque comFeijao[i].toString dava nullpointerexception, foi enviado o código do
        //cardápio com o prompt: Por que buscarPratoComIngrediente retorna o segundo indice como null
        //resposta → trocar buffer[i]→buffer[count++]
        System.out.println("---------------------------");

        cardapio.mostrarPratos();
        //Nota: por algum motivo existem 2 marmitas no cardapio

        //TODO: método único

        Sistema sys = new Sistema("Restaurante");
        sys.start(cardapio);
    }
}
