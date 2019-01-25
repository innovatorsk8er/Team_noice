package prototyp;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// www  .  java2 s .c om
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GuiList {

  public static final void main(String args[]) throws Exception {
    JFrame f = new JFrame();
    DefaultListModel<String> dlm = new DefaultListModel<String>();
    JList<String> list = new JList<>(dlm);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.add(new JScrollPane(list));
    f.add(new JButton("Add") {
      {
        addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            dlm.addElement("A");
          }
        });
      }
    }, BorderLayout.SOUTH);

    f.pack();
    f.setVisible(true);
  }
}