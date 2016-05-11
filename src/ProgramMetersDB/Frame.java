
package ProgramMetersDB;


import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".doc")|| file.getAbsolutePath().endsWith(".docx");
        }
        @Override
        public String getDescription() {
            
            return "Text documents (*.doc,*.docx)";
        }
    } 
public class Frame extends javax.swing.JFrame {

   
    public Frame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        FileChooser = new javax.swing.JFileChooser();
        sqlServer = new javax.swing.JDialog();
        okSqlButton = new javax.swing.JButton();
        cancelSqlButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        serverName = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        conError = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        errorOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        plombOtchet = new javax.swing.JButton();
        createSqlButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        FileChooser.setFileFilter( new MyCustomFilter());
        FileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        FileChooser.setInheritsPopupMenu(true);
        FileChooser.setMultiSelectionEnabled(true);

        sqlServer.setLocation(new java.awt.Point(330, 0));
        sqlServer.setMinimumSize(new java.awt.Dimension(430, 300));
        sqlServer.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        sqlServer.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        sqlServer.setSize(new java.awt.Dimension(430, 300));
        sqlServer.setType(java.awt.Window.Type.UTILITY);

        okSqlButton.setText("OK");
        okSqlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSqlButtonActionPerformed(evt);
            }
        });

        cancelSqlButton.setText("Cancel");
        cancelSqlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSqlButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Введите параметры для связи с MySql сервером:");

        jLabel2.setText("Путь к БД:");

        jLabel3.setText("Пользователь:");

        jLabel4.setText("Пароль:");

        javax.swing.GroupLayout sqlServerLayout = new javax.swing.GroupLayout(sqlServer.getContentPane());
        sqlServer.getContentPane().setLayout(sqlServerLayout);
        sqlServerLayout.setHorizontalGroup(
            sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sqlServerLayout.createSequentialGroup()
                .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sqlServerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sqlServerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sqlServerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sqlServerLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(cancelSqlButton)
                        .addGap(146, 146, 146)
                        .addComponent(okSqlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        sqlServerLayout.setVerticalGroup(
            sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sqlServerLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(serverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(sqlServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelSqlButton)
                    .addComponent(okSqlButton))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        conError.setMinimumSize(new java.awt.Dimension(300, 300));
        conError.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, createSqlButton, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), conError, org.jdesktop.beansbinding.BeanProperty.create("alwaysOnTop"));
        bindingGroup.addBinding(binding);

        conError.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                conErrorComponentShown(evt);
            }
        });
        conError.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                setVisible(evt);
            }
        });
        conError.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                conErrorWindowActivated(evt);
            }
        });

        jLabel5.setText("You have wrong URL conection !");

        errorOk.setText("OK");
        errorOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conErrorLayout = new javax.swing.GroupLayout(conError.getContentPane());
        conError.getContentPane().setLayout(conErrorLayout);
        conErrorLayout.setHorizontalGroup(
            conErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conErrorLayout.createSequentialGroup()
                .addGroup(conErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conErrorLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(conErrorLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(errorOk)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        conErrorLayout.setVerticalGroup(
            conErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conErrorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(errorOk)
                .addGap(66, 66, 66))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Проект автоматизации учета  програмирования ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 410, 390));

        plombOtchet.setText("Отчет по  пломбам");
        plombOtchet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plombOtchetActionPerformed(evt);
            }
        });
        getContentPane().add(plombOtchet, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 150, 30));

        createSqlButton.setText("Отчет в MySql");
        createSqlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSqlButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createSqlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 150, 30));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         System.exit(0); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
      plombOtchet.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void plombOtchetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plombOtchetActionPerformed
        String putFile= new String();
        FileChooser.setCurrentDirectory(new File ("c:\\"));
         int returnFileList = FileChooser.showOpenDialog(this);
    if (returnFileList == JFileChooser.APPROVE_OPTION) {
        File[] file = FileChooser.getSelectedFiles();
        try { 
            Map tMap = new TreeMap<>();//создаем отсортированый сет по дате от раней
                for (File file1 : file) {
                 long mod= file1.lastModified();
                    tMap.put(mod,file1.getAbsolutePath());
                        textArea.setText(file1.getAbsolutePath());
                }
            Set set = tMap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {//перебераем полученые файлы
         Map.Entry mentry = (Map.Entry)iterator.next();
           putFile=(String)mentry.getValue();//получаем путь к файлу из масива файлов выбраных
                if  ( putFile.endsWith("doc")){
                         HashMap docRezult= ReadDoc.rez(putFile);//читаем ворд
                              WriteExel.generateXls(docRezult,"D:\\temp\\6.xls");//создаем поток записи
                                            }else {
                                                    HashMap docRezultx= ReadDoc.rezx(putFile);//читаем ворд
                                                        WriteExel.generateXls(docRezultx,"D:\\temp\\6.xls");//создаем поток записи
                                                    }
              }
           } catch (Exception ex) {
             textArea.setText("problem accessing file"+putFile);
          }
    } else {
        System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_plombOtchetActionPerformed

    private void createSqlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSqlButtonActionPerformed
        // TODO add your handling code here:
      sqlServer.setVisible(true);   
    }//GEN-LAST:event_createSqlButtonActionPerformed

    private void okSqlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okSqlButtonActionPerformed
          Map table= new TreeMap<>();
        try {
            // TODO add your handling code here:
          
       table=MySql.sqlRead(MySql.sqlConection(serverName.getText(),userName.getText(),password.getText()));
       
        } catch (SQLException ex) {
            conError.setVisible(true);
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okSqlButtonActionPerformed

    private void cancelSqlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSqlButtonActionPerformed
        // TODO add your handling code here:
        sqlServer.setVisible(false); 
    }//GEN-LAST:event_cancelSqlButtonActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void errorOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorOkActionPerformed
        // TODO add your handling code here:
        conError.setVisible(false);
    }//GEN-LAST:event_errorOkActionPerformed

    private void conErrorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_conErrorComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_conErrorComponentShown

    private void conErrorWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_conErrorWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_conErrorWindowActivated

    private void setVisible(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_setVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_setVisible

  
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton cancelSqlButton;
    public javax.swing.JDialog conError;
    private javax.swing.JButton createSqlButton;
    private javax.swing.JButton errorOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton okSqlButton;
    private javax.swing.JTextField password;
    private javax.swing.JButton plombOtchet;
    private javax.swing.JTextField serverName;
    private javax.swing.JDialog sqlServer;
    private javax.swing.JTextPane textArea;
    private javax.swing.JTextField userName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
