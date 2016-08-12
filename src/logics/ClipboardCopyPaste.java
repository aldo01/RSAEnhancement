/*   1:    */ package logics;
/*   2:    */ 
/*   3:    */ import java.awt.Toolkit;
/*   4:    */ import java.awt.datatransfer.Clipboard;
/*   5:    */ import java.awt.datatransfer.ClipboardOwner;
/*   6:    */ import java.awt.datatransfer.DataFlavor;
/*   7:    */ import java.awt.datatransfer.StringSelection;
/*   8:    */ import java.awt.datatransfer.Transferable;
/*   9:    */ import java.awt.event.ActionEvent;
/*  10:    */ import java.awt.event.ActionListener;
/*  11:    */ import java.awt.event.MouseAdapter;
/*  12:    */ import java.awt.event.MouseEvent;
/*  13:    */ import java.awt.event.MouseListener;
/*  14:    */ import javax.swing.JMenuItem;
/*  15:    */ import javax.swing.JPopupMenu;
/*  16:    */ import javax.swing.JTextArea;
/*  17:    */ 
/*  18:    */ public final class ClipboardCopyPaste
/*  19:    */   implements ClipboardOwner
/*  20:    */ {
/*  21:    */   public void lostOwnership(Clipboard clipboard, Transferable contents) {}
/*  22:    */   
/*  23:    */   public void copy(String text)
/*  24:    */   {
/*  25: 48 */     StringSelection strSelection = new StringSelection(text);
/*  26: 49 */     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
/*  27: 50 */     clipboard.setContents(strSelection, this);
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String paste()
/*  31:    */   {
/*  32: 57 */     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
/*  33: 58 */     Transferable data = clipboard.getContents(this);
/*  34:    */     String s;
/*  35:    */     try
/*  36:    */     {
/*  37: 61 */       s = (String)data.getTransferData(DataFlavor.stringFlavor);
/*  38:    */     }
/*  39:    */     catch (Exception e)
/*  40:    */     {
/*  41:    */   //    String s;
/*  42: 64 */       s = data.toString();
/*  43:    */     }
/*  44: 66 */     return s;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void createPopupMenu(final JTextArea textArea)
/*  48:    */   {
/*  49: 79 */     JPopupMenu popup = new JPopupMenu();
/*  50: 80 */     JMenuItem menuItem = new JMenuItem("Copy");
/*  51:    */     
/*  52: 82 */     menuItem.addActionListener(new ActionListener()
/*  53:    */     {
/*  54:    */       public void actionPerformed(ActionEvent e)
/*  55:    */       {
/*  56: 84 */         new ClipboardCopyPaste().copy(textArea.getSelectedText());
/*  57:    */       }
/*  58: 86 */     });
/*  59: 87 */     popup.add(menuItem);
/*  60: 88 */     menuItem = new JMenuItem("Paste");
/*  61: 89 */     menuItem.addActionListener(new ActionListener()
/*  62:    */     {
/*  63:    */       public void actionPerformed(ActionEvent e)
/*  64:    */       {
/*  65: 91 */         textArea.setText(new ClipboardCopyPaste().paste());
/*  66:    */       }
/*  67: 93 */     });
/*  68: 94 */     popup.add(menuItem);
/*  69:    */     
/*  70:    */ 
/*  71: 97 */     MouseListener popupListener = new PopupListener(popup);
/*  72: 98 */     textArea.addMouseListener(popupListener);
/*  73:    */   }
/*  74:    */   
/*  75:    */   class PopupListener
/*  76:    */     extends MouseAdapter
/*  77:    */   {
/*  78:    */     JPopupMenu popup;
/*  79:    */     
/*  80:    */     PopupListener(JPopupMenu popupMenu)
/*  81:    */     {
/*  82:109 */       this.popup = popupMenu;
/*  83:    */     }
/*  84:    */     
/*  85:    */     public void mousePressed(MouseEvent e)
/*  86:    */     {
/*  87:113 */       maybeShowPopup(e);
/*  88:    */     }
/*  89:    */     
/*  90:    */     public void mouseReleased(MouseEvent e)
/*  91:    */     {
/*  92:117 */       maybeShowPopup(e);
/*  93:    */     }
/*  94:    */     
/*  95:    */     private void maybeShowPopup(MouseEvent e)
/*  96:    */     {
/*  97:121 */       if (e.isPopupTrigger()) {
/*  98:122 */         this.popup.show(e.getComponent(), e.getX(), e.getY());
/*  99:    */       }
/* 100:    */     }
/* 101:    */   }
/* 102:    */ }


