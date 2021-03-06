package subtitle.convert;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import subtitleFile.FormatVTT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguye
 */
public class SubtitleConvertForm extends javax.swing.JFrame {
    private File openFolder = new File("");
    private File saveFolder = new File("");
    private String inputFormat = "srt";
    private String outputFormat = "xml";
    private boolean convertAll = false;
    private boolean keepFolderStruct = true;
    private ArrayList<String> approveFilesType = new ArrayList<String>();
    /**
     * Creates new form SubtitleConvertForm
     */
    public SubtitleConvertForm() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SubtitleConvertForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setLocationRelativeTo(null);
        customUI();
        approveFilesType.add("vtt");
        approveFilesType.add("srt");
        approveFilesType.add("xml");
        approveFilesType.add("vcc");
        approveFilesType.add("stl");
        approveFilesType.add("ass");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnNormal = new javax.swing.JPanel();
        txtOpen = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        chkConvertAll = new javax.swing.JCheckBox();
        btnStart = new javax.swing.JButton();
        cbFormatOut = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbFormatIn = new javax.swing.JComboBox<>();
        pnOptional = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSave = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        chkKeepFolderStruct = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EL Subtitle Converter");
        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EL Subtitle Converter");

        pnNormal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        txtOpen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOpenKeyTyped(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        chkConvertAll.setText("Convert all files and sub folders");
        chkConvertAll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkConvertAllItemStateChanged(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        cbFormatOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "xml", "stl", "scc", "srt", "ass", "vtt" }));
        cbFormatOut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFormatOutItemStateChanged(evt);
            }
        });

        jLabel3.setText("Format");

        jLabel4.setText("Input Format");

        cbFormatIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "srt", "stl", "scc", "xml", "ass", "vtt" }));
        cbFormatIn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFormatInItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnNormalLayout = new javax.swing.GroupLayout(pnNormal);
        pnNormal.setLayout(pnNormalLayout);
        pnNormalLayout.setHorizontalGroup(
            pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNormalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnNormalLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbFormatIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbFormatOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(chkConvertAll))
                    .addComponent(txtOpen))
                .addGap(18, 18, 18)
                .addGroup(pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpen)
                    .addComponent(btnStart))
                .addContainerGap())
        );
        pnNormalLayout.setVerticalGroup(
            pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNormalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnNormalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkConvertAll)
                        .addComponent(cbFormatOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(cbFormatIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnOptional.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        pnOptional.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Optional");

        txtSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaveKeyTyped(evt);
            }
        });

        btnSave.setText("Save to");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        chkKeepFolderStruct.setSelected(true);
        chkKeepFolderStruct.setText("Keep folders structure");
        chkKeepFolderStruct.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkKeepFolderStructItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnOptionalLayout = new javax.swing.GroupLayout(pnOptional);
        pnOptional.setLayout(pnOptionalLayout);
        pnOptionalLayout.setHorizontalGroup(
            pnOptionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOptionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOptionalLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSave))
                    .addGroup(pnOptionalLayout.createSequentialGroup()
                        .addGroup(pnOptionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkKeepFolderStruct)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnOptionalLayout.setVerticalGroup(
            pnOptionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOptionalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnOptionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkKeepFolderStruct)
                .addGap(22, 22, 22))
        );

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane1.setViewportView(txtResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnOptional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnOptional, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(openFolder);
        fileChooser.setDialogTitle("Choose a file or a folder");
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory()) return true;
                for(String type: approveFilesType){
                    if(f.getName().substring(f.getName().lastIndexOf(".") + 1).equalsIgnoreCase(type)) return true;
                }
                return false;
            }
            @Override
            public String getDescription() {
                return approveFilesType.toString();
            }
        });
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int choose = fileChooser.showOpenDialog(this);
        if(choose == JFileChooser.APPROVE_OPTION){
            openFolder = fileChooser.getSelectedFile();
            txtOpen.setText(openFolder.getAbsolutePath());
            if(openFolder.isFile()){
            cbFormatIn.setSelectedItem(ConvertPro.getFileExt(openFolder));
            } else {
                chkConvertAll.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(checkUserInput()){
            ConvertPro.log.delete(0, ConvertPro.log.length());
            if(convertAll){
                if(openFolder.isFile()){
                    openFolder = openFolder.getParentFile();
                }
                if(saveFolder.exists()){
                    saveFolder = new File(saveFolder.getAbsolutePath() + "\\" + openFolder.getName().replace(":\\", "") + " [Subtitle]");
                    saveFolder.mkdir();
                    ConvertPro.convertAlls(openFolder, saveFolder, inputFormat, outputFormat);
                } else {
                    ConvertPro.convertAlls(openFolder, inputFormat, outputFormat);
                }
            } else {
                if(!openFolder.isFile()){
                    JOptionPane.showMessageDialog(this, "You have to choose a file in convert single file mode", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(saveFolder.exists()){
                    ConvertPro.convert(saveFolder.getAbsolutePath(), openFolder, outputFormat);
                } else {
                    ConvertPro.convert(openFolder.getParent(), openFolder, outputFormat);
                }
            } 
            
            txtResult.setText(ConvertPro.log.toString() + "\nDone!");
        }
        
    }//GEN-LAST:event_btnStartActionPerformed

    private boolean checkUserInput(){
        if(outputFormat.equalsIgnoreCase("vtt")){
            JOptionPane.showMessageDialog(this, "Updating: Not support yet VTT as a output format", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(inputFormat.equalsIgnoreCase(outputFormat)){
            JOptionPane.showMessageDialog(this, "Please choose different input, output format", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!openFolder.exists()){
            JOptionPane.showMessageDialog(this, "Choose wrong folder to open", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!saveFolder.exists() && !txtSave.getText().trim().equals("") || saveFolder.isFile()){
            JOptionPane.showMessageDialog(this, "Choose wrong folder to save", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(saveFolder);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Choose a directory");
        int choose = fileChooser.showSaveDialog(this);
        if(choose == JFileChooser.APPROVE_OPTION){
            saveFolder = fileChooser.getSelectedFile();
            txtSave.setText(saveFolder.getAbsolutePath());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbFormatInItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFormatInItemStateChanged
        // TODO add your handling code here:
        inputFormat = cbFormatIn.getSelectedItem().toString();
    }//GEN-LAST:event_cbFormatInItemStateChanged

    private void cbFormatOutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFormatOutItemStateChanged
        // TODO add your handling code here:
        outputFormat = cbFormatOut.getSelectedItem().toString();
    }//GEN-LAST:event_cbFormatOutItemStateChanged

    private void chkConvertAllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkConvertAllItemStateChanged
        // TODO add your handling code here:
        convertAll = !convertAll;
    }//GEN-LAST:event_chkConvertAllItemStateChanged

    private void chkKeepFolderStructItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkKeepFolderStructItemStateChanged
        // TODO add your handling code here:
        keepFolderStruct = !keepFolderStruct;
    }//GEN-LAST:event_chkKeepFolderStructItemStateChanged

    private void txtOpenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOpenKeyTyped
        // TODO add your handling code here:
        openFolder = new File(txtOpen.getText());
        if(openFolder.isFile()){
            cbFormatIn.setSelectedItem(ConvertPro.getFileExt(openFolder));
        } else {
            chkConvertAll.setSelected(true);
        }
    }//GEN-LAST:event_txtOpenKeyTyped

    private void txtSaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaveKeyTyped
        // TODO add your handling code here:
        saveFolder = new File(txtSave.getText());
    }//GEN-LAST:event_txtSaveKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SubtitleConvertForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubtitleConvertForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubtitleConvertForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubtitleConvertForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubtitleConvertForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox<String> cbFormatIn;
    private javax.swing.JComboBox<String> cbFormatOut;
    private javax.swing.JCheckBox chkConvertAll;
    private javax.swing.JCheckBox chkKeepFolderStruct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnNormal;
    private javax.swing.JPanel pnOptional;
    private javax.swing.JTextField txtOpen;
    private javax.swing.JTextArea txtResult;
    private javax.swing.JTextField txtSave;
    // End of variables declaration//GEN-END:variables

    private void customUI() {
        getContentPane().setBackground(Color.decode("#FAFAFA"));
        pnNormal.setBackground(Color.decode("#FAFAFA"));
        pnOptional.setBackground(Color.decode("#FAFAFA"));
    }
}
