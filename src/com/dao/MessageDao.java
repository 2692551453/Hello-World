package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DB.DBAccess;
import com.bean.Message;

public class MessageDao {
	public List<Message> queryMessageList(String command,String description ) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messagelist = new ArrayList<Message>(); 
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCOMMAND(command);
			message.setDESCRIPTION(description);
			//调用Message.xml中的queryMessageList
			messagelist = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
			    sqlSession.close();
			}
		}
		return messagelist;
	}
	
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
			    sqlSession.close();
			}
		}
	}
	
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
			    sqlSession.close();
			}
		}
	}
	
//   public List<Message> queryMessageList(String command,String description ) {
//	   List<Message> messagelist = new ArrayList<Message>(); 
//	   try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf8", "root", "");
//			StringBuilder sql = new StringBuilder("SELECT ID, COMMAND, DESCRIPTION, CONTENT FROM message WHERE 1=1");
//			List<String> paramlist = new ArrayList<String>();
//			if (command != null && !"".equals(command.trim())) {
//				sql.append(" and COMMAND = ? ");
//				paramlist.add(command);
//			}
//			if (description != null && !"".equals(description.trim())) {
//				sql.append(" and DESCRIPTION like '%' ? '%' ");
//				paramlist.add(description);
//			}
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			for (int i = 0; i < paramlist.size(); i++) {
//				statement.setString(i + 1, paramlist.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				Message message = new Message();
//				messagelist.add(message);
//				message.setID(rs.getInt("ID"));
//				message.setCOMMAND(rs.getString("COMMAND"));
//				message.setCONTENT(rs.getString("CONTENT"));
//				message.setDESCRIPTION(rs.getString("DESCRIPTION"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messagelist;
//   }
}
