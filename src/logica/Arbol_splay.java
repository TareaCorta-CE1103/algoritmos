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
        splay();
    }
    
    private void splay(){
        
    }
}
