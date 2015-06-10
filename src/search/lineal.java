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
public class lineal {
    
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
