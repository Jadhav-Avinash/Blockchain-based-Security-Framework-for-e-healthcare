/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainServer;

import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Lenovo
 */
public class readblockreq extends Thread
{
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static String previousHash="0";
    
    readblockreq()
    {
        super();
        start();
    }
    
    public void run()
    {
        try
        {
            ServerSocket ss=new ServerSocket(3000);
            
            while (true)
            {
                Socket soc=ss.accept();
                ObjectOutputStream oos=new ObjectOutputStream(soc.getOutputStream());
                ObjectInputStream oin=new ObjectInputStream(soc.getInputStream());
                
                String req=(String)oin.readObject();
                
                if (req.equals("ADDBLOCK"))
                {
                   int aid=(Integer)oin.readObject();
                   String problem=(String)oin.readObject();
                   String test=(String)oin.readObject();
                   String treport=(String)oin.readObject();
                   String report=(String)oin.readObject();
                   
                   String match="NONE";
                   
                   
                  // String opr=pid+"-->"+opr2+"-->"+opr3;
                   
                   blockcserver.jTextArea1.append("Doctor report recived for Appointment "+aid+"\n");
                   
                   Block b=new Block(aid,problem,test,treport,report,previousHash);
                   blockchain.add(b);
                   blockcserver.jTextArea1.append("Block Successfully added!\n");
                   blockchain.get(blockchain.size()-1).mineBlock(difficulty);
                   
                   oos.writeObject("SUCCESS");
                }
                else
                if (req.equals("GETTESTREPORT"))
                {
                    int aid=(Integer)oin.readObject();
                    
                    blockcserver.jTextArea1.append("Searching details for Appointment "+aid+"!\n");
                    boolean found=false;
                    for (int i=0;i<blockchain.size();i++)
                    {
                        Block b=blockchain.get(i);
                
                        if (b.aid==aid)
                        {
                            oos.writeObject("FOUND");
                            oos.writeObject(b.test);
                            oos.writeObject(b.treport);
                            oos.writeObject(b.report);
                            found=true;
                            break;
                    
                        }
                    }
                    if (!found)
                    oos.writeObject("NOTFOUND");
                }
                else
                if (req.equals("GETMYREPORT"))
                {
                    int aid=(Integer)oin.readObject();
                    
                    blockcserver.jTextArea1.append("Searching details for Appointment "+aid+"!\n");
                    boolean found=false;
                    for (int i=0;i<blockchain.size();i++)
                    {
                        Block b=blockchain.get(i);
                
                        if (b.aid==aid)
                        {
                            oos.writeObject("FOUND");
                            oos.writeObject(b.problem);
                            oos.writeObject(b.test);
                            oos.writeObject(b.treport);
                            oos.writeObject(b.report);
                            found=true;
                            break;
                    
                        }
                    }
                    if (!found)
                    oos.writeObject("NOTFOUND");
                }
                else
                if (req.equals("GETTEST"))
                {
                    int aid=(Integer)oin.readObject();
                    
                    blockcserver.jTextArea1.append("Searching details for Appointment "+aid+"!\n");
                    boolean found=false;
                    for (int i=0;i<blockchain.size();i++)
                    {
                        Block b=blockchain.get(i);
                
                        if (b.aid==aid)
                        {
                            oos.writeObject("FOUND");
                            
                            oos.writeObject(b.test);
                            oos.writeObject(b.treport);
                            
                            blockcserver.jTextArea1.append("Test details sent to lab !\n");
                           
                            found=true;
                            break;
                    
                        }
                    }
                    if (!found)
                    oos.writeObject("NOTFOUND");
                }
                else
                if (req.equals("UPDATETESTREPORT"))
                {
                    int aid=(Integer)oin.readObject();
                    String treport=(String)oin.readObject();
                    blockcserver.jTextArea1.append("updating test report "+aid+" !\n");
                    String reply=updatetestreport(aid,treport);
                    oos.writeObject(reply);
                }
                else
                if (req.equals("UPDATEDOCTORREPORT"))
                {
                    int aid=(Integer)oin.readObject();
                    String report=(String)oin.readObject();
                    blockcserver.jTextArea1.append("updating Doctor report for "+aid+" !\n");
                    String reply=updatedoctorreport(aid,report);
                    oos.writeObject(reply);
                }
                /*
                else
                if (req.equals("GETUSERS"))
                {
                    
                    Vector v=getusers();
                    oos.writeObject(v);
                }
                else
                if (req.equals("GETHISTORY"))
                {
                    
                    Vector v=gethistory();
                    oos.writeObject(v);
                }
                else
                if (req.equals("FINDMATCH"))
                {
                    String organ=(String)oin.readObject();
                    blockcserver.jTextArea1.append("FINDMATCH request for organ "+organ+"!\n");
                    Vector v=findmatch(organ);
                    oos.writeObject(v);
                }
                else
                if (req.equals("UPDATEMATCH"))
                {
                    String donor=(String)oin.readObject();
                    String recipient=(String)oin.readObject();
                    blockcserver.jTextArea1.append("updating match for donor "+donor+" and recipient "+recipient+"!\n");
                    String reply=updatematch(donor,recipient);
                    oos.writeObject(reply);
                }
                else
                if (req.equals("GETMYDATA"))
                {
                    String uname=(String)oin.readObject();
                    
                    blockcserver.jTextArea1.append("Searching details for user "+uname+"!\n");
                    boolean found=false;
                    for (int i=0;i<blockchain.size();i++)
                    {
                        Block b=blockchain.get(i);
                
                        if (b.uname.equals(uname))
                        {
                            oos.writeObject("FOUND");
                            oos.writeObject(b.organ);
                            oos.writeObject(b.match);
                            found=true;
                            break;
                    
                        }
                    }
                    if (!found)
                    oos.writeObject("NOTFOUND");
                }*/
                
                oos.close();
                oin.close();
                soc.close();
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }    
    
    
    
    String updatetestreport(int aid,String treport)
    {
        
        
        String reply="SUCCESS";
        
                
        try
        {
            for (int i=0;i<blockchain.size();i++)
            {
                Block b=blockchain.get(i);
                
                if (b.aid== aid)
                {
                    b.treport=treport;
                  
                    blockchain.set(i, b);
                    break;
                }
                
                
                
            }
            
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return reply;
    }
    
    String updatedoctorreport(int aid,String report)
    {
        
        
        String reply="SUCCESS";
        
                
        try
        {
            for (int i=0;i<blockchain.size();i++)
            {
                Block b=blockchain.get(i);
                
                if (b.aid== aid)
                {
                    b.report=report;
                  
                    blockchain.set(i, b);
                    break;
                }
                
                
                
            }
            
           
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return reply;
    }
    
    
    void writelogs()
    {
        try
        {
            if (blockchain.size()>0)
            {
                JSONArray blockList = new JSONArray();
                
                for (int i=0;i<blockchain.size();i++)
                {
                    Block b=(Block)blockchain.get(i);
                    JSONObject blockdetails = new JSONObject();
                    blockdetails.put("aid", b.aid);
                    blockdetails.put("problem", b.problem);
                    blockdetails.put("test", b.test);
                    blockdetails.put("treport", b.treport);
                    blockdetails.put("report", b.report);
                    blockdetails.put("previoushash", b.previousHash);
                    blockdetails.put("timestamp", b.timeStamp);
                    blockdetails.put("hash", b.hash);
                    
                    JSONObject blockObject = new JSONObject(); 
                    blockObject.put("block", blockdetails);
                    
                    blockList.add(blockObject);
                }
                
                FileWriter file = new FileWriter("userlogs.json");
                 file.write(blockList.toJSONString()); 
                 file.flush();
                 file.close();
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
        
}
