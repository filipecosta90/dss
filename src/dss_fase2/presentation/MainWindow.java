/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.presentation;

import dss_fase2.business.Cidadao;
import dss_fase2.business.Eleicao;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

/**
 *
 * @author filipeoliveira
 */
public class MainWindow extends javax.swing.JFrame {
  private Cidadao cidadaoActivo;
  private Eleicao eleicao;

  /**
   * Creates new form janelaLogin
   */

  private void enablePanel( String panel) {
    this.painel_admin_apresentar_resultado.setVisible(false);
    this.painel_admin_encerrar_votacao.setVisible(false);
    this.painel_admin_iniciar_votacao.setVisible(false);
    this.painel_eleitor_votar.setVisible(false);
    this.painel_eleitor_votar_antecipadamente.setVisible(false);
    this.painel_sistema_login.setVisible(false);
    this.painel_sistema_sessao.setVisible(false);

    this.getContentPane().removeAll();
    this.getContentPane().add(painel_informacao);
    this.painel_informacao.setVisible(true);
    this.mensagem.setVisible(true);
    this.label_sessao.setVisible(true);

    switch(panel){
      case "login": 
        this.painel_sistema_login.setVisible(true);
        this.getContentPane().add(painel_sistema_login);
        disableSubMenu("logout");
        break;
      case "sessao": 
        this.painel_sistema_sessao.setVisible(true);
        this.getContentPane().add(painel_sistema_sessao);
        disableSubMenu("login");
        break;
      case "votar": 
        this.painel_eleitor_votar.setVisible(true);
        this.getContentPane().add(painel_eleitor_votar);
        break;
      case "votar_antecipadamente":
        this.painel_eleitor_votar_antecipadamente.setVisible(true);
        this.getContentPane().add(painel_eleitor_votar_antecipadamente);
        break;
      case "iniciar_votacao":
        this.painel_admin_iniciar_votacao.setVisible(true);
        this.getContentPane().add(painel_admin_iniciar_votacao);
        break;
      case "encerrar_votacao":
        this.painel_admin_encerrar_votacao.setVisible(true);
        this.getContentPane().add(painel_admin_encerrar_votacao);
        break;
      case "apresentar_resultado":
        this.painel_admin_apresentar_resultado.setVisible(true);
        this.getContentPane().add(painel_admin_apresentar_resultado);
        break;
    }
  }

  private void enviaMensagem ( boolean sessaoAtiva, String mensagem, boolean erro,  boolean ok ){
    this.label_sessao.setVisible(false);
    this.label_nome_cidadao.setVisible(false);
    this.mensagem.setVisible(false);
    this.mensagem.setText("");


    if ( erro || ok ){
      this.mensagem.setVisible(true);
      this.mensagem.setText(mensagem);
      if (erro == true){
        this.mensagem.setForeground(Color.RED);
      }
      if ( ok == true ){
        this.mensagem.setForeground(Color.blue);
      }
    }

    if (sessaoAtiva ){
      this.label_sessao.setVisible(true);
      this.label_nome_cidadao.setVisible(true);
      this.label_nome_cidadao.setText(this.cidadaoActivo.getNome());
    }
  }

  private void enableMenu ( String permit ){
    this.menuAdmin.setVisible(false);
    this.menuEleitor.setVisible(false);
    switch (permit){
      case "sistema":
        break;
      case "admin":
        this.menuEleitor.setVisible(true);
        this.menuAdmin.setVisible(true);
        break;
      case "eleitor":
        this.menuEleitor.setVisible(true);
        break;
    }
  }

  private void disableSubMenu ( String deny ){
    this.item_login.setVisible(true);
    this.item_logout.setVisible(true);
    switch (deny){
      case "logout":
        this.item_logout.setVisible(false);
        break;
      case "login":
        this.item_login.setVisible(false);
        break;
    }
  }

