package com.order_detail.model;

import java.util.List;

import com.product_order.model.Product_orderVO;

/**
 * Order_detailDAO_interface
 * insert
 * update
 * delete
 * findByPK
 * getAll
 */
public interface Order_detailDAO_interface {
	
    /**
     * insert a row
     */
    public void insert(Order_detailVO Order_detailVO);
    
    /**
     * update PK's row
     */
    public void update(Order_detailVO Order_detailVO);
      
    /**
     * delete PK's row
     */
    public void delete(String pdo_no,String prd_no);
    
    /**
     * select a row from table by PK
     * @return Order_detailVO object
     */
    public Order_detailVO findByPK(String pdo_no,String prd_no);
    
    /**
     * select all from table
     * @return Order_detailVO object
     */
    public List<Order_detailVO> getAll();
}
