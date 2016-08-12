 package kp;
 
 import java.math.BigInteger;
 
 public class EnhanceGenerateKeys
 {
   private BigInteger p;
   private BigInteger q;
   private BigInteger n;
   private BigInteger phi;
   private BigInteger e;
  private BigInteger d;
   private int bitsize;
   private RsaP publicKey;
  private RsaPK privateKey;
  
  public EnhanceGenerateKeys(int bitsize)
   {
     this.bitsize = bitsize;
     createKeys();
   }
   
 private void createKeys()
   {
     MillerRabinPrimalityTest primeTest = new MillerRabinPrimalityTest();
     do
     {
     this.p = primeTest.genPrime(this.bitsize);
       this.q = primeTest.genPrime(this.bitsize);
    } while (
     
 
       testPrimeAffinity(this.p, this.q));
     this.n = this.p.multiply(this.q);
     
 
 
 
 
     this.phi = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
    
 
 
 
     this.e = new BigInteger("65537");
     while (this.phi.gcd(this.e).intValue() > 1) {
       this.e = this.e.add(new BigInteger("2"));
     }
    this.d = this.e.modInverse(this.phi);
     
 
     this.publicKey = new RsaP(this.n, this.e);
     this.privateKey = new RsaPK(this.p, this.q, this.e, this.d);
     
 
     this.p = null;
     this.q = null;
     this.n = null;
     this.d = null;
     this.phi = null;
     this.e = null;
   }
   
   public RsaP getPublicKey()
   {
     return this.publicKey;
   }
   
   public RsaPK getPrivateKey()
   {
     return this.privateKey;
   }
   
   public boolean testPrimeAffinity(BigInteger p, BigInteger q)
   {
     if (p.equals(q)) {
       return true;
     }
     return false;
   }
 }

