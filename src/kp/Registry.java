 package kp;
 
 public abstract interface Registry
 {
   public static final String RSA_KPG = "rsa";
   public static final String RAW_ENCODING = "gnu.crypto.raw.format";
   public static final int RAW_ENCODING_ID = 1;
   public static final byte[] MAGIC_RAW_RSA_PUBLIC_KEY = { 71, 1, 82, 80 };
   public static final byte[] MAGIC_RAW_RSA_PRIVATE_KEY = { 71, 1, 82, 112 };
   public static final byte[] MAGIC_RAW_RSA_PSS_SIGNATURE = { 71, 1, 82, 83 };
}

