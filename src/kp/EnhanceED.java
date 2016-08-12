 package kp;
 
 public class EnhanceED
 {
   public byte[] encPublicKey(RsaP publicKey)
   {
     byte[] enc = publicKey.getEncoded(1);
     return enc;
  }
   
   public byte[] encPrivateKey(RsaPK privateKey)
   {
     byte[] enc = privateKey.getEncoded(1);
     return enc;
   }
   
  public RsaP decPublicKey(byte[] enc)
   {
     RsaP pubK = RsaP.valueOf(enc);
     return pubK;
   }
   
   public RsaPK decPrivateKey(byte[] enc)
   {
     RsaPK privK = RsaPK.valueOf(enc);
     return privK;
   }
 }


