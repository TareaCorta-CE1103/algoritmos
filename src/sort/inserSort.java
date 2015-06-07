/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import lists.ListaSdoble;
import lists.Nodo;

/**
 * clase para realizar un insert sort a una arreglo de datos enteros o una lista
 * simple doble.
 * @author osboxes
 * @param <dp> dato generico.
 */
public class inserSort <dp extends Comparable<dp>>{
    /**
     * metodo para realizar un ordenamiento de insercion adaptado para listas 
     * simples dobles.
     * @param pLista dato de la clase lista simple doble.
     */
    public void insertSort(ListaSdoble pLista){
        Nodo pNodo=pLista.getHead().getNext();
        Nodo J;
        for(;pNodo!=null;){
            dp dato =(dp)pNodo.getData();
            for(J=pNodo;J!=pLista.getHead() && dato.compareTo((dp)J.getPrev().getData())<0;){
                J.setData(J.getPrev().getData());
                J=J.getPrev();
            }
            J.setData(dato);
            pNodo=pNodo.getNext();
        }
    }
    
    /**
     * metodo para realizar un insert sort, este agarra un dato y revisa contra
     * todos sus anteriores.
     * @param array dato generico que recibe un arreglo.
     */
    public void insertSort(int[] array){
        int j;
        for( int i = 1; i < array.length; i++ ){
            int tmp = array[i];
            for(j=i; j>0 && tmp<array[j-1];j--)
                array[j]=array[j-1];
            array[j]=tmp;
        }
    }
}
