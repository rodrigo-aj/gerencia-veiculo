import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarVeiculos {
    private ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public String listarVeiculos() {
        String saida = "";

        for (Veiculo v : veiculos) {
            saida += v.imprimir() + "\n";
        }

        return saida;
    }

    public boolean remover(String placa) {
        // usando Iterator para evitar ConcurrentModificationException, pois a lista era modificada enquanto em loop
        // will break if you try to modify a collection while iterating over it

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
                listaVeiculos.append(v.imprimir());
            }
        }

        return listaVeiculos.length() > 0 ? listaVeiculos.toString() : "Nada encontrado!\n";
    }

    public double obterValorImposto(String placa) {

        Veiculo v = this.buscarPorPlaca(placa);

        if (v == null) {
            return -1;
        } else {
            return v.calcularImposto();
        }
    }
}
