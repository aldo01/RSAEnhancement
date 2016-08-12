/*   1:    */ package pSchemes;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.math.BigInteger;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.Iterator;
/*   7:    */ import kp.ED;
/*   8:    */ 
/*   9:    */ public class BlocksOf3Padding
/*  10:    */ {
/*  11: 48 */   private AlphabetNum alphaNum = new AlphabetNum();
/*  12: 49 */   private final int BASE = 26;
/*  13: 50 */   private final String pow_zero = "°";
/*  14: 51 */   private final String pow_one = "¹";
/*  15: 52 */   private final String pow_two = "²";
/*  16: 53 */   private final String times = "×";
/*  17: 54 */   private final String line = "----------------------------------------------------";
/*  18: 56 */   private final double BASE_double = Double.parseDouble(Integer.toString(26));
/*  19: 57 */   private int[] products = new int[3];
/*  20: 58 */   private int firstProduct = 0;
/*  21: 58 */   private int secondProduct = 0;
/*  22: 58 */   private int lastProduct = 0;
/*  23:    */   private double dPart;
/*  24:    */   private double dPart2;
/*  25:    */   private double division;
/*  26:    */   private double temp;
/*  27:    */   
/*  28:    */   private String[] plaintextToBlocks(String message)
/*  29:    */   {
/*  30: 68 */     message = message.replace(" ", "X");
/*  31:    */     
/*  32: 70 */     StringBuilder sB = new StringBuilder(message);
/*  33: 71 */     long length = sB.length();
/*  34:    */     
/*  35:    */ 
/*  36: 74 */     int remainder = (int)(length % 3L);
/*  37: 76 */     if (remainder == 2) {
/*  38: 77 */       sB.append("X");
/*  39:    */     }
/*  40: 80 */     if (remainder == 1) {
/*  41: 81 */       sB.append("XX");
/*  42:    */     }
/*  43: 85 */     length = sB.length();
/*  44:    */     
/*  45:    */ 
/*  46: 88 */     String[] divided = new String[(int)(length / 3L)];
/*  47: 89 */     int start = 0;int end = 3;
/*  48: 89 */     for (int i = 0; end <= length; i++)
/*  49:    */     {
/*  50: 90 */       divided[i] = sB.substring(start, end);start += 3;end += 3;
/*  51:    */     }
/*  52: 93 */     return divided;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getBlocktext(String plaintext)
/*  56:    */   {
/*  57:102 */     StringBuilder sB = new StringBuilder();
/*  58:103 */     for (String s : plaintextToBlocks(plaintext)) {
/*  59:104 */       sB.append(s + " ");
/*  60:    */     }
/*  61:106 */     sB.append("\n");
/*  62:107 */     return sB.toString();
/*  63:    */   }
/*  64:    */   
/*  65:    */   private String blocksToPlaintext(String[] blocks)
/*  66:    */   {
/*  67:116 */     StringBuilder sB = new StringBuilder();
/*  68:118 */     for (int i = 0; i < blocks.length; i++) {
/*  69:119 */       sB.append(blocks[i]);
/*  70:    */     }
/*  71:121 */     String plaintext = sB.toString();
/*  72:    */     
/*  73:123 */     plaintext = plaintext.replace("X", " ");
/*  74:    */     
/*  75:125 */     plaintext.trim();
/*  76:126 */     return plaintext;
/*  77:    */   }
/*  78:    */   
/*  79:    */   private int encodeBlock(String block)
/*  80:    */   {
/*  81:137 */     int num = (int)(this.alphaNum.getNum(block.substring(0, 1)) * Math.pow(26.0D, 2.0D)) + 
/*  82:138 */       (int)(this.alphaNum.getNum(block.substring(1, 2)) * Math.pow(26.0D, 1.0D)) + 
/*  83:139 */       (int)(this.alphaNum.getNum(block.substring(2, 3)) * Math.pow(26.0D, 0.0D));
/*  84:140 */     return num;
/*  85:    */   }
/*  86:    */   
/*  87:    */   private String getEncodeFormula(String text)
/*  88:    */   {
/*  89:150 */     setProductNumbers(text);
/*  90:151 */     String formula = this.products[0] + "×" + 26 + "²" + " + " + this.products[1] + "×" + 26 + "¹" + " + " + this.products[2] + "×" + 26 + "°";
/*  91:152 */     return formula;
/*  92:    */   }
/*  93:    */   
/*  94:    */   private void setProductNumbers(String text)
/*  95:    */   {
/*  96:160 */     this.products[0] = this.alphaNum.getNum(String.valueOf(text.charAt(0)));
/*  97:161 */     this.products[1] = this.alphaNum.getNum(String.valueOf(text.charAt(1)));
/*  98:162 */     this.products[2] = this.alphaNum.getNum(String.valueOf(text.charAt(2)));
/*  99:    */   }
/* 100:    */   
/* 101:    */   private String getFullEncodeFormula(String text)
/* 102:    */   {
/* 103:172 */     return text + " = " + getEncodeFormula(text) + " = " + encodeBlock(text);
/* 104:    */   }
/* 105:    */   
/* 106:    */   public double roundDouble(double nro, int desPlace)
/* 107:    */   {
/* 108:182 */     BigDecimal bd = new BigDecimal(nro);
/* 109:183 */     bd = bd.setScale(desPlace, 0);
/* 110:184 */     nro = bd.doubleValue();
/* 111:185 */     return nro;
/* 112:    */   }
/* 113:    */   
/* 114:    */   private String decode(int encoded)
/* 115:    */   {
/* 116:195 */     StringBuilder sB = new StringBuilder();
/* 117:    */     
/* 118:197 */     this.division = (encoded / this.BASE_double);
/* 119:199 */     if (this.division < this.BASE_double)
/* 120:    */     {
/* 121:200 */       this.firstProduct = 0;
/* 122:    */       
/* 123:202 */       this.secondProduct = ((int)this.division);
/* 124:203 */       this.dPart = (this.division - this.secondProduct);
/* 125:204 */       this.lastProduct = ((int)roundDouble(26.0D * this.dPart, 1));
/* 126:    */     }
/* 127:    */     else
/* 128:    */     {
/* 129:208 */       this.division /= this.BASE_double;
/* 130:213 */       if (this.division < 26.0D)
/* 131:    */       {
/* 132:214 */         this.firstProduct = ((int)this.division);
/* 133:215 */         this.dPart = (this.division - this.firstProduct);
/* 134:216 */         this.temp = (this.dPart * 26.0D);
/* 135:217 */         this.secondProduct = ((int)this.temp);
/* 136:218 */         this.dPart2 = (this.temp - this.secondProduct);
/* 137:219 */         this.lastProduct = ((int)roundDouble(26.0D * this.dPart2, 1));
/* 138:    */       }
/* 139:    */     }
/* 140:223 */     this.products[0] = this.firstProduct;
/* 141:224 */     this.products[1] = this.secondProduct;
/* 142:225 */     this.products[2] = this.lastProduct;
/* 143:227 */     for (int i = 0; i < this.products.length; i++) {
/* 144:228 */       sB.append(this.alphaNum.getLetter(this.products[i]));
/* 145:    */     }
/* 146:230 */     return sB.toString();
/* 147:    */   }
/* 148:    */   
/* 149:    */   private String getDecodecBlockFormula(int encoded)
/* 150:    */   {
/* 151:241 */     StringBuilder sB = new StringBuilder();
/* 152:    */     
/* 153:243 */     this.division = (encoded / this.BASE_double);
/* 154:245 */     if (this.division < 26.0D)
/* 155:    */     {
/* 156:246 */       this.firstProduct = 0;
/* 157:    */       
/* 158:248 */       this.secondProduct = ((int)this.division);
/* 159:249 */       this.dPart = (this.division - this.secondProduct);
/* 160:250 */       this.lastProduct = ((int)roundDouble(26.0D * this.dPart, 1));
/* 161:251 */    





                    //sB.append(encoded + " = (" + encoded + "/" + 26 + ")" + "×" + 26 + "\n");
/* 162:252 */      // sB.append(encoded + " = " + this.division + "×" + 26 + "\n");
/* 163:253 */      // sB.append(encoded + " = " + this.secondProduct + "×" + 26 + " + " + this.dPart + "×" + 26 + "\n");
/* 164:254 */      // sB.append(encoded + " = " + this.secondProduct + "×" + 26 + " + " + this.lastProduct + "×" + 26 + "°" + "\n");
/* 165:    */     }
/* 166:    */     else
/* 167:    */     {
/* 168:258 */      // sB.append(encoded + " = (" + encoded + "/" + 26 + ")" + "×" + 26 + "\n");
/* 169:259 */      // sB.append(encoded + " = " + roundDouble(this.division, 3) + "×" + 26 + "\n");
/* 170:260 */      // sB.append(encoded + " = (" + roundDouble(this.division, 3) + "/" + 26 + ")" + "×" + 26 + "²" + "\n");
/* 171:261 */       this.division /= this.BASE_double;
/* 172:266 */       if (this.division < 26.0D)
/* 173:    */       {
/* 174:267 */         sB.append(encoded + " = " + roundDouble(this.division, 3) + "×" + 26 + "²" + "\n");
/* 175:268 */         this.firstProduct = ((int)this.division);
/* 176:269 */         this.dPart = (this.division - this.firstProduct);
/* 177:270 */         sB.append(encoded + " = " + this.firstProduct + "×" + 26 + "²" + " + " + roundDouble(this.dPart, 3) + "×" + 26 + "²" + "\n");
/* 178:271 */         sB.append(encoded + " = " + this.firstProduct + "×" + 26 + "²" + " + (" + roundDouble(this.dPart, 3) + "×" + 26 + ")" + "×" + 26 + "\n");
/* 179:272 */         this.temp = (this.dPart * 26.0D);
/* 180:273 */         sB.append(encoded + " = " + this.firstProduct + "×" + 26 + "²" + " + " + roundDouble(this.temp, 3) + "×" + 26 + "\n");
/* 181:274 */         this.secondProduct = ((int)this.temp);
/* 182:275 */         this.dPart2 = (this.temp - this.secondProduct);
/* 183:276 */         sB.append(encoded + " = " + this.firstProduct + "×" + 26 + "²" + " + " + this.secondProduct + "×" + 26 + " + " + roundDouble(this.dPart2, 3) + "×" + 26 + "\n");
/* 184:277 */         this.lastProduct = ((int)roundDouble(26.0D * this.dPart2, 1));
/* 185:278 */         sB.append(encoded + " = " + this.firstProduct + "×" + 26 + "²" + " + " + this.secondProduct + "×" + 26 + " + " + this.lastProduct + "×" + 26 + "°" + "\n");
/* 186:    */       }
/* 187:    */     }
/* 188:282 */     this.products[0] = this.firstProduct;
/* 189:283 */     this.products[1] = this.secondProduct;
/* 190:284 */     this.products[2] = this.lastProduct;
/* 191:    */     
/* 192:286 */     sB.append("Products: [" + this.products[0] + ", " + this.products[1] + ", " + this.products[2] + "]\n");
/* 193:    */     
/* 194:288 */     sB.append(this.products[0] + "=" + this.alphaNum.getLetter(this.products[0]) + ", " + 
/* 195:289 */       this.products[1] + "=" + this.alphaNum.getLetter(this.products[1]) + ", " + 
/* 196:290 */       this.products[2] + "=" + this.alphaNum.getLetter(this.products[2]) + "\n");
/* 197:291 */     sB.append("Result: ");
/* 198:292 */     for (int i = 0; i < this.products.length; i++) {
/* 199:293 */       sB.append(this.alphaNum.getLetter(this.products[i]));
/* 200:    */     }
/* 201:295 */     return sB.toString();
/* 202:    */   }
/* 203:    */   
/* 204:    */   private String getEncodedBlock(String block)
/* 205:    */   {
/* 206:303 */     StringBuilder sB = new StringBuilder();
/* 207:304 */     setProductNumbers(block);
/* 208:305 */     sB.append(this.alphaNum.getLetter(this.products[0]) + "=" + this.products[0] + 
/* 209:306 */       ", " + this.alphaNum.getLetter(this.products[1]) + "=" + this.products[1] + 
/* 210:307 */       ", " + this.alphaNum.getLetter(this.products[2]) + "=" + this.products[2] + "\n");
/* 211:308 */     sB.append(getFullEncodeFormula(block) + "\n\n");
/* 212:309 */     return sB.toString();
/* 213:    */   }
/* 214:    */   
/* 215:    */   private String getEncodeFormulas(String[] blocks)
/* 216:    */   {
/* 217:318 */     StringBuilder sB = new StringBuilder();
/* 218:    */     
/* 219:320 */     sB.append("Encode: \n");
/* 220:321 */     sB.append("----------------------------------------------------\n");
/* 221:323 */     for (String s : blocks) {
/* 222:324 */       sB.append(getEncodedBlock(s));
/* 223:    */     }
/* 224:326 */     return sB.toString();
/* 225:    */   }
/* 226:    */   
/* 227:    */   private String getDecodeFormulas(String decoded)
/* 228:    */   {
/* 229:334 */     StringBuilder sB = new StringBuilder();
/* 230:335 */     sB.append("Decode: \n");
/* 231:336 */     sB.append("----------------------------------------------------\n");
/* 232:    */     
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:341 */     String[] numbersStr = decoded.split(" ");
/* 237:342 */     for (String s : numbersStr) {
/* 238:343 */       sB.append(getDecodecBlockFormula(Integer.parseInt(s)) + "\n\n");
/* 239:    */     }
/* 240:345 */     return sB.toString();
/* 241:    */   }
/* 242:    */   
/* 243:    */   private int[] encodeFullPhrase(String msg)
/* 244:    */   {
/* 245:355 */     String[] blocks = plaintextToBlocks(msg);
/* 246:356 */     int[] encoded = new int[blocks.length];
/* 247:357 */     int i = 0;
/* 248:359 */     for (String s : blocks)
/* 249:    */     {
/* 250:360 */       encoded[i] = encodeBlock(s);
/* 251:361 */       i++;
/* 252:    */     }
/* 253:363 */     return encoded;
/* 254:    */   }
/* 255:    */   
/* 256:    */   private int[] encodeBlocks(String[] blocks)
/* 257:    */   {
/* 258:373 */     int[] encoded = new int[blocks.length];
/* 259:374 */     int i = 0;
/* 260:376 */     for (String s : blocks)
/* 261:    */     {
/* 262:377 */       encoded[i] = encodeBlock(s);
/* 263:378 */       i++;
/* 264:    */     }
/* 265:380 */     return encoded;
/* 266:    */   }
/* 267:    */   
/* 268:    */   private String getEncodedConsecutively(int[] enc)
/* 269:    */   {
/* 270:388 */     StringBuilder sB = new StringBuilder();
/* 271:389 */     for (int i : enc) {
/* 272:390 */       sB.append(i + " ");
/* 273:    */     }
/* 274:392 */     sB.append("\n");
/* 275:393 */     return sB.toString();
/* 276:    */   }
/* 277:    */   
/* 278:    */   private String getDecodedFullPhrase(String encoded)
/* 279:    */   {
/* 280:403 */     StringBuilder sB = new StringBuilder();
/* 281:    */     
/* 282:405 */     String[] array = encoded.split(" ");
/* 283:407 */     for (String s : array) {
/* 284:408 */       sB.append(decode(Integer.parseInt(s)) + " ");
/* 285:    */     }
/* 286:410 */     return sB.toString();
/* 287:    */   }
/* 288:    */   
/* 289:    */   private ArrayList<BigInteger> encryptBlocksOfThree(int[] encoded, BigInteger e, BigInteger n)
/* 290:    */   {
/* 291:423 */     ED encDec = new ED();
/* 292:424 */     ArrayList<BigInteger> arrayL = new ArrayList();
/* 293:425 */     for (int i : encoded) {
/* 294:432 */       arrayL.add(encDec.encrypt(i, e, n));
/* 295:    */     }
/* 296:434 */     return arrayL;
/* 297:    */   }
/* 298:    */   
/* 299:    */   private BigInteger[] decryptBlocksOfThree(ArrayList<BigInteger> encrypted, BigInteger d, BigInteger n)
/* 300:    */   {
/* 301:447 */     ED encDec = new ED();
/* 302:    */     
/* 303:449 */     Iterator<BigInteger> iter = encrypted.iterator();
/* 304:450 */     BigInteger[] decrypted = new BigInteger[encrypted.size()];
/* 305:451 */     int i = 0;
/* 306:452 */     while (iter.hasNext())
/* 307:    */     {
/* 308:453 */       decrypted[i] = encDec.decrypt((BigInteger)iter.next(), d, n);
/* 309:454 */       i++;
/* 310:    */     }
/* 311:456 */     return decrypted;
/* 312:    */   }
/* 313:    */   
/* 314:    */   public String getEncodeAndEncryptBlocksOfThree(String plaintext, BigInteger e, BigInteger n)
/* 315:    */   {
/* 316:469 */     StringBuilder sB = new StringBuilder();
/* 317:470 */     plaintext = plaintext.toUpperCase();
/* 318:    */     
/* 319:    */ 
/* 320:    */ 
/* 321:474 */     sB.append(plaintext + "\n");
/* 322:    */     
/* 323:    */ 
/* 324:477 */     String[] blocks = plaintextToBlocks(plaintext);
/* 325:    */     
/* 326:    */ 
/* 327:480 */     sB.append(printArray(blocks) + "\n");
/* 328:    */     
/* 329:    */ 
/* 330:483 */     sB.append(getEncodeFormulas(blocks));
/* 331:484 */     sB.append("Encoded: ");
/* 332:    */     
/* 333:    */ 
/* 334:487 */     int[] encoded = encodeBlocks(blocks);
/* 335:    */     
/* 336:    */ 
/* 337:490 */     sB.append(getEncodedConsecutively(encoded) + "\n");
/* 338:    */     
/* 339:    */ 
/* 340:493 */     sB.append("Encrypt: \n");
/* 341:494 */     sB.append("----------------------------------------------------\n");
/* 342:495 */     for (int i : encoded)
/* 343:    */     {
/* 344:496 */       sB.append(new CalculationPhase(BigInteger.valueOf(i), e).getAll(n));
/* 345:497 */       sB.append("\n\n");
/* 346:    */     }
/* 347:502 */     ArrayList<BigInteger> arrayL = new ArrayList();
/* 348:    */     
/* 349:504 */     arrayL = encryptBlocksOfThree(encoded, e, n);
/* 350:505 */     sB.append("Encrypted: ");
/* 351:    */     
/* 352:    */ 
/* 353:508 */     Object iter = arrayL.iterator();
/* 354:509 */     StringBuilder encNumbers = new StringBuilder();
/* 355:510 */     while (((Iterator)iter).hasNext())
/* 356:    */     {
/* 357:511 */       BigInteger encrypted = (BigInteger)((Iterator)iter).next();
/* 358:512 */       sB.append(encrypted + " ");
/* 359:513 */       encNumbers.append(encrypted.toString() + " ");
/* 360:    */     }
/* 361:517 */     sB.append("\n\n" + this.alphaNum.getNumbers() + "\n\n");
/* 362:    */     
/* 363:    */ 
/* 364:520 */     sB.append("Cryptotext: ");
                   sB.append("C1: ");
                   sB.append(this.alphaNum.stringOfNumbersToLetters(encNumbers.toString()));
                   
                   sB.append("C2: ");
                   sB.append(this.alphaNum.stringOfNumbersToLetters(encNumbers.toString()));
                   
                   
/* 366:522 */     return sB.toString().trim();
/* 367:    */   }
/* 368:    */   
/* 369:    */   public String getDecryptAndDecodeBlocksOfThree(String cryptotext, BigInteger d, BigInteger n)
/* 370:    */   {
/* 371:535 */     StringBuilder sB = new StringBuilder();
/* 372:536 */     StringBuilder sB2 = new StringBuilder();
/* 373:    */     
/* 374:    */ 
/* 375:539 */     sB.append("Cryptotext: " + cryptotext + "\n\n");

                    System.out.println("crypto Text"+cryptotext);
/* 376:    */     
/* 377:    */ 
/* 378:542 */     sB.append(this.alphaNum.getLetters() + "\n\n");
/* 379:    */     
/* 380:    */ 
/* 381:545 */     String encryptedText = this.alphaNum.stringOfLettersToNumbers(cryptotext);
/* 382:    */     
/* 383:    */ 
/* 384:    */ 
/* 385:549 */     sB.append("Encrypted: " + encryptedText + "\n\n");
/* 386:    */     
/* 387:551 */     sB.append("Decrypt: \n");
/* 388:552 */     sB.append("----------------------------------------------------\n");
/* 389:    */     
/* 390:    */ 
/* 391:    */ 
/* 392:556 */     ArrayList<BigInteger> encryptedAL = stringToBiArrayList(encryptedText);
/* 393:557 */     Iterator<BigInteger> iter = encryptedAL.iterator();
/* 394:558 */     while (iter.hasNext())
/* 395:    */     {
/* 396:559 */       sB.append(new CalculationPhase((BigInteger)iter.next(), d).getAll(n));
/* 397:560 */       sB.append("\n\n");
/* 398:    */     }
/* 399:564 */     ArrayList<BigInteger> encrypted = stringToBiArrayList(encryptedText);
/* 400:565 */     BigInteger[] decryptedArray = decryptBlocksOfThree(encrypted, d, n);
/* 401:566 */     for (BigInteger bi : decryptedArray) {
/* 402:567 */       sB2.append(bi + " ");
/* 403:    */     }
/* 404:569 */     String decrypted = sB2.toString();
/* 405:570 */     sB.append("Decrypted: " + decrypted + "\n\n");
/* 406:    */     
/* 407:    */ 
/* 408:    */ 
/* 409:    */ 
/* 410:575 */     sB.append(getDecodeFormulas(decrypted));
/* 411:    */     
/* 412:    */ 
/* 413:578 */     String decoded = getDecodedFullPhrase(decrypted);
/* 414:579 */     sB.append("Decoded: \n");
/* 415:580 */     sB.append(decoded + "\n");
/* 416:    */     
/* 417:    */ 
/* 418:583 */     String decoded_no_ws = decoded.replace(" ", "");
/* 419:584 */     sB.append(decoded_no_ws + "\n");
/* 420:    */     
/* 421:    */ 
/* 422:587 */     String decoded_final = decoded_no_ws.replaceAll("X", " ");
/* 423:588 */     sB.append(decoded_final);
/* 424:589 */     return sB.toString().trim();
/* 425:    */   }
/* 426:    */   
/* 427:    */   public String getEncodeAndEncryptSecure(String plaintext, BigInteger e, BigInteger n)
/* 428:    */   {
/* 429:603 */     StringBuilder sB = new StringBuilder();
/* 430:604 */     plaintext = plaintext.toUpperCase();
/* 431:605 */     Iterator<BigInteger> iter = encryptBlocksOfThree(encodeFullPhrase(plaintext), e, n).iterator();
/* 432:606 */     while (iter.hasNext()) {
/* 433:607 */       sB.append(iter.next() + " ");
/* 434:    */     }
/* 435:610 */     return this.alphaNum.stringOfNumbersToLetters(sB.toString()).trim();
/* 436:    */   }
/* 437:    */   
/* 438:    */   public String getDecryptAndDecodeSecure(String cryptotext, BigInteger d, BigInteger n)
/* 439:    */   {
/* 440:624 */     StringBuilder sB = new StringBuilder();
/* 441:625 */     StringBuilder sB2 = new StringBuilder();
/* 442:    */     
/* 443:627 */     String encrypted = this.alphaNum.stringOfLettersToNumbers(cryptotext);
/* 444:628 */     for (BigInteger bi : decryptBlocksOfThree(stringToBiArrayList(encrypted), d, n)) {
/* 445:629 */       sB2.append(bi + " ");
/* 446:    */     }
/* 447:631 */     sB.append(blocksToPlaintext(getDecodedFullPhrase(sB2.toString()).split(" ")) + "\n");
/* 448:632 */     return sB.toString().trim();
/* 449:    */   }
/* 450:    */   
/* 451:    */   public ArrayList<BigInteger> stringToBiArrayList(String msg)
/* 452:    */   {
/* 453:643 */     String[] array = msg.split(" ");
/* 454:644 */     ArrayList<BigInteger> al = new ArrayList();
/* 455:645 */     for (String s : array) {
/* 456:646 */       al.add(new BigInteger(s));
/* 457:    */     }
/* 458:648 */     return al;
/* 459:    */   }
/* 460:    */   
/* 461:    */   public String printArray(String[] array)
/* 462:    */   {
/* 463:656 */     StringBuilder sB = new StringBuilder();
/* 464:657 */     for (String s : array) {
/* 465:658 */       sB.append(s + " ");
/* 466:    */     }
/* 467:660 */     sB.append("\n");
/* 468:661 */     return sB.toString();
/* 469:    */   }
/* 470:    */ }

