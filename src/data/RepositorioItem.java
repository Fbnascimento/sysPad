package data;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class RepositorioItem implements IRepositorioItem {

	private List<Item> item;
	private int indice;

	public RepositorioItem(int capacidadeInicial) {
		this.item = new ArrayList<>(capacidadeInicial);
	}

	@Override
	public String listarItens() {
		String resultado = "";
		for (Item p : this.item) {
			resultado = resultado + "[C�digo: " + p.getCodigo() + "] [Nome: " + p.getNome() + "] [Fabricante: "
					+ p.getFabricante() + "] [Tipo: " + p.getTipo() + "] [Unidade de Medida: " + p.getUnidadeMedida()
					+ "] [Quantidade: " + p.getQuantidade() + "] [Pre�o de Venda: " + p.getPrecoVenda() + "]" + "\n";
		}
		return resultado;
	}

	@Override // OK
	public Item procurarItem(int codigo) {
		boolean codigoExiste = false;
		indice = 0;
		for (indice = 0; indice < this.item.size() && !codigoExiste; indice++) {
			Item p = this.item.get(indice);
			if (p.getCodigo() == codigo) {
				codigoExiste = true;
			}
			if (codigoExiste) {
				Item j = this.item.get(indice);
				return j;
			}
		}
		return null;
	}

	@Override // OK
	public void cadastrarItem(Item m) {

		if (m != null) {
			int num = m.getCodigo();
			boolean codigoExiste = false;
			for (Item interno : item) {
				if (interno.getCodigo() == num) {
					codigoExiste = true;
				}
			}
			if (!codigoExiste) {
				this.item.add(m);
			}
		}
	}

	@Override // Ok
	public void removerItem(int codigo) {
		boolean codigoExiste = false;
		indice = 0;
		for (indice = 0; indice < this.item.size() && !codigoExiste; indice++) {
			Item p = this.item.get(indice);
			if (p.getCodigo() == codigo) {
				codigoExiste = true;
			}
			if (codigoExiste) {
				this.item.remove(indice - 1);
			}
		}
	}

	@Override // Ok
	public void editarItem(int codigo) {
		boolean codigoExiste = false;
		String nome = "", fabricante = "", tipo = "", unidadeMedida = "";
		double precoVenda = 0;
		indice = 0;
		for (indice = 0; indice < this.item.size() && !codigoExiste; indice++) {
			Item p = this.item.get(indice);
			if (p.getCodigo() == codigo) {
				codigoExiste = true;

				p.setNome(nome);
				p.setFabricante(fabricante);
				p.setTipo(tipo);
				p.setUnidadeMedida(unidadeMedida);
				p.setPrecoVenda(precoVenda);
			}
		}
	}

}