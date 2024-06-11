package blockchainServer;

import blockchainServer.blockcserver;
import blockchainServer.readblockreq;
import java.util.Date;

public class Block {

	public String hash;
	 String previousHash; 
         int aid;
	 String problem; //our data will be a simple message.
         String test;
         String treport;
         String report;
	 long timeStamp; //as number of milliseconds since 1/1/1970.
	 int nonce;

         
         public Block()
         {
             
         }
         
	//Block Constructor.
	public Block(int aid,String problem,String test,String treport,String report,String previousHash ) {
                this.aid=aid;
		this.problem = problem;
		this.test = test;
                this.treport=treport;
                this.report=report;
		this.timeStamp = new Date().getTime();
                this.hash = calculateHash(); //Making sure we do this after we set the other values.
	
	}
        
        //Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				aid + problem + test 
				);
		return calculatedhash;
	}
        
        
        public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		blockcserver.jTextArea1.append("Block Mined!!! : " + hash+"\n");
                readblockreq.previousHash=hash;
	}
}