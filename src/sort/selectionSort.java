/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 * reciebe un arreglo y realiza un ordenamiento del tipo selection.
 * @author osboxes
 */
public class selectionSort extends Metodos{
    
    /**
     * metodo para realizar un ordenamiento por medio de seleccion en un arreglo
     * @param pArray recibe el arreglo sobre el cual se realizaran el 
     * ordenamiento.
     */
    public selectionSort(int[] pArray){
        int out, in, min;
        for(out=0; out<pArray.length-1; out++){
            min=out;
            for(in=out+1; in<pArray.length; in++)
                if(pArray[in]<pArray[min])
                    min = in;
        swap(pArray,out, min);
        }
    }
}
