package com.order_detail.model;

public class TestOrder_detailJDBCDAO {

	public static void main(String[] args) {
		System.out.println("hello world!");

		Order_detailJDBCDAO dao = new Order_detailJDBCDAO();
		
		//☁Test  insert(Order_detailVO Order_detailVO); 
		System.out.println("====☁Test insert(Order_detailVO Order_detailVO)====");
		Order_detailVO odtVO1 = new Order_detailVO();
		odtVO1.setPdo_no("OD171109-000001");
		odtVO1.setPrd_no("PD00000001");
		odtVO1.setOder_uni_price(599);
		odtVO1.setOder_quantity(3);
        dao.insert(odtVO1);
        
		//☁Test   update(Order_detailVO Order_detailVO); 
		System.out.println("====☁Test update(Order_detailVO Order_detailVO)====");
		Order_detailVO odtVO2 = new Order_detailVO();
		odtVO2.setOder_quantity(100);
		odtVO2.setPdo_no("OD171109-000001");
		odtVO2.setPrd_no("PD00000020");
		dao.update(odtVO2);
		
		//☁Test   delete(String pdo_no,String prd_no); 
		System.out.println("====☁Test delete(String pdo_no,String prd_no)====");
		dao.delete("OD171109-000001", "PD00000011");
		
		//☁Test   findByPK(String pdo_no,String prd_no); 
		System.out.println("====☁Test findByPK(String pdo_no,String prd_no)====");
		
		
		
		//☁Test   getAll(); 
		System.out.println("====☁Test getAll()====");
		//☁Test   getAllByPDO_NO(String pdo_no); 
		System.out.println("====☁Test getAllByPDO_NO(String pdo_no)====");
		
		
		
		
		
		
		
		
		
		
		
	}

}
