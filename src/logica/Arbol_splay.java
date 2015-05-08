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
        _root=super.insert(dato, _root);
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
        if(ToRoot.getPadre()!=null && ToRoot.getPadre().getPadre()==null){
            if(ToRoot.getPadre().getHder()==ToRoot)
                Zag(ToRoot);
            else
                Zig(ToRoot);
        }
        else{
            if(ToRoot.getPadre().getPadre().getHder()==ToRoot.getPadre()){
                if(ToRoot.getPadre().getHder()==ToRoot)
                    ZagZag(ToRoot);
                else{
                    Zig(ToRoot);
                    Zag(ToRoot);
                }
            }
            else{
                if(ToRoot.getPadre().getHizq()==ToRoot)
                    ZigZig(ToRoot);
                else{
                    Zag(ToRoot);
                    Zig(ToRoot);
                }
            }
        }
        if(ToRoot.getPadre()!=null)
            return splayAux(ToRoot);
        else
            return ToRoot;
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

    @Override
    public void print() {
        super.print(_root);
    }
    
    public static void main(String[] args) {
        Arbol_splay nuevo = new Arbol_splay();
        nuevo.insert(10);
        nuevo.insert(5);
        //nuevo.insert(15);
        //nuevo.insert(13);
        //nuevo.insert(20);
        //nuevo.insert(19);
        //nuevo.insert(22);
        nuevo.print();
    }
}
