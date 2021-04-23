import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarVeiculos extends Veiculo {

    private ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos(String Modelo, String Marca, int AnoFabricacao, double ValorMercado, String Placa, String TipoCombustivel) {
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
        //usando Iterator para evitar ConcurrentModificationException, pois a lista era modificada enquanto em loop
        //if you try to modify a collection while iterating over it
        
        boolean retorno = false;

        Iterator<Veiculo> i = veiculos.iterator();

        while(i.hasNext()) {
            Veiculo v = i.next();

            if (v.getPlaca().equalsIgnoreCase(placa)) {
                i.remove();

                retorno =  true;
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

            if (v.getTipoCombustivel().equalsIgnoreCase(combustivel)){
                listaVeiculos.append(super.imprimir(v));    
            }
         }

         return listaVeiculos.length() > 0 ? listaVeiculos.toString() : "Nada encontrado!";
     }

    @Override
    public double calcularImposto(int anoFabricacao) {
        return 0;
    }

    @Override
    public double calcularImposto(String tipoCombustivel) {
        return 0;
    }

}
