/*    1:     */ package graphical_user;
/*    2:     */ 
/*    3:     */ import logics.ClipboardCopyPaste;
/*    4:     */ import logics.LoadSaveExec;
/*    5:     */ import java.awt.Color;
/*    6:     */ import java.awt.Container;
/*    7:     */ import java.awt.Cursor;
/*    8:     */ import java.awt.Dimension;
/*    9:     */ import java.awt.Font;
/*   10:     */ import java.awt.GridBagConstraints;
/*   11:     */ import java.awt.GridBagLayout;
/*   12:     */ import java.awt.Insets;
/*   13:     */ import java.awt.event.ActionEvent;
/*   14:     */ import java.awt.event.ActionListener;
/*   15:     */ import java.math.BigInteger;
/*   16:     */ import javax.swing.ButtonGroup;
/*   17:     */ import javax.swing.ButtonModel;
/*   18:     */ import javax.swing.ImageIcon;
/*   19:     */ import javax.swing.JButton;
/*   20:     */ import javax.swing.JComboBox;
/*   21:     */ import javax.swing.JFrame;
/*   22:     */ import javax.swing.JLabel;
/*   23:     */ import javax.swing.JMenu;
/*   24:     */ import javax.swing.JMenuBar;
/*   25:     */ import javax.swing.JMenuItem;
/*   26:     */ import javax.swing.JOptionPane;
/*   27:     */ import javax.swing.JPanel;
/*   28:     */ import javax.swing.JRadioButton;
/*   29:     */ import javax.swing.JScrollPane;
/*   30:     */ import javax.swing.JTextArea;
/*   31:     */ import javax.swing.JTextField;
/*   32:     */ import javax.swing.KeyStroke;
/*   33:     */ import javax.swing.SwingUtilities;
/*   34:     */ import javax.swing.border.LineBorder;
/*   35:     */ import javax.swing.border.TitledBorder;
/*   36:     */ import kp.EnhanceGenerateKeys;
/*   37:     */ import kp.EGenUK;
/*   38:     */ import kp.OS;
/*   39:     */ import kp.RsaPK;
/*   40:     */ import kp.RsaP;
/*   41:     */ import pSchemes.BlocksOf3Padding;
/*   42:     */ import pSchemes.PaddingType1;
/*   43:     */ import pSchemes.PaddingType2;
/*   44:     */ 
/*   45:     */ public class Graphical extends JFrame
/*   47:     */ {
/*   48:     */   private static final long serialVersionUID = -2015036022929739032L;
/*   49:     */   private JMenuBar menuBar;
/*   50:     */   private JMenu menu;
/*   51:     */   private JMenu menu2;
/*   52:     */   private JMenuItem menuItem1;
/*   53:     */   private JMenuItem menuItem2;
/*   54:     */   private JMenuItem menuItem3;
                //  private JMenuItem menuItem4;
/*   55:     */   private JRadioButton radioButton1;
/*   56:     */   private JRadioButton radioButton2;
/*   57:     */   private JRadioButton radioButton3;
/*   58:     */   private JRadioButton radioButton4;
/*   59:     */   private JRadioButton radioButton5;
/*   60:     */   private JButton button1;
/*   61:     */   private JButton button2;
/*   62:     */   private JButton button3;
/*   63:     */   private JButton button4;
/*   64:     */   private JButton button5;
/*   65:     */   private JButton button6;
/*   66:     */   private JButton button7;
/*   67:     */   private JButton button8;
/*   68:     */   private JButton button9;
/*   69:     */   private JButton button10;
/*   70:     */   private JButton button11;
/*   71:     */   private JButton button12;
/*   72:     */   private JButton button13;
/*   73:     */   private JPanel panel3;
/*   74:     */   private JPanel panel6;
/*   75:     */   private JPanel panel7;
/*   76:     */   private JLabel label1;
/*   77:     */   private JLabel label2;
/*   78:     */   private JLabel label3;
/*   79:     */   private JLabel label4;
/*   80:     */   private JLabel label5;
/*   81:     */   private JLabel label6;
/*   82:     */   private JLabel label7;
/*   83:     */   private JLabel label8;
/*   84:     */   private JTextField textField1;
/*   85:     */   private JTextField textField2;
/*   86:     */   private JTextField textField3;
/*   87:     */   private JTextField textField4;
/*   88:     */   private JTextField textField5;
/*   89:     */   private JTextField textField6;
/*   90:     */   private JTextArea textArea1;
/*   91:     */   private JTextArea textArea2;
/*   92:     */   private JScrollPane scrollPane1;
/*   93:     */   private JScrollPane scrollPane2;
/*   94:     */   private JComboBox comboBox1;
/*   95:     */   private ButtonGroup buttonGroup1;
/*   96:     */   private ButtonGroup buttonGroup2;
/*   97:     */   private RsaP publicKey;
/*   98:     */   private RsaPK privateKey;
/*   99:     */   private OS openSave;
/*  100:     */   private PaddingType1 padding1;
/*  101:     */   private PaddingType2 padding2;
/*  102:     */   private BlocksOf3Padding padding3;
/*  103:     */   private ClipboardCopyPaste clipboard;
/*  104:     */   private final String[] textSize;
/*  105:     */   private GPanel panel1;
/*  106:     */   private GPanel panel2;
/*  107:     */   private GPanel panel4;
/*  108:     */   private GPanel panel5;
/*  109:     */   private Color panelColor;
/*  110:     */   
/*  111:     */   public Graphical()
/*  112:     */   {
/*  113: 114 */     this.textSize = new String[] { "Font size 12 pt", "Font size 14 pt", "Font size 16 pt", "Font size 18 pt", "Font size 20 pt" };initComponents();
/*  114:     */   }
/*  115:     */   
/*  116:     */   private void initComponents()
/*  117:     */   {
/*  118: 126 */     this.menuBar = new JMenuBar();
/*  119:     */     
/*  120: 128 */     this.menu = new JMenu();
/*  121: 129 */     this.menu2 = new JMenu();
/*  122:     */     
/*  123: 131 */     this.menuItem1 = new JMenuItem();
/*  124: 132 */     this.menuItem2 = new JMenuItem();
/*  125: 133 */     this.menuItem3 = new JMenuItem();
                  //  this.menuItem4 = new JMenuItem();
/*  126:     */     
/*  127: 135 */     this.radioButton1 = new JRadioButton();
/*  128: 136 */     this.radioButton2 = new JRadioButton();
/*  129: 137 */     this.radioButton3 = new JRadioButton();
/*  130: 138 */     this.radioButton4 = new JRadioButton();
/*  131: 139 */     this.radioButton5 = new JRadioButton();
/*  132:     */     
/*  133: 141 */     this.button1 = new JButton();
/*  134: 142 */     this.button2 = new JButton();
/*  135: 143 */     this.button3 = new JButton();
/*  136: 144 */     this.button4 = new JButton();
/*  137: 145 */     this.button5 = new JButton();
/*  138: 146 */     this.button6 = new JButton();
/*  139: 147 */     this.button7 = new JButton();
/*  140: 148 */     this.button8 = new JButton();
/*  141: 149 */     this.button9 = new JButton();
/*  142: 150 */     this.button10 = new JButton();
/*  143: 151 */     this.button11 = new JButton();
/*  144: 152 */     this.button12 = new JButton();
/*  145: 153 */     this.button13 = new JButton();
/*  146:     */     
/*  147: 155 */     this.panel3 = new JPanel();
/*  148: 156 */     this.panel6 = new JPanel();
/*  149: 157 */     this.panel7 = new JPanel();
/*  150:     */     
/*  151: 159 */     this.label1 = new JLabel();
/*  152: 160 */     this.label2 = new JLabel();
/*  153: 161 */     this.label3 = new JLabel();
/*  154: 162 */     this.label4 = new JLabel();
/*  155: 163 */     this.label5 = new JLabel();
/*  156: 164 */     this.label6 = new JLabel();
/*  157: 165 */     this.label7 = new JLabel();
/*  158: 166 */     this.label8 = new JLabel();
/*  159:     */     
/*  160: 168 */     this.textField1 = new JTextField();
/*  161: 169 */     this.textField2 = new JTextField();
/*  162: 170 */     this.textField3 = new JTextField();
/*  163: 171 */     this.textField4 = new JTextField();
/*  164: 172 */     this.textField5 = new JTextField();
/*  165: 173 */     this.textField6 = new JTextField();
/*  166:     */     
/*  167: 175 */     this.textArea1 = new JTextArea();
/*  168: 176 */     this.textArea2 = new JTextArea();
/*  169:     */     
/*  170: 178 */     this.scrollPane1 = new JScrollPane();
/*  171: 179 */     this.scrollPane2 = new JScrollPane();
/*  172:     */     
/*  173: 181 */     this.comboBox1 = new JComboBox(this.textSize);
/*  174:     */     
/*  175: 183 */     this.buttonGroup1 = new ButtonGroup();
/*  176: 184 */     this.buttonGroup2 = new ButtonGroup();
/*  177:     */     
/*  178: 186 */     this.padding1 = new PaddingType1();
/*  179: 187 */     this.padding2 = new PaddingType2();
/*  180: 188 */     this.padding3 = new BlocksOf3Padding();
/*  181:     */     
/*  182: 190 */     this.clipboard = new ClipboardCopyPaste();
/*  183:     */     
/*  184:     */ 
/*  185: 193 */     this.panelColor = Color.LIGHT_GRAY;
/*  186:     */     
/*  187:     */ 
/*  188: 196 */     setTitle("RSA Education Cryptosystem");
/*  189: 197 */     setDefaultCloseOperation(2);
/*  190: 198 */     setVisible(true);
/*  191:     */     try
/*  192:     */     {
/*  193: 200 */       ClassLoader cl = getClass().getClassLoader();
/*  194: 201 */       setIconImage(new ImageIcon(cl.getResource("images/icon.jpg")).getImage());
/*  195:     */     }
/*  196:     */     catch (Exception localException) {}
/*  197: 205 */     Container contentPane = getContentPane();
/*  198: 206 */     contentPane.setLayout(new GridBagLayout());
/*  199: 207 */     ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] { 10, 581, 10 };
/*  200: 208 */     ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] { 3, 0, 10, 0, 10, 64, 10, 0, 10, 0, 10, 242, 5 };
/*  201: 209 */     ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0001D };
/*  202:     */     
/*  203:     */ 
/*  204:     */ 
/*  205:     */ 
/*  206:     */ 
/*  207:     */ 
/*  208: 216 */     this.menu.setText("File");
/*  209:     */     
/*  210:     */ 
/*      this.menuItem4.setText("Result Analysis/graph plot");
     this.menuItem4.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
      {
         Gui.this.quitMenuItemActionPerformed(e);
       }
     });
     this.menu.add(this.menuItem4);
  */     


             
