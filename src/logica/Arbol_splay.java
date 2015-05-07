/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * clase para crear arboles splay
 * @author osboxes
 * @param <dp>
 */
public class Arbol_splay <dp extends Comparable<dp>> extends Arbol_binario{
    
    private NodoB _root;

    @Override
    public void insert(Comparable dato) {
        super.insert(dato);
        splay(dato);
    }
    
    private void splay(Comparable dato){
        NodoB ToRoot=Find(dato);
        if(ToRoot==null)
            return;
        else{
            _root=splayAux(ToRoot);
        }
    }
    
    private NodoB splayAux(NodoB ToRoot){
        if(ToRoot.getPadre()==null)
            return ToRoot;
        if(ToRoot.getPadre().getPadre()==null){
            if(ToRoot.getHder()==ToRoot)
                Zig(ToRoot);
            else
                Zag(ToRoot);
        }
        else{
            
        }
        if(ToRoot.getPadre()!=null)
            return splayAux(ToRoot);
        return null;
    }
    
    private void Zig(NodoB pNodo){
        NodoB padre=pNodo.getPadre();
        NodoB hder =pNodo.getHder();
        pNodo.setPadre(padre.getPadre());
        pNodo.setHder(padre);
        padre.setPadre(pNodo);
        padre.setHizq(hder);
    }
    
    private void Zag(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB hizq= pNodo.getHizq();
        pNodo.setPadre(padre.getPadre());
        pNodo.setHizq(padre); 
        padre.setPadre(pNodo);
        padre.setHder(hizq);
    }
    
    private void ZagZag(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB abuelo= padre.getPadre();
        NodoB hizqP= padre.getHizq();
        NodoB hizq= pNodo.getHizq();
        pNodo.setPadre(abuelo.getPadre());
        pNodo.setHizq(padre);
        padre.setPadre(pNodo);
        padre.setHder(hizq);
        abuelo.setPadre(padre);
        abuelo.setHizq(hizqP);
    }
    
    private void ZigZig(NodoB pNodo){
        NodoB padre= pNodo.getPadre();
        NodoB abuelo= padre.getPadre();
        NodoB hderP= padre.getHder();
        NodoB hder= pNodo.getHder();
        pNodo.setPadre(abuelo.getPadre());
        pNodo.setHder(padre);
        padre.setPadre(pNodo);
        padre.setHizq(hder);
        abuelo.setPadre(padre);
        abuelo.setHder(hderP);
    }
    
    private NodoB Find(Comparable pDato){
        if (_root.getDato().compareTo(pDato)==0)
            return _root;
        else
            return FindAux(_root,pDato);
    }
    
    private NodoB FindAux(NodoB pNodo, Comparable pDato){
        if(pNodo.getDato().compareTo(pDato)==0)
            return pNodo;
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
}
