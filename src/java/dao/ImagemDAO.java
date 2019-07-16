/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Imagem;

/**
 *
 * @author dappo
 */
public class ImagemDAO extends GenericDAO<Imagem, Long>{
    
    public ImagemDAO(){
        super(Imagem.class);
    }
    
}
