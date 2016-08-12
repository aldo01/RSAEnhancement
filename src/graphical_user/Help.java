/*   1:    */ package graphical_user;
/*   2:    */ 
/*   3:    */ import java.awt.Container;
/*   4:    */ import java.awt.GridBagConstraints;
/*   5:    */ import java.awt.GridBagLayout;
/*   6:    */ import java.awt.Insets;
/*   7:    */ import java.awt.event.ActionEvent;
/*   8:    */ import java.awt.event.ActionListener;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.net.URL;
/*  11:    */ import javax.swing.JButton;
/*  12:    */ import javax.swing.JEditorPane;
/*  13:    */ import javax.swing.JFrame;
/*  14:    */ import javax.swing.JScrollPane;
/*  15:    */ import javax.swing.SwingUtilities;
/*  16:    */ 
/*  17:    */ public class Help
/*  18:    */   extends JFrame
/*  19:    */ {
/*  20:    */   private static final long serialVersionUID = -7279256753979554192L;
/*  21:    */   private JScrollPane scrollPane1;
/*  22:    */   private JEditorPane editorPane1;
/*  23:    */   private JButton button1;
/*  24:    */   
/*  25:    */   public Help()
/*  26:    */   {
/*  27: 41 */     initComponents();
/*  28:    */   }
/*  29:    */   
/*  30: 48 */   ClassLoader cl = getClass().getClassLoader();
/*  31: 49 */   URL urlHelp = this.cl.getResource("Help.html");
/*  32:    */   
/*  33:    */   private void initComponents()
/*  34:    */   {
/*  35: 55 */     this.scrollPane1 = new JScrollPane();
/*  36: 56 */     this.editorPane1 = new JEditorPane();
/*  37: 57 */     this.button1 = new JButton();
/*  38:    */     
/*  39:    */ 
/*  40: 60 */     setVisible(true);
/*  41: 61 */     setTitle("Help - RSA Education Cryptosystem");
/*  42: 62 */     setDefaultCloseOperation(2);
/*  43: 63 */     Container contentPane = getContentPane();
/*  44: 64 */     contentPane.setLayout(new GridBagLayout());
/*  45: 65 */     ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] { 10, 0, 65, 5 };
/*  46: 66 */     ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] { 10, 0, 30, 5 };
/*  47: 67 */     ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0D, 0.0001D };
/*  48: 68 */     ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0D, 0.0001D };
/*  49:    */     
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53: 73 */     this.editorPane1.setEditable(false);
/*  54: 74 */     this.editorPane1.setContentType("text/html");
/*  55: 75 */     this.scrollPane1.setViewportView(this.editorPane1);
/*  56:    */     try
/*  57:    */     {
/*  58: 78 */       this.editorPane1.setPage(this.urlHelp);
/*  59:    */     }
/*  60:    */     catch (IOException e)
/*  61:    */     {
/*  62: 81 */       this.editorPane1.setText("Help file not found");
/*  63:    */     }
/*  64: 84 */     contentPane.add(this.scrollPane1, new GridBagConstraints(1, 1, 2, 1, 0.0D, 0.0D, 
/*  65: 85 */       10, 1, 
/*  66: 86 */       new Insets(0, 0, 5, 5), 0, 0));
/*  67:    */     
/*  68:    */ 
/*  69: 89 */     this.button1.setText("Close");
/*  70: 90 */     this.button1.addActionListener(new ActionListener()
/*  71:    */     {
/*  72:    */       public void actionPerformed(ActionEvent e)
/*  73:    */       {
/*  74: 92 */         Help.this.closeButtonActionPerformed(e);
/*  75:    */       }
/*  76: 94 */     });
/*  77: 95 */     contentPane.add(this.button1, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/*  78: 96 */       10, 1, 
/*  79: 97 */       new Insets(0, 0, 5, 5), 0, 0));
/*  80:    */     
/*  81: 99 */     setSize(900, 650);
/*  82:100 */     setLocationRelativeTo(null);
/*  83:    */   }
/*  84:    */   
/*  85:    */   private void closeButtonActionPerformed(ActionEvent e)
/*  86:    */   {
/*  87:108 */     dispose();
/*  88:    */   }
/*  89:    */   
/*  90:    */   public static void main(String[] args)
/*  91:    */   {
/*  92:116 */     SwingUtilities.invokeLater(new Runnable()
/*  93:    */     {
/*  94:    */       public void run()
/*  95:    */       {
/*  96:118 */         JFrame.setDefaultLookAndFeelDecorated(false);
/*  97:119 */         new Help();
/*  98:    */       }
/*  99:    */     });
/* 100:    */   }
/* 101:    */ }

