package view;
import cliente.Cliente;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnComandos = new javax.swing.JPanel();
        btQuem = new javax.swing.JButton();
        btData = new javax.swing.JButton();
        btIP = new javax.swing.JButton();
        btMAC = new javax.swing.JButton();
        btSys = new javax.swing.JButton();
        btTrends = new javax.swing.JButton();
        btDolar = new javax.swing.JButton();
        btInfo = new javax.swing.JButton();
        btDev = new javax.swing.JButton();
        btPerson = new javax.swing.JButton();
        pnConexao = new javax.swing.JPanel();
        edServidor = new java.awt.TextField();
        lbServidor = new javax.swing.JLabel();
        btConectar = new javax.swing.JButton();
        btDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente socktes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(getPreferredSize());
        setName("Main"); // NOI18N
        setResizable(false);
        setShape(getShape());
        setSize(new java.awt.Dimension(519, 205));

        pnComandos.setBorder(javax.swing.BorderFactory.createTitledBorder("Comandos"));

        btQuem.setText("Quem");
        btQuem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQuemActionPerformed(evt);
            }
        });

        btData.setText("Data");
        btData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataActionPerformed(evt);
            }
        });

        btIP.setText("IP");
        btIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIPActionPerformed(evt);
            }
        });

        btMAC.setText("MAC");
        btMAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMACActionPerformed(evt);
            }
        });

        btSys.setText("SYS");
        btSys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSysActionPerformed(evt);
            }
        });

        btTrends.setText("Trends");
        btTrends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTrendsActionPerformed(evt);
            }
        });

        btDolar.setText("Dólar");
        btDolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDolarActionPerformed(evt);
            }
        });

        btInfo.setText("Info");
        btInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoActionPerformed(evt);
            }
        });

        btDev.setText("Dev");
        btDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDevActionPerformed(evt);
            }
        });

        btPerson.setText("Person");
        btPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPersonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnComandosLayout = new javax.swing.GroupLayout(pnComandos);
        pnComandos.setLayout(pnComandosLayout);
        pnComandosLayout.setHorizontalGroup(
            pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComandosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btQuem)
                    .addComponent(btDev))
                .addGap(18, 18, 18)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btData)
                    .addComponent(btInfo))
                .addGap(18, 18, 18)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIP)
                    .addComponent(btDolar))
                .addGap(18, 18, 18)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMAC)
                    .addComponent(btTrends))
                .addGap(18, 18, 18)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSys)
                    .addComponent(btPerson))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnComandosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btData, btDev, btDolar, btIP, btInfo, btMAC, btQuem, btSys, btTrends});

        pnComandosLayout.setVerticalGroup(
            pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComandosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btQuem)
                    .addComponent(btData)
                    .addComponent(btIP)
                    .addComponent(btMAC)
                    .addComponent(btSys))
                .addGap(18, 18, 18)
                .addGroup(pnComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDev)
                    .addComponent(btInfo)
                    .addComponent(btDolar)
                    .addComponent(btTrends)
                    .addComponent(btPerson))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnComandosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btData, btDev, btDolar, btIP, btInfo, btMAC, btQuem, btSys, btTrends});

        pnConexao.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexão"));

        edServidor.setName(""); // NOI18N

        lbServidor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbServidor.setText("Servidor:");
        lbServidor.setName(""); // NOI18N

        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        btDesconectar.setText("Desconectar");
        btDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnConexaoLayout = new javax.swing.GroupLayout(pnConexao);
        pnConexao.setLayout(pnConexaoLayout);
        pnConexaoLayout.setHorizontalGroup(
            pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDesconectar)
                .addGap(18, 18, 18)
                .addComponent(btConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnConexaoLayout.setVerticalGroup(
            pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btConectar)
                        .addComponent(btDesconectar))
                    .addComponent(lbServidor)
                    .addComponent(edServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbServidor.getAccessibleContext().setAccessibleName("lbServidor");
        lbServidor.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnConexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnComandos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnComandos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesconectarActionPerformed
        String retorno = Cliente.stopConnection();
        
        JOptionPane.showMessageDialog(null,retorno,"Desconectar", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btDesconectarActionPerformed

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        String retorno = Cliente.createConnection(edServidor.getText().toString());
        
        JOptionPane.showMessageDialog(null,retorno,"Conectar", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btConectarActionPerformed

    private void btQuemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQuemActionPerformed
        String retorno = Cliente.Execute("/quem");
        
        JOptionPane.showMessageDialog(null,retorno,"Quem", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btQuemActionPerformed

    private void btDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataActionPerformed
        String retorno = Cliente.Execute("/data");
        
        JOptionPane.showMessageDialog(null,retorno,"Data", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btDataActionPerformed

    private void btIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIPActionPerformed
        String retorno = Cliente.Execute("/ip");
        
        JOptionPane.showMessageDialog(null,retorno,"IP", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btIPActionPerformed

    private void btMACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMACActionPerformed
        String retorno = Cliente.Execute("/mac");
        
        JOptionPane.showMessageDialog(null,retorno,"MAC", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btMACActionPerformed

    private void btSysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSysActionPerformed
        String retorno = Cliente.Execute("/sys");
        
        JOptionPane.showMessageDialog(null,retorno,"SYS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btSysActionPerformed

    private void btTrendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTrendsActionPerformed
        String retorno = Cliente.Execute("/trends");
        
        JOptionPane.showMessageDialog(null,retorno,"Trends", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btTrendsActionPerformed

    private void btDolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDolarActionPerformed
        String retorno = Cliente.Execute("/dolar");
        
        JOptionPane.showMessageDialog(null,retorno,"Dólar", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btDolarActionPerformed

    private void btInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoActionPerformed
        String retorno = Cliente.Execute("/info");
        
        JOptionPane.showMessageDialog(null,retorno,"Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btInfoActionPerformed

    private void btDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDevActionPerformed
        String retorno = Cliente.Execute("/dev");
        
        JOptionPane.showMessageDialog(null,retorno,"Dev", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btDevActionPerformed

    private void btPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPersonActionPerformed
        String comando = JOptionPane.showInputDialog("Digite o comando que deseja executar:");
        
        String retorno = Cliente.Execute(comando);
        JOptionPane.showMessageDialog(null,retorno,"Personalizado", JOptionPane.INFORMATION_MESSAGE);        
    }//GEN-LAST:event_btPersonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConectar;
    private javax.swing.JButton btData;
    private javax.swing.JButton btDesconectar;
    private javax.swing.JButton btDev;
    private javax.swing.JButton btDolar;
    private javax.swing.JButton btIP;
    private javax.swing.JButton btInfo;
    private javax.swing.JButton btMAC;
    private javax.swing.JButton btPerson;
    private javax.swing.JButton btQuem;
    private javax.swing.JButton btSys;
    private javax.swing.JButton btTrends;
    private java.awt.TextField edServidor;
    private javax.swing.JLabel lbServidor;
    private javax.swing.JPanel pnComandos;
    private javax.swing.JPanel pnConexao;
    // End of variables declaration//GEN-END:variables
}
