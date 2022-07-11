package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Department obj);
	//vai consultar no banco se ja existe um obgj com Id se existir vai retornar se não vai dar null 
	Department finById(Integer id);
	//retornar todos os departamentos
	List<Department> findAll();
}
