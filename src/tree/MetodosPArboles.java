/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author osboxes
 * @param <dp>
 */
public class MetodosPArboles <dp> extends Arbol_binario implements Constantes{
    
    /**
     * metodo para heredar para utilizacion en todos los arboles
     * @param pDato generico 
     * @param pNodo aqui se ingresa la raiz del arbol
     * @return  retorna la raiz una vez ingresado el dato para no perder 
     * los nodos
     */
    public NodoB insert(dp pDato, NodoB pNodo){
        return super.insert((Comparable) pDato, pNodo);
    }
    
    /**
     * meotodo booleano de busqueda para todos los arboles
     * @param pDato dato generico.
     * @param pNodo recibe la raiz del arbol.
     * @return retorna un true o false si existe o no.
     */
    public boolean find(dp pDato, NodoB pNodo){
        return super.find((Comparable)pDato, pNodo);
    }
    
    /**
     * meotodo de borrado para cualquier arbol diferente de un binario
     * @param pDato dato generico
     * @param pNodo el nodo raiz del arbol
     * @return retorna el nodo Aux convertido ahora en la raiz
     */
    public NodoB delete(dp pDato, NodoB pNodo){
        return super.delete((Comparable)pDato, pNodo);
    }
    
    /**
     * metodo para realizar rotaciones simples a la Izquierda
     * @param pNodo recibe un dato del tipo NodoB
     * @return retorna el nodo que ahora sera la cabeza de las rotacion.
     */
    public NodoB rotacionSIzq(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hder= pNodo.getHder();
        NodoB maxMIn= pNodo.getHder().getHizq();
        hder.setPadre(padre);
        hder.setHizq(pNodo);
        pNodo.setPadre(hder);
        pNodo.setHder(maxMIn);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hder);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(hder);
        if(maxMIn!=null)
            maxMIn.setPadre(pNodo);
        return hder;
    }
    
    /**
     * metodo para realizar rotacion simple a la Derecha
     * @param pNodo recibe un dato del tipo NodoB
     * @return retorna el nodo que ahora sera la cabeza luego de la rotacion
     */
    public NodoB rotacionSDer(NodoB pNodo){
        NodoB padre=pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        NodoB minMAx=pNodo.getHizq().getHder();
        hizq.setHder(pNodo);
        hizq.setPadre(padre);
        pNodo.setPadre(hizq);
        pNodo.setHizq(minMAx);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(hizq);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(hizq);
        if(minMAx!=null)
            minMAx.setPadre(pNodo);
        return hizq;
    }
    
    /**
     * metodo para realizar una doble rotacion hacia la derecha.
     * @param pNodo este dato pertenece a la clase NodoB.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    public NodoB rotacionDDer(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        NodoB toHead= pNodo.getHizq().getHder();
        NodoB hizqG= pNodo.getHizq().getHder().getHizq();
        NodoB hderG= pNodo.getHizq().getHder().getHder();
        toHead.setPadre(padre);
        toHead.setHizq(hizq);
        toHead.setHder(pNodo);
        hizq.setPadre(toHead);
        hizq.setHder(hizqG);
        pNodo.setPadre(toHead);
        pNodo.setHizq(hderG);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(toHead);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(toHead);
        if(hderG!=null)
            hderG.setPadre(pNodo);
        if (hizqG!=null)
            hizqG.setPadre(hizq);
        return toHead;
    }
    
    /**
     * metodo para realizar rotaciones hacia la izquierda.
     * @param pNodo dato que pertenece a la clase NodoBs.
     * @return retorna el nodo que ahora es la cabeza del movimiento.
     */
    public NodoB rotacionDIzq(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hder= pNodo.getHder();
        NodoB toHead= pNodo.getHder().getHizq();
        NodoB hizqG= pNodo.getHder().getHizq().getHizq();
        NodoB hderG= pNodo.getHder().getHizq().getHder();
        toHead.setPadre(padre);
        toHead.setHder(hder);
        toHead.setHizq(pNodo);
        hder.setPadre(toHead);
        hder.setHizq(hderG);
        pNodo.setPadre(toHead);
        pNodo.setHder(hizqG);
        if(padre!=null && padre.getHder()==pNodo)
            padre.setHder(toHead);
        else if(padre!=null && padre.getHizq()==pNodo)
            padre.setHizq(toHead);
        if(hderG!=null)
            hderG.setPadre(hder);
        if (hizqG!=null)
            hizqG.setPadre(pNodo);
        return toHead;
    }
    
    /**
     * metodo para aumentar el tamaño de un arreglo.
     * @param pMaxSize dato tipo entero, este es el largo maximo del arreglo
     * @param pArreglo dato tipo String[], es el arreglo que se recibe.
     * @return retorna un arreglo con el tamaño aumentado.
     */
    public String[] growArray( int pMaxSize, String[] pArreglo){
        double newMAxsize= (crecimientoArreglo)+pMaxSize;
        String[] newArreglo= new String[(int)newMAxsize];
        System.arraycopy(pArreglo, 0, newArreglo, 0, pMaxSize);
        pMaxSize=(int)newMAxsize;
        pArreglo=newArreglo;
        return pArreglo;
    }
    
    /**
     * metodo para arboles diferentes del binario
     * @param pNodo nodo raiz del arbol
     */
    @Override
    public void print(NodoB pNodo){
        super.print(pNodo);
    }
}
