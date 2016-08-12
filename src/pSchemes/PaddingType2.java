/*   1:    */ package pSchemes;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.math.BigInteger;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import kp.ED;
/*   7:    */ 
/*   8:    */ public class PaddingType2
/*   9:    */ {
/*  10: 28 */   private AlphabetNum alphaNum = new AlphabetNum();
/*  11:    */   
/*  12:    */   public ArrayList<Integer> enCode(String msg)
/*  13:    */   {
/*  14: 37 */     if (msg.length() % 2 != 0) {
/*  15: 38 */       msg = msg + "x";
/*  16:    */     }
/*  17: 40 */     msg = msg.toUpperCase();
/*  18: 41 */     msg = msg.replace(" ", "X");
/*  19:    */     
/*  20: 43 */     ArrayList<Integer> numbers = new ArrayList();
/*  21: 44 */     char[] table = msg.toCharArray();
/*  22: 45 */     int j = 0;
/*  23: 45 */     for (int i = 0; i < table.length; i += 2)
/*  24:    */     {
/*  25: 46 */       numbers.add(j, Integer.valueOf(this.alphaNum.getNum(String.valueOf(table[i])) * 100));
/*  26: 47 */       if (i + 1 < table.length) {
/*  27: 48 */         numbers.set(j, Integer.valueOf(((Integer)numbers.get(j)).intValue() + this.alphaNum.getNum(String.valueOf(table[(i + 1)]))));
/*  28:    */       }
/*  29: 45 */       j++;
/*  30:    */     }
/*  31: 51 */     return numbers;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String deCode(ArrayList<Integer> msg)
/*  35:    */   {
/*  36: 61 */     String decoded = "";
/*  37: 62 */     Integer apu = null;
/*  38: 63 */     for (int i = 0; i < msg.size(); i++)
/*  39:    */     {
/*  40: 64 */       Integer help = (Integer)msg.get(i);
/*  41: 65 */       apu = Integer.valueOf(help.intValue() / 100);
/*  42: 66 */       decoded = decoded + this.alphaNum.getLetter(apu.intValue());
/*  43: 67 */       decoded = decoded + this.alphaNum.getLetter(help.intValue() - apu.intValue() * 100);
/*  44:    */     }
/*  45: 69 */     decoded = decoded.replaceAll("X", " ");
/*  46: 70 */     return decoded;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getLetters(ArrayList<Integer> msg)
/*  50:    */   {
/*  51: 81 */     String s = "";
/*  52: 82 */     Integer apu = null;
/*  53: 83 */     for (Integer integer : msg)
/*  54:    */     {
/*  55: 84 */       Integer help = integer;
/*  56: 85 */       apu = Integer.valueOf(help.intValue() / 100);
/*  57: 86 */       s = s + apu.toString() + "=";
/*  58: 87 */       s = s + this.alphaNum.getLetter(apu.intValue());
/*  59: 88 */       s = s + " ; ";
/*  60: 89 */       s = s + (help.intValue() - apu.intValue() * 100) + "=";
/*  61: 90 */       s = s + this.alphaNum.getLetter(help.intValue() - apu.intValue() * 100);
/*  62: 91 */       s = s + " ; ";
/*  63:    */     }
/*  64: 93 */     return s;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getEnCrypted(String msg, BigInteger exp, BigInteger mod)
/*  68:    */   {
/*  69:104 */     StringBuilder s = new StringBuilder();
/*  70:105 */     AlphabetNum alpha = new AlphabetNum();
/*  71:106 */     ED encrypter = new ED();
/*  72:    */     
/*  73:    */ 
/*  74:109 */     ArrayList<Integer> numberMessage = enCode(msg);
/*  75:110 */     s.append(msg + "\n\n");
/*  76:111 */     s.append(alpha.getLetters() + "\n\n");
/*  77:112 */     s.append("Type 2 encoded text:\n");
/*  78:113 */     for (Integer integer : numberMessage) {
/*  79:114 */       s.append(integer.toString() + " ");
/*  80:    */     }
/*  81:118 */     s.append("\n\nEncrypting:\n");
/*  82:119 */     for (int i = 0; i < numberMessage.size(); i++)
/*  83:    */     {
/*  84:120 */       CalculationPhase phase = new CalculationPhase(new BigInteger(((Integer)numberMessage.get(i)).toString()), exp);
/*  85:121 */       s.append(phase.getAll(mod));
/*  86:122 */       s.append("\n\n");
/*  87:    */     }
/*  88:124 */     s.append("Encryped: \n");
/*  89:    */     
/*  90:126 */     BigInteger[] enCrypted = new BigInteger[numberMessage.size()];
/*  91:127 */     String[] cryptotext = new String[numberMessage.size()];
/*  92:128 */     for (int i = 0; i < enCrypted.length; i++)
/*  93:    */     {
/*  94:129 */       enCrypted[i] = encrypter.encrypt(((Integer)numberMessage.get(i)).intValue(), exp, mod);
/*  95:130 */       cryptotext[i] = alpha.stringOfNumbersToLetters(enCrypted[i].toString());
/*  96:131 */       s.append(enCrypted[i] + " ");
/*  97:    */     }
/*  98:133 */     s.append("\n\n" + alpha.getNumbers());
/*  99:134 */     s.append("\n\nCryptotext:\n");
/* 100:135 */     for (String string : cryptotext) {
/* 101:136 */       s.append(string + " ");
/* 102:    */     }
/* 103:138 */     return s.toString();
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getDeCrypted(String msg, BigInteger exp, BigInteger mod)
/* 107:    */   {
/* 108:149 */     StringBuilder s = new StringBuilder();
/* 109:150 */     AlphabetNum alpha = new AlphabetNum();
/* 110:151 */     ED decrypter = new ED();
/* 111:    */     
/* 112:153 */     s.append("Cryptotext:\n");
/* 113:154 */     s.append(msg + "\n\n");
/* 114:155 */     s.append(alpha.getLetters() + "\n\n");
/* 115:    */     
/* 116:    */ 
/* 117:158 */     msg = alpha.stringOfLettersToNumbers(msg);
/* 118:159 */     String[] stringMessage = msg.split(" ");
/* 119:    */     
/* 120:    */ 
/* 121:162 */     BigInteger[] numberMessage = new BigInteger[stringMessage.length];
/* 122:164 */     for (int i = 0; i < numberMessage.length; i++) {
/* 123:165 */       numberMessage[i] = new BigInteger(stringMessage[i]);
/* 124:    */     }
/* 125:167 */     s.append("Encrypted message: \n");
/* 126:168 */     s.append(msg);
/* 127:169 */     s.append("\n\nDecrypting: \n");
/* 128:170 */     for (int i = 0; i < numberMessage.length; i++)
/* 129:    */     {
/* 130:171 */       CalculationPhase phase = new CalculationPhase(numberMessage[i], exp);
/* 131:172 */       s.append(phase.getAll(mod));
/* 132:173 */       s.append("\n\n");
/* 133:    */     }
/* 134:175 */     s.append("Decrypted: \n");
/* 135:176 */     ArrayList<Integer> integerMessage = new ArrayList();
/* 136:177 */     for (int i = 0; i < numberMessage.length; i++)
/* 137:    */     {
/* 138:178 */       integerMessage.add(i, Integer.valueOf(decrypter.decryptToInt(numberMessage[i], exp, mod)));
/* 139:179 */       s.append(integerMessage.get(i) + " ");
/* 140:    */     }
/* 141:183 */     s.append("\n\n" + alpha.getNumbers());
/* 142:184 */     s.append("\n\nDecoded text: ");
/* 143:185 */     s.append(deCode(integerMessage) + "\n");
/* 144:186 */     return s.toString();
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getEnCryptedSecure(String msg, BigInteger exp, BigInteger mod)
/* 148:    */   {
/* 149:197 */     StringBuilder s = new StringBuilder();
/* 150:198 */     AlphabetNum alpha = new AlphabetNum();
/* 151:199 */     ED encrypter = new ED();
/* 152:    */     
/* 153:    */ 
/* 154:202 */     ArrayList<Integer> numberMessage = enCode(msg);
/* 155:    */     
/* 156:    */ 
/* 157:205 */     BigInteger[] enCrypted = new BigInteger[numberMessage.size()];
/* 158:206 */     String[] cryptotext = new String[numberMessage.size()];
/* 159:207 */     for (int i = 0; i < enCrypted.length; i++)
/* 160:    */     {
/* 161:208 */       enCrypted[i] = encrypter.encrypt(((Integer)numberMessage.get(i)).intValue(), exp, mod);
/* 162:209 */       cryptotext[i] = alpha.stringOfNumbersToLetters(enCrypted[i].toString());
/* 163:    */     }
/* 164:211 */     for (String string : cryptotext) {
/* 165:212 */       s.append(string + " ");
/* 166:    */     }
/* 167:214 */     return s.toString().trim();
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getDeCryptedSecure(String msg, BigInteger exp, BigInteger mod)
/* 171:    */   {
/* 172:225 */     StringBuilder s = new StringBuilder();
/* 173:226 */     AlphabetNum alpha = new AlphabetNum();
/* 174:227 */     ED decrypter = new ED();
/* 175:    */     
/* 176:    */ 
/* 177:230 */     msg = alpha.stringOfLettersToNumbers(msg);
/* 178:231 */     String[] stringMessage = msg.split(" ");
/* 179:    */     
/* 180:    */ 
/* 181:234 */     BigInteger[] numberMessage = new BigInteger[stringMessage.length];
/* 182:236 */     for (int i = 0; i < numberMessage.length; i++) {
/* 183:237 */       numberMessage[i] = new BigInteger(stringMessage[i]);
/* 184:    */     }
/* 185:239 */     ArrayList<Integer> integerMessage = new ArrayList();
/* 186:240 */     for (int i = 0; i < numberMessage.length; i++) {
/* 187:241 */       integerMessage.add(i, Integer.valueOf(decrypter.decryptToInt(numberMessage[i], exp, mod)));
/* 188:    */     }
/* 189:245 */     s.append(deCode(integerMessage));
/* 190:246 */     return s.toString().trim();
/* 191:    */   }
/* 192:    */   
/* 193:    */   public static void main(String[] args)
/* 194:    */   {
/* 195:252 */     ED c = new ED();
/* 196:253 */     PaddingType2 koe = new PaddingType2();
/* 197:254 */     String message = "help helppi";
/* 198:255 */     ArrayList<Integer> testi = null;
/* 199:256 */     System.out.println(message);
/* 200:257 */     testi = koe.enCode(message);
/* 201:258 */     System.out.print("Type2 encoded text: ");
/* 202:259 */     System.out.print(testi);
/* 203:    */     
/* 204:261 */     String[] padded = new String[testi.size()];
/* 205:263 */     for (int i = 0; i < testi.size(); i++) {
/* 206:264 */       padded[i] = ((Integer)testi.get(i)).toString();
/* 207:    */     }
/* 208:267 */     System.out.println();
/* 209:268 */     System.out.print("Encrypted text: ");
/* 210:269 */     BigInteger[] crypto = new BigInteger[padded.length];
/* 211:270 */     for (int i = 0; i < crypto.length; i++) {
/* 212:271 */       crypto[i] = c.encrypt(((Integer)testi.get(i)).intValue(), BigInteger.valueOf(113L), BigInteger.valueOf(3893L));
/* 213:    */     }
/* 214:274 */     for (BigInteger integer : crypto) {
/* 215:275 */       System.out.print(integer + " ");
/* 216:    */     }
/* 217:277 */     System.out.println();
/* 218:278 */     System.out.print("Decrypted text:");
/* 219:279 */     testi.clear();
/* 220:280 */     for (int i = 0; i < crypto.length; i++) {
/* 221:281 */       testi.add(Integer.valueOf(c.decryptToInt(crypto[i], BigInteger.valueOf(1937L), BigInteger.valueOf(3893L))));
/* 222:    */     }
/* 223:283 */     System.out.println(testi);
/* 224:284 */     System.out.print("Type2 decoded text:");
/* 225:285 */     String d = koe.deCode(testi);
/* 226:286 */     System.out.println(d);
/* 227:    */   }
/* 228:    */ }

