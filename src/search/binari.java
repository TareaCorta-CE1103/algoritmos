/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author osboxes
 */
public class binari {
    
    /**
     * metodo para realizar un busqueda binaria, basicamente consiste en que, 
     * en un arreglo ordenado, la mitad se compara y si es menor a la mitad 
     * del arreglo contra el dato que buscamos, el inidice menor para a ser la 
     * mitad mas 1 y si no el inidice mayor a la mitad, asi hasta que los 
     * indices se vuelvan iguales y luego se compara el dato con la ultima 
     * posicion del inidice menor y si son iguales el retorna un true, o un 
     * false si no son iguales.
     * @param pArray arreglo al cual se le quiere hacer la busqueda.
     * @param dato dato que se esta buscando.
     * @return retorna un true si existe el dato y un false si no.
     */
    public boolean binari(int[] pArray,int dato){
        int initArray=0;
        int lastArray=pArray.length-1;
        int midium;
        while(initArray<lastArray){
            midium=(lastArray+initArray)/2;
            if(pArray[midium]<dato)
                initArray=midium+1;
            else if(pArray[midium]>dato)
                lastArray=midium-11;
            else
                return true;
        }
        return (pArray[initArray]==dato);
    }
}
