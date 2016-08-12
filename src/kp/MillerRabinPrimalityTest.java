 package kp;
 
 import java.io.PrintStream;
 import java.math.BigInteger;
 import java.security.SecureRandom;
 import java.util.Scanner;
 
 public class MillerRabinPrimalityTest
 {
  private static final SecureRandom rnd = new SecureRandom();
   
   private static boolean miller_rabin_pass(BigInteger a, BigInteger n)
  {
    BigInteger n_minus_one = n.subtract(BigInteger.ONE);
   BigInteger d = n_minus_one;
     int s = d.getLowestSetBit();
    d = d.shiftRight(s);
    BigInteger a_to_power = a.modPow(d, n);
    if (a_to_power.equals(BigInteger.ONE)) {
      return true;
    }
   for (int i = 0; i < s - 1; i++)
     {
       if (a_to_power.equals(n_minus_one)) {
         return true;
       }
       a_to_power = a_to_power.multiply(a_to_power).mod(n);
     }
     if (a_to_power.equals(n_minus_one)) {
       return true;
     }
     return false;
   }
   
   public static boolean miller_rabin(BigInteger n)
   {
    for (int repeat = 0; repeat < 10; repeat++)
    {
       BigInteger a;
       do
       {
         a = new BigInteger(n.bitLength(), rnd);
       } while (
       
         a.equals(BigInteger.ZERO));
       if (!miller_rabin_pass(a, n)) {
         return false;
       }
     }
     return true;
   }
   
   public boolean isPrime(BigInteger x)
   {
    if (x.intValue() == 1) {
      return false;
   }
   if (new TestPrimality().isFoundFromTable(x)) {
      return true;
     }
     return miller_rabin(x);
   }
   
   public BigInteger genPrime(int bitsize)
   {
     BigInteger p;
   do
  {
      p = new BigInteger(bitsize, rnd);
     } while (((!p.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO)) && 
     (!p.mod(BigInteger.valueOf(3L)).equals(BigInteger.ZERO)) && 
       (!p.mod(BigInteger.valueOf(5L)).equals(BigInteger.ZERO)) && 
    (p.mod(BigInteger.valueOf(7L)).equals(BigInteger.ZERO))) && (!
       miller_rabin(p)));
    return p;
   }
   
   public static void main(String[] args)
   {
     MillerRabinPrimalityTest primeTest = new MillerRabinPrimalityTest();
     Scanner sc = new Scanner(System.in);
     System.out.println("Type a large integer to test if it's prime: ");
     BigInteger x = sc.nextBigInteger();
   System.out.println(primeTest.isPrime(x) ? "Prime" : "Composite");
     System.out.println("Type number of digits you want the generated prime to be: ");
    int bitsize = sc.nextInt();
    System.out.println("The test may take some time depending on the computer hardware used.");
     long startTime = System.currentTimeMillis();
     System.out.println(primeTest.genPrime(bitsize));
     long timeElapsed = System.currentTimeMillis() - startTime;
     System.out.println("Prime generated in " + timeElapsed + " ms.");
   }
 }

