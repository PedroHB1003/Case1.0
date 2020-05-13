package JFrame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.net.ftp.FTPClient;
import java.io.*;


/**
 *
 * @author Pedro
 */
public class Download extends javax.swing.JFrame {
    
    FTPClient ftpClient;
    String server = "localhost";
    int port = 21;
    String user = "User1";
    String pass = "123123";
    
    String std;
    DefaultTableModel model;
    //String [] path;
    File [] files;
    int selectedRowIndex;
    
    

    public Download() throws IOException {
	initComponents();
	connect();
	getFilesName();
    }
    
    // Popular jTable com o nome dos arquivos de uma determinada pasta
    public void getFilesName() 
    {
	File file = new File ("C:\\ProgramData\\Enterprise Distributed Technologies\\Complete FTP\\Public\\FTP");
	files = file.listFiles();
	
	model = (DefaultTableModel)jTable_Files_Name.getModel();
	model.setColumnIdentifiers(new String[] {"Download List"});
	
	Object[] row = new Object[1];
	for (int i = 0; i < files.length; i++) {
	    row [0] = files[i].getName();
	    
	    // Utilização de um Array[] de Strings para guardar cada Path dos aquivos apresentados na JTable
	    //path [i] = files[i].getAbsolutePath();
	    
	    model.addRow(row);
	}
    }
    
    public void connect() throws IOException {
	ftpClient = new FTPClient();

	ftpClient.connect(server, port);
	ftpClient.login(user, pass);
	ftpClient.enterLocalPassiveMode();
    }
    
    public void homeSelectMethod() throws IOException {
	JFileChooser homeChooser = new JFileChooser();
	homeChooser.setDialogTitle("Local destino");
	
	homeChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	
	//Após seleção correta, mostrar Path na LabelChoosedFile
	int retorno = homeChooser.showOpenDialog(this);
	
	if (retorno == JFileChooser.APPROVE_OPTION) {  
	    std = homeChooser.getSelectedFile().getAbsolutePath();
	    txtHomeChooser.setText(std);
	}
    }
    
    public void getDownload() throws IOException {
	
	//  filename do arquivo a ser pego do servidor
	String fileName = files[selectedRowIndex].getName();
	
	// foldername do diretório selecionado para salvar arquivo, necessita de Path + /nome do arquivoBaixado
	String folderName = std + "/" + files[selectedRowIndex].getName();
        
        try (OutputStream os = new FileOutputStream(folderName)) {

            // Download file from FTPServer
            boolean status = ftpClient.retrieveFile(fileName, os);
	    
            System.out.println("status = " + status);
	    jLabel_Status.setText("Realizando download... ");
	    
            System.out.println("reply  = " + ftpClient.getReplyString());
	    jLabel_Status.setText(jLabel_Status.getText() + " Download completo!");
	    
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
		// Disconectar conecção
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_File = new javax.swing.JLabel();
        btnDownload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        homeChooser = new javax.swing.JButton();
        txtHomeChooser = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Files_Name = new javax.swing.JTable();
        jLabel_Size = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOWNLOAD");

        jLabel_File.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel_File.setForeground(new java.awt.Color(153, 153, 153));

        btnDownload.setText("Download file");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Selected file:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Download to:");

        homeChooser.setText("Browse");
        homeChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeChooserActionPerformed(evt);
            }
        });

        txtHomeChooser.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtHomeChooser.setForeground(new java.awt.Color(153, 153, 153));

        jTable_Files_Name.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable_Files_Name.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Download List"
            }
        ));
        jTable_Files_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Files_NameMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Files_Name);

        jLabel_Size.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel_Size.setForeground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("File size:");

        jLabel_Status.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel_Status.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHomeChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(homeChooser))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_File, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_File, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtHomeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeChooserActionPerformed
	try {
	    homeSelectMethod();
	} catch (IOException ex) {
	    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
	}
    }//GEN-LAST:event_homeChooserActionPerformed

    private void jTable_Files_NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Files_NameMouseClicked
	// Ao clicar na linha desejada, o nome do arquivo será visualizado no label
	selectedRowIndex = jTable_Files_Name.getSelectedRow();
	jLabel_File.setText(model.getValueAt(selectedRowIndex, 0).toString());
	
	//Mostrar tamanho do arquivo selecionado
	long fileSize = files[selectedRowIndex].length();
	jLabel_Size.setText("" + fileSize + " KB");
    }//GEN-LAST:event_jTable_Files_NameMouseClicked

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
	try {
	    getDownload();
	} catch (IOException ex) {
	    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
	}
    }//GEN-LAST:event_btnDownloadActionPerformed

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
	    java.util.logging.Logger.getLogger(Download.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Download.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Download.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Download.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    new Download().setVisible(true);
		} catch (IOException ex) {
		    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton homeChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_File;
    private javax.swing.JLabel jLabel_Size;
    private javax.swing.JLabel jLabel_Status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Files_Name;
    private javax.swing.JTextField txtHomeChooser;
    // End of variables declaration//GEN-END:variables
}
