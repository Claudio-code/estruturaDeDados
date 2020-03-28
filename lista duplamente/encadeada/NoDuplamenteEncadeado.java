package com.duplamente.encadeada;

public class NoDuplamenteEncadeado {
	private NoDuplamenteEncadeado proximo;
	private NoDuplamenteEncadeado anterior;
	private int elemento;
	public NoDuplamenteEncadeado getProximo() {
		return proximo;
	}
	public void setProximo(NoDuplamenteEncadeado proximo) {
		this.proximo = proximo;
	}
	public NoDuplamenteEncadeado getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDuplamenteEncadeado anterior) {
		this.anterior = anterior;
	}
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

}
