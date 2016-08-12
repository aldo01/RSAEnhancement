/*   1:    */ package logics;
/*   2:    */ 
/*   3:    */ import java.io.BufferedWriter;
/*   4:    */ import java.io.File;
/*   5:    */ import java.io.FileInputStream;
/*   6:    */ import java.io.FileNotFoundException;
/*   7:    */ import java.io.FileWriter;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.nio.ByteBuffer;
/*  10:    */ import java.nio.channels.FileChannel;
/*  11:    */ import javax.swing.JFileChooser;
/*  12:    */ import javax.swing.JFrame;
/*  13:    */ import javax.swing.JOptionPane;
/*  14:    */ import javax.swing.JTextArea;
/*  15:    */ import kp.OS;
/*  16:    */ 
/*  17:    */ public class LoadSaveExec
/*  18:    */ {
/*  19:    */   OS openSave;
/*  20:    */   JFrame frame;
/*  21:    */   JTextArea textArea;
/*  22:    */   File file;
/*  23:    */   
/*  24:    */   public LoadSaveExec(JFrame frame, JTextArea textArea)
/*  25:    */   {
/*  26: 52 */     this.frame = frame;
/*  27: 53 */     this.textArea = textArea;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void saveExecToFile()
/*  31:    */   {
/*  32: 61 */     File file = chooseFileToSave();
/*  33: 62 */     if (file != null)
/*  34:    */     {
/*  35: 64 */       String[] splits = file.getName().split("\\.");
/*  36: 65 */       String extension = splits[(splits.length - 1)];
/*  37: 68 */       if (!extension.equals("txt"))
/*  38:    */       {
/*  39: 70 */         String newFileName = file.getName() + ".txt";
/*  40:    */         
/*  41: 72 */         int length = file.getPath().length() - file.getName().length();
/*  42: 73 */         String newFilePath = file.getPath().substring(0, length) + newFileName;
/*  43:    */         
/*  44:    */ 
/*  45: 76 */         file = new File(newFilePath);
/*  46:    */       }
/*  47:    */       try
/*  48:    */       {
/*  49: 80 */         BufferedWriter fileOut = new BufferedWriter(new FileWriter(file));
/*  50: 81 */         fileOut.write(this.textArea.getText());
/*  51: 82 */         fileOut.close();
/*  52:    */       }
/*  53:    */       catch (Exception e)
/*  54:    */       {
/*  55: 84 */         JOptionPane.showMessageDialog(this.frame, "Writing execution into a file failed.", "File write error", 0);
/*  56:    */       }
/*  57:    */     }
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void loadExecFromFile()
/*  61:    */   {
/*  62: 98 */     File file = chooseFileToLoad();
/*  63:100 */     if (file != null)
/*  64:    */     {
/*  65:102 */       this.textArea.setText("");
/*  66:    */       
/*  67:104 */       long file_size = file.length();
/*  68:105 */       int byteSize = (int)file_size;
/*  69:106 */       FileInputStream f = null;
/*  70:    */       try
/*  71:    */       {
/*  72:108 */         f = new FileInputStream(file);
/*  73:    */       }
/*  74:    */       catch (FileNotFoundException e)
/*  75:    */       {
/*  76:110 */         JOptionPane.showMessageDialog(this.frame, "File " + file.getName() + " not found.", "File load error", 0);
/*  77:    */       }
/*  78:112 */       FileChannel ch = f.getChannel();
/*  79:113 */       ByteBuffer bb = ByteBuffer.allocateDirect(131072);
/*  80:114 */       byte[] barray = new byte[byteSize];
/*  81:115 */       long checkSum = 0L;
/*  82:    */       try
/*  83:    */       {
/*  84:    */         int nRead;
/*  85:118 */         while ((nRead = ch.read(bb)) != -1)
/*  86:    */         {
/*  87:    */        //   int nRead;
/*  88:119 */           if (nRead != 0)
/*  89:    */           {
/*  90:121 */             bb.position(0);
/*  91:122 */             bb.limit(nRead);
/*  92:    */             int nGet;
/*  93:    */             int i;
/*  94:123 */             for (i=0;i < bb.remaining();i++)
/*  95:    */             {
/*  96:124 */               nGet = Math.min(bb.remaining(), byteSize);
/*  97:125 */               bb.get(barray, 0, nGet);
/*  98:126 */               //i = 0; continue;
/*  99:127 */               checkSum += barray[i];//i++;
/* 100:    */             }
/* 101:129 */             this.textArea.setText(new String(barray));
/* 102:130 */             this.textArea.setCaretPosition(0);
/* 103:131 */             bb.clear();
/* 104:    */           }
/* 105:    */         }
/* 106:    */       }
/* 107:    */       catch (IOException e)
/* 108:    */       {
/* 109:134 */         JOptionPane.showMessageDialog(this.frame, "Error in reading a file " + file.getName(), "File read error", 0);
/* 110:    */       }
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   private File chooseFileToLoad()
/* 115:    */   {
/* 116:146 */     JFileChooser fc = new JFileChooser();
/* 117:147 */     fc.setFileFilter(new ExecutionFileFilter());
/* 118:148 */     int result = fc.showOpenDialog(this.frame);
/* 119:149 */     switch (result)
/* 120:    */     {
/* 121:    */     case 0: 
/* 122:151 */       if (fc.getSelectedFile() != null) {
/* 123:152 */         this.file = fc.getSelectedFile();
/* 124:    */       } else {
/* 125:155 */         JOptionPane.showMessageDialog(this.frame, "No file was selected", "File selection info", 1);
/* 126:    */       }
/* 127:157 */       break;
/* 128:    */     case 1: 
/* 129:    */       break;
/* 130:    */     case -1: 
/* 131:161 */       JOptionPane.showMessageDialog(this.frame, "An error occured while selecting a file to load", "File selection error", 0);
/* 132:    */     }
/* 133:164 */     return this.file;
/* 134:    */   }
/* 135:    */   
/* 136:    */   private File chooseFileToSave()
/* 137:    */   {
/* 138:173 */     JFileChooser fc = new JFileChooser();
/* 139:174 */     fc.setFileFilter(new ExecutionFileFilter());
/* 140:175 */     int result = fc.showSaveDialog(this.frame);
/* 141:176 */     switch (result)
/* 142:    */     {
/* 143:    */     case 0: 
/* 144:178 */       if (fc.getSelectedFile() != null) {
/* 145:179 */         this.file = fc.getSelectedFile();
/* 146:    */       } else {
/* 147:182 */         JOptionPane.showMessageDialog(this.frame, "No file was selected", "File selection info", 1);
/* 148:    */       }
/* 149:184 */       break;
/* 150:    */     case 1: 
/* 151:    */       break;
/* 152:    */     case -1: 
/* 153:188 */       JOptionPane.showMessageDialog(this.frame, "An error occured while selecting a file to save", "File selection error", 0);
/* 154:    */     }
/* 155:191 */     return this.file;
/* 156:    */   }
/* 157:    */ }
