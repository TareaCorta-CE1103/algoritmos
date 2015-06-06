/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import lists.ListaSdoble;
import lists.Nodo;

/**
 * clase para realizar metodos de ordenamiento.
 * @author osboxes
 */
public class Metodos <dp extends Comparable<dp>>{
    
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
     * metodo para realizar un ordenamiento por medio de seleccion en un arreglo
     * @param pArray recibe el arreglo sobre el cual se realizaran el 
     * ordenamiento.
     */
    public void selectionSort(int[] pArray){
        int out, in, min;
        for(out=0; out<pArray.length-1; out++){
            min=out;
            for(in=out+1; in<pArray.length; in++)
                if(pArray[in]<pArray[min])
                    min = in;
        swap(pArray,out, min);
        }
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
        quickSort(pArray, 0, pArray.length-1);
        
    }
    
    /**
     * metodo recursivo que va realizando un quicksort a medida que particiona 
     * el arreglo.
     * @param pArray el arreglo con el cual se esta trabajando
     * @param initArray el primero numero de la porcion del arreglo que vamos a 
     * analizar.
     * @param lastArray el ultimo numero del arreglo que vamos a analizar
     */
    private void quickSort(int [] pArray, int initArray, int lastArray){
        if(lastArray-initArray <=0)
            return;
        int pivot= pArray[lastArray];
        int medium= getMediumSorted(pArray, initArray, lastArray, pivot);
        quickSort(pArray, initArray, medium-1);
        quickSort(pArray, medium+1, lastArray);
    }
    
    /**
     * metodo que para hacer un ordenamiento y escojer el dato medio del arreglo 
     * sobre el cual estamos operando.
     * @param pArray arreglo sobre el cual operaremos.
     * @param initArrya dato inicial del arreglo sobre el cual operamos.
     * @param lastArray dato final del arreglo sobre el cual operamos. 
     * @param pivot dato pivote sobre el cual compararemos para ir ordenando.
     * @return retorna el dato mas medio del arreglo.
     */
    private int getMediumSorted(int[] pArray, int initArrya, int lastArray, int pivot){
        int leftPtr = initArrya-1;
        int rightPtr = lastArray;
        while(true){
            while(pArray[++leftPtr] < pivot )
                ;
            while(rightPtr>0 && pArray[--rightPtr]>pivot)
                ;
            if(leftPtr>=rightPtr)
                break;
            swap(pArray,leftPtr,rightPtr);
        }
        swap(pArray,leftPtr,lastArray);
        return leftPtr;
    }
    
    /**
     * metodo para realizar un intercambio de datos.
     * @param pArray arreglo sobre el cual trabajamos.
     * @param first dato primero a cambiar.
     * @param last dato segundo a cambiar.
     */
    public void swap(int[] pArray, int first, int last){
        int temp= pArray[first];
        pArray[first]=pArray[last];
        pArray[last]=temp;
    }
    
    public static void main(String[] args) {
        int[] arreglo ={4,6,2,9,13,67,20,11};
        int[] arreglo2 ={4,6,2,9,13,67,20,11};
        Metodos nuevo= new Metodos();
        //long tmp1= System.nanoTime();
        nuevo.quickSort(arreglo);
        //long tmp2= System.nanoTime();
        for(int i=0; i<arreglo.length; i++){
            System.out.println(arreglo[i]);
        }
    }
}
