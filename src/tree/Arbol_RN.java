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
     * metodo para devolver la raiz del arbol, por si se ocupa realizar 
     * recorridos al arbol.
     * @return retorna un dato de la clase NodoB
     */
    public NodoB getRoot(){
        return _root;
    }
    
    /**
     * metodo para ingresar nodos en el arbol rojo y negro
     * @param pDato  dato perteneciente a la clase NodoB, el nodo que queremos 
     * ingresar.
    }*/
    @Override
    public void insert(Comparable pDato) {
        _root=super.insert(pDato,_root); //To change body of generated methods, choose Tools | Templates.
        check(pDato);
    }
    
    /**
     * metodo para revisar que el arbol se encuentre de manera correcta.
     * @param pNodo dato de la clase NodoB, nodo que queremos revisar.
     */
    private void check(Comparable pDato){
        NodoB pNodo=Find(pDato);
        if(pNodo==_root)
            return;
        checkAux(pNodo, pNodo.getPadre());
    }
    
    /**
     * metodo para realizar un revisado del arbol cual se le ingresa un nodo.
     * @param pNodo nodo el caul vamos a revisar.
     */
    private void check(NodoB pNodo){
        if(pNodo==null)
            return;
        else if(pNodo==_root)
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
            NodoB tio=null;
            if(abuelo.getHizq()==pPadre){
                checkIzq(abuelo, tio, pPadre, pNodo);
            }else{
                checkDer(abuelo, tio, pPadre, pNodo);
            }
        }
    }
    
    /**
     * metodo para realizar un chequeo cual el nodo que analizamos es un hijo 
     * izquierdo.
     * @param abuelo nodo que va a ser el abuelo del nodo.
     * @param tio nodo tio con el cual analizamos.
     * @param pPadre nodo padre de la organizacion.
     * @param pNodo nodo el cual vamos a eliminar.
     */
    private void checkIzq(NodoB abuelo,NodoB tio, NodoB pPadre, NodoB pNodo){
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
    }
    
    /**
     * metodo para realizar un chequeo cual el nodo que analizamos es un hijo 
     * derecho.
     * @param abuelo nodo que va a ser el abuelo del nodo.
     * @param tio nodo tio con el cual analizamos.
     * @param pPadre nodo padre de la organizacion.
     * @param pNodo nodo el cual vamos a eliminar.
     */
    private void checkDer(NodoB abuelo,NodoB tio, NodoB pPadre, NodoB pNodo){
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
     * metodo para realizar una busqueda en el arbol
     * @param pDato dato para realizar comparaciones 
     * @return retorna un dato booleano si existe o no el dato, true o false.
     */
    public boolean search(Comparable pDato){
        return super.find(pDato, _root);
    }
    
    /**
     * metodo para realizar un borrado en el arbol rojo y negro.
     * @param pDato dato generico para ir eliminando el dato.
     */
    public void borrar(Comparable pDato){
        NodoB pNodo= Find(pDato);
        if(_root==pNodo)
            _root=borrarAux(pNodo);
        else
            borrarAux(pNodo);
    }
    
    /**
     * metodo para auxiliar para eliminar el dato del arbol.
     * @param pNodo recibe un nodo que concuerda con el dato que vamos a 
     * eliminar.
     * @return retorna el nodo que sera la cabeza de la organizacion.
     */
    private NodoB borrarAux(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        if(pNodo.getHder()==null){
            pNodo.getHizq().setColor(Negro);
            if(padre!=null)
                return OneSon(pNodo.getHizq(), padre);
            else
                return pNodo.getHizq();
        }else if(pNodo.getHizq()==null){
            pNodo.getHder().setColor(Negro);
            if(padre!=null)
                return OneSon(pNodo.getHder(), padre);
            else
                return pNodo.getHder();
        }else{
            return BootSons(pNodo);
        }
    }
    
    /**
     * metodo para realizar un borrado cuando solo se tiene un hijo.
     * @param pNodo nodo el cual esta en proceso de eliminacion.
     * @param pPadre nodo que es el padre del pNodo.
     * @return retorna el padre de la nueva organizacion.
     */
    private NodoB OneSon(NodoB pNodo, NodoB pPadre){
        if(pPadre.getHder()==pNodo.getPadre())
           pPadre.setHder(pNodo);
        else
            pPadre.setHizq(pNodo);
        pNodo.setPadre(pPadre);
        check(pNodo);
        return pPadre;
    }
    
    /**
     * metodo para realizar un borrado cuando se tienen dos hijos.
     * @param pNodo nodo el cual vamos a eliminar
     * @return retorna el nuevo padre de la organizacion.
     */
    private NodoB BootSons(NodoB pNodo){
        NodoB Aux = minMax(pNodo.getHder());
        if(Aux==pNodo.getHder()){
            Aux.setHizq(pNodo.getHizq());
            Aux=revisarBorrado(Aux);
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
        menor=revisarBorrado(menor);
        return menor;
    }
    
    /**
     * metodo para hacer un revisado de si existe algun problema al realizar 
     * el borrado.
     * @param pNodo nodo el cual vamos a analizar.
     * @return retorna la cabeza de la nueva organizacion.
     */
    private NodoB revisarBorrado(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hermano;
        if(padre.getHizq()==pNodo){
            hermano=padre.getHder();
            if(padre.getColor()==Negro){
                if(hermano.getColor()==Rojo){
                    padre.setColor(Rojo);hermano.setColor(Negro);
                    padre=rotacionSIzq(padre);
                    check(padre.getHder());
                    return padre;
                }else{
                    hermano.setColor(Rojo);
                    check(hermano.getHder());
                    return padre;
                }
            }else{
                padre.setColor(Negro);
                hermano.setColor(Rojo);
                check(hermano.getHizq());
                return padre;
            }
        }
        else{
            hermano=padre.getHizq();
            if(padre.getColor()==Negro){
                if(hermano.getColor()==Rojo){
                    padre.setColor(Rojo);hermano.setColor(Negro);
                    padre=rotacionSDer(padre);
                    check(padre.getHizq());
                    return padre;
                }else{
                    hermano.setColor(Rojo);
                    check(hermano.getHizq());
                    return padre;
                }
            }else{
                padre.setColor(Negro);
                hermano.setColor(Rojo);
                check(hermano.getHder());
                return padre;
            }
        }
    }
    
    /**
     * metodo privado especial que permite devolver nodos conectados al arbol.
     * @param pDato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     * @return retorna un null si no existe el dato; en caso de que exista
     * devolvera un nodo que contiene las conexiones y referencias con 
     * respecto al arbol.
     */
    private NodoB Find(Comparable pDato){
        if (_root.getDato().compareTo(pDato)==0)
            return _root;
        else
            return FindAux(_root,pDato);
    }
    
    /**
     * metodo privado recursivo que busca el dato que estamos buscando
     * @param pNodo recibe inicialmente la raiz.
     * @param pDato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     * @return retorna el nodo que haya sido igual.
     */
    private NodoB FindAux(NodoB pNodo, Comparable pDato){
        if(pNodo.getDato().compareTo(pDato)==0){
            return pNodo;
        }
        if(pNodo.getDato().compareTo(pDato)<0){
            if(pNodo.getHder()==null)
                return null;
            else
                return FindAux(pNodo.getHder(), pDato);
        }
        if(pNodo.getDato().compareTo(pDato)>0){
            if(pNodo.getHizq()==null)
                return null;
            else 
                return FindAux(pNodo.getHizq(), pDato);
        }
        return null;
    }
    
    /**
     * metodo sobre escrito para impirmir nodos y se usa para casos de prueba.
     */
    @Override
    public void print() {
        super.print(_root); //To change body of generated methods, choose Tools | Templates.
    }    
}
