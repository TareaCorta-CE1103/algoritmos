/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import sort.inserSort;
import tree.Constantes;

/**
 * clase de lista que sive como padre para todas las otras otras clases
 * que hagan listas o sirvan como bases de datos.
 *
 * @author osboxes <------asi se llama la maquina virtual en ubuntu
 * @param <dp>
 */
public class ListaSdoble <dp extends Comparable<dp>> extends inserSort 
implements Constantes{
    
    private Nodo _head;
    private Nodo _tail;
    
    /**
     * encola en una lista doble simple los nodos que se ocupen 
     * @param dato dato generico que recibe cualquier cosa
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
     * metodo especifico para encolar en una lista y las lista que se va 
     * quedando, finaliza como ordenanda, luego de cada ejecucion.
     * @param dato dato generico que recibe cualquier cosa
     */
    public void insert(dp dato){
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
        insertSort();
    }
    
    /**
     * devuelve la cabeza de la lista o el primer nodo que se ingreso
     * @return retorna la cabeza la cabeza de la lista
     */
    public Nodo getHead(){
        return _head;
    }
    
    /**
     * devuelve la cola de la lista o el ulrimo nodo ingresado
     * @return retorna una nodos que es el apunta a la cola
     */
    public Nodo getTail(){
        return _tail;
    }
    
    /**
     * recive un dato y va buscando en toda lista si existe un nodo 
     * que contenga tal valor, de encontrarlo lo elimina, si no lo encuentra
     * alerta un null.
     * @param dato dato generico que puede ser cualquiera, segun cumpla con los
     * tipos de datos anteriormente ingresados
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
            if(next!=null)
                next.setPrev(tmp2);
        }
    }
    
    /**
     * metodo para devolver la cantidad numerica de datos encontrados 
     * en la lista 
     * @return el largo total de la lista, dato tipo entero;
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
     * @param dato dato generico, puede ser cualquiera
     * @return retorna un dato generico, que el dato del nodo que buscabamos
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
    
    /**
     * metodo para realizar un ordenamiento de la lista, cuando ya se tienen 
     * todos los valores ingresados.
     */
    public void insertSort(){
        super.insertSort(this); //To change body of generated methods, choose Tools | Templates.
    }
}
