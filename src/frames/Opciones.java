package frames;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Opciones
  extends JFrame
{
  private JButton btnFileDelete;
  private JButton btnFileRename;
  
  public Opciones()
  {
    initComponents();
    setTitle("takutico - Mini aplicaciones");
    setLocationRelativeTo(null);
  }
  
  private void initComponents()
  {
    this.btnFileRename = new JButton();
    this.btnFileDelete = new JButton();
    
    setDefaultCloseOperation(3);
    
    this.btnFileRename.setText("File renamer");
    this.btnFileRename.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Opciones.this.btnFileRenameActionPerformed(evt);
      }
    });
    this.btnFileDelete.setText("FIle delete");
    this.btnFileDelete.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Opciones.this.btnFileDeleteActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(75, 75, 75).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnFileDelete, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.btnFileRename, GroupLayout.Alignment.LEADING, -1, 253, 32767)).addContainerGap(72, 32767)));
    







    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.btnFileRename).addGap(18, 18, 18).addComponent(this.btnFileDelete).addContainerGap(213, 32767)));
    








    pack();
  }
  
  private void btnFileRenameActionPerformed(ActionEvent evt)
  {
    FileRenamer principal = new FileRenamer();
    principal.setVisible(true);
  }
  
  private void btnFileDeleteActionPerformed(ActionEvent evt)
  {
    FileDelete principal = new FileDelete();
    principal.setVisible(true);
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Opciones().setVisible(true);
      }
    });
  }
}