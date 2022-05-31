package listamercadinho;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Mercadinho {

	private String nome;
	private String registro;
	private List<Produtos> produtos = new LinkedList<Produtos>();
	
	

	public Mercadinho(String nome, String instrutor) {
		this.nome = nome;
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public String getRegistro() {
		return registro;
	}

	public List<Produtos> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void adiciona(Produtos produto) {
		this.produtos.add(produto);
	}


	
}
