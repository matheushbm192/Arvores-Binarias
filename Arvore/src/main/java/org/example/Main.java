package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();
        arvore.add(15);
        arvore.add(8);
        arvore.add(2);
        arvore.add(12);
        arvore.add(23);
        arvore.add(20);
        arvore.add(30);
        int num = 30;
        arvore.removeNo(20);
    }
}