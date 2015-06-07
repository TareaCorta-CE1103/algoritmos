/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 * clase para realizar un ordenamiento tipo quick,recibe solo arreglos de 
 * enteros.
 * @author osboxes
 */
public class quickSort extends Metodos{
     /**
     * metodo para realizar un quickSort sobre un arreglo con datos enteros.
     * @param pArray 
     */
    public quickSort(int[] pArray){
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
}
