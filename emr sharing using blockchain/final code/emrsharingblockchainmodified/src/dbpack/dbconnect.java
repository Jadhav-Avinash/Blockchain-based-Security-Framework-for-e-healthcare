/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpack;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
public class dbconnect 
{
    public Connection connect()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+ips.mysqlip+":3306/emrsharing", "root","root");
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return con;
    }
}
