/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class readJSON {

public readJSON()
{
    //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("userlogs.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray blockList = (JSONArray) obj;
            System.out.println(blockList);
             
            //Iterate over block chain array
            blockList.forEach( blockobject -> parseLogObject( (JSONObject) blockobject ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
}
        
        

   
 
    private static void parseLogObject(JSONObject blockobject) 
    {
        //Get employee object within list
        JSONObject blockdetails = (JSONObject) blockobject.get("block");
         
        //Get user name
        int aid = Integer.parseInt(blockdetails.get("aid").toString());    
        System.out.println(aid);
         
                
        String problem = (String) blockdetails.get("problem");  
        System.out.println(problem);
        
        String test = (String) blockdetails.get("test");  
        System.out.println(test);
        
        String treport = (String) blockdetails.get("treport");  
        System.out.println(treport);
        
        String report = (String) blockdetails.get("report");  
        System.out.println(report);
        
        String prev = (String) blockdetails.get("previoushash");  
        System.out.println(prev);
        
        long time = (long) blockdetails.get("timestamp");  
        System.out.println(time);
        
        String hash = (String) blockdetails.get("hash");  
        System.out.println(hash);
        
        Block b=new Block();
        b.aid=aid;
        b.problem=problem;
        b.test=test;
        b.treport=treport;
        b.report=report;
        b.timeStamp=time;
        b.previousHash=prev;
        b.hash=hash;
        
        readblockreq.blockchain.add(b);
         
        
    }
}
