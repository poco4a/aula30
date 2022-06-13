/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.gui;

import agenda.Evento;
import agenda.io.AgendaIO;
import agenda.utils.AgendaUtils;
import agenda.utils.PeriodicidadeEnum;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author lucio
 */
public class CadastroEventosPanel extends javax.swing.JPanel {

    private ListarEventosPanel listaEventos;    

    public CadastroEventosPanel(ListarEventosPanel listaEventos) {
        this.listaEventos = listaEventos;

        initComponents();
    }

    private void limparCampos() {
        campoData.setText("");
        campoEvento.setText("");
        checkBoxAlarme.setSelected(false);
        campoEmail.setText("");
        radioButton1.setSelected(true);
    }

    private void chamaCadastroEvento() {
        AgendaIO io = new AgendaIO();
        Evento evento = new Evento();

        Object[] novaLinha = new Object[5];

        evento.setDataEvento(AgendaUtils.getDateFromString(campoData.getText()));
        evento.setDescEvento(campoEvento.getText());
        evento.setAlarme(checkBoxAlarme.isSelected() ? 1 : 0);
        evento.setEmailEncaminhar(campoEmail.getText());

        novaLinha[0] = campoData.getText();
        novaLinha[1] = campoEvento.getText();
        novaLinha[4] = checkBoxAlarme.isSelected() ? "LIGADO" : "DESLIGADO";
        novaLinha[3] = campoEmail.getText();

        if (radioButton1.isSelected()) {
            evento.setPeriodicidade(PeriodicidadeEnum.UNICO);
            novaLinha[2] = PeriodicidadeEnum.UNICO;
        } else if (radioButton2.isSelected()) {
            evento.setPeriodicidade(PeriodicidadeEnum.SEMANAL);
            novaLinha[2] = PeriodicidadeEnum.SEMANAL;
        } else {
            evento.setPeriodicidade(PeriodicidadeEnum.MENSAL);
            novaLinha[2] = PeriodicidadeEnum.MENSAL;
        }

        try {
            io.gravarEvento(evento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
        listaEventos.addNewRow(novaLinha);
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        rotuloEvento = new javax.swing.JLabel();
        campoEvento = new javax.swing.JTextField();
        rotuloData = new javax.swing.JLabel();
        campoData = new javax.swing.JTextField();
        rotuloEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        rotuloPeriodicidade = new javax.swing.JLabel();
        radioButton1 = new javax.swing.JRadioButton();
        radioButton2 = new javax.swing.JRadioButton();
        radioButton3 = new javax.swing.JRadioButton();
        checkBoxAlarme = new javax.swing.JCheckBox();
        botaoSalvar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();

        rotuloEvento.setText("Evento");

        campoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEventoActionPerformed(evt);
            }
        });

        rotuloData.setText("Data");

        campoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataActionPerformed(evt);
            }
        });

        rotuloEmail.setText("E-mail");

        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        rotuloPeriodicidade.setText("Periodicidade");

        buttonGroup.add(radioButton1);
        radioButton1.setText("Uma vez");

        buttonGroup.add(radioButton2);
        radioButton2.setText("Semanal");

        buttonGroup.add(radioButton3);
        radioButton3.setText("Mensal");

        checkBoxAlarme.setText("Alarme");
        checkBoxAlarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAlarmeActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoLimpar))
                    .addComponent(checkBoxAlarme)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloEvento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotuloPeriodicidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(radioButton2)
                        .addGap(10, 10, 10)
                        .addComponent(radioButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloEvento)
                    .addComponent(campoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloData)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloEmail)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloPeriodicidade)
                    .addComponent(radioButton1)
                    .addComponent(radioButton2)
                    .addComponent(radioButton3))
                .addGap(18, 18, 18)
                .addComponent(checkBoxAlarme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoLimpar))
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEventoActionPerformed

    private void campoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void checkBoxAlarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAlarmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxAlarmeActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        chamaCadastroEvento();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_botaoLimparActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEvento;
    private javax.swing.JCheckBox checkBoxAlarme;
    private javax.swing.JRadioButton radioButton1;
    private javax.swing.JRadioButton radioButton2;
    private javax.swing.JRadioButton radioButton3;
    private javax.swing.JLabel rotuloData;
    private javax.swing.JLabel rotuloEmail;
    private javax.swing.JLabel rotuloEvento;
    private javax.swing.JLabel rotuloPeriodicidade;
    // End of variables declaration//GEN-END:variables
}
