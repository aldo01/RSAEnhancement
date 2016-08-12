/*  1:   */ package logics;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import javax.swing.filechooser.FileFilter;
/*  5:   */ 
/*  6:   */ public class RsaKeyFileFilter
/*  7:   */   extends FileFilter
/*  8:   */ {
/*  9:   */   public boolean accept(File f)
/* 10:   */   {
/* 11:34 */     return (f.isDirectory()) || (f.getName().toLowerCase().endsWith(".pub")) || (f.getName().toLowerCase().endsWith(".priv"));
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getDescription()
/* 15:   */   {
/* 16:42 */     return ".pub & .priv files";
/* 17:   */   }
/* 18:   */ }

