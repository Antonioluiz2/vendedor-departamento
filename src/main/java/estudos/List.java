package estudos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

public class List {
	public static void main(String[] args) {
		Gato kat = new Gato(null, null, null);
//		Scanner sc = new Scanner(System.in);
//
//		// LinkedList<String> publica =new LinkedList<String>();
//		ArrayList<Object> pub = new ArrayList<Object>();
//
//		// System.out.println("Digite nome");
//		int n = 1;
//		while (n <= 5) {
//			n = n + 1;
//			System.out.println("Digite nome");
//			Object publicador = pub.add(sc.nextLine());
//			// System.out.println(pub);
//		}
//		;
//		System.out.println(pub + "\n");

		// System.out.println("Exiba em ordem alfabetica"+ Collections.min(pub));

		// Logica para contar posições.
//	    Object soma=null;
//	    Iterator<Object>iterator=pub.iterator();
//	    while(iterator.hasNext()) {
//	    	Object next=iterator.next();
//	    	 //soma=next.toString().length();
//	    	 soma=next.toString().length();
//	    }
//	    System.out.println(soma);
		//Organizando lista por ordem alfabetica
		ArrayList<Gato> katy = new ArrayList<Gato>() {
			{
				add(new Gato("nina", 18, "preto"));
				add(new Gato("rabi", 16, "branco"));
				add(new Gato("nina", 8, "cinza"));
				add(new Gato("luiz", 15, "preto"));
			}
		};
		//seleção em ordem alfabetica colletions.sort()
		Collections.sort(katy);
		System.out.println(katy);
	}

}

//Para ordenar uma lista usando comparable e metodo comparetor
class Gato implements Comparable<Gato> {
	private String nome;
	private Integer idade;
	private String cor;

	public Gato(String nome, Integer idade, String cor) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return " [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
	}

	public int compareTo(Gato gato) {
		// TODO Auto-generated method stub
		return this.getNome().compareToIgnoreCase(gato.getNome());
	}

}
