/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 * clase para crear nodos para que trabajen con las listas
 * @author Ellioth
 * @param <dp> generic para administracion de nodos
 */
public class Nodo <dp extends Comparable<dp>> {
    /**
     * atributos de la clase padre nodo
     */
    private dp dato;
    private Nodo NextNodo;
    private Nodo prevNodo;
    
    /**
     * metodo para ingresar el dato que 
     * se va a contener en el nodo creado
     * @param pData dato tipo generico, es el contenido del dato del nodo.
     */
    public Nodo(dp pData){
        this.dato= pData;
    }
    
    /**
     * devuelve el contenido del nodo
     * @return retorna un dato generico, hay que hacer cast para obtener el 
     * dato que se quiere, este es el dato interno del nodo.
     */
    public dp getData(){
        return  dato;
    }
    
    /**
     * si se le desea cambiar el dato 
     * a un nodo, se le ingresa como el 
     * parametro "dato"
     * @param dato dato tipo generico, este va a ser el nuevo dato del nodo.
     */
    public void setData(dp dato){
        this.dato=dato;
    }
    
    /**
     * devuelve el nodo siguiente de 
     * el cual estamos trabajando
     * @return dato de la clase Nodo, retorna el nodo siguiente del nodo con 
     * quien estamos operando.
     */
    public Nodo getNext(){
        return NextNodo;
    }
    
    /**
     * devuelve el nodo anterior del cual nos entramos.
     * @return dato de la clase Nodo, nos retorna el nodo que precede al nodo 
     * con el cual estamos operando.
     */
    public Nodo getPrev(){
        return prevNodo;
    }
    
    /**
     * establece como parametro de entrada un nodo para colocarlo como siguiente
     * del cual nos encontramos.
     * @param pNodo dato de la clase Nodo, este va a ser el nuevo siguiente del
     * nodo con el cual operamos.
     */
    public void setNext(Nodo pNodo){
        this.NextNodo=pNodo;
    }
    
    /**
     * establece un como parametro de entrada el nodo que se encuentra anterior 
     * al cual nos estamos referenciando.
     * @param pNodo dato de la clase Nodo, este sera el nuevo predecesor del 
     * nodo con el cual estamos operando.
     */
    public void setPrev(Nodo pNodo){
        this.prevNodo=pNodo;
    }
}
