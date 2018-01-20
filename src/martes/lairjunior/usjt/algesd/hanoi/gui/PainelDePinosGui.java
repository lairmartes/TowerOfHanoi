/*
 * PainelDePinosGui.java
 *
 * Created on 27 de Setembro de 2005, 04:24
 */

package martes.lairjunior.usjt.algesd.hanoi.gui;

import martes.lairjunior.usjt.algesd.hanoi.Disk;
import martes.lairjunior.usjt.algesd.hanoi.HanoiTowerControl;
import martes.lairjunior.usjt.algesd.hanoi.command.PinoCommandFactory;
import martes.lairjunior.usjt.algesd.hanoi.exception.InvalidMoveException;

/**
 *
 * @author  lair
 */
public class PainelDePinosGui extends javax.swing.JPanel {
    private LinhaDeDisco _linhaDoDiscoAtual;
    private Disk _discoAtual;
    private HanoiTowerControl _hanoiTowerControl;
    private int _moves;
    /** Creates new form PainelDePinosGui */
    public PainelDePinosGui() {
        _hanoiTowerControl = new HanoiTowerControl(3);
        initComponents();
        iniciarJogo();
    }
    public void iniciarJogo() {
        habilitarBotoes();
        atualizarDisco(Disk.DISK_ZERO);
        atualizarPinos();
    }
    public void terminarJogo() {
        desabilitarBotoes();
        _avisoAndamentoJogo.setText("Jogo Terminado em " + _moves + " movimentos.");
    }
    private void habilitarBotoes() {
        _pino1GuiBotao.setEnabled(true);
        _pino2GuiBotao.setEnabled(true);
        _pino3GuiBotao.setEnabled(true);
    }
    private void desabilitarBotoes() {
        _pino1GuiBotao.setEnabled(false);
        _pino2GuiBotao.setEnabled(false);
        _pino3GuiBotao.setEnabled(false);
    }
    private void atualizarDisco(Disk selectedDisk) {
        _discoAtual = selectedDisk;
        _discoAtualTamanhoGuiLabel.setText(Integer.toString(_discoAtual.getSize()));
        _linhaDoDiscoAtual = new LinhaDeDisco(_discoAtual);
        _discoAtualGuiLabel.setText(_linhaDoDiscoAtual.toString());
        _avisoMovimentoInvalido.setText("");
        _avisoAndamentoJogo.setText("Quantidade de Movimentos : " + HanoiTowerControl.getInstance().getQuantidadeDeMovimentos());
        if (HanoiTowerControl.getInstance().isJogoTerminado())
            terminarJogo();
    }
    private void atualizarPinos() {
        _pino1VisualPanel.setPino(HanoiTowerControl.getInstance().getPino(HanoiTowerControl.PIN_1));
        _pino2VisualPanel.setPino(HanoiTowerControl.getInstance().getPino(HanoiTowerControl.PIN_2));
        _pino3VisualPanel.setPino(HanoiTowerControl.getInstance().getPino(HanoiTowerControl.PIN_3));
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        _painelBotoes = new javax.swing.JPanel();
        _pino1GuiBotao = new javax.swing.JButton();
        _pino2GuiBotao = new javax.swing.JButton();
        _pino3GuiBotao = new javax.swing.JButton();
        _painelVisualPinos = new javax.swing.JPanel();
        _pino1VisualPanel = new martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel();
        _pino2VisualPanel = new martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel();
        _pino3VisualPanel = new martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel();
        _painelDescricaoDisco = new javax.swing.JPanel();
        _discoAtualCampoGuiLabel = new javax.swing.JLabel();
        _discoAtualGuiLabel = new javax.swing.JLabel();
        _discoAtualCampoTamanhoGuiLabel = new javax.swing.JLabel();
        _discoAtualTamanhoGuiLabel = new javax.swing.JLabel();
        _avisoMovimentoInvalido = new javax.swing.JLabel();
        _avisoAndamentoJogo = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        _painelBotoes.setLayout(new java.awt.GridBagLayout());

        _pino1GuiBotao.setText("Pin 1");
        _pino1GuiBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _pino1GuiBotaoActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 4);
        _painelBotoes.add(_pino1GuiBotao, gridBagConstraints);

