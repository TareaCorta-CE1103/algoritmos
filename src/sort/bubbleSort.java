/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 * clase para realizar el ordenamiento tipo burbuja por todo un arreglo de datos
 * enteros.
 * @author osboxes
 */
public class bubbleSort extends Metodos{
    
    /**
     * metodo para realizar un ordenamiento tipo burbuja
     * @param pArray arreglo con datos enteros.
     */
    public bubbleSort(int[] pArray){
        int out, in;
        for(out=pArray.length-1; out>1; out--)
            for(in=0; in<out; in++)
                if( pArray[in] > pArray[in+1] ){
                    swap(pArray, in, in+1);
                }
    }
}
