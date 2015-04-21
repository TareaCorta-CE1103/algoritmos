/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para crear arboles binarios
 * @author osboxes
 * @param <dp> tipo de dato generico
 */
public class Arbol_binario <dp extends Comparable<dp>> {
    
    private NodoB _root;
    
    /**
     * metodo para hacer casos base y revisiones simples
     * @param dato generico 
     */
    public void insert(dp dato){
        if (_root==null){
            _root= new NodoB(dato);
        }else{
            NodoB tmp=_root;
            insertAux(tmp, dato);
        }
    }
    
    /**
     * metodo recursivo para ir ingresando los nodos en el arbol
     * @param tmp nodo de arbol que contiene el padre de adonde se va a ingresar
     * @param dato dato generico que contiene lo que se quiere ingresar
     */
    private void insertAux(NodoB tmp, dp dato){
        if(dato.compareTo((dp)tmp.getDato())<0){   
            if(tmp.getHizq()==null)
                tmp.setHizq(new NodoB(dato));
            else
                insertAux(tmp.getHizq(),dato);
        }
        else if (dato.compareTo((dp)tmp.getDato())>0)
            if(tmp.getHder()==null)
                tmp.setHder(new NodoB(dato));
            else
                insertAux(tmp.getHder(),dato);
    }
    
    public boolean find(dp dato){
        if(_root==null)
            return false;
        else
            return findAux(_root, dato);
    }
    
    /**
     * metodo recursivo para encontrar y devolver un falso o cierto si 
     * se encuentra el dato buscado
     * @param tmp nodoB raiz para empezar la busqueda
     * @param dato dato del tipo generico
     * @return devuelve el nodo que concuerda con el dato que ocupamos
     */
    private boolean findAux(NodoB tmp, dp dato){
        if(tmp.getDato().compareTo(dato)<0){
            if(tmp.getHder()==null)
                return false;
            else
                return findAux(tmp.getHder(), dato);
        }
        else if(tmp.getDato().compareTo(dato)>0){
            if(tmp.getHizq()==null)
                return false;
            else 
                return findAux(tmp.getHizq(), dato);
        }
        else
            return true;
    }
    
    /**
     * metodo para devolver el menor de los mayores
     * @param pNodo
     * @return un nodoB
     */
    private NodoB minMax(NodoB pNodo){
        if(pNodo.getHizq()==null)
            return pNodo;
        else if(pNodo.getHizq().getHizq()!=null)
            return minMax(pNodo.getHizq());
        else 
            return pNodo;
    }
    
    /**
     * metodo para eliminar un elemento del arbol
     * @param dato recibe un dato generico
     */
    public void delete(dp dato){
        if(_root==null)
            return;
        else if(find(dato))
            _root=deleteAux(dato, _root, null);
    }
    
    /**
     * metodo recursivo para eliminar el dato del arbol
     * @param dato dato generico extraido del metodo delete
     * @param pNodo dato tipo NodoB que inicialmente es repesenatado por el root
     * @param padre dato tipo NodeB que apunta al padre del nodo que se va eliminar
     * @return retorna lo que va a tomar el valor de la raiz
     */
    private NodoB deleteAux(dp dato, NodoB pNodo, NodoB padre){
        if(pNodo.getDato().equals(dato)){
            if(pNodo.getHizq()==null)
                return pNodo.getHder();
            else if (pNodo.getHder()==null)
                return pNodo.getHizq();
            else{
                NodoB Aux = minMax(pNodo.getHder());
                if(Aux==pNodo.getHder()){
                    Aux.setHizq(pNodo.getHizq());
                    return Aux;
                }
                NodoB menor= Aux.getHizq();
                menor.setHizq(pNodo.getHizq());
                NodoB menor_hder= menor.getHder();
                menor.setHder(pNodo.getHder());
                pNodo.setHder(menor_hder);
                if(Aux.getHizq()==menor)
                    Aux.setHizq(menor_hder);
                else
                    Aux.setHder(menor_hder);
                return menor;
            }
        }
        else if(pNodo.getDato().compareTo(dato)>0){
            pNodo.setHizq(deleteAux(dato, pNodo.getHizq(), pNodo));
            return pNodo;
        }
        else{
            pNodo.setHder(deleteAux(dato, pNodo.getHder(), pNodo));
            return pNodo;
        }
    }
    
    /**
     * metodo para realizar un impresion en order del arbol en orden 
     */
    public void print(){
        NodoB tmp=_root;
        printIOD(tmp);
    }
    
    /**
     * metodo recursivo que va imprimiendo en orden el contenido del arbol
     * @param tmp nodo padre
     */
    private void printIOD(NodoB tmp){
        if(tmp==null)
            return;
        printIOD(tmp.getHizq());
        System.out.println(tmp.getDato());
        printIOD(tmp.getHder());
    }
}
