import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarVeiculos extends Veiculo {

    private ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos(String Modelo, String Marca, int AnoFabricacao, double ValorMercado, String Placa,
            String TipoCombustivel) {
        super(Modelo, Marca, AnoFabricacao, ValorMercado, Placa, TipoCombustivel);
        veiculos = new ArrayList<>();
    }

    public GerenciarVeiculos() {
        veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public String listarVeiculos() {
        StringBuilder listaVeiculos = new StringBuilder();

        System.out.println("Quantidade de veículos cadastrados: " + veiculos.size());

        for (Veiculo v : veiculos) {
            listaVeiculos.append(super.imprimir(v));
        }

        return listaVeiculos.toString();
    }

    public boolean remmover(String placa) {
        // usando Iterator para evitar ConcurrentModificationException, pois a lista era
        // modificada enquanto em loop
        // if you try to modify a collection while iterating over it

        boolean retorno = false;

        Iterator<Veiculo> i = veiculos.iterator();

        while (i.hasNext()) {
            Veiculo v = i.next();

            if (v.getPlaca().equalsIgnoreCase(placa)) {
                i.remove();

                retorno = true;
            }
        }

        return retorno;
    }

    public Veiculo buscarPorPlaca(String placa) {

        Veiculo retorno = null;

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                retorno = v;
            }
        }

        return retorno;
    }

    public String listarVeiculosPorCombustivel(String combustivel) {
        StringBuilder listaVeiculos = new StringBuilder();

        for (Veiculo v : veiculos) {

            if (v.getTipoCombustivel().equalsIgnoreCase(combustivel)) {
                listaVeiculos.append(super.imprimir(v));
            }
        }

        return listaVeiculos.length() > 0 ? listaVeiculos.toString() : "Nada encontrado!";
    }

    public String obterValorImposto(String placa) {
        double valorImposto = this.calcularImposto(placa);

        if (valorImposto == -1) {
            return "\nPlaca informada não localizada";
        } else {
            return "\nValor do imposto do veículo é de: R$ " + valorImposto;
        }
    }

    @Override
    public double calcularImposto(String placa) {

        Veiculo veiculo = this.buscarPorPlaca(placa);

        if (veiculo == null){

            return -1;
        }

        // Carros com mais de 20 anos são isentos (ou seja, imposto é zero);
        if ((2021 - veiculo.getAnoFabricacao()) > 20) {

            return 0;
        }

        // Carros movidos a gasolina, diesel e flex devem pagar 4% do valor de mercado como imposto;
        if (veiculo.getTipoCombustivel().equalsIgnoreCase("gasolina")
                || veiculo.getTipoCombustivel().equalsIgnoreCase("diesel")
                || veiculo.getTipoCombustivel().equalsIgnoreCase("flex")) {

            return veiculo.getValorMercado() * 0.04;
        } else { //Demais combustíveis: imposto é 3% do valor de mercado;

            return veiculo.getValorMercado() * 0.03;
        }
    }

}
