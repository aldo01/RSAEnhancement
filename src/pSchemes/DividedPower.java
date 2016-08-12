/*  1:   */ package pSchemes;
/*  2:   */ 
/*  3:   */ import java.math.BigInteger;
/*  4:   */ 
/*  5:   */ public class DividedPower
/*  6:   */   extends PowerOfTwo
/*  7:   */ {
/*  8:   */   public StringBuilder powerDivison(BigInteger prime)
/*  9:   */   {
/* 10:33 */     StringBuilder pwr = new StringBuilder();
/* 11:34 */     BigInteger stop = BigInteger.ZERO;
/* 12:35 */     BigInteger tulos = calculate(prime);
/* 13:36 */     stop = stop.add(prime);
/* 14:37 */     pwr.append(tulos);
/* 15:38 */     stop = stop.subtract(tulos);
/* 16:39 */     while (stop.compareTo(BigInteger.ZERO) > 0)
/* 17:   */     {
/* 18:40 */       tulos = calculate(stop);
/* 19:41 */       stop = stop.subtract(tulos);
/* 20:42 */       pwr.insert(0, tulos + "+");
/* 21:   */     }
/* 22:44 */     return pwr;
/* 23:   */   }
/* 24:   */ }

