
package VISUAL;
import DAL.ConectaBd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class frmCadPontoDistribuicao extends javax.swing.JInternalFrame {
    
    Connection conecta1;
    PreparedStatement pst;
    ResultSet rs;
   
    public frmCadPontoDistribuicao() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocation(500, 200);
        conecta1 = ConectaBd.conectabd();
    }
    
     public void listarPontos()
    {
        String sql = "Select *from ponto_de_distribuicao";
        try
        {
           pst = conecta1.prepareStatement(sql);
           rs = pst.executeQuery();
           tblPonto.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void cadastrarPonto()
    {
        String sql = "Insert into ponto_de_distribuicao(tipo,capacidade_em_w,latitude,longitude) values(?,?,?,?)";
         try
        {
          pst =conecta1.prepareStatement(sql);
          pst.setString(1,txtTipo.getText());
          pst.setString(2,txtCapacidade.getText());
          pst.setString(3,txtLatitude1.getText());
          pst.setString(4,txtLongitude1.getText());
          
          pst.execute();
          JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastrado com sucesso",JOptionPane.INFORMATION_MESSAGE);
          listarPontos();
          
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }

    }
    
     public void pesquisarPonto()
    {
        String sql = "Select *from ponto_de_distribuicao where etiqueta like ?";
        
        try
        {
            pst = conecta1.prepareStatement(sql);
            pst.setString(1, txtPesquisar1.getText()+"%");
            rs = pst.executeQuery();
            tblPonto.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);

        }
    }
     
     public void mostraItens1()
    {
      int seleciona1 = tblPonto.getSelectedRow();
      txtEtiqueta2.setText(tblPonto.getModel().getValueAt(seleciona1,0).toString());
      txtTipo.setText(tblPonto.getModel().getValueAt(seleciona1,1).toString());
      txtCapacidade.setText(tblPonto.getModel().getValueAt(seleciona1,2).toString());
      txtLatitude1.setText(tblPonto.getModel().getValueAt(seleciona1,3).toString());
      txtLongitude1.setText(tblPonto.getModel().getValueAt(seleciona1,4).toString());

    }
     
      public void editarPonto()
    {
        String sql = "Update usuarios set tipo = ?, capacidade_em_w = ?, latitude = ?, longitude = ? where etiqueta = ?";
        
        
        try
        {
            pst = conecta1.prepareStatement(sql);
            pst.setString(1, txtTipo.getText());
            pst.setString(2, txtCapacidade.getText());
            pst.setString(3, txtLatitude1.getText());
            pst.setString(4, txtLongitude1.getText());
            pst.setInt(5,Integer.parseInt(txtEtiqueta2.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
            listarPontos();
        }
        catch(SQLException error)
        {
         JOptionPane.showMessageDialog(null, error);

        }
    }
      
      public void deletar() throws SQLException
    {
        String sql = "Delete from poste where etiqueta = ? ";
       
        try
        {
            pst = conecta1.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtEtiqueta2.getText()));
            pst.execute();
        listarPontos();
        }
        catch(SQLException error)
        {
         JOptionPane.showMessageDialog(null, error);

        }
    }
     
      public void limparCampos1()
    {
        txtEtiqueta2.setText("");
        txtTipo.setText("");
        txtCapacidade.setText("");
        txtLatitude1.setText("");
        txtLongitude1.setText("");
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPonto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEtiqueta2 = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtCapacidade = new javax.swing.JTextField();
        txtLatitude1 = new javax.swing.JTextField();
        txtLongitude1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Ponto de Distribuição");

        tblPonto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPonto);

        jLabel1.setText("Etiqueta:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Capacidade:");

        jLabel4.setText("Latitude:");

        jLabel5.setText("Longitude:");

        txtEtiqueta2.setEnabled(false);
        txtEtiqueta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtiqueta2ActionPerformed(evt);
            }
        });

        jLabel6.setText("W");

        txtPesquisar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisar1MouseClicked(evt);
            }
        });
        txtPesquisar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisar1KeyReleased(evt);
            }
        });

        jLabel7.setText("Buscar");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEtiqueta2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapacidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLatitude1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLongitude1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEtiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtLatitude1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLongitude1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(17, 17, 17))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        cadastrarPonto();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPesquisar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisar1KeyReleased
        
        pesquisarPonto();
        
    }//GEN-LAST:event_txtPesquisar1KeyReleased

    private void txtPesquisar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisar1MouseClicked

        mostraItens1();
        
    }//GEN-LAST:event_txtPesquisar1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        limparCampos1();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtEtiqueta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtiqueta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtiqueta2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        editarPonto();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            deletar();
        } catch (SQLException ex) {
            Logger.getLogger(frmCadPontoDistribuicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPonto;
    private javax.swing.JTextField txtCapacidade;
    private javax.swing.JTextField txtEtiqueta2;
    private javax.swing.JTextField txtLatitude1;
    private javax.swing.JTextField txtLongitude1;
    private javax.swing.JTextField txtPesquisar1;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
