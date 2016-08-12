 package kp;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import javax.swing.JFrame;
 import javax.swing.JOptionPane;
 
 public class LdKey
 {
   private JFrame frame;
   
  public LdKey(JFrame frame)
   {
     this.frame = frame;
   }
   
   public byte[] loadKeyFromFile(File file)
  {
     InputStream inputS = null;
    try
     {
       inputS = new FileInputStream(file);
     }
     catch (FileNotFoundException e)
     {
       JOptionPane.showMessageDialog(this.frame, "File " + file.getName() + " not found.", "File load error", 0);
     }
     long length = file.length();
     if (length > 2147483647L)
     {
       JOptionPane.showMessageDialog(this.frame, "File " + file.getName() + " is too large to process", "File load error", 0);
       return null;
    }
     byte[] bytes = new byte[(int)length];
  
 
     int offset = 0;
     int numRead = 0;
     try
     {
     while ((offset < bytes.length) && 
       
         ((numRead = inputS.read(bytes, offset, bytes.length - offset)) >= 0)) {
         offset += numRead;
       }
       if (offset < bytes.length) {
         throw new IOException("Could not completely read file " + file.getName());
       }
       inputS.close();
     }
     catch (IOException e)
     {
       JOptionPane.showMessageDialog(this.frame, "Error in reading file " + file.getName(), "File load error", 0);
     }
     return bytes;
   }
   
   public void saveKeyToFile(byte[] enc, File file)
   {
     FileOutputStream out = null;
     try
     {
       out = new FileOutputStream(file);
     }
     catch (FileNotFoundException e)
     {
       JOptionPane.showMessageDialog(this.frame, "File " + file.getName() + " not found.", "File save error", 0);
     }
     try
     {
       out.write(enc);
       out.close();
     }
     catch (IOException e)
     {
       JOptionPane.showMessageDialog(this.frame, "Error in reading file " + file.getName(), "File save error", 0);
     }
   }
 }