        _pino2GuiBotao.setText("Pin 2");
        _pino2GuiBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _pino2GuiBotaoActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 4);
        _painelBotoes.add(_pino2GuiBotao, gridBagConstraints);

        _pino3GuiBotao.setText("Pin 3");
        _pino3GuiBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _pino3GuiBotaoActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 4);
        _painelBotoes.add(_pino3GuiBotao, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 2, 3, 2);
        add(_painelBotoes, gridBagConstraints);

        _painelVisualPinos.setLayout(new java.awt.GridBagLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _painelVisualPinos.add(_pino1VisualPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _painelVisualPinos.add(_pino2VisualPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        _painelVisualPinos.add(_pino3VisualPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 2, 3, 2);
        add(_painelVisualPinos, gridBagConstraints);

        _painelDescricaoDisco.setLayout(new java.awt.GridBagLayout());

        _discoAtualCampoGuiLabel.setText("DiscoAtual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        _painelDescricaoDisco.add(_discoAtualCampoGuiLabel, gridBagConstraints);

        _discoAtualGuiLabel.setText("___");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        _painelDescricaoDisco.add(_discoAtualGuiLabel, gridBagConstraints);

        _discoAtualCampoTamanhoGuiLabel.setText("Tamanho");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        _painelDescricaoDisco.add(_discoAtualCampoTamanhoGuiLabel, gridBagConstraints);

        _discoAtualTamanhoGuiLabel.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        _painelDescricaoDisco.add(_discoAtualTamanhoGuiLabel, gridBagConstraints);

        _avisoMovimentoInvalido.setFont(new java.awt.Font("Dialog", 1, 11));
        _avisoMovimentoInvalido.setForeground(new java.awt.Color(255, 102, 102));
        _avisoMovimentoInvalido.setText("Movimento Invalido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 2, 3);
        _painelDescricaoDisco.add(_avisoMovimentoInvalido, gridBagConstraints);

        _avisoAndamentoJogo.setFont(new java.awt.Font("Dialog", 1, 12));
        _avisoAndamentoJogo.setForeground(new java.awt.Color(0, 102, 0));
        _avisoAndamentoJogo.setText("Jogo em andamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        _painelDescricaoDisco.add(_avisoAndamentoJogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        add(_painelDescricaoDisco, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void _pino3GuiBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__pino3GuiBotaoActionPerformed
      atualizarTela(HanoiTowerControl.PIN_3);
    }//GEN-LAST:event__pino3GuiBotaoActionPerformed

    private void _pino2GuiBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__pino2GuiBotaoActionPerformed
      atualizarTela(HanoiTowerControl.PIN_2);
    }//GEN-LAST:event__pino2GuiBotaoActionPerformed

    private void _pino1GuiBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__pino1GuiBotaoActionPerformed
      atualizarTela(HanoiTowerControl.PIN_1);
    }
      private void atualizarTela(int pinoAcionado) {
        try {
            HanoiTowerControl.getInstance().setDiscoAtual(
            PinoCommandFactory.getInstance()
                          .create(HanoiTowerControl.getInstance().getDiscoAtual())
                          .doAction(HanoiTowerControl.getInstance().getPino(pinoAcionado),
                                    HanoiTowerControl.getInstance().getDiscoAtual())
            );
            atualizarDisco();
            atualizarPinos();
        }catch (InvalidMoveException e) {
            _avisoMovimentoInvalido.setText(e.getMessage());
        }
    }//GEN-LAST:event__pino1GuiBotaoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _avisoAndamentoJogo;
    private javax.swing.JLabel _avisoMovimentoInvalido;
    private javax.swing.JLabel _discoAtualCampoGuiLabel;
    private javax.swing.JLabel _discoAtualCampoTamanhoGuiLabel;
    private javax.swing.JLabel _discoAtualGuiLabel;
    private javax.swing.JLabel _discoAtualTamanhoGuiLabel;
    private javax.swing.JPanel _painelBotoes;
    private javax.swing.JPanel _painelDescricaoDisco;
    private javax.swing.JPanel _painelVisualPinos;
    private javax.swing.JButton _pino1GuiBotao;
    private martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel _pino1VisualPanel;
    private javax.swing.JButton _pino2GuiBotao;
    private martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel _pino2VisualPanel;
    private javax.swing.JButton _pino3GuiBotao;
    private martes.lairjunior.usjt.algesd.hanoi.gui.PinoVisualPanel _pino3VisualPanel;
    // End of variables declaration//GEN-END:variables
    
}
