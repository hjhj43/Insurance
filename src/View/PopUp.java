package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame {
	private static final long serialVersionUID = 1L;
	
   private JPanel mainP;
   private JPanel buttonP;
   private JPanel labelP;

   private JLabel text;
   private JButton check;
   private boolean backTo = false;
   private boolean saveAs = false;
   
   private ActionHandler AC;

   public PopUp(String text) {

      this.AC = new ActionHandler();
      
      this.mainP = new JPanel();
      this.buttonP = new JPanel();
      this.labelP = new JPanel();
      
      this.setLayout(new BorderLayout());
      this.mainP.setLayout(new BorderLayout());
      this.buttonP.setLayout(new BorderLayout());
      this.labelP.setLayout(new BorderLayout());
      
      this.text = new JLabel(text);
      this.check = new JButton("확인");
      this.check.setActionCommand("확인");
      this.check.addActionListener(AC);

      this.labelP.add(this.text,BorderLayout.CENTER);
      this.buttonP.add(this.check,BorderLayout.CENTER);
      
      this.mainP.add(this.labelP,BorderLayout.CENTER);
      this.mainP.add(this.buttonP,BorderLayout.SOUTH);
      
      
      this.add(this.mainP);
      this.setSize(400, 200);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }
   
   public boolean setHandler(ActionListener ActionHandler) {
      this.check.addActionListener(ActionHandler);
      return backTo;
      
   }
   
   public boolean setHandler2(ActionListener ActionHandler) {
      this.check.addActionListener(ActionHandler);
      return saveAs;
      
   }


   private class ActionHandler implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("확인")) {
            dispose();
         
         }

      }

   }
}