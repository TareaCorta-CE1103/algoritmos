/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 * clase que contiene metodos que se utilizan entre los metodos de ordenamiento.
 * @author osboxes
 */
public class Metodos {
    
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
}
