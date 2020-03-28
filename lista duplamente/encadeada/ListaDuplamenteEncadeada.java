package com.duplamente.encadeada;

public class ListaDuplamenteEncadeada {
	private NoDuplamenteEncadeado primeiro = null;
	private NoDuplamenteEncadeado ultimo = null;
	private NoDuplamenteEncadeado anterior = null;
	private int quantidade = 0;

	public void inserirNoComeco(int elemento) {
		NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
		novoNo.setProximo(primeiro);
		novoNo.setElemento(elemento);
		if (quantidade == 0) {
			ultimo = novoNo;
		} else {
			primeiro.setAnterior(novoNo);
		}
		primeiro = novoNo;
		quantidade++;
	}

	public void removerNoInicio() {
		if (quantidade == 0) {
			return;
		}
		primeiro = primeiro.getProximo();
		primeiro.setAnterior(null);
		quantidade--;
		if (quantidade == 0) {
			ultimo = null;
		}
	}

	public void removerNoFinal() {
		if (quantidade == 0) {
			return;
		}
		NoDuplamenteEncadeado penultimo = ultimo.getAnterior();
		penultimo.setProximo(null);
		ultimo = penultimo;
		quantidade--;
	}

	public void removerNaPosicao(int posicao) {
		if (quantidade == 0) {
			return;
		} else if (quantidade == 1) {
			removerNoInicio();
		} else if (quantidade == posicao) {
			removerNoFinal();
		} else if (!existeElementoNaPosicao(posicao)) {
			throw new RuntimeException("posicao n existe");
		} else {
			NoDuplamenteEncadeado noAtual = buscaPorPosicao(posicao);
			NoDuplamenteEncadeado noAnterior = noAtual.getAnterior();

			NoDuplamenteEncadeado proximo = noAnterior.getProximo();
			if (proximo != null) {
				noAnterior.setProximo(proximo);
				proximo.setAnterior(noAnterior);
			} else {
				noAnterior.setProximo(null);
				ultimo = noAnterior;
				quantidade--;
			}
		}
	}

	public void inserirNoFinal(int elemento) {
		if (quantidade == 0) {
			inserirNoComeco(elemento);
		} else {
			NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado();
			novoNo.setElemento(elemento);
			novoNo.setProximo(null);
			novoNo.setAnterior(ultimo);
			ultimo.setProximo(novoNo);
			ultimo = novoNo;
			quantidade++;
		}
	}

	public void inserirNaPosicao(int posicao, int elemento) {
		if (quantidade == 0) {
			inserirNoComeco(elemento);
		} else if (posicao == quantidade) {
			inserirNoFinal(elemento);
		} else if (posicao > quantidade) {
			return;
		} else {
			NoDuplamenteEncadeado NoNaPosicao = buscaPorPosicao(posicao);
			NoNaPosicao.setElemento(elemento);
			quantidade++;
		}
	}

	public NoDuplamenteEncadeado buscaPorPosicao(int posicao) {
		if (!existeElementoNaPosicao(posicao)) {
			throw new RuntimeException("posicao n existe");
		}
		NoDuplamenteEncadeado atual = primeiro;

		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	public boolean existeElementoNaPosicao(int posicao) {
		return posicao >= 0 && posicao < quantidade;
	}

	public int mostrarQuantidade() {
		return quantidade;
	}
	public void mostrarNaTela() {
		if (quantidade==0) {
			System.out.println("[");
			return;
		}
		String elemento= retornarElementos();
		System.out.println(elemento.toString());
	}

	private String retornarElementos() {
		StringBuilder elementos = new StringBuilder("[");

		NoDuplamenteEncadeado atual = primeiro;
		while (atual.getProximo() != null) {
			elementos.append(atual.getElemento());
			elementos.append(",");
			atual = atual.getProximo();
		}
		elementos.append(atual.getElemento());
		elementos.append("]");
		return elementos.toString();
	}

	public NoDuplamenteEncadeado getPrimeiro() {
		return primeiro;
	}

	public NoDuplamenteEncadeado getUltimo() {
		return ultimo;
	}

	public NoDuplamenteEncadeado getAnterior() {
		return anterior;
	}

}
