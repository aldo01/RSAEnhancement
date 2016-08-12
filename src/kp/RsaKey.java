 package kp;

 import java.math.BigInteger;
 import java.security.Key;
 import java.security.interfaces.RSAKey;

 public abstract class RsaKey
   implements Key, RSAKey
 {
   private static final long serialVersionUID = -3818079750139280582L;
   private final BigInteger n;
   private final BigInteger e;
   
   protected RsaKey(BigInteger n, BigInteger e)
   {
     this.n = n;
     this.e = e;
   }
  
  public BigInteger getModulus()
   {
    return getN();
  }
 
   public String getAlgorithm()
  {
     return "rsa";
   }
 
   public byte[] getEncoded()
  {
     return getEncoded(1);
   }
 
   public String getFormat()
   {
     return null;
  }
 
  public BigInteger getN()
   {
     return this.n;
  }
  
   public BigInteger getPublicExponent()
   {
     return getE();
   }
   
   public BigInteger getE()
   {
     return this.e;
   }
   
  public boolean equals(Object obj)
   {
     if (obj == null) {
      return false;
     }
     if (!(obj instanceof RSAKey)) {
      return false;
     }
     RSAKey that = (RSAKey)obj;
     return this.n.equals(that.getModulus());
   }
   
   public abstract byte[] getEncoded(int paramInt);
 }

