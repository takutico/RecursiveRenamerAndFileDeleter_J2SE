package frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FileDelete
  extends JFrame
{
  private static final String newline = "\n";
  private File dir = null;
  private File[] listaFicheros;
  private String nombreFichero = "";
  private JButton btnEjecutar;
  private JButton jButton1;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JScrollPane jScrollPane1;
  private JTextArea log;
  private JPanel pnlFileDelete;
  private JTextField txtDir;
  private JTextField txtNombreFichero;
  
  public FileDelete()
  {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("takutico - File delete");
  }
  
  private void initComponents()
  {
    this.pnlFileDelete = new JPanel();
    this.jPanel1 = new JPanel();
    this.jPanel3 = new JPanel();
    this.txtNombreFichero = new JTextField();
    this.btnEjecutar = new JButton();
    this.jLabel2 = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.log = new JTextArea();
    this.jPanel2 = new JPanel();
    this.txtDir = new JTextField();
    this.jButton1 = new JButton();
    this.jLabel1 = new JLabel();
    
    setDefaultCloseOperation(3);
    
    this.pnlFileDelete.setLayout(new BorderLayout());
    
    this.jPanel1.setLayout(new BorderLayout());
    
    this.btnEjecutar.setText("Ejecutar");
    this.btnEjecutar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        FileDelete.this.btnEjecutarActionPerformed(evt);
      }
    });
    this.jLabel2.setText("Nombre de fichero a borrar");
    
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(72, 72, 72).addComponent(this.btnEjecutar, -2, 117, -2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.txtNombreFichero, -2, 246, -2))).addContainerGap()));
    













    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNombreFichero, -2, -1, -2).addGap(34, 34, 34).addComponent(this.btnEjecutar).addContainerGap(249, 32767)));
    










    this.jPanel1.add(this.jPanel3, "West");
    
    this.log.setColumns(20);
    this.log.setRows(5);
    this.jScrollPane1.setViewportView(this.log);
    
    this.jPanel1.add(this.jScrollPane1, "Center");
    
    this.pnlFileDelete.add(this.jPanel1, "Center");
    
    this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
    
    this.jButton1.setText("...");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        FileDelete.this.jButton1ActionPerformed(evt);
      }
    });
    this.jLabel1.setText("Directorio");
    
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.txtDir, -1, 668, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)).addComponent(this.jLabel1)).addContainerGap()));
    










    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtDir).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap(40, 32767)));
    










    this.pnlFileDelete.add(this.jPanel2, "First");
    
    getContentPane().add(this.pnlFileDelete, "Center");
    
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(1);
    fileChooser.setVisible(true);
    fileChooser.setApproveButtonText("OK");
    
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
  
  private void btnEjecutarActionPerformed(ActionEvent evt)
  {
    if (this.txtNombreFichero.getText().equals(""))
    {
      this.log.setText("Debe insertar un nombre de fichero");
      return;
    }
    this.nombreFichero = this.txtNombreFichero.getText();
    if (this.dir != null) {
      borrarDirectorio(this.dir);
    }
  }
  
  private void borrarDirectorio(File f)
  {
    File[] lf = f.listFiles();
    for (int i = 0; i < lf.length; i++) {
      if (lf[i].isDirectory())
      {
        if (lf[i].getName().equals(this.nombreFichero))
        {
          borrarTodo(lf[i]);
          if (lf[i].delete()) {
            this.log.append(lf[i].getPath() + " --> ELIMINADO" + "\n");
          }
        }
        else
        {
          borrarDirectorio(lf[i]);
        }
      }
      else if ((lf[i].getName().equals(this.nombreFichero)) && 
        (lf[i].delete())) {
        this.log.append(lf[i].getPath() + " --> ELIMINADO" + "\n");
      }
    }
  }
  
  private void borrarTodo(File f)
  {
    File[] lf = f.listFiles();
    for (int i = 0; i < lf.length; i++) {
      if (lf[i].isDirectory())
      {
        borrarTodo(lf[i]);
        if (lf[i].delete()) {
          this.log.append(lf[i].getPath() + " --> ELIMINADO" + "\n");
        }
      }
      else if (lf[i].delete())
      {
        this.log.append(lf[i].getPath() + " --> ELIMINADO" + "\n");
      }
    }
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        FileDelete fd = new FileDelete();
        fd.setVisible(true);
      }
    });
  }
}
