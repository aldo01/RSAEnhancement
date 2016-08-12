 package kp;
 
 import logics.RsaKeyFileFilter;
 import java.io.File;
 import javax.swing.JFileChooser;
 import javax.swing.JFrame;
 import javax.swing.JOptionPane;

 public class OS
 {
   private EnhanceED encDec;
   private LdKey loadSave;
  private RsaP pubKey;
   private RsaPK privKey;
   private File file;
   private JFrame frame;
   byte[] encoded;
   
   public OS(JFrame frame)
   {
     this.frame = frame;
 }
   
   public File chooseFileToLoad()
   {
     JFileChooser fc = new JFileChooser();
  fc.setFileFilter(new RsaKeyFileFilter());
     int result = fc.showOpenDialog(this.frame);
   switch (result)
     {
     case 0: 
      if (fc.getSelectedFile() != null) {
         this.file = fc.getSelectedFile();
       } else {
         JOptionPane.showMessageDialog(this.frame, "No file was selected", "File selection info", 1);
       }
       break;
     case 1: 
      break;
     case -1: 
      JOptionPane.showMessageDialog(this.frame, "An error occured while selecting a file to load", "File selection error", 0);
     }
     return this.file;
   }
   
   public File chooseFileToSave()
   {
     JFileChooser fc = new JFileChooser();
     fc.setFileFilter(new RsaKeyFileFilter());
     int result = fc.showSaveDialog(this.frame);
     switch (result)
     {
     case 0: 
   if (fc.getSelectedFile() != null) {
         this.file = fc.getSelectedFile();
      } else {
         JOptionPane.showMessageDialog(this.frame, "No file was selected", "File selection info", 1);
       }
      break;
     case 1: 
       break;
     case -1: 
       JOptionPane.showMessageDialog(this.frame, "An error occured while selecting a file to save", "File selection error", 0);
     }
    return this.file;
   }
   
   public void savePublicKey(RsaP publicKey)
   {
     this.encDec = new EnhanceED();
    this.encoded = this.encDec.encPublicKey(publicKey);
     
   this.file = chooseFileToSave();
   if (this.file != null)
     {
       String[] splits = this.file.getName().split("\\.");
       String extension = splits[(splits.length - 1)];
       if (!extension.equals("pub"))
      {
      String newFileName = this.file.getName() + ".pub";
        
        int length = this.file.getPath().length() - this.file.getName().length();
         String newFilePath = this.file.getPath().substring(0, length) + newFileName;
         
 
         this.file = new File(newFilePath);
      }
      this.loadSave = new LdKey(this.frame);
       this.loadSave.saveKeyToFile(this.encoded, this.file);
     }
   }
   
   public void savePrivateKey(RsaPK privateKey)
  {
     this.encDec = new EnhanceED();
     this.encoded = this.encDec.encPrivateKey(privateKey);
     
 
     this.file = chooseFileToSave();
     if (this.file != null)
     {
       String[] splits = this.file.getName().split("\\.");
       String extension = splits[(splits.length - 1)];
       if (!extension.equals("priv"))
       {
         String newFileName = this.file.getName() + ".priv";
         
      int length = this.file.getPath().length() - this.file.getName().length();
        String newFilePath = this.file.getPath().substring(0, length) + newFileName;
       
        this.file = new File(newFilePath);
      }
       this.loadSave = new LdKey(this.frame);
       this.loadSave.saveKeyToFile(this.encoded, this.file);
     }
   }
   
   public RsaP loadPublicKey()
  {
     this.file = chooseFileToLoad();
    if (this.file == null)
     {
       this.pubKey = null;
     }
     else
     {
       this.loadSave = new LdKey(this.frame);
       this.encoded = this.loadSave.loadKeyFromFile(this.file);
      
 
       this.encDec = new EnhanceED();
       this.pubKey = this.encDec.decPublicKey(this.encoded);
    }
     return this.pubKey;
   }
   
   public RsaPK loadPrivateKey()
   {
    this.file = chooseFileToLoad();
     if (this.file == null)
     {
       this.privKey = null;
    }
     else
     {
       this.loadSave = new LdKey(this.frame);
       this.encoded = this.loadSave.loadKeyFromFile(this.file);
       
 
       this.encDec = new EnhanceED();
       this.privKey = this.encDec.decPrivateKey(this.encoded);
     }
     return this.privKey;
   }
 }
