package com.thzhima.advance.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleCallableStatement;

public class StudentDao2 {

	public static Map<String, Object> login(String name, String pwd) throws SQLException {
		Map<String, Object> map = null;
		
		String sql = "select * from student where student_name=? and pwd=?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql); // ����������ݿ����Ԥ���롣
			stm.setString(1, name);
			stm.setString(2, pwd);
			
			rst = stm.executeQuery();
			
			if(rst.next()) {
				map = new HashMap<>();
				map.put("studentID", rst.getInt("student_id"));
				map.put("studentName", rst.getString("student_name"));
				map.put("gender", rst.getString("gender"));
				map.put("birthDate", rst.getDate("birth_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return map;
	}
	
	public static boolean update(int id, String name, String gender, Date birthDate) throws SQLException {
		boolean ok = false;
		String sql = "update student set student_name=?, gender=?, birth_date=? where student_id=?";
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, gender);
			stm.setDate(3, birthDate);
			stm.setInt(4, id);
			
			int count = stm.executeUpdate();
			ok = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return ok;
	}
	
	public static void addStudent(String name, String gender, Date birthDate) throws SQLException {
		Connection conn = null;
		CallableStatement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false); // ����������� 
			
			stm = conn.prepareCall("{call p_add_student(?,?,?)}");
			stm.setString("name", name);
			stm.setString("gender", gender);
			stm.setDate("birth_date", birthDate);
			
			System.out.println(stm.execute());
			conn.commit();  // �ύ����
		} catch (SQLException e) {
			conn.rollback(); // �ع�����
			e.printStackTrace();
		} finally {

			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
	
	}
	
	public static String findNameByID(int id) throws SQLException {
		String name = null;
		
		Connection conn = null;
		CallableStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareCall("{call p_find_by_id(?,?)}");
			stm.setInt(1, id); // Ϊ���������ֵ
			stm.registerOutParameter(2, Types.NVARCHAR); // Ҫע���������
			boolean b = stm.execute();
			System.out.println(b);
			
			name = stm.getString(2);  // ȡ�������ֵ
			
			conn.commit();
		} catch (SQLException e) {
			if(null != conn) {
				conn.rollback();
			}
			
			e.printStackTrace();
		} finally {

			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return name;
	}
	
	public static List<Map<String, Object>> list(int page, int len) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<>();
		
		Connection conn = null;
		CallableStatement stm= null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareCall("{call p_list_student(?,?,?)}");
			
			stm.setInt(1, page);
			stm.setInt(2, len);
			stm.registerOutParameter(3, Types.REF_CURSOR);
			
			boolean s = stm.execute();
			System.out.println(s);
			
			rst = ((OracleCallableStatement)stm).getCursor(3);
			
			ResultSetMetaData md = rst.getMetaData(); // ��ȡ�����Ԫ���ݶ���
			int count = md.getColumnCount(); // ���������������
			
			while(rst.next()) {
				Map<String, Object> map = new HashMap<>();
				for(int i=1; i<=count; i++) {
					String name = md.getColumnName(i); // ��ȡ�е�����
					Object o =  rst.getObject(i);
					map.put(name, o);
				}
				list.add(map);
			}
			
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(login("xxx' or 1=1 --", "123456"));
		
//		StudentDao2.update(3, "�¹�", "Ů", new Date(90, 0, 1));
//		StudentDao2.addStudent("���군", "��", new Date(76, 11, 30));
		
//		System.out.println(StudentDao2.findNameByID(1));
		
		System.out.println(StudentDao2.list(2, 2));
	}
}
