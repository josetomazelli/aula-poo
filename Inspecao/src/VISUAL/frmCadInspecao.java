
package VISUAL;
import DAL.ConectaBd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class frmCadInspecao extends javax.swing.JInternalFrame {

    Connection conecta2;
    PreparedStatement pst;
    ResultSet rs;
   
    public frmCadInspecao() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocation(500, 200);
        conecta2 = ConectaBd.conectabd();

    }
    
     public void listarInspecoes()
    {
        String sql = "Select *from inspecao";
        try
        {
           pst = conecta2.prepareStatement(sql);
           rs = pst.executeQuery();
           tblInspecao.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
     public void cadastrarInspecao()
    {
        String sql = "Insert into inspecao (data,estado,prumo,condicao_de_fiacao) values(?,?,?,?)";
         try
        {
          pst =conecta2.prepareStatement(sql);
          pst.setString(1,txtData.getText());
          pst.setString(2,boxEstado.getActionCommand());
          pst.setString(3,txtPrumo.getText());
          pst.setString(4,boxCondicao.getActionCommand());
          
          pst.execute();
          JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
          listarInspecoes();
          
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }

    }
     
      public void pesquisarInspecao()
    {
        String sql = "Select *from poste where data like ?";
        
        try
        {
            pst = conecta2.prepareStatement(sql);
            pst.setString(1, txtPesquisar2.getText()+"%");
            rs = pst.executeQuery();
            tblInspecao.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);

        }
    }
      
        public void mostraItens2()
    {
      int seleciona2 = tblInspecao.getSelectedRow();
      txtCodigo.setText(tblInspecao.getModel().getValueAt(seleciona2,0).toString());
      txtData.setText(tblInspecao.getModel().getValueAt(seleciona2,1).toString());
      boxEstado.setActionCommand(tblInspecao.getModel().getValueAt(seleciona2,2).toString());
      txtPrumo.setText(tblInspecao.getModel().getValueAt(seleciona2,3).toString());
      boxCondicao.setActionCommand(tblInspecao.getModel().getValueAt(seleciona2,4).toString());

    }
        
         public void editarInspecao()
    {
        String sql = "Update usuarios set data = ?, estado = ?, prumo = ?, condicao_fiacao = ? where etiqueta = ?";
        
        
        try
        {
            pst = conecta2.prepareStatement(sql);
            pst.setString(1, txtData.getText());
            pst.setString(2, (String) boxEstado.getSelectedItem());
            pst.setString(3, txtPrumo.getText());
            pst.setString(4, (String) boxCondicao.getSelectedItem());
            pst.setInt(5,Integer.parseInt(txtCodigo.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
            listarInspecoes();
        }
        catch(SQLException error)
        {
         JOptionPane.showMessageDialog(null, error);

        }
    }
         
         public void deletar() throws SQLException
    {
        String sql = "Delete from poste where os = ? ";
   
        try
        {
            pst = conecta2.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigo.getText()));
            pst.execute();
            listarInspecoes();
        }
        catch(SQLException error)
        {
         JOptionPane.showMessageDialog(null, error);

        }
    }
        
        public void limparCampos()
    {
        txtCodigo.setText("");
        txtData.setText("");
        boxEstado.setSelectedItem(0);
        txtPrumo.setText("");
        boxCondicao.setSelectedItem(0);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesquisar2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInspecao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrumo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        boxEstado = new javax.swing.JComboBox<>();
        boxCondicao = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Inspeção");

        jLabel1.setText("Buscar");

        txtPesquisar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisar2MouseClicked(evt);
            }
        });
        txtPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisar2ActionPerformed(evt);
            }
        });
        txtPesquisar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisar2KeyReleased(evt);
            }
        });

        tblInspecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblInspecao);

        jLabel2.setText("Código:");

        txtCodigo.setEnabled(false);

        jLabel3.setText("Data:");

        jLabel4.setText("Prumo:");

        jLabel5.setText("Estado do poste:");

        jLabel6.setText("Condição da fiação:");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adequado", "Inadequado" }));
        boxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstadoActionPerformed(evt);
            }
        });

        boxCondicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adequada", "Inadequada" }));

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtCodigo))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(txtPrumo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(boxCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisar2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        cadastrarInspecao();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPesquisar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisar2KeyReleased
        
        pesquisarInspecao();
        
    }//GEN-LAST:event_txtPesquisar2KeyReleased

    private void txtPesquisar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisar2MouseClicked

        mostraItens2();
        
    }//GEN-LAST:event_txtPesquisar2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        limparCampos();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        editarInspecao();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            deletar();
        } catch (SQLException ex) {
            Logger.getLogger(frmCadInspecao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCondicao;
    private javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInspecao;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtPesquisar2;
    private javax.swing.JTextField txtPrumo;
    // End of variables declaration//GEN-END:variables
}
