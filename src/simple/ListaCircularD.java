/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import tree.Constantes;
import static tree.Constantes.cero;

/**
 *
 * @author osboxes
 * @param <dp>
 */
public class ListaCircularD <dp extends Comparable<dp>> implements Constantes {
    
    private int _cont=cero;
    private Nodo _head;
    private Nodo _tail;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato 
     */
    public void enQueue(dp dato){
        if (_head==null){
            _head=_tail=new Nodo(dato);
            _head.setNext(_tail);_tail.setNext(_head);
            _head.setPrev(_tail);_tail.setPrev(_head);
        }
        else{
            Nodo tmp=_tail;
            tmp.setNext( new Nodo(dato));
            _tail=tmp.getNext();
            _tail.setNext(_head);
            _tail.setPrev(tmp);
            _head.setPrev(_tail);
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
        _cont=cero;
        while(_cont<dos && !tmp.getData().equals(dato))
            tmp=tmp.getNext();
        if(_cont==dos)
            return;
        else if(tmp==_head){
            _tail.setNext(_head.getNext());
            _head=_head.getNext();
            _head.setPrev(_tail);
        }
        else{
            Nodo tmp2= tmp.getNext();
            tmp.getPrev().setNext(tmp2);
            tmp2.setPrev(tmp.getPrev());
        }
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista 
     * @return i dato entero que devuelve la maxima cantidad de datos;
     */
    public int getLength(){
        Nodo tmp=_head;
        _cont=cero;
        int i =cero;
        while(_cont<dos){
            if(tmp==_head)
                _cont++;
            i++;
            tmp= tmp.getNext();
        }
        return i-uno;
    }
    
    /**
     * metodo para imprimir los nodos de una lista.
     */
    public void print(){
        Nodo tmp=_head;
        System.out.println(tmp.getData());
        tmp=tmp.getNext();
        _cont=cero;
        while(_cont<uno){
            if(tmp==_head)
                _cont++;
            if(_cont<1){
                System.out.println(tmp.getData());
                tmp=tmp.getNext();
            }
        }
    }
    
    /**
     * hace casi lo mismo que el metodo de borrado pero no lo elimina, solo
     * devuelve el valor del nodo.
     * @param dato recibe un dato generico, este el dato que queremos buscar.
     * @return retorna un verdadero o falso, si el nodo existe o no.
     */
    public boolean find(dp dato){
        Nodo tmp =_head;
        _cont=cero;
        while(_cont<dos && !tmp.getData().equals(dato)){
            if(tmp==_head)
                _cont++;
            tmp=tmp.getNext();
        }return _cont<dos;
    }
}
