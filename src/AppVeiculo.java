import java.util.Scanner;

public class AppVeiculo {

    public static void main(String[] args) {
        GerenciarVeiculos carro = new GerenciarVeiculos();
        int menu;
        String modelo, marca, placa, tipoCombustivel, msg;
        int anoFabricacao;
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
                System.out.println("Informe o modelo do veículo: ");
                modelo = teclado.nextLine();

                System.out.println("Informe a marca do veículo: ");
                marca = teclado.nextLine();

                System.out.println("Informe a placa do veículo: ");
                placa = teclado.nextLine();

                System.out.println("Informe o tipo de combustível do veículo: ");
                tipoCombustivel = teclado.nextLine();

                System.out.println("Informe o ano do veículo: ");
                anoFabricacao = teclado.nextInt();

                System.out.println("Informe o valor de mercado do veículo: ");
                valorMercado = teclado.nextDouble();

                carro.adicionar(
                        new GerenciarVeiculos(modelo, marca, anoFabricacao, valorMercado, placa, tipoCombustivel));
                break;

            case 2:
                System.out.println(carro.listarVeiculos());
                System.out.println("\nDigite a placa do veículo a ser removido: ");
                placa = teclado.nextLine();

                msg = carro.remmover(placa) ? "\nVeículo removido com sucesso" : "\nPlaca informada não localizada";
                System.out.println(msg);
                break;

            case 3:
                System.out.println("\nDigite a placa do veículo a ser pesquisado: ");
                placa = teclado.nextLine();
                Veiculo buscaCarro = carro.buscarPorPlaca(placa);
                msg = buscaCarro != null ? carro.imprimir(buscaCarro) : "\nPlaca informada não localizada";
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
                carro.obterValorImposto(placa);
                //System.out.println(carro.obterValorImposto(placa));
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
