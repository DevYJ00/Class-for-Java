package com.newlecture.web.jdbc;
import java.util.Scanner;
import java.sql.*;

public class Homework {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("[게시글 검색 프로그램]]");
        Scanner scan = new Scanner(System.in);
        System.out.println("회원 이름 입력 : >");
        String memberName = scan.nextLine();

        System.out.printf("회원이름        이름           닉네임      \n");

        //1. JDBC Driver GET!
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //2. Connection!
        String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
        Connection conn = DriverManager.getConnection(url, "NEWLEC", "rland");

        //3. Statement 객체
        Statement st = conn.createStatement();

//        String sql = "SELECT * FROM MEMBER";
        //쿼리가 헷갈리면 쿼리를 별도로 빼서 이용 - String.format 이용
        String query = "a";
        
        String sql = "SELECT id, name, nicname FROM MEMBER WHERE id LIKE '%"+memberName+"%'";
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String nicname = rs.getString("nicname");
            System.out.printf("%-5d %-20s %-10s\n", id, name, nicname);
        }
        
        st.close();
        conn.close();
        
        // db 연결이 길어질수록 자원낭비가 발생하니 배열에 데이터를 담아놓고, 윗부분은 DB 
        // 하단 부분에서 출력을 처리하는게 좋다.
        


    }
}
