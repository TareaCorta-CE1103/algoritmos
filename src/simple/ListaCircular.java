/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import tree.Constantes;

/**
 *
 * @author osboxes
 * @param <dp>
 */
public class ListaCircular <dp extends Comparable<dp>> implements Constantes{
    
    private Nodo _head;
    private Nodo _tail;
    private int _cont=cero;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato 
     */
    public void enQueue(dp dato){
        if (_head==null){
            _head=_tail=new Nodo(dato);
            _head.setNext(_tail);_tail.setNext(_head);
        }
        else{
            Nodo tmp1=_tail;
            tmp1.setNext( new Nodo(dato));
            _tail=tmp1.getNext();
            _tail.setNext(_head);
        }
    }
    
    /**
     * devuelve la cabeza de la lista o el primer nodo que se ingreso
     * @return 
     */
    public Nodo getHead(){
        return _head;
    }
    
    /**
     * devuelve la cola de la lista o el ulrimo nodo ingresado
     * @return 
     */
    public Nodo getTail(){
        return _tail;
    }
    
    /**
     * recive un dato y va buscando en toda lista si existe un nodo 
     * que contenga tal valor, de encontrarlo lo elimina, si no lo encuentra
     * alerta un null.
     * @param dato 
     */
    public void deQueue(dp dato){
        Nodo tmp=_head;
        Nodo tmp2= tmp;
        _cont=cero;
        while(_cont<dos && !tmp.getData().equals(dato)){
            tmp2=tmp;
            tmp=tmp.getNext();
        }
        if(_cont==dos)
            return;
        else if(tmp==_head){
            _tail.setNext(_head.getNext());
            _head=_head.getNext();
        }
        else
            tmp2.setNext(tmp.getNext());
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista 
     * @return i dato entero que devuelve la maxima cantidad de datos;
     */
    public int getLength(){
        Nodo tmp=_head;
        int i =cero;
        while(_cont<=dos){
            if(tmp==_head)
                _cont++;
            i++;
            tmp= tmp.getNext();
        }
        return i-uno;
    }
    
    /**
     * funcion para imprimir todos los nodos de una lista.
     */
    public void print(){
        Nodo tmp=_head;
        System.out.println(tmp.getData());
        tmp=tmp.getNext();
        while(_cont<uno){
            if(tmp==_head)
                _cont++;
            if(_cont<1){
                System.out.println(tmp.getData());
                tmp=tmp.getNext();
            }
        }
        _cont=cero;
    }
    
    /**
     * hace casi lo mismo que el metodo de borrado pero no lo elimina, solo
     * devuelve el valor del nodo.
     * @param dato
     * @return 
     */
    public boolean find(dp dato){
        Nodo tmp =_head;
        while(_cont<dos && !tmp.getData().equals(dato)){
            if(tmp==_head)
                _cont++;
            tmp=tmp.getNext();
        }
        if(_cont<2){
            _cont=cero;
            return true;
        }
        else
            return false;
    }
    
}
