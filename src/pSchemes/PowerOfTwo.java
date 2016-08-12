/*  1:   */ package pSchemes;
/*  2:   */ 
/*  3:   */ import java.math.BigInteger;
/*  4:   */ 
/*  5:   */ public class PowerOfTwo
/*  6:   */ {
/*  7:31 */   private BigInteger result = BigInteger.ONE;
/*  8:   */   
/*  9:   */   public BigInteger calculate(BigInteger prime)
/* 10:   */   {
/* 11:39 */     this.result = BigInteger.ONE;
/* 12:40 */     return calc(prime);
/* 13:   */   }
/* 14:   */   
/* 15:   */   private BigInteger calc(BigInteger pri)
/* 16:   */   {
/* 17:50 */     while (this.result.compareTo(pri) < 0) {
/* 18:51 */       this.result = power(this.result);
/* 19:   */     }
/* 20:53 */     if (this.result.compareTo(pri) == 0) {
/* 21:54 */       return this.result;
/* 22:   */     }
/* 23:56 */     return this.result.shiftRight(1);
/* 24:   */   }
/* 25:   */   
/* 26:   */   private BigInteger power(BigInteger k)
/* 27:   */   {
/* 28:66 */     return k.shiftLeft(1);
/* 29:   */   }
/* 30:   */ }
