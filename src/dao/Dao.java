/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.entities.Company;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jacqu
 */
public interface Dao <E> {
    
	public void save(E e);
        //public E findById(int id);
        //public List<E> getAll();
        //public void update(E e, String[] params);
        //public void delete(E e);
	
}
