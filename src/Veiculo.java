public abstract class Veiculo {
    private String modelo;
    private String marca;
    private int anoFabricacao;
    private double valorMercado;
    private String placa;
    private String tipoCombustivel;

    public Veiculo(String modelo, String marca, int anoFabricacao, double valorMercado, String placa, String tipoCombustivel) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.valorMercado = valorMercado;
        this.placa = placa;
        this.tipoCombustivel = tipoCombustivel;
    }

    public abstract double calcularImposto();

    public String imprimir() {
        return "\nDados do veículo:" +
                "\nModelo: " + this.getModelo() +
                "\nMarca: " + this.getMarca() +
                "\nAno de fabricacao: " + this.getAnoFabricacao() +
                "\nValor Mercado: " + String.format("%.2f", this.getValorMercado()) +
                "\nPlaca: " + this.getPlaca() +
                "\nTipo Combustivel: " + this.getTipoCombustivel() +
                "\n------------";
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public double getValorMercado() {
        return this.valorMercado;
    }

    public void setValorMercado(double ValorMercado) {
        this.valorMercado = ValorMercado;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getTipoCombustivel() {
        return this.tipoCombustivel;
    }

}
