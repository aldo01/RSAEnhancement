/*   1:    */ package pSchemes;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.math.BigInteger;
/*   5:    */ import kp.ED;
/*   6:    */ import kp.EGenUK;
/*   7:    */ import kp.RsaPK;
/*   8:    */ import kp.RsaP;
              import java.util.Random;

/*   9:    */ 
/*  10:    */ public class PaddingType1
/*  11:    */ {
/*  12: 31 */   private AlphabetNum alphaNum = new AlphabetNum();

                private static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYDFGHDJURITNG";
                private static final int RANDOM_STRING_LENGTH = 2;


/*  13:    */   
/*  14:    */   public Integer[] enCode(String msg)
/*  15:    */   {
/*  16: 40 */     msg = msg.toUpperCase();
/*  17: 41 */     msg = msg.replace(" ", "X");
/*  18:    */     
/*  19: 43 */     Integer[] numbers = new Integer[msg.length()];
/*  20: 44 */     char[] table = msg.toCharArray();
/*  21: 45 */     for (int j = 0; j < table.length; j++) {
/*  22: 46 */       numbers[j] = Integer.valueOf(this.alphaNum.getNum(String.valueOf(table[j])));
/*  23:    */     }
/*  24: 48 */     return numbers;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public String deCode(Integer[] msg)
/*  28:    */   {
/*  29: 58 */     String unpadded = "";
/*  30: 59 */     for (int i = 0; i < msg.length; i++) {
/*  31: 60 */       unpadded = unpadded + this.alphaNum.getLetter(msg[i].intValue());
/*  32:    */     }
/*  33: 62 */     unpadded = unpadded.replaceAll("X", " ");
/*  34: 63 */     return unpadded;
/*  35:    */   }
/*  36:    */   


 private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }


/*  37:    */   public String getEnCrypted(String msg, BigInteger exp, BigInteger mod)
/*  38:    */   {
/*  39: 75 */     StringBuilder s = new StringBuilder();
/*  40: 76 */     AlphabetNum alpha = new AlphabetNum();
/*  41: 77 */     ED encrypter = new ED();
/*  42:    */     
/*  43:    */ 
/*  44: 80 */     Integer[] numberMessage = enCode(msg);
/*  45: 81 */     s.append(msg + "\n\n");
/*  46: 82 */     s.append(alpha.getLetters() + "\n\n");
/*  47: 83 */     s.append("Type 1 encoded text:\n");
/*  48: 84 */     for (Integer integer : numberMessage) {
/*  49: 85 */       s.append(integer.toString() + " ");
/*  50:    */     }
/*  51: 89 */     s.append("\n\nEncrypting:\n");
/*  52: 90 */     for (int i = 0; i < numberMessage.length; i++)
/*  53:    */     {
/*  54: 91 */       CalculationPhase phase = new CalculationPhase(new BigInteger(numberMessage[i].toString()), exp);
/*  55: 92 */       s.append(phase.getAll(mod));
/*  56: 93 */       s.append("\n\n");
/*  57:    */     }
/*  58: 95 */     s.append("Encrypted: \n");
/*  59: 96 */     BigInteger[] enCrypted = new BigInteger[numberMessage.length];
/*  60: 97 */     String[] enCryptedLetters = new String[enCrypted.length];
/*  61: 98 */     for (int i = 0; i < enCrypted.length; i++)
/*  62:    */     {
/*  63: 99 */       enCrypted[i] = encrypter.encrypt(numberMessage[i].intValue(), exp, mod);
/*  64:100 */       enCryptedLetters[i] = alpha.stringOfNumbersToLetters(enCrypted[i].toString());
/*  65:101 */       s.append(enCrypted[i] + " ");
/*  66:    */     }
/*  67:105 */     s.append("\n\n" + alpha.getNumbers());



     s.append("\n\nCryptotext: \n");
     s.append("c1: ");
     
     
     
     
     
     for (String string : enCryptedLetters) {
         
         
      StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
         
         
         string=string+randStr.toString();      //new BigInteger(130, random).toString(32);
       s.append(string + " ");
     
     }
     
     s.append("\nc2: ");
     for (String string : enCryptedLetters) {
       s.append(string + " ");
     }
     
     
     
     
     
     
     
     return s.toString();
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getDeCrypted(String msg, BigInteger exp, BigInteger mod)
/*  76:    */   {
/*  77:122 */     StringBuilder s = new StringBuilder();
/*  78:123 */     AlphabetNum alpha = new AlphabetNum();
/*  79:124 */     ED decrypter = new ED();
/*  80:    */     
/*  81:    */ 
/*  82:127 */    // s.append("Cryptotext: \n");
/*  83:128 */    // s.append(msg + "\n\n");
/*  84:129 */     s.append(alpha.getLetters() + "\n\n");
/*  85:130 */     msg = alpha.stringOfLettersToNumbers(msg);
/*  86:131 */     String[] stringMessage = msg.split(" ");
/*  87:    */     
/*  88:    */ 
/*  89:134 */     BigInteger[] numberMessage = new BigInteger[stringMessage.length];
/*  90:136 */     for (int i = 0; i < numberMessage.length; i++) {
/*  91:137 */       numberMessage[i] = new BigInteger(stringMessage[i]);
/*  92:    */     }
/*  93:139 */     s.append("Encrypted message: \n");
/*  94:140 */     s.append(msg);
/*  95:141 */     s.append("\n\nDecrypting: \n");
/*  96:142 */     for (int i = 0; i < numberMessage.length; i++)
/*  97:    */     {
/*  98:143 */       CalculationPhase phase = new CalculationPhase(numberMessage[i], exp);
/*  99:144 */       s.append(phase.getAll(mod));
/* 100:145 */       s.append("\n\n");
/* 101:    */     }
/* 102:147 */     s.append("Decrypted: \n");
/* 103:148 */     Integer[] integerMessage = new Integer[numberMessage.length];
/* 104:149 */     for (int i = 0; i < numberMessage.length; i++)
/* 105:    */     {
/* 106:150 */       integerMessage[i] = Integer.valueOf(decrypter.decryptToInt(numberMessage[i], exp, mod));
/* 107:151 */       s.append(integerMessage[i] + " ");
/* 108:    */     }
/* 109:155 */     s.append("\n\n" + alpha.getNumbers());
             


                  s.append("\n\nDecoded text: ");
                  String unCoded = deCode(integerMessage);
                  s.append(unCoded + "\n");
/* 113:159 */     return s.toString();
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getEnCryptedSecure(String msg, BigInteger exp, BigInteger mod)
/* 117:    */   {
/* 118:171 */     StringBuilder sB = new StringBuilder();
/* 119:172 */     AlphabetNum alpha = new AlphabetNum();
/* 120:173 */     ED encrypter = new ED();
/* 121:    */     
/* 122:    */ 
/* 123:176 */     Integer[] numberMessage = enCode(msg);
/* 124:    */     
/* 125:    */ 
/* 126:179 */     BigInteger[] enCrypted = new BigInteger[numberMessage.length];
/* 127:180 */     String[] enCryptedLetters = new String[enCrypted.length];
/* 128:181 */     for (int i = 0; i < enCrypted.length; i++)
/* 129:    */     {
/* 130:182 */       enCrypted[i] = encrypter.encrypt(numberMessage[i].intValue(), exp, mod);
/* 131:183 */       enCryptedLetters[i] = alpha.stringOfNumbersToLetters(enCrypted[i].toString());
/* 132:    */     }
/* 133:187 */     for (String string : enCryptedLetters) {
/* 134:188 */       sB.append(string + " ");
/* 135:    */     }
/* 136:190 */     return sB.toString().trim();
/* 137:    */   }
/* 138:    */   
/* 139:    */   public String getDeCryptedSecure(String msg, BigInteger exp, BigInteger mod)
/* 140:    */   {
/* 141:202 */     AlphabetNum alpha = new AlphabetNum();
/* 142:203 */     ED decrypter = new ED();
/* 143:    */     
/* 144:    */ 
/* 145:206 */     msg = alpha.stringOfLettersToNumbers(msg);
/* 146:207 */     String[] stringMessage = msg.split(" ");
/* 147:    */     
/* 148:    */ 
/* 149:210 */     BigInteger[] numberMessage = new BigInteger[stringMessage.length];
/* 150:211 */     for (int i = 0; i < numberMessage.length; i++) {
/* 151:212 */       numberMessage[i] = new BigInteger(stringMessage[i]);
/* 152:    */     }
/* 153:214 */     Integer[] integerMessage = new Integer[numberMessage.length];
/* 154:215 */     for (int i = 0; i < numberMessage.length; i++) {
/* 155:216 */       integerMessage[i] = Integer.valueOf(decrypter.decryptToInt(numberMessage[i], exp, mod));
/* 156:    */     }
/* 157:220 */     String deCoded = deCode(integerMessage);
/* 158:221 */     return deCoded;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public static void main(String[] args)
/* 162:    */   {
/* 163:231 */     PaddingType1 koe = new PaddingType1();
/* 164:    */     
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:    */ 
/* 177:    */ 
/* 178:    */ 
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:    */ 
/* 183:    */ 
/* 184:    */ 
/* 185:    */ 
/* 186:    */ 
/* 187:    */ 
/* 188:    */ 
/* 189:    */ 
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:    */ 
/* 200:    */ 
/* 201:    */ 
/* 202:    */ 
/* 203:271 */     EGenUK genKeys = new EGenUK();
/* 204:272 */     genKeys.createKeys(new BigInteger("131"), new BigInteger("137"), new BigInteger("3"));
/* 205:273 */     RsaP publicKey = genKeys.getPublicKey();
/* 206:274 */     RsaPK privateKey = genKeys.getPrivateKey();
/* 207:275 */     String cryptotext = koe.getEnCryptedSecure("salaisuus", publicKey.getE(), publicKey.getModulus());
/* 208:276 */     System.out.println(cryptotext);
/* 209:    */     
/* 210:278 */     String decrypted = koe.getDeCryptedSecure(cryptotext, privateKey.getPrivateExponent(), privateKey.getModulus());
/* 211:279 */     System.out.println(decrypted);
/* 212:    */   }
/* 213:    */ }