  private void enableRadio (int index, String partido ){
    switch (index){
      case 1:
        this.radio1.setVisible(true);
        this.radio1.setText(partido);
        this.butoesVotar.add(radio1);
        break;
      case 2:
        this.radio2.setVisible(true);
        this.radio2.setText(partido);
        this.butoesVotar.add(radio2);

        break;
      case 3:
        this.radio3.setVisible(true);
        this.radio3.setText(partido);
        this.butoesVotar.add(radio3);

        break;
      case 4:
        this.radio4.setVisible(true);
        this.radio4.setText(partido);
        this.butoesVotar.add(radio4);
        break;
      case 5:
        this.radio5.setVisible(true);
        this.radio5.setText(partido);
        this.butoesVotar.add(radio5);

        break;
      case 6:
        this.radio6.setVisible(true);
        this.radio6.setText(partido);
        this.butoesVotar.add(radio6);

        break;
      case 7:
        this.radio7.setVisible(true);
        this.radio7.setText(partido);
        this.butoesVotar.add(radio7);

        break;
      case 8:
        this.radio8.setVisible(true);
        this.radio8.setText(partido);
        this.butoesVotar.add(radio8);

        break;
      case 9:
        this.radio9.setVisible(true);
        this.radio9.setText(partido);
        this.butoesVotar.add(radio9);

        break;
      case 10:
        this.radio10.setVisible(true);
        this.radio10.setText(partido);
        this.butoesVotar.add(radio10);

        break;

    }
  }

  private void disableRadio (int index ){
    switch (index){
      case 1:
        this.radio1.setVisible(false);
        break;
      case 2:
        this.radio2.setVisible(false);
        break;
      case 3:
        this.radio3.setVisible(false);
        break;
      case 4:
        this.radio4.setVisible(false);
        break;
      case 5:
        this.radio5.setVisible(false);
        break;
      case 6:
        this.radio6.setVisible(false);
        break;
      case 7:
        this.radio7.setVisible(false);
        break;
      case 8:
        this.radio8.setVisible(false);
        break;
      case 9:
        this.radio9.setVisible(false);
        break;
      case 10:
        this.radio10.setVisible(false);
        break;

    }
  }

  private int existeSeleccaoBotoesVoto(){
    int pos = -1;
    if ( this.radio1.isSelected() ){
      pos = 1;
    }
    if ( this.radio2.isSelected() ){
      pos = 2;
    }
    if ( this.radio3.isSelected() ){
      pos = 3;
    }
    if ( this.radio4.isSelected() ){
      pos = 4;
    }
    if ( this.radio5.isSelected() ){
      pos = 5;
    }
    if ( this.radio6.isSelected() ){
      pos = 6;
    }
    if ( this.radio7.isSelected() ){
      pos = 7;
    }
    if ( this.radio8.isSelected() ){
      pos = 8;
    }
    if ( this.radio9.isSelected() ){
      pos = 9;
    }
    if ( this.radio10.isSelected() ){
      pos = 10;
    }
    return pos;
  }

  private String getValorSeleccaoBotaoVoto (int index ){
    String valor="";
    switch (index){
      case 1:
        valor = this.radio1.getText();
        break;
      case 2:
        valor = this.radio2.getText();
        break;
      case 3:
        valor = this.radio3.getText();
        break;
      case 4:
        valor = this.radio4.getText();
        break;
      case 5:
        valor = this.radio5.getText();
        break;
      case 6:
        valor = this.radio6.getText();
        break;
      case 7:
        valor = this.radio7.getText();
        break;
      case 8:
        valor = this.radio8.getText();
        break;
      case 9:
        valor = this.radio9.getText();
        break;
      case 10:
        valor = this.radio10.getText();
        break;
    }
    return valor;
  }

  public MainWindow() {
    initComponents();
    this.eleicao = new Eleicao();

    //menu sistema
    this.menuSistema.setVisible(true);
    //menu eleitor
    this.menuEleitor.setVisible(false);
    //menu admin
    this.menuAdmin.setVisible(false);

    enablePanel("login");
    this.enviaMensagem(false, "", false, false);

  }


  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

