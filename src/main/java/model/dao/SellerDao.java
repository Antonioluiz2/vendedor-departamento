package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Seller obj);
	//vai consultar no banco se ja existe um obgj com Id se existir vai retornar se não vai dar null 
	Seller finById(Integer id);
	//retornar todos os departamentos
	List<Seller> findAll();
	List<Seller> findByDepartment(Department departament);
}
