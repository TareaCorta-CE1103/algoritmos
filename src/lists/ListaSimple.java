/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import tree.Constantes;

/**
 * clase para crear listas simple.
 * @author osboxes
 * @param <dp> parametro para hacer que la lista reciba un dato generico.
 */
public class ListaSimple <dp extends Comparable<dp>> implements Constantes{
    
    private Nodo _head;
    private Nodo _tail;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato recibe un dato generico, este va a ser el nuevo que vamos
     * a encolar en la lista.
     */
    public void enQueue(dp dato){
        if (_head==null)
            _head=_tail=new Nodo(dato);
        else{
            Nodo tmp1=_tail;
            tmp1.setNext( new Nodo(dato));
            _tail=(Nodo)tmp1.getNext();
        }
    }
    
    /**
     * metodo para ingresar dato no repetidos
     * @param dato dato tipo generico.
     */
    public void enQueue_none_repeat(dp dato){
        Nodo tmp= _head;
        boolean check= false;
        while(tmp!=null && !check){
            if(tmp.getData().equals(dato))
                check=true;
            tmp= tmp.getNext();
        }
        if(!check){
            enQueue(dato);
        }
            
    }
    
    /**
     * devuelve la cabeza de la lista o el primer nodo que se ingreso
     * @return dato de la clase Nodo, esta es la cabeza de la lista.
     */
    public Nodo getHead(){
        return _head;
    }
    
    /**
     * devuelve la cola de la lista o el ulrimo nodo ingresado
     * @return dato de la clase Nodo, esta es la cola de la lista.
     */
    public Nodo getTail(){
        return _tail;
    }
    
    /**
     * recive un dato y va buscando en toda lista si existe un nodo 
     * que contenga tal valor, de encontrarlo lo elimina, si no lo encuentra
     * alerta un null.
     * @param dato recibe un dato generico, este va a ser el dato que queremos
     * eliminar del la lista.
     */
    public void deQueue(dp dato){
        Nodo tmp=_head;
        Nodo tmp2=tmp;
        while(tmp!=null && !tmp.getData().equals(dato)){
            tmp2=tmp;
            tmp=tmp.getNext();
        }
        if(tmp==null)
            return;
        else if(tmp==tmp2 && tmp.getData().equals(dato))
            _head=_head.getNext();
        else
            tmp2.setNext(tmp.getNext());
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista.
     * @return un dato entero, este representa el largo de la lista.
     */
    public int getLength(){
        Nodo tmp=_head;
        int i =cero;
        while(tmp!=null){
            i++;
            tmp= tmp.getNext();
        }
        return i;
    }
    
    /**
     * metodo para imprimir todos los valores internos de los nodos.
     */
    public void print(){
        Nodo tmp=_head;
        while(tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNext();
        }
    }
    
    /**
     * metodo para buscar nodos es un 
     * @param dato recibe un dato generico, este dato sirve para buscar el nodo 
     * que queremos.
     * @return retorna un booleando de si encontro el nodo o no.
     */
    public boolean find(dp dato){
        Nodo tmp =_head;
        while(tmp!=null && tmp.getData().equals(dato))
            tmp=tmp.getNext();
        if(tmp==null)
            return false;
        return true;
    }
}
