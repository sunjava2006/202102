package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// �������ݿ�Ķ��󣬳�Ϊ��DAO���ݿ���ʶ���
public class StudentDAO {

	private static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	
	private static String format(Date d) {
		return formater.format(d);
	}
	
	public static boolean addStudent(String name, String gender, Date birthDate) throws SQLException {
		boolean ok = false;
		int count = -1;
		// ���ݿ����Ӷ���
		Connection conn = null;
		Statement stm = null;

		try {
			// 2�����ӵ����ݿ�
			conn = ConnectionUtil.getConnection();

			// 3������������ִ����䡣
			stm = conn.createStatement();
			String birthday = format(birthDate);
			String sql = "insert into student(student_id, student_name, gender, birth_date)"
					+ "values(seq.nextval, '"+ name +"','"+ gender +"', "
					+ "to_date('"+birthday+"','yyyy-mm-dd') )";
			count = stm.executeUpdate(sql); // executeUpdate��������ִ�и�����Ӱ���������

			// 4�������ؽ��
			ok = count == 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�������
			if (null != stm) {
				stm.close();
			}
			// 5���ر�����
			if (null != conn) {
				conn.close();
			}
		}
		return ok;
	}

	public static boolean deleteByID(int id) throws SQLException {
		boolean ok = false;
		
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			int count = stm.executeUpdate("delete from student where student_id="+id);
			ok = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return ok;
	}
	
	
	
	
	public static Map<String, Object> selectByID(int id) throws SQLException{
		Map<String, Object> map = new HashMap<>();
		String sql = "select "
				   + " student_id, student_name, birth_date, gender"
				   + " from student "
				   + " where student_id=" + id;
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null; //��ʾ��ѯ�Ľ��������ָ�����ݿ��ѯ������αꡣ
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			
			if(rst.next()) {
				Integer studentid = rst.getInt(1);
				map.put("studentID", studentid);
				
				String student_name = rst.getString("student_name");
				map.put("studentName", student_name);
				
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
	
	
	public static List<Map<String, Object>> selectByName(String name) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "select "
				   + " student_id, student_name, birth_date, gender"
				   + " from student "
				   + " where student_name='" + name+"'";
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null; //��ʾ��ѯ�Ľ��������ָ�����ݿ��ѯ������αꡣ
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			
			while(rst.next()) {
				Map<String, Object> map = new HashMap<>();
				Integer studentid = rst.getInt(1);
				map.put("studentID", studentid);
				
				String student_name = rst.getString("student_name");
				map.put("studentName", student_name);
				
				map.put("gender", rst.getString("gender"));
				map.put("birthDate", rst.getDate("birth_date"));
				
				list.add(map);
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
		
		return list;
	}
	
	
	public static Map<String, Object> login(String name, String pwd) throws SQLException{
		Map<String, Object> map = new HashMap<>();
		
		// ���ע��
		String sql = "select "
				   + " student_id, student_name, birth_date, gender"
				   + " from student "
				   + " where student_name='" + name+"' and pwd='"+pwd+"'";
		
		System.out.println(sql);
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null; //��ʾ��ѯ�Ľ��������ָ�����ݿ��ѯ������αꡣ
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			
			if(rst.next()) {
				
				Integer studentid = rst.getInt(1);
				map.put("studentID", studentid);
				
				String student_name = rst.getString("student_name");
				map.put("studentName", student_name);
				
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
		
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(addStudent("Ǯ��", "��", new Date()));
		
//		System.out.println(deleteByID(37));
		
//		System.out.println(selectByID(3));
		
//		System.out.println(selectByName("xx'  or 1=1 --"));
		
		System.out.println(login("dfd' or 3=3 --", "refee"));
	}

}
