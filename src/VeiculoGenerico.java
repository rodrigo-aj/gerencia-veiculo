import java.time.LocalDate;

public class VeiculoGenerico extends Veiculo {

    public VeiculoGenerico(String modelo, String marca, int anoFabricacao, double valorMercado, String placa, String tipoCombustivel) {
        super(modelo, marca, anoFabricacao, valorMercado, placa, tipoCombustivel);
    }

    @Override
    public double calcularImposto() {

        // Carros com mais de 20 anos são isentos (ou seja, imposto é zero);
        if (((LocalDate.now()).getYear() - getAnoFabricacao()) > 20) {
            return 0;
        }

        // Carros movidos a gasolina, diesel e flex devem pagar 4% do valor de mercado como imposto;
        if (getTipoCombustivel().equalsIgnoreCase("gasolina")
                || getTipoCombustivel().equalsIgnoreCase("diesel")
                || getTipoCombustivel().equalsIgnoreCase("flex")) {

            return getValorMercado() * 0.04;
        } else {
            //Demais combustíveis: imposto é 3% do valor de mercado;
            return getValorMercado() * 0.03;
        }
    }
}
