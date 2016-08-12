/*   1:    */ package kp;
/*   2:    */ 
/*   3:    */ import java.math.BigInteger;
/*   4:    */ import java.security.PrivateKey;
/*   5:    */ import java.security.interfaces.RSAPrivateCrtKey;
/*   6:    */ import java.security.interfaces.RSAPrivateKey;
/*   7:    */ 
 public class EnhanceRsaPrivateKey  extends RsaKey
   implements PrivateKey, RSAPrivateCrtKey
 {
  private static final long serialVersionUID = 2040896623722437691L;
   private final BigInteger p;
  private final BigInteger q;
   private final BigInteger e;
   private final BigInteger d;
   private final BigInteger dP;
  private final BigInteger dQ;
   private final BigInteger qInv;
  
  public EnhanceRsaPrivateKey(BigInteger p, BigInteger q, BigInteger e, BigInteger d)
   {
    super(p.multiply(q), e);
    
     this.p = p;
     this.q = q;
     this.d = d;
    this.e = e;
    

 
 

     this.dP = e.modInverse(p.subtract(BigInteger.ONE));
     this.dQ = e.modInverse(q.subtract(BigInteger.ONE));
     


     this.qInv = q.modInverse(p);
  }
   
  public static RsaPK valueOf(byte[] k)
   {
    if (k[0] == Registry.MAGIC_RAW_RSA_PRIVATE_KEY[0])
    {
                EnhanceRsaKeyPairRawCodec codec = new EnhanceRsaKeyPairRawCodec();
                    return (RsaPK)codec.decodePrivateKey(k);//decodePrivateKey(k);
               }
    throw new IllegalArgumentException("magic");
   }
   
   public BigInteger getPrimeP()
   {
     return this.p;
  }
  
  public BigInteger getPrimeQ()
 {
    return this.q;
  }
   
  public BigInteger getPrimeExponentP()
   {
     return this.dP;
   }
  
   public BigInteger getPrimeExponentQ()
  {
     return this.dQ;
  }
  
   public BigInteger getCrtCoefficient()
   {
    return this.qInv;
  }
   
  public BigInteger getPrivateExponent()
   {
     return this.d;
   }
   
  public BigInteger getPublicExponent()
   {
     return this.e;
   }
   
 public byte[] getEncoded(int format)
  {
    byte[] result;
    switch (format)
    {
     case 1: 
      result = new EnhanceRsaKeyPairRawCodec().encodePrivateKey(this);
      break;
   default: 
      throw new IllegalArgumentException("format");
    }
   //  byte[] result;
    return result;
  }
  
  public boolean equals(Object obj)
   {
  if (obj == null) {
       return false;
     }
     if ((obj instanceof RSAPrivateKey))
     {
       RSAPrivateKey that = (RSAPrivateKey)obj;
       return (super.equals(that)) && (this.d.equals(that.getPrivateExponent()));
     }
     if ((obj instanceof RSAPrivateCrtKey))
     {
       RSAPrivateCrtKey that = (RSAPrivateCrtKey)obj;
       
 
 


       return (super.equals(that)) && (this.p.equals(that.getPrimeP())) && (this.q.equals(that.getPrimeQ())) && (this.dP.equals(that.getPrimeExponentP())) && (this.dQ.equals(that.getPrimeExponentQ())) && (this.qInv.equals(that.getCrtCoefficient()));
    }
    return false;
   }
}
