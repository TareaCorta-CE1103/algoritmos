/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import sort.Metodos;
import tree.Constantes;

/**
 * clase de lista que sive como padre para todas las otras otras clases
 * que hagan listas o sirvan como bases de datos.
 *
 * @author osboxes <------asi se llama la maquina virtual en ubuntu
 * @param <dp>
 */
public class ListaSdoble <dp extends Comparable<dp>> extends Metodos 
implements Constantes{
    
    private Nodo _head;
    private Nodo _tail;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato 
     */
    public void enQueue(dp dato){
        if (_head==null){
            _head=_tail=new Nodo(dato);
            _tail.setPrev(_head);
        }
        else{
            Nodo tmp1=_tail;
            tmp1.setNext( new Nodo(dato));
            _tail=tmp1.getNext();
            _tail.setPrev(tmp1);
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
        Nodo tmp2=tmp;
        while(tmp!=null && !tmp.getData().equals(dato)){
            tmp2=tmp;
            tmp=tmp.getNext();
        }
        if(tmp==null)
            return;
        else if(tmp==tmp2){
            _head=_head.getNext();
            _head.setPrev(null);
        }
        else{
            Nodo next= tmp.getNext();
            tmp2.setNext(next);
            next.setPrev(tmp2);
        }
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista 
     * @return i;
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
    
    public void print(){
        Nodo tmp=_head;
        while(tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNext();
        }
    }
    /**
     * hace casi lo mismo que el metodo de borrado pero no lo elimina, solo
     * devuelve el valor del nodo.
     * @param dato
     * @return 
     */
    public dp find(dp dato){
        Nodo tmp =_head;
        while(tmp!=null && !tmp.getData().equals(dato))
            tmp=tmp.getNext();
        if (tmp!=null)
            return (dp)tmp.getData();
        else
            return null;
    }
    
    public void insertSort(){
        super.insertSort(this); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        ListaSdoble nuevo = new ListaSdoble();
        nuevo.enQueue(5);
        nuevo.enQueue(14);
        nuevo.enQueue(78);
        nuevo.enQueue(34);
        nuevo.enQueue(3);
        nuevo.enQueue(1);
        nuevo.enQueue(56);
        nuevo.enQueue(7);
        nuevo.insertSort();
        nuevo.print();
    }
}
