/*   1:    */ package pSchemes;
/*   2:    */ 
/*   3:    */ import graphical_user.FScreen;
/*   4:    */ import java.awt.Font;
/*   5:    */ import java.math.BigInteger;
/*   6:    */ import javax.swing.JTextArea;
/*   7:    */ 
/*   8:    */ public class CalculationPhase
/*   9:    */   extends DividedPower
/*  10:    */ {
/*  11:    */   private BigInteger number;
/*  12:    */   private BigInteger exponent;
/*  13: 33 */   private UnicodeConverter sc = new UnicodeConverter();
/*  14: 34 */   private final String kongru = "×";
/*  15: 35 */   private final String times = "≡";
/*  16:    */   
/*  17:    */   public CalculationPhase(BigInteger num, BigInteger exp)
/*  18:    */   {
/*  19: 44 */     this.number = num;
/*  20: 45 */     this.exponent = exp;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BigInteger getExponent()
/*  24:    */   {
/*  25: 54 */     return this.exponent;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BigInteger getNumber()
/*  29:    */   {
/*  30: 63 */     return this.number;
/*  31:    */   }

/*  32:    */   
/*  33:    */   public StringBuilder getFormula()
/*  34:    */   {
/*  35: 72 */     StringBuilder s = new StringBuilder();
/*  36: 73 */     s.append(this.number);
/*  37:    */     
/*  38: 75 */     s.append(this.sc.superScript(this.exponent.toString()));
/*  39: 76 */     return s;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public StringBuilder getExpDiv()
/*  43:    */   {
/*  44: 85 */     StringBuilder s = new StringBuilder();
/*  45: 86 */     s.append(this.number);
/*  46:    */     
/*  47: 88 */     String[] a = powerDivison(this.exponent).toString().split("");
/*  48: 89 */     for (String i : a) {
/*  49: 90 */       s.append(this.sc.superScript(i));
/*  50:    */     }
/*  51: 93 */     return s;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public StringBuilder getAddition()
/*  55:    */   {
/*  56:102 */     StringBuilder s = new StringBuilder();
/*  57:103 */     String[] p = powerDivison(this.exponent).toString().split("\\+");
/*  58:104 */     for (int i = 0; i < p.length; i++)
/*  59:    */     {
/*  60:105 */       s.append(this.number.toString());
/*  61:    */       
/*  62:107 */       s.append(this.sc.superScript(p[i]));
/*  63:108 */       if (i < p.length - 1) {
/*  64:109 */         s.append("×");
/*  65:    */       }
/*  66:    */     }
/*  67:112 */     return s;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public StringBuilder getModulo(BigInteger mod)
/*  71:    */   {
/*  72:123 */     StringBuilder s = new StringBuilder();
/*  73:124 */     StringBuilder begin = new StringBuilder();
/*  74:125 */     String[] p = powerDivison(this.exponent).toString().split("\\+");
/*  75:126 */     BigInteger help = new BigInteger("0");
/*  76:    */     
/*  77:128 */     int a = 0;
/*  78:129 */     for (int i = 0; i < p.length; i++) {
/*  79:130 */       if (new BigInteger(p[i]).compareTo(BigInteger.ONE) < 1)
/*  80:    */       {
/*  81:131 */         s.append(this.number);
/*  82:132 */         if (i < p.length - 1)
/*  83:    */         {
/*  84:133 */           s.append("×");
/*  85:134 */           begin.append(s);
/*  86:    */         }
/*  87:    */       }
/*  88:    */       else
/*  89:    */       {
/*  90:137 */         help = this.number.modPow(new BigInteger(p[i]), mod);
/*  91:138 */         s.append(help);
/*  92:139 */         begin.append(help);
/*  93:140 */         if (i < p.length - 1)
/*  94:    */         {
/*  95:141 */           s.append("×");
/*  96:142 */           begin.append("×");
/*  97:    */         }
/*  98:145 */         a = i;
/*  99:146 */         for (int j = i; j < p.length; j++) {
/* 100:147 */           if (j < p.length - 1)
/* 101:    */           {
/* 102:148 */             s.append(help);
/* 103:    */             
/* 104:150 */             s.append(this.sc
/* 105:151 */               .superScript(new BigInteger(p[(j + 1)]).divide(new BigInteger(p[a])).toString()));
/* 106:152 */             if (j + 1 < p.length - 1) {
/* 107:153 */               s.append("×");
/* 108:    */             }
/* 109:    */           }
/* 110:    */         }
/* 111:157 */         if (i < p.length - 1)
/* 112:    */         {
/* 113:158 */           s.append("\n ≡");
/* 114:159 */           s.append(begin);
/* 115:    */         }
/* 116:    */       }
/* 117:    */     }
/* 118:164 */     s.append("\n ≡");
/* 119:165 */     BigInteger answer = BigInteger.ONE;
/* 120:166 */     String[] v = begin.toString().split("×");
/* 121:167 */     for (int i = 0; i < v.length; i++) {
/* 122:168 */       answer = answer.multiply(new BigInteger(v[i]));
/* 123:    */     }
/* 124:171 */     s.append(answer.mod(mod));
/* 125:172 */     s.append("(mod " + mod + ")");
/* 126:173 */     return s;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public StringBuilder getAll(BigInteger modulo)
/* 130:    */   {
/* 131:183 */     StringBuilder s = new StringBuilder();
/* 132:    */     
/* 133:185 */     s.append(getFormula() + "\n = ");
/* 134:186 */     s.append(getExpDiv() + "\n = ");
/* 135:187 */     s.append(getAddition() + "\n " + "≡" + " ");
/* 136:188 */     s.append(getModulo(modulo));
/* 137:189 */     return s;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public static void main(String[] args)
/* 141:    */   {
/* 142:197 */     CalculationPhase f = new CalculationPhase(BigInteger.valueOf(63L), new BigInteger("29"));
/* 143:    */     
/* 144:199 */     JTextArea j = new JTextArea();
/* 145:200 */     j.setFont(new Font("Arial Unicode MS", 0, 14));
/* 146:201 */     j.setText(f.getAll(new BigInteger("91")).toString());
/* 147:202 */     new FScreen(j);
/* 148:    */   }
/* 149:    */ }

