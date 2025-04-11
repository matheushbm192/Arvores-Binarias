package org.example;

public class Arvore<E> {
    private No<E> lista;
    private int size;

    public Arvore(){
        lista = null;
    }

    public void add(E no){
        if(lista == null){
            lista = new No<E>(no, null, null);
        } else{
            No<E> novoNo = new No<E>(no,null,null);

            alocarNo(novoNo, lista);


        }
    }

    private void alocarNo(No<E> novoNo,No<E> lista){

        if((Integer)lista.elemento < (Integer)novoNo.elemento){
            if(lista.proximo == null){
                lista.proximo = novoNo;
                return;
            }
            alocarNo(novoNo , lista.proximo);
        }else{
            if(lista.anterior == null){
                lista.anterior = novoNo;
                return;
            }
            alocarNo(novoNo , lista.anterior);
        }


    }

    public static class No<T> {
        T elemento;
        No<T> proximo;
        No<T> anterior;
        No(T no, No<T> prox, No<T> anterior) {
            elemento = no;
            proximo = prox;
            anterior = anterior;
        }
    }
}
