/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para crear arboles auto-valanceables
 * @author osboxes
 * @param <dp>
 */
public class Arbol_AVL <dp extends Comparable<dp>> extends Arbol_binario{
    
    private NodoB _root;
    
    @Override
    public void insert(Comparable dato) {
        super.insert(dato);
        check();
    }
    /**
     * metodo para calcular la altura de 
     * @param Hizq
     * @param Hder
     * @return 
     */
    private int Heigth(NodoB Hizq, NodoB Hder){
        if(Hizq!=null&&Hder!=null)
            return Math.max(Hizq.getDepth(),Hder.getDepth());
        else if(Hizq!=null)
            return Hizq.getDepth();
        else if(Hder!=null)
            return Hder.getDepth();
        else
            return 0;
    }
    
    /**
     * metodo para calcular el factor de equilibrio de un nodo
     * @param Hizq
     * @param Hder
     * @return retrona un dato tipo int, si se retorna un dato con valor
     * de cero es que se encuentra equilibrado
     */
    private double FactorEquilibrio(NodoB Hizq, NodoB Hder){
        if(Hizq!=null&&Hder!=null)
            return Hizq.getDepth()-Hder.getDepth();
        else if(Hizq!=null)
            return Hizq.getDepth();
        else if(Hder!=null)
            return -Hder.getDepth();
        else
            return 0;
    }
    
    /**
     * metodo para realizar rotaciones simples a la derecha 
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void rotacionSDer(NodoB pNodo){
        
    }
    
    /**
     * metodo para realizar rotacion simple a la izquiera
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void rotacionSIzq(NodoB pNodo){
        
    }
    
    /**
     * metodo para establce y revisar la altura de los nodos
     * este mismo realiza las rotaciones.
     */
    private void check(){
        NodoB tmp= _root;
        checkAux(tmp);
    }
    
    /**
     * metodo recursivo que va poniendo la profundidad, factor de equilibrio
     * y revisa si se ocupan hacer rotaciones en el arbol.
     * @param pNodo recibe un dato del tipo NodoB
     */
    private void checkAux(NodoB pNodo){
        if(pNodo==null)
            return;
        checkAux(pNodo.getHizq());
        pNodo.setDepth(Heigth(pNodo.getHizq(), pNodo.getHder()));
        pNodo.setFE(FactorEquilibrio(pNodo.getHizq(), pNodo.getHder()));
        if(pNodo.getFE()>1)
            rotacionSDer(pNodo);
        else if(pNodo.getFE()<-1)
            rotacionSIzq(pNodo);
        checkAux(pNodo.getHder());
    }
}
