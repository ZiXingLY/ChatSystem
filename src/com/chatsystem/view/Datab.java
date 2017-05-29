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
    static // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
    // 避免中文乱码要指定useUnicode和characterEncoding
    // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
    // 下面语句之前就要先创建javademo数据库
    String url = "jdbc:mysql://bdm260213172.my3w.com:3306/bdm260213172_db?"
            + "user=bdm260213172&password=hang183367&useUnicode=true&characterEncoding=UTF8";
    static Statement stmt;
	//public static void main(String args[]) throws Exception {
      Datab() throws Exception{  
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();

            //System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            stmt = conn.createStatement();
           // sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
           // int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
           // if (result != -1) {
             //   System.out.println("创建数据表成功");
//                sql = "insert into jchatuser(userNO,userPass) values('zinian','183367')";
//               // result = stmt.executeUpdate(sql);
//                stmt.executeUpdate(sql);
//                sql = "insert into jchatuser(userNO,userPass) values('zinian1','183367')";
//              //  result = stmt.executeUpdate(sql);
//                stmt.executeUpdate(sql);
//                sql = "select * from jchatuser";
//                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
//                System.out.println("usr\tpass");
//                while (rs.next()) {
//                    System.out
//                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
//                }
//            	String ch="\'";
//                sql = "select * from jchatuser where userNo="+ch+"zinian"+ch;
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    System.out
//                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
//                }
          //  }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
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
