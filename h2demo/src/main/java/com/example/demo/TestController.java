package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * Created by wendepeng on 2017/8/3.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class not found "+ e);
        }
        System.out.println("JDBC Class found");
        int no_of_rows = 0;
        try {
            Connection con = DriverManager.getConnection
                    ("jdbc:h2:mem:test","root",
                            "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM  dbtbl_0.t_order_0");
            while (rs.next()) {
                no_of_rows++;
            }
            System.out.println("There are "+ no_of_rows
                    + " record in the table");
        }
        catch(SQLException e){
            System.out.println("SQL exception occured" + e);
        }

        return "hello world";
    }
}
