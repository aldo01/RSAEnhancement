/*   1:    */ package pSchemes;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.util.HashMap;
/*   5:    */ 
/*   6:    */ public class AlphabetNum
/*   7:    */ {
/*   8: 35 */   private String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
/*   9: 35 */   private HashMap<String, Integer> alphaNum = createHashMap();
/*  10:    */   
/*  11:    */   public HashMap<String, Integer> createHashMap()
/*  12:    */   {
/*  13: 50 */     HashMap<String, Integer> alphaNum = new HashMap();
/*  14: 51 */     for (int i = 0; i < 26; i++) {
/*  15: 52 */       alphaNum.put(this.alphabet[i], Integer.valueOf(i));
/*  16:    */     }
/*  17: 54 */     return alphaNum;
/*  18:    */   }
/*  19:    */   
/*  20:    */   public int getNum(String letter)
/*  21:    */   {
/*  22: 63 */     return ((Integer)this.alphaNum.get(letter)).intValue();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getLetter(int num)
/*  26:    */   {
/*  27: 72 */     return this.alphabet[num];
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getStringNum(String letter)
/*  31:    */   {
/*  32: 81 */     return ((Integer)this.alphaNum.get(letter)).toString();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getNumbers()
/*  36:    */   {
/*  37: 90 */     String s = "";
/*  38: 91 */     for (int i = 0; i < 26; i++)
/*  39:    */     {
/*  40: 92 */       s = s + i + "=";
/*  41: 93 */       s = s + getLetter(i);
/*  42: 94 */       if (i != 25) {
/*  43: 95 */         s = s + ", ";
/*  44:    */       }
/*  45: 97 */       if ((i == 10) || (i == 20)) {
/*  46: 98 */         s = s + "\n";
/*  47:    */       }
/*  48:    */     }
/*  49:101 */     return s;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getLetters()
/*  53:    */   {
/*  54:110 */     String s = "";
/*  55:111 */     for (int i = 0; i < 26; i++)
/*  56:    */     {
/*  57:112 */       s = s + getLetter(i) + "=";
/*  58:113 */       s = s + i;
/*  59:114 */       if (i != 25) {
/*  60:115 */         s = s + ", ";
/*  61:    */       }
/*  62:117 */       if ((i == 10) || (i == 20)) {
/*  63:118 */         s = s + "\n";
/*  64:    */       }
/*  65:    */     }
/*  66:121 */     return s;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String stringOfNumbersToLetters(String numbers)
/*  70:    */   {
/*  71:130 */     StringBuilder sB = new StringBuilder();
/*  72:131 */     for (int i = 0; i < numbers.length(); i++)
/*  73:    */     {
/*  74:132 */       char c = numbers.charAt(i);
/*  75:133 */       if (numbers.charAt(i) != ' ') {
/*  76:134 */         sB.append(getLetter(Character.getNumericValue(c)));
/*  77:    */       } else {
/*  78:137 */         sB.append(" ");
/*  79:    */       }
/*  80:    */     }
/*  81:140 */     return sB.toString();
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String stringOfLettersToNumbers(String letters)
/*  85:    */   {
/*  86:150 */     StringBuilder sB = new StringBuilder();
/*  87:151 */     for (int i = 0; i < letters.length(); i++)
/*  88:    */     {
/*  89:152 */       char c = letters.charAt(i);
/*  90:153 */       if (letters.charAt(i) != ' ') {
/*  91:154 */         sB.append(getNum(Character.toString(c)));
/*  92:    */       } else {
/*  93:157 */         sB.append(" ");
/*  94:    */       }
/*  95:    */     }
/*  96:160 */     return sB.toString();
/*  97:    */   }
/*  98:    */   
/*  99:    */   public static void main(String[] args)
/* 100:    */   {
/* 101:164 */     String numbers = "0123 314 32 4354 36443 574354 835 394";
/* 102:165 */     System.out.println(numbers);
/* 103:166 */     String letters = new AlphabetNum().stringOfNumbersToLetters(numbers);
/* 104:167 */     System.out.println(letters);
/* 105:168 */     System.out.println(new AlphabetNum().stringOfLettersToNumbers(letters));
/* 106:169 */     System.out.println("\n");
/* 107:170 */     System.out.println(new AlphabetNum().getNumbers());
/* 108:171 */     System.out.println("\n");
/* 109:172 */     System.out.println(new AlphabetNum().getLetters());
/* 110:173 */     System.out.println("\n");
/* 111:    */   }
/* 112:    */ }

