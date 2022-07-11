package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
//		Departments obj=new Departments(1, "Livros");
//		System.out.println(obj);
//			Connection conn = DB.getConnection();
//			DB.closeConnection();
		//injeção de dependencia sem expor a implementação
		SellerDao sellerDao= DaoFactory.createSellerDao();
		System.out.println("===Teste : seller findById===");
		Seller seller=sellerDao.finById(4);
		System.out.println(seller);
		
		System.out.println("===Teste 2: seller findByDepartment===");
		Department dep=new Department(4,null);
		List<Seller> list=sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		}
		

}