      butoesVotar = new javax.swing.ButtonGroup();
      painel_informacao = new javax.swing.JPanel();
      jLabel10 = new javax.swing.JLabel();
      label_sessao = new javax.swing.JLabel();
      label_nome_cidadao = new javax.swing.JLabel();
      mensagem = new javax.swing.JLabel();
      painel_admin_encerrar_votacao = new javax.swing.JPanel();
      painel_admin_apresentar_resultado = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      painel_admin_iniciar_votacao = new javax.swing.JPanel();
      jLabel7 = new javax.swing.JLabel();
      painel_eleitor_votar = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      radio1 = new javax.swing.JRadioButton();
      radio2 = new javax.swing.JRadioButton();
      radio3 = new javax.swing.JRadioButton();
      radio4 = new javax.swing.JRadioButton();
      radio5 = new javax.swing.JRadioButton();
      radio6 = new javax.swing.JRadioButton();
      radio7 = new javax.swing.JRadioButton();
      radio8 = new javax.swing.JRadioButton();
      radio9 = new javax.swing.JRadioButton();
      radio10 = new javax.swing.JRadioButton();
      butao_registar_voto = new javax.swing.JButton();
      painel_eleitor_votar_antecipadamente = new javax.swing.JPanel();
      jLabel6 = new javax.swing.JLabel();
      painel_sistema_sessao = new javax.swing.JPanel();
      painel_sistema_login = new javax.swing.JPanel();
      jLabel5 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      field_cc = new javax.swing.JTextField();
      field_password = new javax.swing.JTextField();
      butao_login = new javax.swing.JButton();
      menuBar = new javax.swing.JMenuBar();
      menuSistema = new javax.swing.JMenu();
      item_login = new javax.swing.JMenuItem();
      item_logout = new javax.swing.JMenuItem();
      menuEleitor = new javax.swing.JMenu();
      item_votar = new javax.swing.JMenuItem();
      item_votar_antecipadamente = new javax.swing.JMenuItem();
      menuAdmin = new javax.swing.JMenu();
      item_iniciar_votacao = new javax.swing.JMenuItem();
      item_encerrar_votacao = new javax.swing.JMenuItem();
      item_apresentar_resultado = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("frame_principal");
      setBounds(new java.awt.Rectangle(0, 0, 0, 0));
      setMaximumSize(new java.awt.Dimension(500, 500));
      setPreferredSize(new java.awt.Dimension(500, 500));
      setResizable(false);

      painel_informacao.setMinimumSize(new java.awt.Dimension(500, 100));
      painel_informacao.setPreferredSize(new java.awt.Dimension(500, 100));
      painel_informacao.setLayout(null);

      jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dss_fase2/presentation/cne.png"))); // NOI18N
      painel_informacao.add(jLabel10);
      jLabel10.setBounds(324, 6, 170, 90);

      label_sessao.setText("Sessão Iniciada como:");
      painel_informacao.add(label_sessao);
      label_sessao.setBounds(11, 6, 139, 16);

      label_nome_cidadao.setText("jLabel12");
      painel_informacao.add(label_nome_cidadao);
      label_nome_cidadao.setBounds(162, 6, 200, 16);

      mensagem.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
      mensagem.setForeground(new java.awt.Color(0, 153, 153));
      mensagem.setText("Mensagem");
      painel_informacao.add(mensagem);
      mensagem.setBounds(10, 20, 310, 70);

      painel_admin_encerrar_votacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      painel_admin_encerrar_votacao.setEnabled(false);
      painel_admin_encerrar_votacao.setPreferredSize(new java.awt.Dimension(500, 500));
      painel_admin_encerrar_votacao.setSize(new java.awt.Dimension(500, 500));

