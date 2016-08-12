/*   1:    */ package graphical_user;
/*   2:    */ 
/*   3:    */ import logics.ClipboardCopyPaste;
/*   4:    */ import logics.LoadSaveExec;
/*   5:    */ import java.awt.Container;
/*   6:    */ import java.awt.Dimension;
/*   7:    */ import java.awt.Font;
/*   8:    */ import java.awt.GraphicsEnvironment;
/*   9:    */ import java.awt.GridBagConstraints;
/*  10:    */ import java.awt.GridBagLayout;
/*  11:    */ import java.awt.Insets;
/*  12:    */ import java.awt.Rectangle;
/*  13:    */ import java.awt.event.ActionEvent;
/*  14:    */ import java.awt.event.ActionListener;
/*  15:    */ import javax.swing.BoxLayout;
/*  16:    */ import javax.swing.JButton;
/*  17:    */ import javax.swing.JComboBox;
/*  18:    */ import javax.swing.JFrame;
/*  19:    */ import javax.swing.JPanel;
/*  20:    */ import javax.swing.JScrollPane;
/*  21:    */ import javax.swing.JTextArea;
/*  22:    */ import javax.swing.SwingUtilities;
/*  23:    */ 
/*  24:    */ public class FScreen extends JFrame
/*  26:    */ {
/*  27:    */   private static final long serialVersionUID = -556243637750407246L;
/*  28: 35 */   ClipboardCopyPaste clipboard = new ClipboardCopyPaste();
/*  29:    */   private JPanel panel1;
/*  30:    */   private JScrollPane scrollPane1;
/*  31:    */   private JTextArea textArea1;
/*  32:    */   private JPanel panel2;
/*  33:    */   private JButton button2;
/*  34:    */   private JButton button3;
/*  35:    */   private JComboBox comboBox1;
/*  36:    */   private JButton button1;
/*  37:    */   private LoadSaveExec loadSaveExec;
/*  38:    */   
/*  39:    */   public FScreen(JTextArea textArea)
/*  40:    */   {
/*  41: 42 */     initComponents();
/*  42: 43 */     this.textArea1.setText(textArea.getText());
/*  43: 44 */     this.textArea1.setCaretPosition(0);
/*  44:    */   }
/*  45:    */   
/*  46: 57 */   private final String[] textSize = { "Font size 12 pt", "Font size 14 pt", 
/*  47: 58 */     "Font size 16 pt", "Font size 20 pt", "Font size 30 pt" };
/*  48:    */   
/*  49:    */   private void initComponents()
/*  50:    */   {
/*  51: 65 */     this.panel1 = new JPanel();
/*  52: 66 */     this.scrollPane1 = new JScrollPane();
/*  53: 67 */     this.textArea1 = new JTextArea();
/*  54: 68 */     this.panel2 = new JPanel();
/*  55: 69 */     this.button2 = new JButton();
/*  56: 70 */     this.button3 = new JButton();
/*  57: 71 */     this.button1 = new JButton();
/*  58: 72 */     this.comboBox1 = new JComboBox(this.textSize);
/*  59:    */     
/*  60:    */ 
/*  61: 75 */     setTitle("RSA Education Cryptosystem");
/*  62: 76 */     setDefaultCloseOperation(2);
/*  63: 77 */     Container contentPane = getContentPane();
/*  64: 78 */     contentPane.setLayout(new GridBagLayout());
/*  65: 79 */     ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] { 15, 849, 10 };
/*  66: 80 */     ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] { 15, 543, 10, 30, 10 };
/*  67: 81 */     ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0001D };
/*  68: 82 */     ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] { 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0001D };
/*  69:    */     
/*  70:    */ 
/*  71:    */ 
/*  72: 86 */     this.panel1.setLayout(new BoxLayout(this.panel1, 0));
/*  73:    */     
/*  74:    */ 
/*  75:    */ 
/*  76: 90 */     this.scrollPane1.setViewportView(this.textArea1);
/*  77:    */     
/*  78: 92 */     this.textArea1.setFont(new Font("Arial Unicode MS", 0, 16));
/*  79: 93 */     this.clipboard.createPopupMenu(this.textArea1);
/*  80: 94 */     this.panel1.add(this.scrollPane1);
/*  81:    */     
/*  82: 96 */     contentPane.add(this.panel1, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 
/*  83: 97 */       10, 1, 
/*  84: 98 */       new Insets(0, 0, 5, 5), 0, 0));
/*  85:    */     
/*  86:    */ 
/*  87:    */ 
/*  88:102 */     this.panel2.setLayout(new GridBagLayout());
/*  89:103 */     ((GridBagLayout)this.panel2.getLayout()).columnWidths = new int[] { 125, 125, 305, 105, 100 };
/*  90:104 */     ((GridBagLayout)this.panel2.getLayout()).rowHeights = new int[] { 25 };
/*  91:105 */     ((GridBagLayout)this.panel2.getLayout()).columnWeights = new double[] { 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0001D };
/*  92:106 */     ((GridBagLayout)this.panel2.getLayout()).rowWeights = new double[] { 0.0D, 0.0001D };
/*  93:    */     
/*  94:    */ 
/*  95:109 */     this.button2.setText("Save to file");
/*  96:110 */     this.button2.setPreferredSize(new Dimension(125, 25));
/*  97:111 */     this.button2.setMaximumSize(new Dimension(125, 25));
/*  98:112 */     this.button2.setMinimumSize(new Dimension(125, 25));
/*  99:113 */     this.button2.addActionListener(new ActionListener()
/* 100:    */     {
/* 101:    */       public void actionPerformed(ActionEvent e)
/* 102:    */       {
/* 103:115 */         FScreen.this.saveExecutionButtonActionPerformed(e);
/* 104:    */       }
/* 105:117 */     });
/* 106:118 */     this.panel2.add(this.button2, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 
/* 107:119 */       10, 1, 
/* 108:120 */       new Insets(0, 0, 0, 5), 0, 0));
/* 109:    */     
/* 110:    */ 
/* 111:123 */     this.button3.setText("Load from file");
/* 112:124 */     this.button3.setPreferredSize(new Dimension(125, 25));
/* 113:125 */     this.button3.setMaximumSize(new Dimension(125, 25));
/* 114:126 */     this.button3.setMinimumSize(new Dimension(125, 25));
/* 115:127 */     this.button3.addActionListener(new ActionListener()
/* 116:    */     {
/* 117:    */       public void actionPerformed(ActionEvent e)
/* 118:    */       {
/* 119:129 */         FScreen.this.loadExecutionButtonActionPerformed(e);
/* 120:    */       }
/* 121:131 */     });
/* 122:132 */     this.panel2.add(this.button3, new GridBagConstraints(1, 0, 1, 1, 0.0D, 0.0D, 
/* 123:133 */       10, 1, 
/* 124:134 */       new Insets(0, 0, 0, 5), 0, 0));
/* 125:    */     
/* 126:    */ 
/* 127:137 */     this.comboBox1.setPreferredSize(new Dimension(120, 25));
/* 128:138 */     this.comboBox1.setMinimumSize(new Dimension(100, 25));
/* 129:139 */     this.comboBox1.addActionListener(new ActionListener()
/* 130:    */     {
/* 131:    */       public void actionPerformed(ActionEvent e)
/* 132:    */       {
/* 133:141 */         FScreen.this.fontSizeComboBoxActionPerformed(e);
/* 134:    */       }
/* 135:143 */     });
/* 136:144 */     this.comboBox1.setSelectedIndex(2);
/* 137:145 */     this.panel2.add(this.comboBox1, new GridBagConstraints(3, 0, 1, 1, 0.0D, 0.0D, 
/* 138:146 */       10, 1, 
/* 139:147 */       new Insets(0, 0, 0, 5), 0, 0));
/* 140:    */     
/* 141:    */ 
/* 142:150 */     this.button1.setText("Close");
/* 143:151 */     this.button1.setPreferredSize(new Dimension(100, 25));
/* 144:152 */     this.button1.setMaximumSize(new Dimension(59, 25));
/* 145:153 */     this.button1.setMinimumSize(new Dimension(59, 25));
/* 146:154 */     this.button1.addActionListener(new ActionListener()
/* 147:    */     {
/* 148:    */       public void actionPerformed(ActionEvent e)
/* 149:    */       {
/* 150:156 */         FScreen.this.closeButtonActionPerformed(e);
/* 151:    */       }
/* 152:158 */     });
/* 153:159 */     this.panel2.add(this.button1, new GridBagConstraints(4, 0, 1, 1, 0.0D, 0.0D, 
/* 154:160 */       10, 1, 
/* 155:161 */       new Insets(0, 0, 0, 0), 0, 0));
/* 156:    */     
/* 157:163 */     contentPane.add(this.panel2, new GridBagConstraints(1, 3, 1, 1, 0.0D, 0.0D, 
/* 158:164 */       10, 1, 
/* 159:165 */       new Insets(0, 0, 5, 5), 0, 0));
/* 160:    */     
/* 161:    */ 
/* 162:168 */     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/* 163:169 */     int width = ge.getMaximumWindowBounds().width;
/* 164:170 */     int height = ge.getMaximumWindowBounds().height;
/* 165:171 */     setSize(width, height);
/* 166:    */     
/* 167:173 */     setLocationRelativeTo(null);
/* 168:174 */     toFront();
/* 169:175 */     setVisible(true);
/* 170:    */   }
/* 171:    */   
/* 172:    */   private void saveExecutionButtonActionPerformed(ActionEvent e)
/* 173:    */   {
/* 174:183 */     this.loadSaveExec = new LoadSaveExec(this, this.textArea1);
/* 175:184 */     this.loadSaveExec.saveExecToFile();
/* 176:    */   }
/* 177:    */   
/* 178:    */   private void loadExecutionButtonActionPerformed(ActionEvent e)
/* 179:    */   {
/* 180:192 */     this.loadSaveExec = new LoadSaveExec(this, this.textArea1);
/* 181:193 */     this.loadSaveExec.loadExecFromFile();
/* 182:    */   }
/* 183:    */   
/* 184:    */   private void fontSizeComboBoxActionPerformed(ActionEvent e)
/* 185:    */   {
/* 186:201 */     if (this.comboBox1.getSelectedItem() == "Font size 12 pt") {
/* 187:202 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 12));
/* 188:204 */     } else if (this.comboBox1.getSelectedItem() == "Font size 14 pt") {
/* 189:205 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 14));
/* 190:207 */     } else if (this.comboBox1.getSelectedItem() == "Font size 16 pt") {
/* 191:208 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 16));
/* 192:210 */     } else if (this.comboBox1.getSelectedItem() == "Font size 20 pt") {
/* 193:211 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 20));
/* 194:213 */     } else if (this.comboBox1.getSelectedItem() == "Font size 30 pt") {
/* 195:214 */       this.textArea1.setFont(new Font("Arial Unicode MS", 0, 30));
/* 196:    */     }
/* 197:    */   }
/* 198:    */   
/* 199:    */   private void closeButtonActionPerformed(ActionEvent e)
/* 200:    */   {
/* 201:223 */     dispose();
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void updateTextArea(JTextArea textArea)
/* 205:    */   {
/* 206:231 */     this.textArea1.setText(textArea.getText());
/* 207:    */   }
/* 208:    */   
/* 209:    */   public static void main(String[] args)
/* 210:    */   {
/* 211:239 */     SwingUtilities.invokeLater(new Runnable()
/* 212:    */     {
/* 213:    */       public void run()
/* 214:    */       {
/* 215:241 */         JFrame.setDefaultLookAndFeelDecorated(false);
/* 216:242 */         new FScreen(new JTextArea());
/* 217:    */       }
/* 218:    */     });
/* 219:    */   }
/* 220:    */ }

