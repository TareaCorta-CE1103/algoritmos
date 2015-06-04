/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 * clase para crear arboles rojo y negro
 * @author osboxes
 * @param <dp>
 */
public class Arbol_RN  <dp extends Comparable<dp>> extends MetodosPArboles implements Constantes{
    
    private NodoB _root;

    /**
     * metodo para ingresar nodos en el arbol rojo y negro
     * @param pDato  dato perteneciente a la clase NodoB, el nodo que queremos 
     * ingresar.
    }*/
    
    @Override
    public void insert(Comparable pDato) {
        _root=super.insert(pDato,_root); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodo para revisar que el arbol se encuentre de manera correcta.
     * @param pNodo dato de la clase NodoB, nodo que queremos revisar.
     */
    private void check(dp pDato){
        NodoB pNodo=new NodoB(pDato);
        if(pNodo==_root)
            return;
        checkAux(pNodo, pNodo.getPadre());
    }
    
    /**
     * metodo recursivo para ir revisando si los nodos se encuentra en 
     * condiciones aceptables.
     * @param pNodo dato de la clase NodoB, nodo que ingresamos.
     * @param pPadre dato de la clase NodoB, es el padre del nodo.
     */
    private void checkAux(NodoB pNodo, NodoB pPadre){
        if (pPadre==null){
            if(pNodo.getColor()==Rojo)
                changeColor(pNodo);
            _root=pNodo;
            return;
        }
        else if (pPadre.getPadre()==null){
            return;
        }
        else{
            NodoB abuelo=pPadre.getPadre();
            NodoB tio;
            if(abuelo.getHizq()==pPadre){
                tio=abuelo.getHder();
                if (pPadre.getColor()==Negro)
                    return;
                else if(tio==null){
                    if(pNodo==pPadre.getHizq()){
                        changeColor(pPadre);changeColor(abuelo);
                        abuelo=rotacionSDer(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }else{
                        changeColor(pNodo);changeColor(abuelo);
                        abuelo=rotacionDDer(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }
                }
                else if(tio.getColor()==Rojo){
                    changeColor(pPadre);changeColor(tio);changeColor(abuelo);
                    checkAux(abuelo, abuelo.getPadre());
                    return;
                }
                else if (tio.getColor()==Negro){
                    changeColor(abuelo);changeColor(pPadre);
                    abuelo=rotacionSDer(abuelo);
                    checkAux(pPadre, pPadre.getPadre());
                    return;
                }
            }else{
                tio=abuelo.getHizq();
                if (pPadre.getColor()==Negro)
                    return;
                else if(tio==null){
                    if(pNodo==pPadre.getHder()){
                        changeColor(pPadre);changeColor(abuelo);
                        abuelo=rotacionSIzq(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }else{
                        changeColor(pNodo);changeColor(abuelo);
                        abuelo=rotacionDIzq(abuelo);
                        checkAux(abuelo, abuelo.getPadre());
                        return;
                    }
                }
                else if(tio.getColor()==Rojo){
                    changeColor(pPadre);changeColor(tio);changeColor(abuelo);
                    checkAux(abuelo, abuelo.getPadre());
                    return;
                }
                else if (tio.getColor()==Negro){
                    changeColor(abuelo);changeColor(pPadre);
                    abuelo=rotacionSIzq(abuelo);
                    checkAux(pPadre, pPadre.getPadre());
                    return;
                }
            }
        }
    }
    
    /**
     * metodo para intercambiar el color de un nodo, sol basta con ingresar el 
     * nodo que se quiera y el invierte el color automaticamente.
     * @param pNodo dato de la clase NodoB, es el nodo al cual se le quiere
     * cambiar el color.
     */
    private void changeColor(NodoB pNodo){
        if(pNodo.getColor()==Rojo)
            pNodo.setColor(Negro);
        else
            pNodo.setColor(Rojo);
    }
    
    /**
     * metodo sobre escrito para impirmir nodos y se usa para casos de prueba.
     */
    @Override
    public void print() {
        super.print(_root); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodos de prueba.
     * @param args 
    public static void main(String[] args) {
        Arbol_RN Nuevo = new Arbol_RN();
        NodoB nuevo= new NodoB(6);
        NodoB nuevo1= new NodoB(7);
        NodoB nuevo2= new NodoB(8);
        NodoB nuevo3= new NodoB(9);
        NodoB nuevo4= new NodoB(10);
        Nuevo.insert(nuevo);
        Nuevo.insert(nuevo1);
        Nuevo.insert(nuevo2);
        Nuevo.insert(nuevo3);
        Nuevo.insert(nuevo4);
        Nuevo.print();
    } */
}
