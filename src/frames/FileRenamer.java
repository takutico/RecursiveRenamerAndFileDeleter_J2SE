package frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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

public class FileRenamer
  extends JFrame
{
  private static final String newline = "\n";
  private File dir = null;
  private File[] listaFicheros;
  private String sustituir = "";
  private String sustituirPor = "";
  private JButton btnDirectorio;
  private JButton btnSustituir;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JLabel lblDirectorio;
  private JLabel lblSustituir;
  private JLabel lblSustituirPor;
  private JTextArea log;
  private JTextField txtDir;
  private JTextField txtSustituir;
  private JTextField txtSustituirPor;
  
  public FileRenamer()
  {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("takutico - File Renamer");
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.lblDirectorio = new JLabel();
    this.txtDir = new JTextField();
    this.btnDirectorio = new JButton();
    this.jPanel3 = new JPanel();
    this.jPanel2 = new JPanel();
    this.jPanel4 = new JPanel();
    this.lblSustituir = new JLabel();
    this.txtSustituir = new JTextField();
    this.lblSustituirPor = new JLabel();
    this.txtSustituirPor = new JTextField();
    this.btnSustituir = new JButton();
    this.jPanel5 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.log = new JTextArea();
    
    setDefaultCloseOperation(3);
    
    this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
    
    this.lblDirectorio.setText("Directorio");
    
    this.btnDirectorio.setText("Buscar");
    this.btnDirectorio.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        FileRenamer.this.btnDirectorioActionPerformed(evt);
      }
    });
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtDir, -1, 674, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnDirectorio)).addComponent(this.lblDirectorio)).addContainerGap()));
    










    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.lblDirectorio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDir, -2, -1, -2).addComponent(this.btnDirectorio)).addContainerGap(-1, 32767)));
    










    getContentPane().add(this.jPanel1, "North");
    
    this.jPanel3.setLayout(new BorderLayout());
    getContentPane().add(this.jPanel3, "East");
    
    this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
    this.jPanel2.setLayout(new BorderLayout());
    
    this.jPanel4.setPreferredSize(new Dimension(400, 208));
    
    this.lblSustituir.setText("Texto a sustituir");
    
    this.lblSustituirPor.setText("Sustituir por");
    
    this.btnSustituir.setText("Sustituir");
    this.btnSustituir.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        FileRenamer.this.btnSustituirActionPerformed(evt);
      }
    });
    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.lblSustituir).addContainerGap(312, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.txtSustituir, -1, 349, 32767).addGap(41, 41, 41)).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.lblSustituirPor).addContainerGap(332, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.txtSustituirPor, -1, 349, 32767).addGap(41, 41, 41)).addGroup(jPanel4Layout.createSequentialGroup().addGap(105, 105, 105).addComponent(this.btnSustituir, -2, 141, -2).addContainerGap(154, 32767)));
    





















    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.lblSustituir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtSustituir, -2, -1, -2).addGap(18, 18, 18).addComponent(this.lblSustituirPor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtSustituirPor, -2, -1, -2).addGap(18, 18, 18).addComponent(this.btnSustituir, -2, 33, -2).addContainerGap(190, 32767)));
    














    this.jPanel2.add(this.jPanel4, "West");
    
    this.jPanel5.setLayout(new BorderLayout());
    
    this.log.setColumns(20);
    this.log.setEditable(false);
    this.log.setRows(5);
    this.jScrollPane1.setViewportView(this.log);
    
    this.jPanel5.add(this.jScrollPane1, "Center");
    
    this.jPanel2.add(this.jPanel5, "Center");
    
    getContentPane().add(this.jPanel2, "Center");
    
    pack();
  }
  
  private void btnSustituirActionPerformed(ActionEvent evt)
  {
    this.log.setText("");
    
    this.sustituir = this.txtSustituir.getText();
    this.sustituirPor = this.txtSustituirPor.getText();
    if (this.dir != null)
    {
      this.listaFicheros = this.dir.listFiles();
      for (int i = 0; i < this.listaFicheros.length; i++) {
        if (this.listaFicheros[i].getName().contains(this.sustituir))
        {
          this.log.append(this.listaFicheros[i].getName() + "  -->  " + this.listaFicheros[i].getName().replace(this.sustituir, this.sustituirPor) + "\n");
          


          File archivo = new File(this.listaFicheros[i].getAbsolutePath());
          archivo.renameTo(new File(this.dir + "\\" + this.listaFicheros[i].getName().replace(this.sustituir, this.sustituirPor)));
        }
      }
    }
  }
  
  private void btnDirectorioActionPerformed(ActionEvent evt)
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
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new FileRenamer().setVisible(true);
      }
    });
  }
}
