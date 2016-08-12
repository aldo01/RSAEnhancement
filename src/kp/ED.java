 package kp;

 import java.math.BigInteger;
 
 public class ED
 {
   public BigInteger encrypt(int encoded, BigInteger e, BigInteger n)
  {
     BigInteger bIntMsg = new BigInteger(Integer.toString(encoded));
     BigInteger c = bIntMsg.modPow(e, n);
     return c;
   }
   
   public BigInteger decrypt(BigInteger encrypted, BigInteger d, BigInteger n)
   {
     BigInteger m = encrypted.modPow(d, n);
     return m;
   }
   
   public int decryptToInt(BigInteger encrypted, BigInteger d, BigInteger n)
   {
     BigInteger m = encrypted.modPow(d, n);
     return m.intValue();
   }
 }

