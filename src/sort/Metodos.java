/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import simple.ListaSdoble;
import simple.Nodo;

/**
 *
 * @author osboxes
 * @param <dp>
 */
public class Metodos <dp extends Comparable<? super dp>>{
    
    /**
     * metodo para realizar un ordenamiento tipo burbuja
     * @param pArray arreglo con datos enteros.
     */
    public void bubbleSort(int[] pArray){
        int out, in;
        for(out=pArray.length-1; out>1; out--)
            for(in=0; in<out; in++)
                if( pArray[in] > pArray[in+1] ){
                    swap(pArray, in, in+1);
                }
    }
    
    /**
     * metodo para realizar un intercambio de datos.
     * @param pArray arreglo sobre el cual trabajamos.
     * @param first dato primero a cambiar.
     * @param last dato segundo a cambiar.
     */
    private void swap(int[] pArray, int first, int last){
        int temp= pArray[first];
        pArray[first]=pArray[last];
        pArray[last]=temp;
    }
    
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
    
    /**
     * metodo que recibe un arreglo y realiza un merge sort, que va revisando
     * mitades de mitades de arreglos y haciendo comparaciones.
     * @param pArray arreglo inicial que recibe.
     */
    public void mergeSort(int [] pArray){
        int[] contenedor= new int[pArray.length];
        mergeSort(pArray,contenedor,0, pArray.length-1);
    }
    
    /**
     * metodo para recursionar e ir dividiendo los arreglos en mitades 
     * @param pArray arreglo inicial 
     * @param pArray2 arreglo temporal donde se almacenaran todos los datos
     * @param initPlace posicion inicial de la primera parte del arreglo
     * @param lastPlace posicion inicial de la segunda parte del arreglo
     */
    private void mergeSort(int[] pArray, int[] pArray2,int initPlace,int lastPlace){
        
        if (initPlace<lastPlace){
            int media= (initPlace+lastPlace)/2;
            mergeSort(pArray, pArray2, initPlace, media);
            mergeSort(pArray, pArray2, media+1, lastPlace);
            merge(pArray, pArray2, initPlace, media+1, lastPlace);
        }
    }
    
    /**
     * metodo para revisar quien es mayor a quien e intercambia los datos si es
     * necesario 
     * @param pArray arreglo inicial
     * @param pArray2 arreglo de almacenaje
     * @param initArray1 posicion inicial de la primera parte del arreglo
     * @param initArray2 posicion inicial de la segunda parte del arreglo
     * @param lastArray largo maximo de las partes de los arreglos.
     */
    private void merge(int[] pArray, int[] pArray2, int initArray1, int initArray2, 
            int lastArray){
        
        int finalIzq=initArray2-1;
        int tmpPos= initArray1;
        int totalElements= (lastArray-initArray1)+1;
        //revisa quien es menor a quien en los arreglos
        while(initArray1<=finalIzq && initArray2<=lastArray){
            if(pArray[initArray1]<=pArray[initArray2]){
                pArray2[tmpPos]=pArray[initArray1];
                tmpPos++;initArray1++;
            }
            else{
                pArray2[tmpPos]=pArray[initArray2];
                tmpPos++;initArray2++;
            }
        }
        //revisa si quedaron datos sin copiar en el arreglo izquierdo
        while(initArray1<=finalIzq){
            pArray2[tmpPos]=pArray[initArray1];
            tmpPos++;initArray1++;
        }
        //revisa si quedaron datos sin copiar en el arreglo derecho
        while(initArray2<=lastArray){
            pArray2[tmpPos]=pArray[initArray2];
            tmpPos++;initArray2++;
        }
        for(int i =0; i<totalElements; i++,lastArray--)
            pArray[lastArray]=pArray2[lastArray];
    }
    
    /**
     * metodo para realizar un quickSort sobre un arreglo con datos enteros.
     * @param pArray 
     */
    public void quickSort(int[] pArray){
        
    }
}
