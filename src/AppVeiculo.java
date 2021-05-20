import java.util.Scanner;

public class AppVeiculo {

    public static void main(String[] args) {
        GerenciarVeiculos carro = new GerenciarVeiculos();

        String modelo, marca, placa, tipoCombustivel, msg;
        int menu, anoFabricacao;
        double valorMercado;
        Scanner teclado;

        do {
            teclado = new Scanner(System.in);

            System.out.println("\n1- adicionar veículo");
            System.out.println("2- remover veículo");
            System.out.println("3- buscar veículo por placa");
            System.out.println("4- listar por tipo combustível");
            System.out.println("5- listar todos");
            System.out.println("6- obter valor imposto por placa");
            System.out.println("7- sair\n");

            menu = Integer.parseInt(teclado.nextLine());

            switch (menu) {

                case 1:
//                System.out.println("Informe o modelo do veículo: ");
//                modelo = teclado.nextLine();
//
//                System.out.println("Informe a marca do veículo: ");
//                marca = teclado.nextLine();
//
//                System.out.println("Informe a placa do veículo: ");
//                placa = teclado.nextLine();
//
//                System.out.println("Informe o tipo de combustível do veículo: ");
//                tipoCombustivel = teclado.nextLine();
//
//                System.out.println("Informe o ano do veículo: ");
//                anoFabricacao = teclado.nextInt();
//
//                System.out.println("Informe o valor de mercado do veículo: ");
//                valorMercado = teclado.nextDouble();
//
//                carro.adicionar(new VeiculoGenerico(modelo, marca, anoFabricacao, valorMercado, placa, tipoCombustivel));

                    /*  --->TESTES<--- */
                    carro.adicionar(new VeiculoGenerico("modelo1", "marca1", 2011, 11100, "aaa", "gasolina"));
                    carro.adicionar(new VeiculoGenerico("modelo2", "marca2", 2012, 222000, "bbb", "gasolina"));
                    carro.adicionar(new VeiculoGenerico("modelo3", "marca3", 2013, 333000, "ccc", "gasolina"));
                    carro.adicionar(new VeiculoGenerico("modelo4", "marca4", 2014, 444000, "ddd", "flex"));
                    carro.adicionar(new VeiculoGenerico("modelo5", "marc5", 2015, 555000, "eee", "flex"));
                    carro.adicionar(new VeiculoGenerico("modelo6", "marc6", 2016, 666000, "fff", "flex"));
                    carro.adicionar(new VeiculoGenerico("modelo7", "marca7", 2017, 777000, "ggg", "diesel"));
                    carro.adicionar(new VeiculoGenerico("modelo8", "marca8", 2018, 888000, "hhh", "diesel"));
                    carro.adicionar(new VeiculoGenerico("modelo9", "marca9", 2019, 999000, "iii", "diesel"));
                    carro.adicionar(new VeiculoGenerico("modelo10", "marca10", 2020, 1000000, "jjj", "alcool"));

                    System.out.println("Inserção finalizada!");
                    break;

                case 2:
                    System.out.println(carro.listarVeiculos());
                    System.out.println("\nDigite a placa do veículo a ser removido: ");
                    placa = teclado.nextLine();

                    msg = carro.remover(placa) ? "\nVeículo removido com sucesso" : "\nPlaca informada não localizada";
                    System.out.println(msg);
                    break;

                case 3:
                    System.out.println("\nDigite a placa do veículo a ser pesquisado: ");
                    placa = teclado.nextLine();
                    Veiculo buscaCarro = carro.buscarPorPlaca(placa);
                    msg = buscaCarro != null ? buscaCarro.imprimir() : "\nPlaca informada não localizada";
                    System.out.println(msg);
                    break;

                case 4:
                    System.out.println("\nDigite o tipo de combustível: ");
                    tipoCombustivel = teclado.nextLine();
                    System.out.println(carro.listarVeiculosPorCombustivel(tipoCombustivel));
                    break;

                case 5:
                    System.out.println(carro.listarVeiculos());
                    break;

                case 6:
                    System.out.println("\nDigite a placa do veículo a ser pesquisado: ");
                    placa = teclado.nextLine();

                    double valorImposto = carro.obterValorImposto(placa);

                    if (valorImposto == -1) {
                        System.out.println("\nPlaca informada não localizada\n");
                    } else {
                        System.out.printf("Valor do imposto do veículo é de: R$ %.2f\n", valorImposto);
                    }
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (menu != 7);

        teclado.close();
    }
}
