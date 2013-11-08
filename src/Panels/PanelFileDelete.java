package Panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelFileDelete
  extends JFrame
{
  private static final String newline = "\n";
  private File dir = null;
  private File[] listaFicheros;
  private JButton btnBuscar;
  private JButton btnEjecutar;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JScrollPane jScrollPane1;
  private JTextArea log;
  private JTextField txtDir;
  private JTextField txtFichero;
  
  public PanelFileDelete()
  {
    initComponents();
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.jPanel4 = new JPanel();
    this.btnEjecutar = new JButton();
    this.txtFichero = new JTextField();
    this.jScrollPane1 = new JScrollPane();
    this.log = new JTextArea();
    this.jPanel3 = new JPanel();
    this.txtDir = new JTextField();
    this.btnBuscar = new JButton();
    
    setLayout(new BorderLayout());
    
    this.jPanel1.setLayout(new BorderLayout());
    
    this.jPanel2.setLayout(new GridLayout());
    
    this.btnEjecutar.setText("Ejecutar");
    this.btnEjecutar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        PanelFileDelete.this.btnEjecutarActionPerformed(evt);
      }
    });
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.txtFichero, -1, 247, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.btnEjecutar, -2, 154, -2).addGap(57, 57, 57)))));
    










    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.txtFichero, -2, -1, -2).addGap(34, 34, 34).addComponent(this.btnEjecutar).addContainerGap(57, 32767)));
    








    this.jPanel2.add(this.jPanel4);
    
    this.log.setColumns(20);
    this.log.setRows(5);
    this.jScrollPane1.setViewportView(this.log);
    
    this.jPanel2.add(this.jScrollPane1);
    
    this.jPanel1.add(this.jPanel2, "Center");
    
    this.txtDir.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        PanelFileDelete.this.txtDirActionPerformed(evt);
      }
    });
    this.btnBuscar.setText("...");
    this.btnBuscar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        PanelFileDelete.this.btnBuscarActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.txtDir, -1, 401, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar).addGap(55, 55, 55)));
    







    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(34, 34, 34).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDir, -2, -1, -2).addComponent(this.btnBuscar)).addContainerGap(46, 32767)));
    








    this.jPanel1.add(this.jPanel3, "First");
    
    add(this.jPanel1, "Center");
  }
  
  private void txtDirActionPerformed(ActionEvent evt) {}
  
  private void btnEjecutarActionPerformed(ActionEvent evt) {}
  
  private void btnBuscarActionPerformed(ActionEvent evt)
  {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(1);
    fileChooser.setVisible(true);
    fileChooser.setApproveButtonText("Guardar");
    
    int status = fileChooser.showDialog(this, null);
    if (status == 0)
    {
      this.log.setText("");
      
      File directorioRaiz = fileChooser.getSelectedFile();
      this.txtDir.setText(directorioRaiz.getAbsolutePath());
      if (this.txtDir.getText().equals("")) {
        this.dir = new File(".");
      } else {
        this.dir = new File(this.txtDir.getText());
      }
      if (this.dir != null)
      {
        this.listaFicheros = this.dir.listFiles();
        for (int i = 0; i < this.listaFicheros.length; i++) {
          this.log.append(this.listaFicheros[i].getName() + "\n");
        }
      }
    }
    fileChooser.getSelectedFile().getPath();
  }
}