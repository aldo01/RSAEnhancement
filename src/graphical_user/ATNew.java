/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphical_user;
import kp.OS;
import kp.Registry;
import kp.RsaPK;
import kp.RsaP;
import logics.ClipboardCopyPaste;
import java.io.*;
import java.security.*;
import java.util.Random;
import javax.crypto.Cipher;
import pSchemes.BlocksOf3Padding;
import pSchemes.PaddingType1;
import pSchemes.PaddingType2;
/**
 *
 * @author waayoo
 */
public class ATNew {
    
    public double n1=1000;
    public double n2=Math.pow(10, 8);
    public double n3=Math.pow(10, 300);
    
    
    public double p11=.1;
    public double p12=.8;
    public double p13=1.0;
    
    public double p21=.934;
    public double p22=.743;
    public double p23=.003;
    
     private RsaP publicKey;
     private RsaPK privateKey;
      private OS openSave;
     private PaddingType1 padding1;
  private PaddingType2 padding2;
 private BlocksOf3Padding padding3;
 private ClipboardCopyPaste clipboard;
  
    
    public double K1=.0345;
    public double K2=568454.0;
    
      
   public byte[] encodePublicKey(PublicKey key)
   {
     if (!(key instanceof RsaP)) {
     throw new IllegalArgumentException("key");
    }
     RsaP rsaKey = (RsaP)key;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
   
 
    baos.write(Registry.MAGIC_RAW_RSA_PUBLIC_KEY[0]);
    baos.write(Registry.MAGIC_RAW_RSA_PUBLIC_KEY[1]);
     baos.write(Registry.MAGIC_RAW_RSA_PUBLIC_KEY[2]);
     baos.write(Registry.MAGIC_RAW_RSA_PUBLIC_KEY[3]);
     
 
     baos.write(1);
     
 
    byte[] buffer = rsaKey.getModulus().toByteArray();
     int length = buffer.length;
    baos.write(length >>> 24);
   baos.write(length >>> 16 & 0xFF);
     baos.write(length >>> 8 & 0xFF);
     baos.write(length & 0xFF);
     baos.write(buffer, 0, length);
    

     buffer = rsaKey.getPublicExponent().toByteArray();
     length = buffer.length;
    baos.write(length >>> 24);
    baos.write(length >>> 16 & 0xFF);
     baos.write(length >>> 8 & 0xFF);
    baos.write(length & 0xFF);
     baos.write(buffer, 0, length);
     
     return baos.toByteArray();
  }
   private static void showRandomInteger(int aStart, int aEnd, Random aRandom){
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to long to avoid overflow problems
    long range = (long)aEnd - (long)aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    int randomNumber =  (int)(fraction + aStart);    
  //  log("Generated : " + randomNumber);
  }
    
    public void analyze(){
     String p = "abc";
   // Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding", "BC");
    SecureRandom random = new SecureRandom();
    //KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");

  //  generator.initialize(386, random);
 StringBuilder b = new StringBuilder();
 int format=5;
 String a = p;
    for (int i = 1; i < 5; i++) {
      // b.append((String)map.get(a[i]));
     }
    //KeyPair pair = generator.generateKeyPair();
  //  Key pubKey = pair.getPublic();

  //  Key privKey = pair.getPrivate();

    //cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
   // byte[] cipherText = cipher.doFinal(input);
  //  System.out.println("cipher: " + new String(cipherText));

    //cipher.init(Cipher.DECRYPT_MODE, privKey);
    //byte[] plainText = cipher.doFinal(cipherText);
   // System.out.println("plain : " + new String(plainText));
    n1=1000;
    n2=Math.pow(10, 8);
    n3=Math.pow(10, 300);
       
       byte[] result;
     switch (format)
     {
     case 1: 
      format=2;
     break;
     default: 
         format=2;
     // throw new IllegalArgumentException("format");
     }
     
    p11=.1;
    p12=.8;
    p13=1.0;
      int START = 1;
    int END = 10;
   // Random random = new Random();
    for (int idx = 1; idx <= 10; ++idx){
      showRandomInteger(START, END, random);
    }
    p21=.934;
    p22=.743;
    p23=.003;
    
    }
    
    
    public void saveInDock(){
    //open file write data in dock 
    
        
        
        try {
 
			String content = "n\t\tp1\t\tp2\n"+n1+"\t\t"+p11+"\t\t"+p21+"\n"+n2+"\t\t"+p12+"\t\t"+p22+"\n"+n3+"\t\t"+p13+"\t\t"+p23+"\n";
                        
 
			File file = new File("filename.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
    
    
    
    
    public static void main(String[] args) {
	ATNew a=new ATNew();
        a.analyze();
        a.saveInDock();
        
	}
}
    
    
    