/*  211: 219 */     this.menuItem3.setText("Quit");
/*  212: 220 */     this.menuItem3.addActionListener(new ActionListener()
/*  213:     */     {
/*  214:     */       public void actionPerformed(ActionEvent e)
/*  215:     */       {
/*  216: 222 */         Graphical.this.quitMenuItemActionPerformed(e);
/*  217:     */       }
/*  218: 224 */     });
/*  219: 225 */     this.menu.add(this.menuItem3);




/*  221: 227 */     this.menuBar.add(this.menu);
/*  222:     */     
/*  223:     */ 
/*  224:     */ 
/*  225: 231 */     this.menu2.setText("Help");
/*  226:     */     
/*  227:     */ 
/*  228: 234 */     this.menuItem1.setText("Show help");
/*  229: 235 */     this.menuItem1.addActionListener(new ActionListener()
/*  230:     */     {
/*  231:     */       public void actionPerformed(ActionEvent e)
/*  232:     */       {
/*  233: 237 */         Graphical.this.showHelpMenuItemActionPerformed(e);
/*  234:     */       }
/*  235: 240 */     });
/*  236: 241 */     this.menuItem1.setAccelerator(KeyStroke.getKeyStroke(122, 0));
/*  237: 242 */     this.menu2.add(this.menuItem1);
/*  238:     */     
/*  239:     */ 
/*  240: 245 */     this.menuItem2.setText("About");
/*  241: 246 */     this.menuItem2.addActionListener(new ActionListener()
/*  242:     */     {
/*  243:     */       public void actionPerformed(ActionEvent e)
/*  244:     */       {
/*  245: 248 */         Graphical.this.aboutMenuItemActionPerformed(e);
/*  246:     */       }
/*  247: 250 */     });
/*  248: 251 */     this.menu2.add(this.menuItem2);
/*  249:     */     
/*  250: 253 */     this.menuBar.add(this.menu2);
/*  251:     */     
/*  252:     */ 
/*  253: 256 */     setJMenuBar(this.menuBar);
/*  254:     */     
/*  255:     */ 
/*  256:     */ 
/*  257: 260 */     this.panel1 = new GPanel(this.panelColor, new GridBagLayout());
/*  258: 261 */     ((GridBagLayout)this.panel1.getLayout()).columnWidths = new int[] { 25, 162, 32, 105, 110, 105, 105, 20 };
/*  259: 262 */     ((GridBagLayout)this.panel1.getLayout()).rowHeights = new int[] { 12, 0, 0, 0, 0, 0, 5 };
/*  260: 263 */     ((GridBagLayout)this.panel1.getLayout()).columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0001D };
/*  261: 264 */     ((GridBagLayout)this.panel1.getLayout()).rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0001D };
/*  262:     */     
/*  263: 266 */     this.panel1.setBorder(new TitledBorder(new LineBorder(Color.gray, 1, true), "Key creation"));
/*  264:     */     
/*  265:     */ 
/*  266: 269 */     this.label1.setText("p");
/*  267: 270 */     this.label1.setHorizontalAlignment(0);
/*  268: 271 */     this.panel1.add(this.label1, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 
/*  269: 272 */       10, 3, 
/*  270: 273 */       new Insets(0, 0, 5, 5), 0, 0));
/*  271: 274 */     this.panel1.add(this.textField1, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/*  272: 275 */       10, 1, 
/*  273: 276 */       new Insets(0, 0, 5, 5), 0, 0));
/*  274:     */     
/*  275:     */ 
/*  276: 279 */     this.label4.setText("n");
/*  277: 280 */     this.label4.setHorizontalAlignment(0);
/*  278: 281 */     this.panel1.add(this.label4, new GridBagConstraints(2, 1, 1, 1, 0.0D, 0.0D, 
/*  279: 282 */       10, 1, 
/*  280: 283 */       new Insets(0, 0, 5, 5), 0, 0));
/*  281:     */     
/*  282:     */ 
/*  283: 286 */     this.textField4.setEditable(false);
/*  284: 287 */     this.panel1.add(this.textField4, new GridBagConstraints(3, 1, 4, 1, 0.0D, 0.0D, 
/*  285: 288 */       10, 1, 
/*  286: 289 */       new Insets(0, 0, 5, 5), 0, 0));
/*  287:     */     
/*  288:     */ 
/*  289: 292 */     this.label2.setText("q");
/*  290: 293 */     this.label2.setHorizontalAlignment(0);
/*  291: 294 */     this.panel1.add(this.label2, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 
/*  292: 295 */       10, 3, 
/*  293: 296 */       new Insets(0, 0, 5, 5), 0, 0));
/*  294: 297 */     this.panel1.add(this.textField2, new GridBagConstraints(1, 2, 1, 1, 0.0D, 0.0D, 
/*  295: 298 */       10, 1, 
/*  296: 299 */       new Insets(0, 0, 5, 5), 0, 0));
/*  297:     */     
/*  298:     */ 
/*  299: 302 */     this.label5.setText("d");
/*  300: 303 */     this.label5.setHorizontalAlignment(0);
/*  301: 304 */     this.panel1.add(this.label5, new GridBagConstraints(2, 2, 1, 1, 0.0D, 0.0D, 
/*  302: 305 */       10, 1, 
/*  303: 306 */       new Insets(0, 0, 5, 5), 0, 0));
/*  304:     */     
/*  305:     */ 
/*  306: 309 */     this.textField5.setEditable(false);
/*  307: 310 */     this.panel1.add(this.textField5, new GridBagConstraints(3, 2, 4, 1, 0.0D, 0.0D, 
/*  308: 311 */       10, 1, 
/*  309: 312 */       new Insets(0, 0, 5, 5), 0, 0));
/*  310:     */     
/*  311:     */ 
/*  312: 315 */     this.label3.setText("e");
/*  313: 316 */     this.label3.setHorizontalAlignment(0);
/*  314: 317 */     this.panel1.add(this.label3, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 
/*  315: 318 */       10, 3, 
/*  316: 319 */       new Insets(0, 0, 5, 5), 0, 0));
/*  317: 320 */     this.panel1.add(this.textField3, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/*  318: 321 */       10, 1, 
/*  319: 322 */       new Insets(0, 0, 5, 5), 0, 0));
/*  320:     */     
/*  321:     */ 
/*  322: 325 */     this.label6.setText("Save");
/*  323: 326 */     this.panel1.add(this.label6, new GridBagConstraints(5, 3, 1, 1, 0.0D, 0.0D, 
/*  324: 327 */       10, 3, 
/*  325: 328 */       new Insets(0, 0, 5, 5), 0, 0));
/*  326:     */     
/*  327:     */ 
/*  328: 331 */     this.label7.setText("Load");
/*  329: 332 */     this.panel1.add(this.label7, new GridBagConstraints(6, 3, 1, 1, 0.0D, 0.0D, 
/*  330: 333 */       10, 3, 
/*  331: 334 */       new Insets(0, 0, 5, 5), 0, 0));
/*  332:     */     
/*  333:     */ 
/*  334: 337 */     this.button11.setText("Clear keys");
/*  335: 338 */     this.button11.addActionListener(new ActionListener()
/*  336:     */     {
/*  337:     */       public void actionPerformed(ActionEvent e)
/*  338:     */       {
/*  339: 340 */         Graphical.this.clearKeysButtonActionPerformed(e);
/*  340:     */       }
/*  341: 342 */     });
/*  342: 343 */     this.panel1.add(this.button11, new GridBagConstraints(4, 5, 1, 1, 0.0D, 0.0D, 
/*  343: 344 */       10, 1, 
/*  344: 345 */       new Insets(0, 0, 5, 5), 0, 0));
/*  345:     */     
/*  346:     */ 
/*  347: 348 */     this.label8.setText("Prime bitsize");
/*  348: 349 */     this.label8.setVisible(false);
/*  349: 350 */     this.panel1.add(this.label8, new GridBagConstraints(3, 4, 1, 1, 0.0D, 0.0D, 
/*  350: 351 */       10, 3, 
/*  351: 352 */       new Insets(0, 0, 5, 5), 0, 0));
/*  352:     */     
/*  353:     */ 
/*  354: 355 */     this.button2.setText("Public key");
/*  355: 356 */     this.button2.addActionListener(new ActionListener()
/*  356:     */     {
/*  357:     */       public void actionPerformed(ActionEvent e)
/*  358:     */       {
/*  359: 358 */         Graphical.this.savePublicKeyButtonActionPerformed(e);
/*  360:     */       }
/*  361: 360 */     });
/*  362: 361 */     this.panel1.add(this.button2, new GridBagConstraints(5, 4, 1, 1, 0.0D, 0.0D, 
/*  363: 362 */       10, 1, 
/*  364: 363 */       new Insets(0, 0, 5, 5), 0, 0));
/*  365:     */     
/*  366:     */ 
/*  367: 366 */     this.button9.setText("Public key");
/*  368: 367 */     this.button9.addActionListener(new ActionListener()
/*  369:     */     {
/*  370:     */       public void actionPerformed(ActionEvent e)
/*  371:     */       {
/*  372: 369 */         Graphical.this.loadPublicKeyButtonActionPerformed(e);
/*  373:     */       }
/*  374: 371 */     });
/*  375: 372 */     this.panel1.add(this.button9, new GridBagConstraints(6, 4, 1, 1, 0.0D, 0.0D, 
/*  376: 373 */       10, 1, 
/*  377: 374 */       new Insets(0, 0, 5, 5), 0, 0));
/*  378:     */     
/*  379:     */ 
/*  380: 377 */     this.button1.setText("Create keys");
/*  381: 378 */     this.button1.addActionListener(new ActionListener()
/*  382:     */     {
/*  383:     */       public void actionPerformed(ActionEvent e)
/*  384:     */       {
/*  385: 380 */         Graphical.this.createKeysButtonActionPerformed(e);
/*  386:     */       }
/*  387: 382 */     });
/*  388: 383 */     this.panel1.add(this.button1, new GridBagConstraints(1, 5, 1, 1, 0.0D, 0.0D, 
/*  389: 384 */       10, 1, 
/*  390: 385 */       new Insets(0, 0, 5, 5), 0, 0));
/*  391: 386 */     this.panel1.add(this.textField6, new GridBagConstraints(3, 5, 1, 1, 0.0D, 0.0D, 
/*  392: 387 */       10, 1, 
/*  393: 388 */       new Insets(0, 0, 5, 5), 0, 0));
/*  394:     */     
/*  395: 390 */     this.textField6.setVisible(false);
/*  396:     */     
/*  397:     */ 
/*  398: 393 */     this.button7.setText("Private key");
/*  399: 394 */     this.button7.addActionListener(new ActionListener()
/*  400:     */     {
/*  401:     */       public void actionPerformed(ActionEvent e)
/*  402:     */       {
/*  403: 396 */         Graphical.this.savePrivateKeyButtonActionPerformed(e);
/*  404:     */       }
/*  405: 398 */     });
/*  406: 399 */     this.panel1.add(this.button7, new GridBagConstraints(5, 5, 1, 1, 0.0D, 0.0D, 
/*  407: 400 */       10, 1, 
/*  408: 401 */       new Insets(0, 0, 5, 5), 0, 0));
/*  409:     */     
/*  410:     */ 
/*  411: 404 */     this.button10.setText("Private key");
/*  412: 405 */     this.button10.addActionListener(new ActionListener()
/*  413:     */     {
/*  414:     */       public void actionPerformed(ActionEvent e)
/*  415:     */       {
/*  416: 407 */         Graphical.this.loadPrivateKeyButtonActionPerformed(e);
/*  417:     */       }
/*  418: 409 */     });
/*  419: 410 */     this.panel1.add(this.button10, new GridBagConstraints(6, 5, 1, 1, 0.0D, 0.0D, 
/*  420: 411 */       10, 1, 
/*  421: 412 */       new Insets(0, 0, 5, 5), 0, 0));
/*  422:     */     
/*  423: 414 */     contentPane.add(this.panel1, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/*  424: 415 */       10, 3, 
/*  425: 416 */       new Insets(0, 0, 0, 0), 0, 0));
/*  426:     */     
/*  427:     */ 
/*  428:     */ 
/*  429: 420 */     this.panel2 = new GPanel(this.panelColor, new GridBagLayout());
/*  430: 421 */     ((GridBagLayout)this.panel2.getLayout()).columnWidths = new int[] { 10, 435, 5 };
/*  431: 422 */     ((GridBagLayout)this.panel2.getLayout()).rowHeights = new int[] { 71, 5 };
/*  432: 423 */     ((GridBagLayout)this.panel2.getLayout()).columnWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0001D };
/*  433: 424 */     ((GridBagLayout)this.panel2.getLayout()).rowWeights = new double[] { 0.0D, 0.0D, 0.0001D };
/*  434:     */     
/*  435: 426 */     this.panel2.setBorder(new TitledBorder(new LineBorder(Color.gray, 1, true), "Message to encrypt/decrypt"));
/*  436:     */     
/*  437:     */ 
/*  438:     */ 
/*  439:     */ 
/*  440:     */ 
/*  441: 432 */     this.textArea2.setLineWrap(true);
/*  442: 433 */     this.textArea2.setWrapStyleWord(true);
/*  443: 434 */     this.clipboard.createPopupMenu(this.textArea2);
/*  444: 435 */     this.scrollPane2.setViewportView(this.textArea2);
/*  445:     */     
/*  446: 437 */     this.panel2.add(this.scrollPane2, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  447: 438 */       10, 1, 
/*  448: 439 */       new Insets(0, 0, 5, 5), 0, 0));
/*  449:     */     
/*  450: 441 */     contentPane.add(this.panel2, new GridBagConstraints(1, 5, 1, 1, 0.0D, 0.0D, 
/*  451: 442 */       10, 1, 
/*  452: 443 */       new Insets(0, 0, 0, 0), 0, 0));
/*  453:     */     
/*  454:     */ 
/*  455:     */ 
/*  456: 447 */     this.panel3.setLayout(new GridBagLayout());
/*  457: 448 */     ((GridBagLayout)this.panel3.getLayout()).columnWidths = new int[] { 155, 105, 20, 105, 150 };
/*  458: 449 */     ((GridBagLayout)this.panel3.getLayout()).rowHeights = new int[] { 28 };
/*  459: 450 */     ((GridBagLayout)this.panel3.getLayout()).columnWeights = new double[] { 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0001D };
/*  460: 451 */     ((GridBagLayout)this.panel3.getLayout()).rowWeights = new double[] { 0.0D, 0.0001D };
/*  461:     */     
/*  462:     */ 
/*  463: 454 */     this.button3.setText("Encrypt");
/*  464: 455 */     this.button3.addActionListener(new ActionListener()
/*  465:     */     {
/*  466:     */       public void actionPerformed(ActionEvent e)
/*  467:     */       {
/*  468: 457 */         Graphical.this.encryptButtonActionPerformed(e);
/*  469:     */       }
/*  470: 459 */     });
/*  471: 460 */     this.panel3.add(this.button3, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  472: 461 */       10, 1, 
/*  473: 462 */       new Insets(0, 0, 0, 5), 0, 0));
/*  474:     */     
/*  475:     */ 
/*  476: 465 */     this.button4.setText("Decrypt");
/*  477: 466 */     this.button4.addActionListener(new ActionListener()
/*  478:     */     {
/*  479:     */       public void actionPerformed(ActionEvent e)
/*  480:     */       {
/*  481: 468 */         Graphical.this.decryptButtonActionPerformed(e);
/*  482:     */       }
/*  483: 470 */     });
/*  484: 471 */     this.panel3.add(this.button4, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/*  485: 472 */       10, 1, 
/*  486: 473 */       new Insets(0, 0, 0, 5), 0, 0));
/*  487:     */     
/*  488: 475 */     contentPane.add(this.panel3, new GridBagConstraints(1, 9, 1, 1, 0.0D, 0.0D, 
/*  489: 476 */       10, 1, 
/*  490: 477 */       new Insets(0, 0, 0, 0), 0, 0));
/*  491:     */     
/*  492:     */ 
/*  493:     */ 
/*  494: 481 */     this.panel4 = new GPanel(this.panelColor, new GridBagLayout());
/*  495: 482 */     this.panel4.setBorder(new TitledBorder(new LineBorder(Color.gray, 1, true), "Padding scheme"));
/*  496: 483 */     ((GridBagLayout)this.panel4.getLayout()).columnWidths = new int[] { 80, 81, 80 };
/*  497: 484 */     ((GridBagLayout)this.panel4.getLayout()).rowHeights = new int[2];
/*  498: 485 */     ((GridBagLayout)this.panel4.getLayout()).columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0001D };
/*  499: 486 */     ((GridBagLayout)this.panel4.getLayout()).rowWeights = new double[] { 0.0D, 0.0001D };
/*  500:     */     
/*  501:     */ 
/*  502: 489 */     this.radioButton3.setText("One letter");
/*  503: 490 */     this.radioButton3.setOpaque(false);
/*  504: 491 */     this.radioButton3.setSelected(true);
/*  505: 492 */     this.panel4.add(this.radioButton3, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  506: 493 */       10, 1, 
/*  507: 494 */       new Insets(0, 0, 0, 5), 0, 0));
/*  508:     */     
/*  509:     */ 
/*  510: 497 */     this.radioButton4.setText("Two letters");
/*  511: 498 */     this.radioButton4.setOpaque(false);
/*  512: 499 */     this.panel4.add(this.radioButton4, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  513: 500 */       10, 1, 
/*  514: 501 */       new Insets(0, 0, 0, 5), 0, 0));
/*  515:     */     
/*  516:     */ 
/*  517: 504 */     this.radioButton5.setText("Three letters");
/*  518: 505 */     this.radioButton5.setOpaque(false);
/*  519: 506 */     this.panel4.add(this.radioButton5, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/*  520: 507 */       10, 1, 
/*  521: 508 */       new Insets(0, 0, 0, 0), 0, 0));
/*  522:     */     
/*  523: 510 */     contentPane.add(this.panel4, new GridBagConstraints(1, 7, 1, 1, 0.0D, 0.0D, 
/*  524: 511 */       10, 1, 
/*  525: 512 */       new Insets(0, 0, 0, 0), 0, 0));
/*  526:     */     
/*  527:     */ 
/*  528:     */ 
/*  529: 516 */     this.panel5 = new GPanel(this.panelColor, new GridBagLayout());
/*  530: 517 */     ((GridBagLayout)this.panel5.getLayout()).columnWidths = new int[] { 10, 0, 5 };
/*  531: 518 */     ((GridBagLayout)this.panel5.getLayout()).rowHeights = new int[] { 210 };
/*  532: 519 */     ((GridBagLayout)this.panel5.getLayout()).columnWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0001D };
/*  533: 520 */     ((GridBagLayout)this.panel5.getLayout()).rowWeights = new double[] { 0.0D, 0.0D, 0.0001D };
/*  534:     */     
/*  535: 522 */     this.panel5.setBorder(new TitledBorder(new LineBorder(Color.gray, 1, true), "RSA execution"));
/*  536:     */     
/*  537:     */ 
/*  538:     */ 
/*  539: 526 */     this.scrollPane1.setViewportView(this.textArea1);
/*  540:     */     
/*  541:     */ 
/*  542: 529 */     this.clipboard.createPopupMenu(this.textArea1);
/*  543:     */     
/*  544: 531 */     this.panel5.add(this.scrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  545: 532 */       10, 1, 
/*  546: 533 */       new Insets(0, 0, 5, 5), 0, 0));
/*  547:     */     
/*  548: 535 */     contentPane.add(this.panel5, new GridBagConstraints(1, 11, 1, 1, 0.0D, 0.0D, 
/*  549: 536 */       10, 1, 
/*  550: 537 */       new Insets(0, 0, 0, 0), 0, 0));
/*  551:     */     
/*  552:     */ 
/*  553:     */ 
/*  554:     */ 
/*  555: 542 */     this.panel6.setLayout(new GridBagLayout());
/*  556: 543 */     ((GridBagLayout)this.panel6.getLayout()).columnWidths = new int[] { 0, 0, 15, 65, 55, 15, 119, 90 };
/*  557: 544 */     ((GridBagLayout)this.panel6.getLayout()).rowHeights = new int[2];
/*  558: 545 */     ((GridBagLayout)this.panel6.getLayout()).columnWeights = new double[] { 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0001D };
/*  559: 546 */     ((GridBagLayout)this.panel6.getLayout()).rowWeights = new double[] { 0.0D, 0.0001D };
/*  560:     */     
/*  561:     */ 
/*  562: 549 */     this.button5.setText("Save to file");
/*  563: 550 */     this.button5.addActionListener(new ActionListener()
/*  564:     */     {
/*  565:     */       public void actionPerformed(ActionEvent e)
/*  566:     */       {
/*  567: 552 */         Graphical.this.saveExecutionButtonActionPerformed(e);
/*  568:     */       }
/*  569: 554 */     });
/*  570: 555 */     this.panel6.add(this.button5, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  571: 556 */       10, 1, 
/*  572: 557 */       new Insets(0, 0, 0, 5), 0, 0));
/*  573:     */     
/*  574:     */ 
/*  575: 560 */     this.button6.setText("Load from file");
/*  576: 561 */     this.button6.addActionListener(new ActionListener()
/*  577:     */     {
/*  578:     */       public void actionPerformed(ActionEvent e)
/*  579:     */       {
/*  580: 563 */         Graphical.this.loadExecutionButtonActionPerformed(e);
/*  581:     */       }
/*  582: 565 */     });
/*  583: 566 */     this.panel6.add(this.button6, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/*  584: 567 */       10, 1, 
/*  585: 568 */       new Insets(0, 0, 0, 5), 0, 0));
/*  586:     */     
/*  587:     */ 
/*  588: 571 */     this.button12.setText("Clear");
/*  589: 572 */     this.button12.addActionListener(new ActionListener()
/*  590:     */     {
/*  591:     */       public void actionPerformed(ActionEvent e)
/*  592:     */       {
/*  593: 574 */         Graphical.this.ClearExecButtonActionPerformed(e);
/*  594:     */       }
/*  595: 576 */     });
/*  596: 577 */     this.panel6.add(this.button12, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/*  597: 578 */       10, 1, 
/*  598: 579 */       new Insets(0, 0, 0, 5), 0, 0));
/*  599:     */     
/*  600:     */ 
/*  601: 582 */     this.button13.setText("Copy to clipboard");
/*  602: 583 */     this.button13.addActionListener(new ActionListener()
/*  603:     */     {
/*  604:     */       public void actionPerformed(ActionEvent e)
/*  605:     */       {
/*  606: 585 */         Graphical.this.copyToClipboardButtonActionPerformed(e);
/*  607:     */       }
/*  608: 587 */     });
/*  609: 588 */     this.panel6.add(this.button13, new GridBagConstraints(4, 0, 1, 1, 0.0D, 0.0D, 
/*  610: 589 */       10, 1, 
/*  611: 590 */       new Insets(0, 0, 0, 5), 0, 0));
/*  612:     */     
/*  613:     */ 
/*  614: 593 */     this.comboBox1.addActionListener(new ActionListener()
/*  615:     */     {
/*  616:     */       public void actionPerformed(ActionEvent e)
/*  617:     */       {
/*  618: 595 */         Graphical.this.fontSizeComboBoxActionPerformed(e);
/*  619:     */       }
/*  620: 597 */     });
/*  621: 598 */     this.panel6.add(this.comboBox1, new GridBagConstraints(6, 0, 1, 1, 0.0D, 0.0D, 
/*  622: 599 */       10, 1, 
/*  623: 600 */       new Insets(0, 0, 0, 5), 0, 0));
/*  624:     */     
/*  625:     */ 
/*  626: 603 */     this.button8.setText("Full screen");
/*  627: 604 */     this.button8.setPreferredSize(new Dimension(100, 23));
/*  628: 605 */     this.button8.setMaximumSize(new Dimension(100, 23));
/*  629: 606 */     this.button8.setMinimumSize(new Dimension(100, 23));
/*  630: 607 */     this.button8.addActionListener(new ActionListener()
/*  631:     */     {
/*  632:     */       public void actionPerformed(ActionEvent e)
/*  633:     */       {
/*  634: 609 */         Graphical.this.fullScreenButtonActionPerformed(e);
/*  635:     */       }
/*  636: 611 */     });
/*  637: 612 */     this.panel6.add(this.button8, new GridBagConstraints(7, 0, 1, 1, 0.0D, 0.0D, 
/*  638: 613 */       13, 3, 
/*  639: 614 */       new Insets(0, 0, 0, 0), 0, 0));
/*  640:     */     
/*  641: 616 */     contentPane.add(this.panel6, new GridBagConstraints(1, 13, 1, 1, 0.0D, 0.0D, 
/*  642: 617 */       10, 1, 
/*  643: 618 */       new Insets(0, 0, 0, 0), 0, 0));
/*  644:     */     
/*  645:     */ 
/*  646:     */ 
/*  647: 622 */     this.panel7.setLayout(new GridBagLayout());
/*  648: 623 */     ((GridBagLayout)this.panel7.getLayout()).columnWidths = new int[] { 0, 10, 0, 10 };
/*  649: 624 */     ((GridBagLayout)this.panel7.getLayout()).rowHeights = new int[2];
/*  650: 625 */     ((GridBagLayout)this.panel7.getLayout()).columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0001D };
/*  651: 626 */     ((GridBagLayout)this.panel7.getLayout()).rowWeights = new double[] { 0.0D, 0.0001D };
/*  652:     */     
/*  653:     */ 
/*  654: 629 */     this.radioButton1.setText("Teach mode");
/*  655: 630 */     this.radioButton1.setSelected(true);
/*  656: 631 */     this.radioButton1.setActionCommand("Teach mode");
/*  657: 632 */     this.radioButton1.addActionListener(new ActionListener()
/*  658:     */     {
/*  659:     */       public void actionPerformed(ActionEvent e)
/*  660:     */       {
/*  661: 634 */         Graphical.this.teachModeRadioButtonActionPerformed(e);
/*  662:     */       }
/*  663: 636 */     });
/*  664: 637 */     this.panel7.add(this.radioButton1, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/*  665: 638 */       10, 1, 
/*  666: 639 */       new Insets(0, 0, 0, 5), 0, 0));
/*  667:     */     
/*  668:     */ 
/*  669: 642 */     this.radioButton2.setText("Secure mode");
/*  670: 643 */     this.radioButton2.setActionCommand("Secure mode");
/*  671: 644 */     this.radioButton2.addActionListener(new ActionListener()
/*  672:     */     {
/*  673:     */       public void actionPerformed(ActionEvent e)
/*  674:     */       {
/*  675: 646 */         Graphical.this.secureModeRadioButtonActionPerformed(e);
/*  676:     */       }
/*  677: 648 */     });
/*  678: 649 */     this.panel7.add(this.radioButton2, new GridBagConstraints(2, 0, 1, 1, 0.0D, 0.0D, 
/*  679: 650 */       10, 1, 
/*  680: 651 */       new Insets(0, 0, 0, 5), 0, 0));
/*  681:     */     
/*  682: 653 */     contentPane.add(this.panel7, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/*  683: 654 */       10, 1, 
/*  684: 655 */       new Insets(0, 0, 0, 0), 0, 0));
/*  685:     */     
/*  686: 657 */     setSize(750, 775);
/*  687: 658 */     setLocationRelativeTo(null);
/*  688: 659 */     toFront();
/*  689: 660 */     setVisible(true);
/*  690:     */     
/*  691:     */ 
/*  692: 663 */     this.buttonGroup1.add(this.radioButton1);
/*  693: 664 */     this.buttonGroup1.add(this.radioButton2);
/*  694:     */     
/*  695:     */ 
/*  696: 667 */     this.buttonGroup2.add(this.radioButton3);
/*  697: 668 */     this.buttonGroup2.add(this.radioButton4);
/*  698: 669 */     this.buttonGroup2.add(this.radioButton5);
/*  699:     */   }
/*  700:     */   
/*  701:     */   private void teachModeRadioButtonActionPerformed(ActionEvent e)
/*  702:     */   {
/*  703: 679 */     teachModeButtonPressed();
/*  704:     */   }
/*  705:     */   
/*  706:     */   private void secureModeRadioButtonActionPerformed(ActionEvent e)
/*  707:     */   {
/*  708: 687 */     secureModeButtonPressed();
/*  709:     */   }
/*  710:     */   
/*  711:     */   private void quitMenuItemActionPerformed(ActionEvent e)
/*  712:     */   {
/*  713: 695 */     dispose();
/*  714:     */   }
/*  715:     */   
/*  716:     */   private void showHelpMenuItemActionPerformed(ActionEvent e)
/*  717:     */   {
/*  718: 703 */     new Help().toFront();
/*  719:     */   }
/*  720:     */   
/*  721:     */   private void aboutMenuItemActionPerformed(ActionEvent e)
/*  722:     */   {
/*  723: 711 */     showAbout();
/*  724:     */   }
/*  725:     */   
/*  726:     */   private void savePublicKeyButtonActionPerformed(ActionEvent e)
/*  727:     */   {
/*  728: 719 */     savePublicKey();
/*  729:     */   }
/*  730:     */   
/*  731:     */   private void loadPublicKeyButtonActionPerformed(ActionEvent e)
/*  732:     */   {
/*  733: 727 */     loadPublicKey();
/*  734:     */   }
/*  735:     */   
/*  736:     */   private void savePrivateKeyButtonActionPerformed(ActionEvent e)
/*  737:     */   {
/*  738: 735 */     savePrivateKey();
/*  739:     */   }
/*  740:     */   
/*  741:     */   private void loadPrivateKeyButtonActionPerformed(ActionEvent e)
/*  742:     */   {
/*  743: 743 */     loadPrivateKey();
/*  744:     */   }
/*  745:     */   
/*  746:     */   private void encryptButtonActionPerformed(ActionEvent e)
/*  747:     */   {
/*  748: 751 */     encrypt();
/*  749:     */   }
/*  750:     */   
/*  751:     */   private void decryptButtonActionPerformed(ActionEvent e)
/*  752:     */   {
/*  753: 759 */     decrypt();
/*  754:     */   }
/*  755:     */   
/*  756:     */   private void saveExecutionButtonActionPerformed(ActionEvent e)
/*  757:     */   {
/*  758: 767 */     saveExecution();
/*  759:     */   }
/*  760:     */   
/*  761:     */   private void loadExecutionButtonActionPerformed(ActionEvent e)
/*  762:     */   {
/*  763: 775 */     loadExecution();
/*  764:     */   }
/*  765:     */   
/*  766:     */   private void fontSizeComboBoxActionPerformed(ActionEvent e)
/*  767:     */   {
/*  768: 783 */     fontSizeChange();
/*  769:     */   }
/*  770:     */   
/*  771:     */   private void fullScreenButtonActionPerformed(ActionEvent e)
/*  772:     */   {
/*  773: 791 */     showExecFullScreen();
/*  774:     */   }
/*  775:     */   
/*  776:     */   private void createKeysButtonActionPerformed(ActionEvent e)
/*  777:     */   {
/*  778: 799 */     createKeys();
/*  779:     */   }
/*  780:     */   
/*  781:     */   private void clearKeysButtonActionPerformed(ActionEvent e)
/*  782:     */   {
/*  783: 808 */     clearKeyTextFields();
/*  784:     */     
/*  785: 810 */     this.publicKey = null;
/*  786: 811 */     this.privateKey = null;
/*  787:     */   }
/*  788:     */   
/*  789:     */   private void ClearExecButtonActionPerformed(ActionEvent e)
/*  790:     */   {
/*  791: 820 */     this.textArea1.setText("");
/*  792:     */   }
/*  793:     */   
/*  794:     */   private void copyToClipboardButtonActionPerformed(ActionEvent e)
/*  795:     */   {
/*  796: 828 */     new ClipboardCopyPaste().copy(this.textArea1.getText());
/*  797:     */   }
/*  798:     */   
/*  799:     */   private void clearKeyTextFields()
/*  800:     */   {
/*  801: 839 */     this.textField1.setText("");
/*  802: 840 */     this.textField2.setText("");
/*  803: 841 */     this.textField3.setText("");
/*  804: 842 */     this.textField4.setText("");
/*  805: 843 */     this.textField5.setText("");
/*  806:     */   }
/*  807:     */   
/*  808:     */   private void createKeys()
/*  809:     */   {
/*  810: 851 */     if (this.buttonGroup1.getSelection().getActionCommand().equals("Teach mode")) {
/*  811:     */       try
/*  812:     */       {
/*  813: 854 */         BigInteger p = new BigInteger(this.textField1.getText());
/*  814: 855 */         BigInteger q = new BigInteger(this.textField2.getText());
/*  815: 856 */         BigInteger e = new BigInteger(this.textField3.getText());
/*  816:     */         
/*  817: 858 */         EGenUK genKeys = new EGenUK();
/*  818: 861 */         if (genKeys.testInputEligibility(p, q, e))
/*  819:     */         {
/*  820: 863 */           setCursor(Cursor.getPredefinedCursor(3));
/*  821: 864 */           genKeys.createKeys(p, q, e);
/*  822: 865 */           setCursor(Cursor.getPredefinedCursor(0));
/*  823:     */           
/*  824: 867 */           this.publicKey = genKeys.getPublicKey();
/*  825: 868 */           this.privateKey = genKeys.getPrivateKey();
/*  826:     */           
/*  827:     */ 
/*  828: 871 */           this.textField4.setText(this.publicKey.getN().toString());
/*  829: 872 */           this.textField5.setText(this.privateKey.getPrivateExponent().toString());
/*  830:     */         }
/*  831:     */         else
/*  832:     */         {
/*  833: 875 */           genKeys.showInputError(this, p, q, e);
/*  834:     */         }
/*  835:     */       }
/*  836:     */       catch (Exception e)
/*  837:     */       {
/*  838: 878 */         JOptionPane.showMessageDialog(this, "Key creation error.", "Error", 0);
/*  839:     */       }
/*  840: 882 */     } else if (this.buttonGroup1.getSelection().getActionCommand().equals("Secure mode")) {
/*  841: 884 */       if (this.textField6.getText().equals(""))
/*  842:     */       {
/*  843: 885 */         JOptionPane.showMessageDialog(this, "Bitsize field is empty.", "Bitsize error", 0);
/*  844:     */       }
/*  845:     */       else
/*  846:     */       {
/*  847: 887 */         int value = 0;
/*  848: 888 */         if (Integer.parseInt(this.textField6.getText()) > 2048) {
/*  849: 890 */           value = JOptionPane.showConfirmDialog(this, "Are you sure you want to create primes larger than 2048 bits? It will take some time.", "Large bitsize warning", 2, 1);
/*  850:     */         }
/*  851: 892 */         if (value == 0) {
/*  852: 893 */           if (Integer.parseInt(this.textField6.getText()) <= 5)
/*  853:     */           {
/*  854: 894 */             JOptionPane.showMessageDialog(this, "Prime bitsize must be larger than 5.", "Bitsize error", 0);
/*  855:     */           }
/*  856:     */           else
/*  857:     */           {
/*  858: 896 */             setCursor(Cursor.getPredefinedCursor(3));
/*  859: 897 */             EnhanceGenerateKeys genKeys = new EnhanceGenerateKeys(Integer.parseInt(this.textField6.getText()));
/*  860: 898 */             this.publicKey = genKeys.getPublicKey();
/*  861: 899 */             this.privateKey = genKeys.getPrivateKey();
/*  862: 900 */             setCursor(Cursor.getPredefinedCursor(0));
/*  863:     */           }
/*  864:     */         }
/*  865:     */       }
/*  866:     */     }
/*  867:     */   }
/*  868:     */   
/*  869:     */   private void savePublicKey()
/*  870:     */   {
/*  871: 911 */     if (this.publicKey != null)
/*  872:     */     {
/*  873: 912 */       this.openSave = new OS(this);
/*  874: 913 */       this.openSave.savePublicKey(this.publicKey);
/*  875:     */     }
/*  876:     */     else
/*  877:     */     {
/*  878: 915 */       JOptionPane.showMessageDialog(this, "Public key is not created.", "Public key save error", 0);
/*  879:     */     }
/*  880:     */   }
/*  881:     */   
/*  882:     */   private void loadPublicKey()
/*  883:     */   {
/*  884: 923 */     this.openSave = new OS(this);
/*  885: 924 */     RsaP pubKey = null;
/*  886:     */     try
/*  887:     */     {
/*  888: 926 */       pubKey = this.openSave.loadPublicKey();
/*  889:     */     }
/*  890:     */     catch (Exception e)
/*  891:     */     {
/*  892: 928 */       JOptionPane.showMessageDialog(this, "Public key couldn't be loaded.", "Public key load error", 0);
/*  893:     */     }
/*  894: 930 */     if (pubKey != null)
/*  895:     */     {
/*  896: 931 */       clearKeyTextFields();
/*  897: 932 */       this.publicKey = pubKey;
/*  898: 933 */       this.privateKey = null;
/*  899: 934 */       if (this.buttonGroup1.getSelection().getActionCommand().equals("Teach mode"))
/*  900:     */       {
/*  901: 936 */         this.textField3.setText(this.publicKey.getE().toString());
/*  902: 937 */         this.textField4.setText(this.publicKey.getN().toString());
/*  903:     */         
/*  904:     */ 
/*  905: 940 */         this.textField1.setText("");
/*  906: 941 */         this.textField2.setText("");
/*  907: 942 */         this.textField5.setText("");
/*  908:     */       }
/*  909:     */     }
/*  910:     */   }
/*  911:     */   
/*  912:     */   private void savePrivateKey()
/*  913:     */   {
/*  914: 951 */     if (this.privateKey != null)
/*  915:     */     {
/*  916: 952 */       this.openSave = new OS(this);
/*  917: 953 */       this.openSave.savePrivateKey(this.privateKey);
/*  918:     */     }
/*  919:     */     else
/*  920:     */     {
/*  921: 955 */       JOptionPane.showMessageDialog(this, "Private key is not created.", "Private key save error", 0);
/*  922:     */     }
/*  923:     */   }
/*  924:     */   
/*  925:     */   private void loadPrivateKey()
/*  926:     */   {
/*  927: 963 */     this.openSave = new OS(this);
/*  928: 964 */     RsaPK privKey = null;
/*  929:     */     try
/*  930:     */     {
/*  931: 967 */       privKey = this.openSave.loadPrivateKey();
/*  932:     */     }
/*  933:     */     catch (Exception e)
/*  934:     */     {
/*  935: 969 */       JOptionPane.showMessageDialog(this, "Private key couldn't be loaded.", "Private key load error", 0);
/*  936:     */     }
/*  937: 971 */     if (privKey != null)
/*  938:     */     {
/*  939: 972 */       this.privateKey = privKey;
/*  940: 973 */       this.publicKey = new RsaP(this.privateKey.getN(), this.privateKey.getE());
/*  941: 974 */       if (this.buttonGroup1.getSelection().getActionCommand().equals("Teach mode"))
/*  942:     */       {
/*  943: 975 */         this.textField1.setText(this.privateKey.getPrimeP().toString());
/*  944: 976 */         this.textField2.setText(this.privateKey.getPrimeQ().toString());
/*  945: 977 */         this.textField3.setText(this.privateKey.getE().toString());
/*  946: 978 */         this.textField4.setText(this.privateKey.getN().toString());
/*  947: 979 */         this.textField5.setText(this.privateKey.getPrivateExponent().toString());
/*  948:     */       }
/*  949:     */     }
/*  950:     */   }
/*  951:     */   
/*  952:     */   private void saveExecution()
/*  953:     */   {
/*  954: 988 */     new LoadSaveExec(this, this.textArea1).saveExecToFile();
/*  955:     */   }
/*  956:     */   
/*  957:     */   private void loadExecution()
/*  958:     */   {
/*  959: 995 */     new LoadSaveExec(this, this.textArea1).loadExecFromFile();
/*  960:     */   }
/*  961:     */   
/*  962:     */   private void showExecFullScreen()
/*  963:     */   {
/*  964:1002 */     new FScreen(this.textArea1);
/*  965:     */   }
/*  966:     */   
/*  967:     */   private void encrypt()
/*  968:     */   {
/*  969:1009 */     if (this.publicKey == null) {
/*  970:1010 */       JOptionPane.showMessageDialog(this, "Public key not created", "Public key error", 0);
/*  971:     */     }
/*  972:1013 */     if (this.buttonGroup1.getSelection().getActionCommand().equals("Teach mode"))
/*  973:     */     {
/*  974:1015 */       if (this.radioButton3.isSelected())
/*  975:     */       {
/*  976:1017 */         String plaintext = this.textArea2.getText().toUpperCase();
/*  977:1019 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/*  978:1021 */           if (this.publicKey.getN().compareTo(new BigInteger("25")) > 0) {
/*  979:     */             try
/*  980:     */             {
/*  981:1024 */               this.textArea1.setText(this.padding1.getEnCrypted(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/*  982:1025 */               this.textArea1.setCaretPosition(0);
/*  983:     */             }
/*  984:     */             catch (Exception e)
/*  985:     */             {
/*  986:1027 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/*  987:     */             }
/*  988:     */           } else {
/*  989:1030 */             JOptionPane.showMessageDialog(this, "One letter padding scheme requires n > 25", "Input error", 0);
/*  990:     */           }
/*  991:     */         }
/*  992:     */       }
/*  993:1035 */       else if (this.radioButton4.isSelected())
/*  994:     */       {
/*  995:1037 */         String plaintext = this.textArea2.getText().toUpperCase();
/*  996:1039 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/*  997:1041 */           if (this.publicKey.getN().compareTo(new BigInteger("2525")) > 0) {
/*  998:     */             try
/*  999:     */             {
/* 1000:1044 */               this.textArea1.setText(this.padding2.getEnCrypted(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/* 1001:1045 */               this.textArea1.setCaretPosition(0);
/* 1002:     */             }
/* 1003:     */             catch (Exception e)
/* 1004:     */             {
/* 1005:1047 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/* 1006:     */             }
/* 1007:     */           } else {
/* 1008:1050 */             JOptionPane.showMessageDialog(this, "Two letters padding scheme requires n > 2525", "Input error", 0);
/* 1009:     */           }
/* 1010:     */         }
/* 1011:     */       }
/* 1012:1055 */       else if (this.radioButton5.isSelected())
/* 1013:     */       {
/* 1014:1057 */         String plaintext = this.textArea2.getText().toUpperCase();
/* 1015:1059 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/* 1016:1061 */           if (this.publicKey.getN().compareTo(new BigInteger("17575")) > 0) {
/* 1017:     */             try
/* 1018:     */             {
/* 1019:1064 */               this.textArea1.setText(this.padding3.getEncodeAndEncryptBlocksOfThree(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/* 1020:1065 */               this.textArea1.setCaretPosition(0);
/* 1021:     */             }
/* 1022:     */             catch (Exception e)
/* 1023:     */             {
/* 1024:1067 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/* 1025:     */             }
/* 1026:     */           } else {
/* 1027:1070 */             JOptionPane.showMessageDialog(this, "Three letters padding scheme letters requires n > 17575", "Input error", 0);
/* 1028:     */           }
/* 1029:     */         }
/* 1030:     */       }
/* 1031:     */     }
/* 1032:1076 */     else if (this.buttonGroup1.getSelection().getActionCommand().equals("Secure mode")) {
/* 1033:1078 */       if (this.radioButton3.isSelected())
/* 1034:     */       {
/* 1035:1080 */         String plaintext = this.textArea2.getText().toUpperCase();
/* 1036:1082 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/* 1037:1084 */           if (this.publicKey.getN().compareTo(new BigInteger("25")) > 0) {
/* 1038:     */             try
/* 1039:     */             {
/* 1040:1087 */               this.textArea1.setText(this.padding1.getEnCryptedSecure(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/* 1041:1088 */               this.textArea1.setCaretPosition(0);
/* 1042:     */             }
/* 1043:     */             catch (Exception e)
/* 1044:     */             {
/* 1045:1090 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/* 1046:     */             }
/* 1047:     */           } else {
/* 1048:1093 */             JOptionPane.showMessageDialog(this, "One letter padding scheme requires n > 25", "Input error", 0);
/* 1049:     */           }
/* 1050:     */         }
/* 1051:     */       }
/* 1052:1098 */       else if (this.radioButton4.isSelected())
/* 1053:     */       {
/* 1054:1100 */         String plaintext = this.textArea2.getText().toUpperCase();
/* 1055:1102 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/* 1056:1104 */           if (this.publicKey.getN().compareTo(new BigInteger("2525")) > 0) {
/* 1057:     */             try
/* 1058:     */             {
/* 1059:1107 */               this.textArea1.setText(this.padding2.getEnCryptedSecure(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/* 1060:1108 */               this.textArea1.setCaretPosition(0);
/* 1061:     */             }
/* 1062:     */             catch (Exception e)
/* 1063:     */             {
/* 1064:1110 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/* 1065:     */             }
/* 1066:     */           } else {
/* 1067:1113 */             JOptionPane.showMessageDialog(this, "Two letters padding scheme requires n > 2525", "Input error", 0);
/* 1068:     */           }
/* 1069:     */         }
/* 1070:     */       }
/* 1071:1118 */       else if (this.radioButton5.isSelected())
/* 1072:     */       {
/* 1073:1120 */         String plaintext = this.textArea2.getText().toUpperCase();
/* 1074:1122 */         if ((!plaintext.isEmpty()) && (this.publicKey != null)) {
/* 1075:1124 */           if (this.publicKey.getN().compareTo(new BigInteger("17575")) > 0) {
/* 1076:     */             try
/* 1077:     */             {
/* 1078:1127 */               this.textArea1.setText(this.padding3.getEncodeAndEncryptSecure(plaintext, this.publicKey.getPublicExponent(), this.publicKey.getModulus()));
/* 1079:1128 */               this.textArea1.setCaretPosition(0);
/* 1080:     */             }
/* 1081:     */             catch (Exception e)
/* 1082:     */             {
/* 1083:1130 */               JOptionPane.showMessageDialog(this, "Only letters A - Z are allowed.", "Input error", 0);
/* 1084:     */             }
/* 1085:     */           } else {
/* 1086:1133 */             JOptionPane.showMessageDialog(this, "Three letters padding scheme letters requires n > 17575", "Input error", 0);
/* 1087:     */           }
/* 1088:     */         }
/* 1089:     */       }
/* 1090:     */     }
/* 1091:     */   }
/* 1092:     */   
/* 1093:     */   private void decrypt()
/* 1094:     */   {
/* 1095:1144 */     if (this.privateKey == null) {
/* 1096:1145 */       JOptionPane.showMessageDialog(this, "Private key not created", "Private key error", 0);
/* 1097:     */     }
/* 1098:1148 */     if (this.buttonGroup1.getSelection().getActionCommand().equals("Teach mode"))
/* 1099:     */     {
/* 1100:1150 */       if (this.radioButton3.isSelected())
/* 1101:     */       {
/* 1102:1152 */         String encrypted = this.textArea2.getText();
/* 1103:1154 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1104:1156 */           if (this.privateKey.getN().compareTo(new BigInteger("25")) > 0) {
/* 1105:     */             try
/* 1106:     */             {
/* 1107:1159 */               this.textArea1.setText(this.padding1.getDeCrypted(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1108:1160 */               this.textArea1.setCaretPosition(0);
/* 1109:     */             }
/* 1110:     */             catch (Exception e)
/* 1111:     */             {
/* 1112:1162 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1113:     */             }
/* 1114:     */           } else {
/* 1115:1165 */             JOptionPane.showMessageDialog(this, "One letter padding scheme requires n > 25", "Input error", 0);
/* 1116:     */           }
/* 1117:     */         }
/* 1118:     */       }
/* 1119:1170 */       else if (this.radioButton4.isSelected())
/* 1120:     */       {
/* 1121:1172 */         String encrypted = this.textArea2.getText();
/* 1122:1174 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1123:1176 */           if (this.privateKey.getN().compareTo(new BigInteger("2525")) > 0) {
/* 1124:     */             try
/* 1125:     */             {
/* 1126:1179 */               this.textArea1.setText(this.padding2.getDeCrypted(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1127:1180 */               this.textArea1.setCaretPosition(0);
/* 1128:     */             }
/* 1129:     */             catch (Exception e)
/* 1130:     */             {
/* 1131:1182 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1132:     */             }
/* 1133:     */           } else {
/* 1134:1185 */             JOptionPane.showMessageDialog(this, "Two letters padding scheme requires n > 2525", "Input error", 0);
/* 1135:     */           }
/* 1136:     */         }
/* 1137:     */       }
/* 1138:1190 */       else if (this.radioButton5.isSelected())
/* 1139:     */       {
/* 1140:1192 */         String encrypted = this.textArea2.getText();
/* 1141:1194 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1142:1196 */           if (this.privateKey.getN().compareTo(new BigInteger("17575")) > 0) {
/* 1143:     */             try
/* 1144:     */             {
/* 1145:1199 */               this.textArea1.setText(this.padding3.getDecryptAndDecodeBlocksOfThree(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1146:1200 */               this.textArea1.setCaretPosition(0);
/* 1147:     */             }
/* 1148:     */             catch (Exception e)
/* 1149:     */             {
/* 1150:1202 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1151:     */             }
/* 1152:     */           } else {
/* 1153:1205 */             JOptionPane.showMessageDialog(this, "Three letters padding scheme requires n > 17575", "Input error", 0);
/* 1154:     */           }
/* 1155:     */         }
/* 1156:     */       }
/* 1157:     */     }
/* 1158:1212 */     else if (this.buttonGroup1.getSelection().getActionCommand().equals("Secure mode")) {
/* 1159:1214 */       if (this.radioButton3.isSelected())
/* 1160:     */       {
/* 1161:1216 */         String encrypted = this.textArea2.getText();
/* 1162:1218 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1163:1220 */           if (this.privateKey.getN().compareTo(new BigInteger("25")) > 0) {
/* 1164:     */             try
/* 1165:     */             {
/* 1166:1223 */               this.textArea1.setText(this.padding1.getDeCryptedSecure(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1167:1224 */               this.textArea1.setCaretPosition(0);
/* 1168:     */             }
/* 1169:     */             catch (Exception e)
/* 1170:     */             {
/* 1171:1226 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1172:     */             }
/* 1173:     */           } else {
/* 1174:1229 */             JOptionPane.showMessageDialog(this, "One letter padding scheme requires n > 25", "Input error", 0);
/* 1175:     */           }
/* 1176:     */         }
/* 1177:     */       }
/* 1178:1234 */       else if (this.radioButton4.isSelected())
/* 1179:     */       {
/* 1180:1236 */         String encrypted = this.textArea2.getText();
/* 1181:1238 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1182:1240 */           if (this.privateKey.getN().compareTo(new BigInteger("2525")) > 0) {
/* 1183:     */             try
/* 1184:     */             {
/* 1185:1243 */               this.textArea1.setText(this.padding2.getDeCryptedSecure(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1186:1244 */               this.textArea1.setCaretPosition(0);
/* 1187:     */             }
/* 1188:     */             catch (Exception e)
/* 1189:     */             {
/* 1190:1246 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1191:     */             }
/* 1192:     */           } else {
/* 1193:1249 */             JOptionPane.showMessageDialog(this, "Two letters padding scheme requires n > 2525", "Input error", 0);
/* 1194:     */           }
/* 1195:     */         }
/* 1196:     */       }
/* 1197:1254 */       else if (this.radioButton5.isSelected())
/* 1198:     */       {
/* 1199:1256 */         String encrypted = this.textArea2.getText();
/* 1200:1258 */         if ((!encrypted.isEmpty()) && (this.privateKey != null)) {
/* 1201:1260 */           if (this.privateKey.getN().compareTo(new BigInteger("17575")) > 0) {
/* 1202:     */             try
/* 1203:     */             {
/* 1204:1263 */               this.textArea1.setText(this.padding3.getDecryptAndDecodeSecure(encrypted, this.privateKey.getPrivateExponent(), this.privateKey.getModulus()));
/* 1205:1264 */               this.textArea1.setCaretPosition(0);
/* 1206:     */             }
/* 1207:     */             catch (Exception e)
/* 1208:     */             {
/* 1209:1266 */               JOptionPane.showMessageDialog(this, "Not a genuine cryptotext.", "Input error", 0);
/* 1210:     */             }
/* 1211:     */           } else {
/* 1212:1269 */             JOptionPane.showMessageDialog(this, "Three letters padding scheme requires n > 17575", "Input error", 0);
/* 1213:     */           }
/* 1214:     */         }
/* 1215:     */       }
/* 1216:     */     }
/* 1217:     */   }
/* 1218:     */   
/* 1219:     */   private void fontSizeChange()
/* 1220:     */   {
/* 1221:1281 */     if (this.comboBox1.getSelectedItem() == "Font size 12 pt") {
/* 1222:1282 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 12));
/* 1223:1284 */     } else if (this.comboBox1.getSelectedItem() == "Font size 14 pt") {
/* 1224:1285 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 14));
/* 1225:1287 */     } else if (this.comboBox1.getSelectedItem() == "Font size 16 pt") {
/* 1226:1288 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 16));
/* 1227:1290 */     } else if (this.comboBox1.getSelectedItem() == "Font size 18 pt") {
/* 1228:1291 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 18));
/* 1229:1293 */     } else if (this.comboBox1.getSelectedItem() == "Font size 20 pt") {
/* 1230:1294 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 20));
/* 1231:     */     }
/* 1232:     */   }
/* 1233:     */   
/* 1234:     */   private void secureModeButtonPressed()
/* 1235:     */   {
/* 1236:1305 */     this.textArea1.setText("");
/* 1237:1306 */     this.textField6.setVisible(true);
/* 1238:1307 */     this.label8.setVisible(true);
/* 1239:1308 */     this.textField1.setVisible(false);
/* 1240:1309 */     this.textField2.setVisible(false);
/* 1241:1310 */     this.textField3.setVisible(false);
/* 1242:1311 */     this.label1.setVisible(false);
/* 1243:1312 */     this.label2.setVisible(false);
/* 1244:1313 */     this.label3.setVisible(false);
/* 1245:1314 */     this.label4.setVisible(false);
/* 1246:1315 */     this.label5.setVisible(false);
/* 1247:1316 */     this.textField4.setVisible(false);
/* 1248:1317 */     this.textField5.setVisible(false);
/* 1249:     */   }
/* 1250:     */   
/* 1251:     */   private void teachModeButtonPressed()
/* 1252:     */   {
/* 1253:1326 */     this.textArea1.setText("");
/* 1254:1327 */     this.textField6.setVisible(false);
/* 1255:1328 */     this.label8.setVisible(false);
/* 1256:1329 */     this.textField1.setVisible(true);
/* 1257:1330 */     this.textField2.setVisible(true);
/* 1258:1331 */     this.textField3.setVisible(true);
/* 1259:1332 */     this.label1.setVisible(true);
/* 1260:1333 */     this.label2.setVisible(true);
/* 1261:1334 */     this.label3.setVisible(true);
/* 1262:1335 */     this.label4.setVisible(true);
/* 1263:1336 */     this.label5.setVisible(true);
/* 1264:1337 */     this.textField4.setVisible(true);
/* 1265:1338 */     this.textField5.setVisible(true);
/* 1266:     */   }
/* 1267:     */   
/* 1268:     */   private void showAbout()
/* 1269:     */   {
/* 1270:1345 */     JOptionPane.showMessageDialog(this, "Authors:", "About", -1);
/* 1279:     */   }
/* 1280:     */   
/* 1281:     */   public static void main(String[] args)
/* 1282:     */   {
/* 1283:1362 */     SwingUtilities.invokeLater(new Runnable()
/* 1284:     */     {
/* 1285:     */       public void run()
/* 1286:     */       {
/* 1287:1364 */         JFrame.setDefaultLookAndFeelDecorated(false);
/* 1288:1365 */         new Graphical();
/* 1289:     */       }
/* 1290:     */     });
/* 1291:     */   }
/* 1292:     */ }

