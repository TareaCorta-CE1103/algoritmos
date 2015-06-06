/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 * clase para realizar busquedas sobre un arreglo de enteros.
 * @author osboxes
 */
public class Search {
    
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
            else
                lastArray=midium;
        }
        return (pArray[initArray]==dato);
    }
    
    /**
     * metodo para realizar una busqueda lineal en un arreglo y va comparando 
     * uno por uno hasta encontrar el dato.
     * @param pArray arreglo de datos enteros sobre el cual se quiere hacer 
     * la busqueda.
     * @param dato datos entero el cual se esta buscando.
     * @return retorna un true o un false si existe el dato o no.
     */
    public boolean lineal(int[] pArray, int dato){
        for(int i=0; i<pArray.length;i++)
            if(pArray[i]==dato)
                return true;
        return false;
    }
}
