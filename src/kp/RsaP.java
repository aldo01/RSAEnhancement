 package kp;
 import java.math.BigInteger;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

public class RsaP extends RsaKey implements PublicKey, RSAPublicKey
 {
  private static final long serialVersionUID = -2504810529753771180L;
   
   public RsaP(BigInteger n, BigInteger e)
   {
     super(n, e);
   }
  
   public static RsaP valueOf(byte[] k)
   {
   if (k[0] == Registry.MAGIC_RAW_RSA_PUBLIC_KEY[0])
    {
      IKeyPairCodec codec = new EnhanceRsaKeyPairRawCodec();
      return (RsaP)codec.decodePublicKey(k);
     }
     throw new IllegalArgumentException("magic");
   }
   
   public byte[] getEncoded(int format)
   {
     byte[] result;
     switch (format)
     {
    case 1: 
       result = new EnhanceRsaKeyPairRawCodec().encodePublicKey(this);
       break;
     default: 
       throw new IllegalArgumentException("format");
     }
     //byte[] result;
     return result;
   }
   
   public boolean equals(Object obj)
   {
     if (obj == null) {
       return false;
     }
     if (!(obj instanceof RSAPublicKey)) {
      return false;
     }
     RSAPublicKey that = (RSAPublicKey)obj;
     
 
     return (super.equals(that)) && (getPublicExponent().equals(that.getPublicExponent()));
   }
 }

