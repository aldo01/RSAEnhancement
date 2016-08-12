/*  1:   */ package pSchemes;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.util.HashMap;
/*  5:   */ 
/*  6:   */ public class UnicodeConverter
/*  7:   */ {
/*  8:29 */   private static HashMap<String, String> map = new HashMap();
/*  9:30 */   private static String[] numbers = { "⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", 
/* 10:31 */     "⁸", "⁹" };
/* 11:   */   
/* 12:   */   public UnicodeConverter()
/* 13:   */   {
/* 14:37 */     for (int i = 0; i < numbers.length; i++) {
/* 15:38 */       map.put(Integer.valueOf(i).toString(), numbers[i]);
/* 16:   */     }
/* 17:40 */     map.put("+", "⁺");
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String superScript(String p)
/* 21:   */   {
/* 22:48 */     StringBuilder b = new StringBuilder();
/* 23:49 */     String[] a = p.split("");
/* 24:50 */     for (int i = 1; i < a.length; i++) {
/* 25:51 */       b.append((String)map.get(a[i]));
/* 26:   */     }
/* 27:54 */     return b.toString();
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static void main(String[] args)
/* 31:   */   {
/* 32:61 */     UnicodeConverter h = new UnicodeConverter();
/* 33:62 */     String k = h.superScript("123456");
/* 34:63 */     System.out.println("63" + k);
/* 35:   */   }
/* 36:   */ }

