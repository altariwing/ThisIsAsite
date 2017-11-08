package com.product_order.model;

import java.util.List;

/**
 * Product_orderDAO_interface
 * insert
 * update
 * delete
 * findByPK
 * getAll
 */
public interface Product_orderDAO_interface {
	
    /**
     * insert a row
     */
    public void insert(Product_orderVO Product_orderVO);
    
    /**
     * update that pdo_no's row
     */
    public void update(Product_orderVO Product_orderVO);
      
    /**
     * delete that pdo_no's row
     */
    public void delete(String pdo_no);
    
    /**
     * select a row from table by pdo_no
     * @return Product_orderVO object
     */
    public Product_orderVO findByPK(String pdo_no);
    
    /**
     * select all from table
     * @return Product_orderVO object
     */
    public List<Product_orderVO> getAll();
}
