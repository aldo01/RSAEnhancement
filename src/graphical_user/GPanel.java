/*  1:   */ package graphical_user;
/*  2:   */ 
/*  3:   */ import java.awt.Color;
/*  4:   */ import java.awt.Container;
/*  5:   */ import java.awt.GradientPaint;
/*  6:   */ import java.awt.Graphics;
/*  7:   */ import java.awt.Graphics2D;
/*  8:   */ import java.awt.LayoutManager;
/*  9:   */ import java.awt.Paint;
/* 10:   */ import javax.swing.JFrame;
/* 11:   */ import javax.swing.JPanel;
/* 12:   */ import javax.swing.UIManager;
/* 13:   */ 
/* 14:   */ public class GPanel extends JPanel
/* 16:   */ {
/* 17:   */   private static final long serialVersionUID = 7994720220746831366L;
/* 18:   */   
/* 19:   */   public GPanel(Color background)
/* 20:   */   {
/* 21:39 */     setBackground(background);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public GPanel(Color background, LayoutManager lm)
/* 25:   */   {
/* 26:48 */     super(lm);
/* 27:49 */     setBackground(background);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void paintComponent(Graphics g)
/* 31:   */   {
/* 32:53 */     super.paintComponent(g);
/* 33:54 */     if (!isOpaque()) {
/* 34:55 */       return;
/* 35:   */     }
/* 36:57 */     Color control = UIManager.getColor("control");
/* 37:58 */     int width = getWidth();
/* 38:59 */     int height = getHeight();
/* 39:   */     
/* 40:61 */     Graphics2D g2 = (Graphics2D)g;
/* 41:62 */     Paint storedPaint = g2.getPaint();
/* 42:63 */     setPaint(control, g2);
/* 43:64 */     g2.fillRect(0, 0, width, height);
/* 44:65 */     g2.setPaint(storedPaint);
/* 45:   */   }
/* 46:   */   
/* 47:   */   private void setPaint(Color control, Graphics2D g2)
/* 48:   */   {
/* 49:69 */     g2.setPaint(new GradientPaint(0.0F, 0.0F, getBackground(), 0.0F, getHeight(), control));
/* 50:   */   }
/* 51:   */   
/* 52:   */   public static void main(String[] args)
/* 53:   */   {
/* 54:77 */     JFrame frame = new JFrame();
/* 55:78 */     frame.setSize(600, 600);
/* 56:   */     
/* 57:80 */     GPanel gP = new GPanel(Color.DARK_GRAY);
/* 58:81 */     gP.setSize(500, 500);
/* 59:   */     
/* 60:83 */     frame.getContentPane().add(gP);
/* 61:84 */     frame.setVisible(true);
/* 62:   */   }
/* 63:   */ }