      javax.swing.GroupLayout painel_admin_encerrar_votacaoLayout = new javax.swing.GroupLayout(painel_admin_encerrar_votacao);
      painel_admin_encerrar_votacao.setLayout(painel_admin_encerrar_votacaoLayout);
      painel_admin_encerrar_votacaoLayout.setHorizontalGroup(
          painel_admin_encerrar_votacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 498, Short.MAX_VALUE)
          );
      painel_admin_encerrar_votacaoLayout.setVerticalGroup(
          painel_admin_encerrar_votacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 498, Short.MAX_VALUE)
          );

      painel_admin_apresentar_resultado.setEnabled(false);
      painel_admin_apresentar_resultado.setPreferredSize(new java.awt.Dimension(500, 500));

      jLabel1.setText("apresentar resultado");

      jLabel4.setText("encerrar votacao");

      javax.swing.GroupLayout painel_admin_apresentar_resultadoLayout = new javax.swing.GroupLayout(painel_admin_apresentar_resultado);
      painel_admin_apresentar_resultado.setLayout(painel_admin_apresentar_resultadoLayout);
      painel_admin_apresentar_resultadoLayout.setHorizontalGroup(
          painel_admin_apresentar_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_admin_apresentar_resultadoLayout.createSequentialGroup()
            .addContainerGap(247, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addGap(149, 149, 149))
          .addGroup(painel_admin_apresentar_resultadoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
      painel_admin_apresentar_resultadoLayout.setVerticalGroup(
          painel_admin_apresentar_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_admin_apresentar_resultadoLayout.createSequentialGroup()
            .addGap(370, 370, 370)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addGap(158, 158, 158))
          );

      painel_admin_iniciar_votacao.setEnabled(false);
      painel_admin_iniciar_votacao.setPreferredSize(new java.awt.Dimension(500, 500));

      jLabel7.setText("iniciar votação");

      javax.swing.GroupLayout painel_admin_iniciar_votacaoLayout = new javax.swing.GroupLayout(painel_admin_iniciar_votacao);
      painel_admin_iniciar_votacao.setLayout(painel_admin_iniciar_votacaoLayout);
      painel_admin_iniciar_votacaoLayout.setHorizontalGroup(
          painel_admin_iniciar_votacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_admin_iniciar_votacaoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addContainerGap(402, Short.MAX_VALUE))
          );
      painel_admin_iniciar_votacaoLayout.setVerticalGroup(
          painel_admin_iniciar_votacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_admin_iniciar_votacaoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

      painel_eleitor_votar.setEnabled(false);
      painel_eleitor_votar.setPreferredSize(new java.awt.Dimension(500, 500));
      painel_eleitor_votar.setLayout(null);

      jLabel2.setText("votar");
      painel_eleitor_votar.add(jLabel2);
      jLabel2.setBounds(10, 100, 32, 16);

      radio1.setText("jRadioButton1");
      painel_eleitor_votar.add(radio1);
      radio1.setBounds(60, 110, 120, 23);

      radio2.setText("jRadioButton2");
      painel_eleitor_votar.add(radio2);
      radio2.setBounds(60, 140, 120, 23);

      radio3.setText("jRadioButton3");
      painel_eleitor_votar.add(radio3);
      radio3.setBounds(60, 170, 120, 23);

      radio4.setText("jRadioButton4");
      painel_eleitor_votar.add(radio4);
      radio4.setBounds(60, 200, 120, 23);

      radio5.setText("jRadioButton5");
      painel_eleitor_votar.add(radio5);
      radio5.setBounds(60, 240, 120, 23);

      radio6.setText("jRadioButton6");
      painel_eleitor_votar.add(radio6);
      radio6.setBounds(290, 110, 120, 23);

      radio7.setText("jRadioButton7");
      painel_eleitor_votar.add(radio7);
      radio7.setBounds(290, 140, 120, 23);

      radio8.setText("jRadioButton8");
      painel_eleitor_votar.add(radio8);
      radio8.setBounds(290, 180, 120, 23);

      radio9.setText("jRadioButton9");
      painel_eleitor_votar.add(radio9);
      radio9.setBounds(290, 210, 120, 23);

      radio10.setText("jRadioButton10");
      painel_eleitor_votar.add(radio10);
      radio10.setBounds(290, 240, 128, 23);

      butao_registar_voto.setText("Registar Voto");
      butao_registar_voto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          butao_registar_votoActionPerformed(evt);
        }
      });
      painel_eleitor_votar.add(butao_registar_voto);
      butao_registar_voto.setBounds(360, 360, 128, 29);

      painel_eleitor_votar_antecipadamente.setEnabled(false);
      painel_eleitor_votar_antecipadamente.setPreferredSize(new java.awt.Dimension(500, 500));

      jLabel6.setText("votar antecipadamente");

      javax.swing.GroupLayout painel_eleitor_votar_antecipadamenteLayout = new javax.swing.GroupLayout(painel_eleitor_votar_antecipadamente);
      painel_eleitor_votar_antecipadamente.setLayout(painel_eleitor_votar_antecipadamenteLayout);
      painel_eleitor_votar_antecipadamenteLayout.setHorizontalGroup(
          painel_eleitor_votar_antecipadamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_eleitor_votar_antecipadamenteLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel6)
            .addContainerGap(351, Short.MAX_VALUE))
          );
      painel_eleitor_votar_antecipadamenteLayout.setVerticalGroup(
          painel_eleitor_votar_antecipadamenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_eleitor_votar_antecipadamenteLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel6)
            .addContainerGap(478, Short.MAX_VALUE))
          );

      painel_sistema_sessao.setEnabled(false);
      painel_sistema_sessao.setLocation(new java.awt.Point(100, 0));
      painel_sistema_sessao.setMaximumSize(new java.awt.Dimension(400, 500));
      painel_sistema_sessao.setMinimumSize(new java.awt.Dimension(400, 500));
      painel_sistema_sessao.setPreferredSize(new java.awt.Dimension(400, 500));

      javax.swing.GroupLayout painel_sistema_sessaoLayout = new javax.swing.GroupLayout(painel_sistema_sessao);
      painel_sistema_sessao.setLayout(painel_sistema_sessaoLayout);
      painel_sistema_sessaoLayout.setHorizontalGroup(
          painel_sistema_sessaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 400, Short.MAX_VALUE)
          );
      painel_sistema_sessaoLayout.setVerticalGroup(
          painel_sistema_sessaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 500, Short.MAX_VALUE)
          );

      painel_sistema_login.setPreferredSize(new java.awt.Dimension(500, 500));

      jLabel5.setText("login");

      jLabel8.setText("Cartão Cidadão");

      jLabel9.setText("Password");

      field_cc.setToolTipText("");
      field_cc.setMinimumSize(new java.awt.Dimension(160, 28));
      field_cc.setPreferredSize(new java.awt.Dimension(160, 28));
      field_cc.setSize(new java.awt.Dimension(160, 28));
      field_cc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          field_ccActionPerformed(evt);
        }
      });

      field_password.setPreferredSize(new java.awt.Dimension(160, 28));
      field_password.setSize(new java.awt.Dimension(160, 28));

      butao_login.setLabel("Login");
      butao_login.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          butao_loginActionPerformed(evt);
        }
      });

      javax.swing.GroupLayout painel_sistema_loginLayout = new javax.swing.GroupLayout(painel_sistema_login);
      painel_sistema_login.setLayout(painel_sistema_loginLayout);
      painel_sistema_loginLayout.setHorizontalGroup(
          painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_sistema_loginLayout.createSequentialGroup()
            .addGap(101, 101, 101)
            .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5)
              .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(butao_login)
                .addGroup(painel_sistema_loginLayout.createSequentialGroup()
                  .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                  .addGap(18, 18, 18)
                  .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addContainerGap(125, Short.MAX_VALUE))
          );
      painel_sistema_loginLayout.setVerticalGroup(
          painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_sistema_loginLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel5)
            .addGap(18, 18, 18)
            .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel8)
              .addComponent(field_cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(painel_sistema_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel9)
              .addComponent(field_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(butao_login)
            .addContainerGap(345, Short.MAX_VALUE))
          );

      menuSistema.setText("Sistema");

      item_login.setText("login");
      item_login.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_loginActionPerformed(evt);
        }
      });
      menuSistema.add(item_login);

      item_logout.setText("logout");
      item_logout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_logoutActionPerformed(evt);
        }
      });
      menuSistema.add(item_logout);

      menuBar.add(menuSistema);

      menuEleitor.setText("Eleitor");

      item_votar.setText("votar");
      item_votar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_votarActionPerformed(evt);
        }
      });
      menuEleitor.add(item_votar);

      item_votar_antecipadamente.setText("votar antecipadamente");
      item_votar_antecipadamente.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_votar_antecipadamenteActionPerformed(evt);
        }
      });
      menuEleitor.add(item_votar_antecipadamente);

      menuBar.add(menuEleitor);

      menuAdmin.setText("Admin");

      item_iniciar_votacao.setText("iniciar votação");
      item_iniciar_votacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_iniciar_votacaoActionPerformed(evt);
        }
      });
      menuAdmin.add(item_iniciar_votacao);

      item_encerrar_votacao.setText("encerrar votação");
      item_encerrar_votacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_encerrar_votacaoActionPerformed(evt);
        }
      });
      menuAdmin.add(item_encerrar_votacao);

      item_apresentar_resultado.setText("apresentar resultado");
      item_apresentar_resultado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_apresentar_resultadoActionPerformed(evt);
        }
      });
      menuAdmin.add(item_apresentar_resultado);

      menuBar.add(menuAdmin);

      setJMenuBar(menuBar);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(painel_admin_iniciar_votacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_admin_encerrar_votacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_sistema_sessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_sistema_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_eleitor_votar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_eleitor_votar_antecipadamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_admin_apresentar_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(painel_admin_iniciar_votacao, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
          .addComponent(painel_admin_encerrar_votacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_sistema_sessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(120, 120, 120)
            .addComponent(painel_sistema_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(painel_eleitor_votar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_eleitor_votar_antecipadamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_admin_apresentar_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          );

      pack();
    }// </editor-fold>//GEN-END:initComponents

  private void item_votarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_votarActionPerformed
    if ( this.cidadaoActivo.getJaVotou() == false ){
      enablePanel("votar");
      int i = 1;
      for(String nomeLista : this.eleicao.getMapaListas().keySet()) {
        enableRadio(i, nomeLista);
        System.out.println(nomeLista);
        i++;
      }
      for (  ; i <= 10; i++ ){
        disableRadio(i);
      }
    }
    else {
      enviaMensagem(true, "Já efectuou o voto!", true, false );
    }
  }//GEN-LAST:event_item_votarActionPerformed

  private void item_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_logoutActionPerformed
    this.cidadaoActivo.terminaSessao();
    this.eleicao.logout(this.cidadaoActivo.getCC());
    enablePanel("login");
    enableMenu("sistema");
    disableSubMenu("logout");
    this.field_cc.setText("");
    this.field_password.setText("");
    this.enviaMensagem(false,"",false,false);
  }//GEN-LAST:event_item_logoutActionPerformed

  private void item_votar_antecipadamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_votar_antecipadamenteActionPerformed
    enablePanel("votar_antecipadamente");
  }//GEN-LAST:event_item_votar_antecipadamenteActionPerformed

  private void item_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_loginActionPerformed
    enablePanel("login");

  }//GEN-LAST:event_item_loginActionPerformed

  private void item_iniciar_votacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_iniciar_votacaoActionPerformed
    enablePanel("iniciar_votacao");
  }//GEN-LAST:event_item_iniciar_votacaoActionPerformed

  private void item_encerrar_votacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_encerrar_votacaoActionPerformed
    enablePanel("encerrar_votacao");
  }//GEN-LAST:event_item_encerrar_votacaoActionPerformed

  private void item_apresentar_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_apresentar_resultadoActionPerformed
    enablePanel("apresentar_resultado");
  }//GEN-LAST:event_item_apresentar_resultadoActionPerformed

  private void butao_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butao_loginActionPerformed

    int cc =  Integer.parseInt(field_cc.getText());
    String pass = field_password.getText();
    System.out.println("going to try logging in as " + cc + "pass: " + pass );
    if (this.eleicao.verificaLogin(cc, pass) == true ){
      this.cidadaoActivo = this.eleicao.iniciaSessaoNaEleicao(cc);
      this.enviaMensagem(true, "Bem vindo", false, true);
      enableMenu("eleitor");
      enablePanel("sessao");
      if ( this.cidadaoActivo.verificaPermissoesAdmin() || this.cidadaoActivo.verificaPermissoesRR() ){
        enableMenu("admin");
      } 
    }
    else {
      //mensagem de erro
      this.enviaMensagem(false, "Erro de login", true, false);
      //limpar campos
      this.field_cc.setText("");
      this.field_password.setText("");
    }

  }//GEN-LAST:event_butao_loginActionPerformed

  private void field_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ccActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_field_ccActionPerformed

  private void butao_registar_votoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butao_registar_votoActionPerformed
    boolean resultado;
    int index = existeSeleccaoBotoesVoto();
    if ( index > 0 ){
      String nomeLista = getValorSeleccaoBotaoVoto (index );
      resultado =  this.eleicao.registaVotoCidadaoNaEleicao( this.cidadaoActivo.getCC() , nomeLista );
      if ( resultado == true ){
        enviaMensagem(true, "Voto Registado com sucesso", false, true );
      }
      else {
        enviaMensagem(true, "Erro no registo do Voto", true, false );
      }
      enablePanel("sessao");
    }
    else {
      enviaMensagem(true, "Não tem seleção válida. Por favor seleccione opção de voto.", true, false );
    }

    // TODO add your handling code here:
  }//GEN-LAST:event_butao_registar_votoActionPerformed

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
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainWindow().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butao_login;
  private javax.swing.JButton butao_registar_voto;
  private javax.swing.ButtonGroup butoesVotar;
  private javax.swing.JTextField field_cc;
  private javax.swing.JTextField field_password;
  private javax.swing.JMenuItem item_apresentar_resultado;
  private javax.swing.JMenuItem item_encerrar_votacao;
  private javax.swing.JMenuItem item_iniciar_votacao;
  private javax.swing.JMenuItem item_login;
  private javax.swing.JMenuItem item_logout;
  private javax.swing.JMenuItem item_votar;
  private javax.swing.JMenuItem item_votar_antecipadamente;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JLabel label_nome_cidadao;
  private javax.swing.JLabel label_sessao;
  private javax.swing.JLabel mensagem;
  private javax.swing.JMenu menuAdmin;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu menuEleitor;
  private javax.swing.JMenu menuSistema;
  private javax.swing.JPanel painel_admin_apresentar_resultado;
  private javax.swing.JPanel painel_admin_encerrar_votacao;
  private javax.swing.JPanel painel_admin_iniciar_votacao;
  private javax.swing.JPanel painel_eleitor_votar;
  private javax.swing.JPanel painel_eleitor_votar_antecipadamente;
  private javax.swing.JPanel painel_informacao;
  private javax.swing.JPanel painel_sistema_login;
  private javax.swing.JPanel painel_sistema_sessao;
  private javax.swing.JRadioButton radio1;
  private javax.swing.JRadioButton radio10;
  private javax.swing.JRadioButton radio2;
  private javax.swing.JRadioButton radio3;
  private javax.swing.JRadioButton radio4;
  private javax.swing.JRadioButton radio5;
  private javax.swing.JRadioButton radio6;
  private javax.swing.JRadioButton radio7;
  private javax.swing.JRadioButton radio8;
  private javax.swing.JRadioButton radio9;
  // End of variables declaration//GEN-END:variables
}
