/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 * clase para crear arboles splay
 * @author osboxes
 * @param <dp>
 */
public class Arbol_splay <dp extends Comparable<dp>> extends Arbol_binario{
    
    private NodoB _root;
    private boolean _ifPadre;
    
    
    /**
     * metodo para retornar la raiz y realizar recorridos en el arbol.
     * @return retorna un dato de la clase NodoKeyword, este es la raiz del 
     * arbol.
     */
    public NodoB getRoot(){
        return _root;
    }

    /**
     * metodo sobre-escrito de la clase Arbol binario para ingresar nodos 
     * en un arbol Splay.
     * @param pDato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     */
    @Override
    public void insert(Comparable pDato) {
        _root=super.insert(pDato, _root);
        splay(pDato);
    }
    
    /**
     * metodo privado para hacer las verificaciones de las rotaciones 
     * del nodos
     * @param dato recibe un dato generico que concuerda con el dato que
     * acamos de ingresar en el arbol.
     */
    private void splay(Comparable pDato){
        NodoB ToRoot=Find(pDato);
        if(!_ifPadre || ToRoot==_root)
            return;
        else{
            _root=splayAux(ToRoot);
        }
    }
    
    /**
     * metodo para realizar las verificaciones de si tenemos que rotar los nodos
     * del arbol para que un cierto nodo llegue a la raiz.
     * @param pNodo recibe un nodoB para realizar el metodo splay
     */
    private void splay(NodoB pNodo){
        if(pNodo==null)
            return;
         _root=splayAux(pNodo);
    }
    
    /**
     * metodo que rota los nodos hasta poner el nodo que se quiere en 
     * la posicion buscada.
     * @param ToRoot recibe un nodo que coincide con el nodo que acabamos 
     * de ingresar.
     * @return retorna la nueva raiz del arbol.
     */
    private NodoB splayAux(NodoB ToRoot){
        if (ToRoot.getPadre()==null)
            return ToRoot;
        else if(ToRoot.getPadre().getPadre()==null){
            if(ToRoot.getPadre().getHder()==ToRoot)
                Zag(ToRoot);
            else
                Zig(ToRoot);
        }
        else{
            if(ToRoot.getPadre().getPadre().getHder()==ToRoot.getPadre()){
                if(ToRoot.getPadre().getHder()==ToRoot){
                    ZagZag(ToRoot);
                }
                else{
                    ZigZag(ToRoot);
                }
            }
            else{
                if(ToRoot.getPadre().getHizq()==ToRoot){
                    ZigZig(ToRoot);
                }
                else{
                    ZagZig(ToRoot);
                }
            }
        }
        if(ToRoot.getPadre()!=null)
            return splayAux(ToRoot);
        else
            return ToRoot;
    }
    
    /**
     * metodo privado que recibe un nodo, que coincide con el que vamos a rotar.
     * @param pNodo recibe un dato de la clase NodoB
     */
    private void Zig(NodoB pNodo){
        NodoB padre=pNodo.getPadre();
        NodoB hder =pNodo.getHder();
        pNodo.setPadre(padre.getPadre());
        if(padre.getPadre()!=null){
            if(padre.getPadre().getHder()==padre)
                padre.getPadre().setHder(pNodo);
            else
                padre.getPadre().setHizq(pNodo);
        }
        pNodo.setHder(padre);
        padre.setPadre(pNodo);
        padre.setHizq(hder);
        if(hder!=null)
            hder.setPadre(padre);
    }
    
    /**
     * metodo privado que recibe un nodo, este coincide con el nodo que se 
     * ingreso de ultimo y es el que se va a establecer como nueva raiz.
     * @param pNodo dato de la clase NodoB.
     */
    private void Zag(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        pNodo.setPadre(padre.getPadre());
        if(padre.getPadre()!=null){
            if(padre.getPadre().getHder()==padre)
                padre.getPadre().setHder(pNodo);
            else
                padre.getPadre().setHizq(pNodo);
        }
        pNodo.setHizq(padre); 
        padre.setPadre(pNodo);
        padre.setHder(hizq);
        if(hizq!=null)
            hizq.setPadre(padre);
    }
    
    /**
     * metodo especial para cuando se tiene que hacer dos veces una rotacion 
     * a la derecha.
     * @param pNodo dato de la clase NodoB, es el nodo que queremos que rote.
     */
    private void ZagZag(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB abuelo= padre.getPadre();
        NodoB hizqP= padre.getHizq();
        NodoB hizq= pNodo.getHizq();
        pNodo.setPadre(abuelo.getPadre());
        if(abuelo.getPadre()!=null){
            if(abuelo.getPadre().getHder()==abuelo)
                abuelo.getPadre().setHder(pNodo);
            else
                abuelo.getPadre().setHizq(pNodo);
        }
        pNodo.setHizq(padre);
        padre.setPadre(pNodo);
        padre.setHder(hizq);
        padre.setHizq(abuelo);
        abuelo.setPadre(padre);
        abuelo.setHder(hizqP);
        if(hizq!=null)
            hizq.setPadre(padre);
        if(hizqP!=null)
            hizqP.setPadre(abuelo);
    }
    
