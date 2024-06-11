/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import dbpack.ips;

/**
 *
 * @author Lenovo
 */
public class sendblock 
{
    String addblock(int aid,String problem,String test,String treport,String report)
    {
        String reply="FAILED";
       try
       {
           Socket soc=new Socket(ips.blockchainip,ips.blockchainport);
           ObjectOutputStream oos=new ObjectOutputStream(soc.getOutputStream());
           ObjectInputStream oin=new ObjectInputStream(soc.getInputStream());
           
           oos.writeObject("ADDBLOCK");
           oos.writeObject(aid);
           oos.writeObject(problem);
           oos.writeObject(test);
           oos.writeObject(treport);
           oos.writeObject(report);
           
           reply=(String)oin.readObject();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       
       return reply;
    }
    
}
