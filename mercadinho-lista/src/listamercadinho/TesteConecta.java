package listamercadinho;

import java.io.ObjectInputStream.GetField;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.lang.invoke.StringConcatException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.postgresql.util.Gettable;

public class TesteConecta {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Digite uma opção \n1 - sair \n2 - cadastrar cliente \n3 - apagar cliente \n4 - atualizar cliente \n5 - cadastrar produto \n6 - apagar cliente \n7 - atualiza produtos \n8 - lista produtos ");
			String opcao = scan.nextLine();

			switch (opcao) {
			case "1":
				System.exit(0);
			case "2":
				System.out.println("Digite o ID: ");
				int id = Integer.parseInt(scan.nextLine());

				System.out.println("Digite o Nome: ");
				String nome = scan.nextLine();

				CriaCliente(id, nome);
				break;
			case "3":
				System.out.println("Digite o cliente a ser excluído: ");
				int apagaCliente = Integer.parseInt(scan.nextLine());

				ApagaCliente(apagaCliente);
				break;
			case "4":
				System.out.println("Digite o ID do cliente a ser atualizado");
				int idCliente = Integer.parseInt(scan.nextLine());
				System.out.println(idCliente);

				System.out.println("Digite o Nome do cliente a ser atulizado");
				String nomeCliente = scan.nextLine();
				System.out.println(nomeCliente);

				AtualizaCliente(idCliente, nomeCliente);
				break;
			case "5":
				System.out.println("Digite o ID do produto:  ");
				int idProduto = Integer.parseInt(scan.nextLine());

				System.out.println("Digite o nome do produto: ");
				String descricao = scan.nextLine();

				System.out.println("Digite a quantidade: ");
				int quantidade = Integer.parseInt(scan.nextLine());

				System.out.println("Digite o preço: ");
				double preco = scan.nextDouble();

				CriaProduto(idProduto, descricao, quantidade, preco);
				break;
			case "6":
				System.out.println("Digite o produto a ser excluído");
				int apagaProduto = Integer.parseInt(scan.nextLine());

				ApagaProduto(apagaProduto);
			case "7":
				System.out.println("Digite a ID do produto");
				int atualizaProdutoId = Integer.parseInt(scan.nextLine());

				System.out.println("Digite a descricao que será atualizada");
				String atualizaProdutoDesc = scan.nextLine();

				System.out.println("Digite a quantidade a ser alterada");
				Integer atualizaProdutoQuant = scan.nextInt();

				System.out.println("Digite o preço a ser alterado");
				double atualizaProdutoPreco = scan.nextDouble();

				AtualizaProduto(atualizaProdutoId, atualizaProdutoDesc, atualizaProdutoQuant, atualizaProdutoPreco);
				break;
			case "8":
				System.out.println("Listando...");
				try {
					ResultSet rs = ListaProdutos(1);
					System.out.println("\n");
					while (rs.next()) {
						System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "9":
				System.out.println("Listando...");
				try {
					ResultSet rs = ListaClientes(1);
					System.out.println("\n");
					while (rs.next()) {
						System.out.println("Cliente: " + rs.getString(2));
						Thread.sleep(500);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case "10":
				System.out.println(opcao);
				break;

			default:
				break;
			}
		}

	}

	private static String ListaProdutos() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void CriaCliente(int id, String nome) {
		try {
			Clientes cliente = new Clientes();
			cliente.CreateCliente(id, nome);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void CriaProduto(int id, String descricao, int quantidade, double preco) {
		try {
			Produtos produtos = new Produtos();
			produtos.CreateProduto(id, descricao, quantidade, preco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ApagaCliente(int apagaId) {
		try {
			Clientes cliente = new Clientes();
			cliente.ApagaCliente(apagaId);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void ApagaProduto(int apagaId) {
		try {
			Produtos produtos = new Produtos();
			produtos.ApagaProduto(apagaId);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void AtualizaCliente(int id, String nome) {
		try {
			Clientes clientes = new Clientes();
			clientes.AtualizaCliente(id, nome);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void AtualizaProduto(int id, String descricao, int quantidade, double preco) {
		try {
			Produtos produtos = new Produtos();
			produtos.AtualizaProduto(id, descricao, quantidade, preco);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void ListaCliente(int id, String nome) {
		try {
			Clientes cliente = new Clientes();
			cliente.CreateCliente(id, nome);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static ResultSet ListaProdutos(int id) throws ClassNotFoundException, SQLException {

		Produtos produtos = new Produtos();
		produtos.ListaProdutos(id);

		return produtos.ListaProdutos(id);

	}

	public static ResultSet ListaClientes(int id) throws ClassNotFoundException, SQLException {

		Clientes clientes = new Clientes();
		clientes.ListaClientes(id);

		return clientes.ListaClientes(id);

	}
}
