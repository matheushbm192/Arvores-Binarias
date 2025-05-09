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
    No<E> pai = null;
//buscaBinaria
    public No<E> buscaBinaria(No<E> raiz, int ch){
        No<E> atual = raiz;
        pai = null;
        while(atual.elemento != null){
            if( (Integer) atual.elemento == ch) {return atual;}
            //possivel error
            pai = atual;
            if(ch < (Integer) atual.elemento){
                atual = atual.anterior;
            } else {
                atual = atual.proximo;
            }
        }
        return null;
    }

    public No<E> removeNo( int ch){
        No<E> raiz = lista;
        No<E>  no, p , q;
        no = buscaBinaria(raiz,ch);
        if(no == null){return raiz;}
        if(no.anterior == null || no.proximo == null) {
            if (no.anterior == null){
                q = no.proximo;
            }else{
                q = no.anterior;
            }
        }else{
            p = no;
            q = no.anterior;
            while(q.proximo != null){
                p = q;
                q = q.proximo;
            }

            if(p != no){
                p.proximo = q.anterior;
                q.anterior = no.anterior;
            }
            q.proximo = no.proximo;
        }
        if (pai == null){
            return q;
        }
        if (ch < (Integer) pai.elemento){
            pai.anterior = q;

        }else {
            pai.proximo = q;

        }
        return raiz;
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
