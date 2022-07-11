package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Seller obj) {
		// TODO Auto-generated method stub

	}


	@Override
	public Seller finById(Integer id) {
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
					+ "FROM seller INNER JOIN department\r\n"
					+ "ON seller.DepartmentId=department.Id\r\n"
					+ "WHERE seller.Id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			if (rs.next()) {
				Department dep= instateament(rs);
				Seller obj=instateamentSeller(rs,dep);
				return obj;

			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

		}
		return null;
	}
	
	//Reutilizar o codigo instanciando
	private Seller instateamentSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj=new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instateament(ResultSet rs) throws SQLException {
		Department dep= new Department();
		dep.setId(rs.getInt("ID"));
		dep.setName(rs.getString("DepName"));
		return null;
	}

	@Override
	public List<Seller> findAll() {
		//		 PreparedStatement st=null;
		//		 ResultSet rs=null;
		//		 try {
		//			st=conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
		//					+ "FROM seller INNER JOIN department\r\n"
		//					+ "ON seller.DepartmentId=department.Id\r\n"
		//					+ "WHERE seller.Id=?");
		//			st.setInt(1, id);
		//			rs=st.executeQuery();
		//			if (rs.next()) {
		//				Department dep=new Department();
		//				dep.setId(rs.getInt("ID"));
		//				dep.setName(rs.getString("DepName"));
		//				Seller obj=new Seller();
		//				obj.setId(rs.getInt("Id"));
		//				obj.setName(rs.getString("Name"));
		//				obj.setEmail(rs.getString("Email"));
		//				obj.setBaseSalary(rs.getDouble("BaseSalary"));
		//				obj.setBirthDate(rs.getDate("BirthDate"));
		//				obj.setDepartment(dep);
		//				return obj;
		//				
		//			}
		//			return null;
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}
		//		 finally {
		//			 
		////			ResultSet.CLOSE_CURSORS_AT_COMMIT
		//}
		return null;
	}

	@Override
	//Relacionando vendedores a um unico departamento
	public List<Seller> findByDepartment(Department departament) {
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
					+ "FROM seller INNER JOIN department\r\n"
					+ "ON seller.DepartmentId=department.Id\r\n"
					+ "WHERE DepartmentId=?\r\n"
					+ "ORDER BY Name");
			st.setInt(1, departament.getId());
			rs=st.executeQuery();
			
			List<Seller> list=new ArrayList<>();
			//Relacionar a chave ao obj
			Map<Integer, Department> map =new HashMap<>();
			while (rs.next()) {
				
				Department dep= map.get(rs.getInt("DepartmentId"));
				if(dep==null) {
					dep= instateament(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj=instateamentSeller(rs,dep);
				list.add(obj);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

		}
		//return ;
		return null;
	}

}
