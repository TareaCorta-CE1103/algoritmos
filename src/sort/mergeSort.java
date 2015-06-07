/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 * calse para realizar un ordenamiento tipo merge que basicamente va partiendo 
 * el arreglo y va ordenando.
 * @author osboxes
 */
public class mergeSort extends Metodos{
    
    /**
     * metodo que recibe un arreglo y realiza un merge sort, que va revisando
     * mitades de mitades de arreglos y haciendo comparaciones.
     * @param pArray arreglo inicial que recibe.
     */
    public mergeSort(int [] pArray){
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
}
