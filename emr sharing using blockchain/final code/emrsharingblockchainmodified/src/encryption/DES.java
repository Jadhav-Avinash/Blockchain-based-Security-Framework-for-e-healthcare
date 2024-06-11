package encryption;

import lab.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.security.*;

public class DES
{
	public DES()
	{
		
	}
	
	public String encrypt(String msg,String key)
	{
		
		try
		{
			
			
			if (key.length()==8)
			{
			
				Cipher cipher= Cipher.getInstance("DES");
				SecretKeySpec spec= new SecretKeySpec(key.getBytes(), "DES");
				cipher.init(Cipher.ENCRYPT_MODE, spec);
				byte messageArray[]=msg.getBytes("UTF8");
				messageArray= cipher.doFinal(messageArray,0,messageArray.length);
				msg=new BASE64Encoder().encode(messageArray);
				
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return msg;
	}
	
	public String decrypt(String msg,String key)
	{
			
		
		
		try
		{
			
			Cipher cipher= Cipher.getInstance("DES");
			SecretKeySpec spec= new SecretKeySpec(key.getBytes(), "DES");
			cipher.init(Cipher.DECRYPT_MODE, spec);
			byte messageArray[]=new BASE64Decoder().decodeBuffer(msg);
			messageArray= cipher.doFinal(messageArray);
			msg="";
			for (int i=0;i<messageArray.length;i++)
			msg+=(char) messageArray[i];
			msg.trim();
			
		
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		return msg;
	}
	
	
        public static void main(String args[])
        {
            String msg="whats up";
            String cipher=new DES().encrypt(msg, "12345678");
            System.out.println(cipher);
            System.out.println(new DES().decrypt(cipher, "12345678"));
        }
            
}