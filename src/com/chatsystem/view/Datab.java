package com.chatsystem.view;
//import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement; 
public class Datab {
	
	static Connection conn = null;
    static String sql;
    static // MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
    // ������������Ҫָ��useUnicode��characterEncoding
    // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
    // �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
    String url = "jdbc:mysql://bdm260213172.my3w.com:3306/bdm260213172_db?"
            + "user=bdm260213172&password=hang183367&useUnicode=true&characterEncoding=UTF8";
    static Statement stmt;
	//public static void main(String args[]) throws Exception {
      Datab() throws Exception{  
        try {
            // ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
            // ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
            Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or��
            // new com.mysql.jdbc.Driver();

            //System.out.println("�ɹ�����MySQL��������");
            // һ��Connection����һ�����ݿ�����
            conn = DriverManager.getConnection(url);
            // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
            stmt = conn.createStatement();
           // sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
           // int result = stmt.executeUpdate(sql);// executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
           // if (result != -1) {
             //   System.out.println("�������ݱ�ɹ�");
//                sql = "insert into jchatuser(userNO,userPass) values('zinian','183367')";
//               // result = stmt.executeUpdate(sql);
//                stmt.executeUpdate(sql);
//                sql = "insert into jchatuser(userNO,userPass) values('zinian1','183367')";
//              //  result = stmt.executeUpdate(sql);
//                stmt.executeUpdate(sql);
//                sql = "select * from jchatuser";
//                ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
//                System.out.println("usr\tpass");
//                while (rs.next()) {
//                    System.out
//                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
//                }
//            	String ch="\'";
//                sql = "select * from jchatuser where userNo="+ch+"zinian"+ch;
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    System.out
//                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
//                }
          //  }
        } catch (SQLException e) {
            System.out.println("MySQL��������");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } //finally {
          //  conn.close();
       // }
        

    }
	boolean Logindb(String name,String pass) throws SQLException{
		String ch="\'";
		sql = "select userPass from jchatuser where userNo="+ch+name+ch;
		boolean flag=false;
		try {
			ResultSet rs = this.stmt.executeQuery(sql);
			if(!rs.wasNull()&&rs.next()&&rs.getString(1).equals(pass))
			//if(rs.next())	
			{
					flag=true;
				//System.out.println(rs.getString(1));
				}
			else
				{
				//System.out.println(rs.getString(1));
				//System.out.println(pass);
					flag=false;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	            conn.close();
		}
		return flag;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
