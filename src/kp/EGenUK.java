 package kp;
 
 import java.math.BigInteger;
 import javax.swing.JFrame;
 import javax.swing.JOptionPane;
 
 public class EGenUK
 {
   private RsaP publicKey;
   private RsaPK privateKey;
  
  public boolean testInputEligibility(BigInteger p, BigInteger q, BigInteger e)
  {
     TestPrimality primeTester = new TestPrimality();
     if (!primeTester.isPrime(p)) {
       return false;
    }
   if (!primeTester.isPrime(q)) {
       return false;
     }
     if (p.equals(q)) {
       return false;
    }
     if (e.intValue() <= 1) {
     return false;
     }
     BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
     if (phi.gcd(e).intValue() != 1) {
       return false;
     }
     return true;
   }
  
   public void showInputError(JFrame frame, BigInteger p, BigInteger q, BigInteger e)
 {
     TestPrimality primeTester = new TestPrimality();
     BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
     if (!primeTester.isPrime(p)) {
       JOptionPane.showMessageDialog(frame, 
         "P is not a prime.", "Input error", 
        0);
     } else if (!primeTester.isPrime(q)) {
     JOptionPane.showMessageDialog(frame, 
        "Q is not a prime.", "Input error", 
         0);
     } else if (p.equals(q)) {
      JOptionPane.showMessageDialog(frame, 
         "P and Q should not be equal.", "Input error", 
         0);
     } else if (e.intValue() <= 1) {
       JOptionPane.showMessageDialog(frame, 
         "E must be greater than 1.", "Input error", 
         0);
     } else if (phi.gcd(e).intValue() != 1) {
      JOptionPane.showMessageDialog(frame, 
         "E not suitable. gcd(e, (p-1)(q-1)) must equal one .", "Input error", 
         0);
     }
   }
   
   public void createKeys(BigInteger p, BigInteger q, BigInteger e)
   {
     BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
     
 
     BigInteger d = e.modInverse(phi);
     
 
     BigInteger n = p.multiply(q);
     
 
     this.publicKey = new RsaP(n, e);
     this.privateKey = new RsaPK(p, q, e, d);
   }
   
  public RsaP getPublicKey()
   {
     return this.publicKey;
   }
   
   public RsaPK getPrivateKey()
   {
     return this.privateKey;
   }
 }

