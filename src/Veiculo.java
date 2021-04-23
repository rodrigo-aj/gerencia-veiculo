public abstract class Veiculo {
    private String Modelo;
    private String Marca;
    private int AnoFabricacao;
    private double ValorMercado;
    private String Placa;
    private String TipoCombustivel;

    public Veiculo(String Modelo, String Marca, int AnoFabricacao, double ValorMercado, String Placa, String TipoCombustivel) {
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.AnoFabricacao = AnoFabricacao;
        this.ValorMercado = ValorMercado;
        this.Placa = Placa;
        this.TipoCombustivel = TipoCombustivel;
    }

    public Veiculo() {

    }

    public abstract double calcularImposto(int anoFabricacao);
    public abstract double calcularImposto(String tipoCombustivel);

    public String imprimir(Veiculo veiculo) {
        return "\nDados do veículo:\n" +
        "Modelo: " + veiculo.Modelo + "\n" + 
        "Marca: " + veiculo.Marca + "\n" + 
        "Ano de fabricacao: " + veiculo.AnoFabricacao + "\n" + 
        "Valor Mercado: " + veiculo.ValorMercado  + "\n" + 
        "Placa: " + veiculo.Placa + "\n" + 
        "Tipo Combustivel: " + veiculo.TipoCombustivel + "\n" + 
        "------------";
    }

    public String getModelo() {
        return this.Modelo;
    }

    public String getMarca() {
        return this.Marca;
    }

    public int getAnoFabricacao() {
        return this.AnoFabricacao;
    }

    public double getValorMercado() {
        return this.ValorMercado;
    }

    public void setValorMercado(double ValorMercado) {
        this.ValorMercado = ValorMercado;
    }

    public String getPlaca() {
        return this.Placa;
    }

    public String getTipoCombustivel() {
        return this.TipoCombustivel;
    }
    
}