    /**
     * metodo privado que permite hacer dos rotaciones hacia la izquierda.
     * @param pNodo dato de la clase NodoB, es el nodo que queremos que rote.
     */
    private void ZigZig(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB abuelo= padre.getPadre();
        NodoB hderP= padre.getHder();
        NodoB hder= pNodo.getHder();
        pNodo.setPadre(abuelo.getPadre());
        if(abuelo.getPadre()!=null){
            if(abuelo.getPadre().getHder()==abuelo)
                abuelo.getPadre().setHder(pNodo);
            else
                abuelo.getPadre().setHizq(pNodo);
        }
        pNodo.setHder(padre);
        padre.setPadre(pNodo);
        padre.setHizq(hder);
        padre.setHder(abuelo);
        abuelo.setPadre(padre);
        abuelo.setHizq(hderP);
        if(hder!=null)
            hder.setPadre(padre);
        if(hderP!=null)
            hderP.setPadre(abuelo);
    }
    
    /**
     * metodo para hacer un rotacion entre el hijo y el padre hacia la izquierda
     * y el hijo y el abuelo hacia la derecha.
     * @param pNodo dato de la clase NodoB, es el nodo que queremos que rote.
     */
    private void ZigZag(NodoB pNodo){
        NodoB abuelo=pNodo.getPadre().getPadre();
        NodoB padre= pNodo.getPadre();
        NodoB hizq=pNodo.getHizq();
        NodoB hder=pNodo.getHder();
        pNodo.setPadre(abuelo.getPadre());
        if(abuelo.getPadre()!=null){
            if(abuelo.getPadre().getHder()==abuelo)
                abuelo.getPadre().setHder(pNodo);
            else
                abuelo.getPadre().setHizq(pNodo);
        }
        pNodo.setHizq(abuelo);
        pNodo.setHder(padre);
        padre.setPadre(pNodo);
        padre.setHizq(hder);
        abuelo.setPadre(pNodo);
        abuelo.setHder(hizq);
        if(hizq!=null)
            hizq.setPadre(abuelo);
        if(hder!=null)
            hder.setPadre(padre);
    }
    
    /**
     * metodo para hacer una rotacion hacia la derecha entre el hijo y el padre
     * y una rotacion hacia la izquierda entre el hijo y el abuelo.
     * @param pNodo dato de la clase NodoB, es el nodo que queremos que rote.
     */
    private void ZagZig(NodoB pNodo){
        NodoB abuelo=pNodo.getPadre().getPadre();
        NodoB padre= pNodo.getPadre();
        NodoB hizq=pNodo.getHizq();
        NodoB hder=pNodo.getHder();
        pNodo.setPadre(abuelo.getPadre());
        if(abuelo.getPadre()!=null){
            if(abuelo.getPadre().getHder()==abuelo)
                abuelo.getPadre().setHder(pNodo);
            else
                abuelo.getPadre().setHizq(pNodo);
        }
        pNodo.setHizq(padre);
        pNodo.setHder(abuelo);
        padre.setPadre(pNodo);
        padre.setHder(hizq);
        abuelo.setPadre(pNodo);
        abuelo.setHizq(hder);
        if(hizq!=null)
            hizq.setPadre(padre);
        if(hder!=null)
            hder.setPadre(abuelo);
    }
    
    /**
     * metodo sobre-escrito del padre para borrar datos del arbol
     * @param dato recibe un dato generico, que sea igual a los datos 
     * que se ingresado con anterioridad al arbol.
     */
    @Override
    public void delete(Comparable dato) {
        NodoB tmp= Find(dato);
        if(tmp==_root){
            _root=delete(dato, _root);
        }
        else if(_ifPadre){
            NodoB padre= tmp.getPadre();
            _root=delete(dato, tmp);
            splay(padre);
        }
        else
            splay(tmp);
    }
    
    /**
     * metodo para realizar una busqueda en el arbol
     * @param dato dato de generico, este el nodo que queremos 
     */
    public void search(Comparable dato){
        NodoB tmp = Find(dato);
        splay(tmp);
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
        if (_root.getDato().compareTo(pDato)==0){
            _ifPadre=false;
            return _root;
        }
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
            _ifPadre=true;
            return pNodo;
        }
        else if(pNodo.getDato().compareTo(pDato)<0){
            if(pNodo.getHder()==null){
                _ifPadre=false;
                return pNodo;
            }
            else
                return FindAux(pNodo.getHder(), pDato);
        }
        else if(pNodo.getDato().compareTo(pDato)>0){
            if(pNodo.getHizq()==null){
                _ifPadre=false;
                return pNodo;
            }
            else 
                return FindAux(pNodo.getHizq(), pDato);
        }
        return null;
    }

    /**
     * metodo sobre escrito del padre para imprimir los datos del arbol;
     * este metodo solo se utiliza para los casos de prueba.
     */
    @Override
    public void print() {
        super.print(_root);
        //System.out.println("raiz: "+ _root.getDato());
    }
}
