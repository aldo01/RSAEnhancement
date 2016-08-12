package kp;

import java.security.PrivateKey;
import java.security.PublicKey;

public abstract interface IKeyPairCodec
{
  public static final int RAW_FORMAT = 1;
  
  public abstract int getFormatID();
  
  public abstract byte[] encodePublicKey(PublicKey paramPublicKey);
  
  public abstract byte[] encodePrivateKey(PrivateKey paramPrivateKey);
  
  public abstract PublicKey decodePublicKey(byte[] paramArrayOfByte);
  
  public abstract PrivateKey decodePrivateKey(byte[] paramArrayOfByte);
}

