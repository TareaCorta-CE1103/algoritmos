/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import tree.Constantes;
import tree.MetodosPArboles;

/**
 * clase para crear heaps, este solo funciona con Strings.
 * @author osboxes
 */
public class Heap extends MetodosPArboles implements Constantes{
    
    private int _tail=cero;
    private int _MaxSize=uno;
    private int _depthSize=cero;
    private int[] _arreglo= new int[_MaxSize];
    
    /**
     * metodo para insertar datos en un arreglo.
     * @param dato dato tipo entero.
     */
    public void insert(int dato){
        if(_tail==_MaxSize)
            growArray();
        _arreglo[_tail]=dato;
        _tail++;
        check();
    }
    
    /**
     * metodo para revizar que el heap se encuentre ordenado, segun lo que 
     * especifica, ya sea un heap de meyores o menores.
     */
    private void check(){
        if (_tail==_MaxSize)
            return;
        checkAux(uno);
        checkAux(dos);
    }
    
    /**
     * metodo para ir revizando hijo por hijo, que cumpla lo que se pide.
     * @param pHijo dato tipo entero que es el indice del hijo.
     */
    private void checkAux(int pHijo){
        if(pHijo>= _MaxSize)
            return;
        checkAux((pHijo*dos)+uno);
        checkAux((pHijo*dos) +dos);
        if(_arreglo[pHijo/dos]>(_arreglo[pHijo]))
            swap(pHijo);
    }
    
    /**
     * metodo para aumentar el tamaño del arreglo una vez que haya llenado todos
     * los campos.
     */
    private void growArray(){
        _arreglo=super.growArray(_MaxSize, _arreglo);
    }
    
    /**
     * metodo para intercambiar entre el padre y el hijo del arreglo.
     * @param pHijo dato entero que es el indice del hijo.
     */
    private void swap(int pHijo){
        int Ipadre= pHijo/dos;
        int hijo=_arreglo[pHijo];
        _arreglo[pHijo]=_arreglo[Ipadre];
        _arreglo[Ipadre]=hijo;
    }
    
    /**
     * metodo para imprimir los datos de un heap en Orden.
     */
    public void print(){
        int indice=cero;
        printAux(indice);
    }
    
    /**
     * metodo recursivo para ir imprimiendo los nodos de un Heap una vez que de 
     * manera recursiva en un arbol.
     * @param pIndice dato entero, que es el indice del nodoel cual vamos a 
     * imprimir.
     */
    private void printAux(int pIndice){
        if(pIndice>=_MaxSize)
            return;
        printAux((pIndice*dos)+uno);
        System.out.println(_arreglo[pIndice]);
        printAux((pIndice*dos)+dos);
    }
}
