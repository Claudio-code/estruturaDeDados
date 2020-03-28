package com.encadeada;

import javax.management.RuntimeErrorException;

public class ListaEncadeada {
	private NoEncadeado primeiro = null;
	private NoEncadeado ultimo = null;
	private int quantidade = 0;

	public void inserirNoComeco(int elemento) {
		// criando objeto alxiliar
		NoEncadeado novoNo = new NoEncadeado();

		// colocando um valor no elemento do objeto auxiliar
		novoNo.setElemento(elemento);

		/*
		 * colocando um valor no apontador (que aponta para o proximo elemento) do
		 * objeto auxiliar
		 */
		novoNo.setProximo(primeiro);

		/* o primeiro objt recebe o elemento e o apontador(PROXIMO) do objt auxiliar */
		primeiro = novoNo;

		/*
		 * se o tamanho da lista for 0 o ultimo objto recebe o primeiro pois o
		 * apontamento da memoria na lista encadeada funciona assim primeiro --> ultimo
		 */
		if (quantidade == 0) {
			ultimo = primeiro;
			/*
			 * agr o ultimo é o primeiro e o primeiro aponta para o ultimo (os dois
			 * apontadores são null ) ou seja o primeiro aponta o ultimo q aponta para o
			 * nada
			 */
		}
		quantidade++;
	}

	public void inseriNoFinal(int elemento) {
		if (quantidade == 0) {
			/*
			 * se a lista for vazia chama o metodo de inserir no começo pq tem o mesmo
			 * efeito
			 */
			inserirNoComeco(elemento);
		} else {
			NoEncadeado novoNo = new NoEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProximo(ultimo);
			ultimo = novoNo;
			quantidade++;
		}
	}

	public boolean existeElementoNaPosicao(int posicao) {
		// se posicao for maior ou igual a 0 e menor que o tamanho
		return posicao >= 0 && posicao < quantidade;
	}

	public NoEncadeado buscaNaPosicao(int posicao) {
		// se existe elementos na posicao eu nego ai solto uma excepition
		if (!existeElementoNaPosicao(posicao)) {
			throw new RuntimeException("posicao nao existe");
		}

		NoEncadeado atual = primeiro;
		// correndo a posicao do no para chegar onde eu quero
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	public void inserirNaPosicao(int posicao, int elemento) {
		if (quantidade == 0) {
			inserirNoComeco(elemento);
		}
		if (posicao == quantidade) {
			inseriNoFinal(elemento);
		} else {
			NoEncadeado noNaPosicao = buscaNaPosicao(posicao);
			noNaPosicao.setElemento(elemento);
		}
	}

	public void removerNoInicio() {
		if (quantidade == 0) {

			return;

		} else {
			primeiro.setProximo(null);
		}
		if (quantidade == 0) {
			ultimo = null;
		}
	}

	public void removerNoFinal() {
		if (quantidade == 0) {
			return;
		}
		if (quantidade == 1) {
			removerNoInicio();
		}
		// o elemento final nao vale pois ao evocar ele vc acaba chamando o proximo
		// por isso a quantidade tem q descontar dois
		NoEncadeado noFimReal = buscaNaPosicao(quantidade - 2);
		noFimReal.setProximo(null);

		ultimo = noFimReal;
		quantidade--;
	}

	public void removerNaPosicao(int posicao) {
		if (quantidade == 0) {
			return;
		} else if (posicao == quantidade) {
			removerNoFinal();
		} else {
			NoEncadeado noNaPosicaoAnterior = buscaNaPosicao(posicao - 1);
			NoEncadeado noNaPosicaoAtual = noNaPosicaoAnterior.getProximo();

			if (noNaPosicaoAtual.getProximo() != null) {
				noNaPosicaoAnterior.setProximo(noNaPosicaoAtual.getProximo());
			} else {
				noNaPosicaoAnterior.setProximo(null);
				ultimo = noNaPosicaoAnterior;
			}
			quantidade--;
		}

	}

	public Integer retornarElementoNaPosicao(int posicao) {
		return buscaNaPosicao(posicao).getElemento();
	}

	public int retornarQuantidade() {
		return quantidade;
	}

	public void imprimir() {
		if (quantidade == 0) {
			System.out.println("[]");
			return;
		}
		String elemento = null;
		elemento = retornarElementos();
		System.out.println(elemento);
	}

	private String retornarElementos() {
		StringBuilder elementos = new StringBuilder("[");

		NoEncadeado atual = primeiro;

		while (atual.getProximo() != null) {
			elementos.append(atual);
			elementos.append(" ");
			atual = atual.getProximo();
		}
		elementos.append(atual.getElemento());
		elementos.append("]");
		return elementos.toString();
	}

	public NoEncadeado getPrimeiro() {
		return primeiro;
	}

	public NoEncadeado getUltimo() {
		return ultimo;
	}
}
