/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.presentation;

import dss_fase2.business.Cidadao;
import dss_fase2.business.Eleicao;
import dss_fase2.data.EleicaoDAO;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.TreeMap;

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

    updateDadosCidadaoAtivo();

    this.painel_admin_apresentar_resultado.setVisible(false);
    this.painel_admin_encerrar_votacao.setVisible(false);
    this.painel_admin_iniciar_votacao.setVisible(false);
    this.painel_eleitor_votar.setVisible(false);
    this.painel_admin_marcar_eleicao.setVisible(false);
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
        this.field_titulo_sessao.setVisible(true);
        this.field_sessao_mensagem.setVisible(true);
        if (this.eleicao.isPublicadoResultado()){
          mensagemSessao("Resultados finais", getStringResultados());
        }
        if (this.eleicao.isIniciada() == true && this.eleicao.isTerminada() == false ){
          mensagemSessao("Estão neste momento a decorrer eleições!", getStringInstrucoesVoto());
        }
        if ( this.eleicao.isIniciada() && this.eleicao.isTerminada() && this.eleicao.isPublicadoResultado() == false ){
          mensagemSessao("A eleição foi dada por terminada!", getStringMensagemAguardarResultados());
        }
        if (this.eleicao.isMarcada() && this.eleicao.isIniciada() == false ){
          mensagemSessao("Existe uma eleição marcada mas não iniciada!", getStringMensagemMarcadaNaoIniciada());
        }
        if ( this.eleicao.isMarcada() == false ){
          mensagemSessao("Não existe de momento qualquer eleição marcada!", getStringMensagemSemEleicao());
        }
        break;
      case "votar": 
        this.painel_eleitor_votar.setVisible(true);
        this.getContentPane().add(painel_eleitor_votar);
        break;
      case "marcar_eleicao":
        this.painel_admin_marcar_eleicao.setVisible(true);
        this.getContentPane().add(painel_admin_marcar_eleicao);
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
        this.mensagem.setDisabledTextColor(Color.RED);
      }
      if ( ok == true ){
        this.mensagem.setDisabledTextColor(Color.blue);
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
    this.eleicao = new EleicaoDAO();

    //menu sistema
    this.menuSistema.setVisible(true);
    //menu eleitor
    this.menuEleitor.setVisible(false);
    //menu admin
    this.menuAdmin.setVisible(false);

    enablePanel("login");
    this.enviaMensagem(false, "", false, false);
    mensagemSessao("","");

  }

  private void mensagemSessao(String titulo, String corpo ){
    this.field_titulo_sessao.setText(titulo);
    this.field_sessao_mensagem.setText(corpo);
  }

  private String getStringResultados (){
    StringBuilder sb = new StringBuilder();
    sb.append("Resultados por número de votos\n-----------------------------------\n");
    TreeMap <String, Integer> mapaResultados = this.eleicao.getResultadoFinal();
    int pos = 1;
    for ( String partido: mapaResultados.keySet() ){
      sb.append(pos).append("º lugar: ").append(partido).append("\ttotal votos: ").append(mapaResultados.get(partido)).append("\n");
      pos++;
    }
    sb.append("\n\nResultados por percentagem de votos\n-----------------------------------\n");
    TreeMap <String, Float> mapaResultadosPercentagem = this.eleicao.getResultadoFinalPercentagem();
    pos = 1;
    DecimalFormat df = new DecimalFormat("###.##");
    for ( String partido: mapaResultados.keySet() ){
      sb.append(pos).append("º lugar: ").append(partido).append("\tperc. votos: ").append(  df.format( mapaResultadosPercentagem.get(partido) )).append(" % \n");
      pos++;
    }
    return sb.toString();
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
      mensagem = new javax.swing.JTextArea();
      painel_admin_encerrar_votacao = new javax.swing.JPanel();
      painel_admin_apresentar_resultado = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      field_resultados = new javax.swing.JTextArea();
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
      botao_registar_voto = new javax.swing.JButton();
      painel_admin_marcar_eleicao = new javax.swing.JPanel();
      jLabel6 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel11 = new javax.swing.JLabel();
      jLabel12 = new javax.swing.JLabel();
      field_tipo = new javax.swing.JTextField();
      field_ano = new javax.swing.JTextField();
      field_mes = new javax.swing.JTextField();
      jLabel13 = new javax.swing.JLabel();
      field_dia = new javax.swing.JTextField();
      butao_marcar_eleicao = new javax.swing.JButton();
      painel_sistema_sessao = new javax.swing.JPanel();
      field_titulo_sessao = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      field_sessao_mensagem = new javax.swing.JTextArea();
      painel_sistema_login = new javax.swing.JPanel();
      jLabel5 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      field_cc = new javax.swing.JTextField();
      butao_login = new javax.swing.JButton();
      field_password = new javax.swing.JPasswordField();
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
      item_marcar_eleicao = new javax.swing.JMenuItem();

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

      mensagem.setEditable(false);
      mensagem.setBackground(new java.awt.Color(214, 217, 233));
      mensagem.setColumns(20);
      mensagem.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
      mensagem.setLineWrap(true);
      mensagem.setRows(5);
      mensagem.setToolTipText("");
      mensagem.setWrapStyleWord(true);
      mensagem.setBorder(null);
      mensagem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
      mensagem.setDragEnabled(false);
      mensagem.setEnabled(false);
      mensagem.setFocusable(false);
      mensagem.setOpaque(false);
      painel_informacao.add(mensagem);
      mensagem.setBounds(10, 30, 310, 60);

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
      painel_admin_apresentar_resultado.setLayout(null);

      jLabel1.setText("Resultados Eleitorais:");
      painel_admin_apresentar_resultado.add(jLabel1);
      jLabel1.setBounds(182, 100, 135, 16);

      field_resultados.setBackground(new java.awt.Color(238, 238, 238));
      field_resultados.setColumns(20);
      field_resultados.setLineWrap(true);
      field_resultados.setRows(20);
      field_resultados.setWrapStyleWord(true);
      field_resultados.setDisabledTextColor(new java.awt.Color(0, 0, 0));
      field_resultados.setDragEnabled(false);
      field_resultados.setEnabled(false);
      field_resultados.setOpaque(false);
      jScrollPane1.setViewportView(field_resultados);

      painel_admin_apresentar_resultado.add(jScrollPane1);
      jScrollPane1.setBounds(60, 134, 379, 300);

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

      botao_registar_voto.setText("Registar Voto");
      botao_registar_voto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          botao_registar_votoActionPerformed(evt);
        }
      });
      painel_eleitor_votar.add(botao_registar_voto);
      botao_registar_voto.setBounds(360, 360, 128, 29);

      painel_admin_marcar_eleicao.setEnabled(false);
      painel_admin_marcar_eleicao.setPreferredSize(new java.awt.Dimension(500, 500));

      jLabel6.setText("marcar eleição");

      jLabel3.setText("Tipo Eleição");

      jLabel4.setText("Data Eleição:");

      jLabel11.setText("Ano");

      jLabel12.setText("Mês");

      field_tipo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          field_tipoActionPerformed(evt);
        }
      });

      jLabel13.setText("Dia");

      field_dia.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          field_diaActionPerformed(evt);
        }
      });

      butao_marcar_eleicao.setText("marcar eleição");
      butao_marcar_eleicao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          butao_marcar_eleicaoActionPerformed(evt);
        }
      });

      javax.swing.GroupLayout painel_admin_marcar_eleicaoLayout = new javax.swing.GroupLayout(painel_admin_marcar_eleicao);
      painel_admin_marcar_eleicao.setLayout(painel_admin_marcar_eleicaoLayout);
      painel_admin_marcar_eleicaoLayout.setHorizontalGroup(
          painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
            .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel6))
              .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(butao_marcar_eleicao)
                  .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
                    .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addComponent(jLabel3)
                      .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                      .addComponent(field_tipo)
                      .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addComponent(field_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(90, 90, 90))
                        );
      painel_admin_marcar_eleicaoLayout.setVerticalGroup(
          painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(painel_admin_marcar_eleicaoLayout.createSequentialGroup()
            .addGap(100, 100, 100)
            .addComponent(jLabel6)
            .addGap(14, 14, 14)
            .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(field_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3))
            .addGap(12, 12, 12)
            .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(field_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11)
                .addComponent(jLabel4))
              .addGroup(painel_admin_marcar_eleicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(field_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel12)
                .addComponent(jLabel13)
                .addComponent(field_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(59, 59, 59)
            .addComponent(butao_marcar_eleicao)
            .addContainerGap())
            );

      painel_sistema_sessao.setEnabled(false);
      painel_sistema_sessao.setMaximumSize(new java.awt.Dimension(500, 500));
      painel_sistema_sessao.setMinimumSize(new java.awt.Dimension(500, 500));
      painel_sistema_sessao.setPreferredSize(new java.awt.Dimension(500, 500));
      painel_sistema_sessao.setLayout(null);

      field_titulo_sessao.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
      field_titulo_sessao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      field_titulo_sessao.setText("jLabel14");
      painel_sistema_sessao.add(field_titulo_sessao);
      field_titulo_sessao.setBounds(10, 110, 480, 17);

      field_sessao_mensagem.setBackground(new java.awt.Color(238, 238, 238));
      field_sessao_mensagem.setColumns(20);
      field_sessao_mensagem.setLineWrap(true);
      field_sessao_mensagem.setRows(5);
      field_sessao_mensagem.setWrapStyleWord(true);
      field_sessao_mensagem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
      field_sessao_mensagem.setDragEnabled(false);
      field_sessao_mensagem.setEnabled(false);
      field_sessao_mensagem.setFocusable(false);
      field_sessao_mensagem.setOpaque(false);
      jScrollPane2.setViewportView(field_sessao_mensagem);

      painel_sistema_sessao.add(jScrollPane2);
      jScrollPane2.setBounds(6, 134, 488, 310);

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
                    .addComponent(field_cc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_password)))))
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

      item_marcar_eleicao.setText("marcar eleição");
      item_marcar_eleicao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          item_marcar_eleicaoActionPerformed(evt);
        }
      });
      menuAdmin.add(item_marcar_eleicao);

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
          .addComponent(painel_admin_marcar_eleicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
          .addComponent(painel_admin_marcar_eleicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_admin_apresentar_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(painel_informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          );

      pack();
    }// </editor-fold>//GEN-END:initComponents

  private void item_votarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_votarActionPerformed

    if ( this.eleicao.isMarcada() == true ){
      if (  this.eleicao.isIniciada() == true ){
        if ( this.eleicao.isTerminada() == false ){
          if ( this.cidadaoActivo.getJaVotou() == false ){
            enablePanel("votar");
            int i = 1;
            for(String nomeLista : this.eleicao.getMapaListas().keySet()) {
              enableRadio(i, nomeLista);
              i++;
            }
            for (  ; i <= 10; i++ ){
              disableRadio(i);
            }
          }
          else {
            enviaMensagem( true, "Já exerceu o seu direito de voto!", true, false );
          }
        }

        else {
          enviaMensagem( true, "A votação já foi terminada. Não pode registar voto!", true, false );
        }
      }
      else {
        enviaMensagem( true, "Não existe nenhuma votação iniciada!", true, false );
      }
    }
    else{
      enviaMensagem( true, "Não existe nenhuma votação marcada!", true, false );
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
    if ( this.eleicao.isMarcada() == true ){
      if (  this.eleicao.isIniciada() == true ){
        if ( this.eleicao.isTerminada() == false ){
          if ( this.cidadaoActivo.podeVotarAntecipadamente() ){
            if ( this.cidadaoActivo.getJaVotou() == false ){
              enablePanel("votar");
              int i = 1;
              for(String nomeLista : this.eleicao.getMapaListas().keySet()) {
                enableRadio(i, nomeLista);
                i++;
              }
              for (  ; i <= 10; i++ ){
                disableRadio(i);
              }
            }
            else {
              enviaMensagem( true, "Já exerceu o seu direito de voto!", true, false );
            }
          }
          else {
            enviaMensagem( true, "Não tem permissão de voto antecipado!", true, false );
          }
        }

        else {
          enviaMensagem( true, "A votação já foi terminada. Não pode registar voto!", true, false );
        }
      }
      else {
        enviaMensagem( true, "Não existe nenhuma votação iniciada!", true, false );
      }
    }
    else{
      enviaMensagem( true, "Não existe nenhuma votação marcada!", true, false );
    }
  }//GEN-LAST:event_item_votar_antecipadamenteActionPerformed

  private void item_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_loginActionPerformed
    enablePanel("login");
  }//GEN-LAST:event_item_loginActionPerformed

  private void item_iniciar_votacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_iniciar_votacaoActionPerformed
    if ( this.cidadaoActivo.getPermissaoAdmin() ){
      if ( this.eleicao.isMarcada() == true ){
        if ( this.eleicao.isIniciada() == false ){
          if ( this.eleicao.isTerminada() == false ){
            this.eleicao.abreVotacao(this.cidadaoActivo.getCC());
            enviaMensagem( true, "A votação foi iniciada pelo admin: "+ this.cidadaoActivo.getNome() , false, true );
          }
          else{
            enviaMensagem( true, "A votação já foi terminada! Não a pode voltar a iniciar!", true, false );
          }
        }
        else{
          enviaMensagem( true, "A votação já foi iniciada anteriormente!", true, false );
        } 

      }
      else {
        enviaMensagem( true, "Não existe uma votação marcada!", true, false );               
      }
    }
    else {
      enviaMensagem( true, "Não tem permissões para iniciar a votação!", true, false );
    }
    enablePanel("sessao");
  }//GEN-LAST:event_item_iniciar_votacaoActionPerformed

  private void item_encerrar_votacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_encerrar_votacaoActionPerformed
    if ( this.cidadaoActivo.getPermissaoAdmin(  ) ){
      if ( this.eleicao.isMarcada() == true ){
        if (  this.eleicao.isTerminada() == true ){
          enviaMensagem( true, "A votação já foi terminada anteriormente!", true, false );
        }
        else{
          if (this.eleicao.isIniciada() == false ){
            enviaMensagem( true, "Não existe nenhuma votação iniciada!", true, false );
          }
          else {
            this.eleicao.encerraVotacao(this.cidadaoActivo.getCC());
            enviaMensagem( true, "A votação foi terminada pelo admin: "+ this.cidadaoActivo.getNome() , false, true );
          }
        }
      }
      else{
        enviaMensagem( true, "Não existe uma votação marcada!", true, false );
      }
    }
    else {
      enviaMensagem( true, "Não tem permissões para terminar a votação!", true, false );
    }
    enablePanel("sessao");
  }//GEN-LAST:event_item_encerrar_votacaoActionPerformed

  private void item_apresentar_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_apresentar_resultadoActionPerformed
    if ( this.cidadaoActivo.getPermissaoAdmin(  ) ){
      if ( this.eleicao.isMarcada() == true ){
        if (this.eleicao.isIniciada() ){
          if (this.eleicao.isTerminada() ){
            if (this.eleicao.isPublicadoResultado() == false ){
              enablePanel("apresentar_resultado");
              StringBuilder sb = new StringBuilder();
              sb.append("Resultados por número de votos\n-----------------------------------\n");
              TreeMap <String, Integer> mapaResultados = this.eleicao.getResultadoFinal();
              int pos = 1;
              for ( String partido: mapaResultados.keySet() ){
                sb.append(pos).append("º lugar: ").append(partido).append("\ttotal votos: ").append(mapaResultados.get(partido)).append("\n");
                pos++;
              }
              sb.append("\n\nResultados por percentagem de votos\n-----------------------------------\n");
              TreeMap <String, Float> mapaResultadosPercentagem = this.eleicao.getResultadoFinalPercentagem();
              pos = 1;
              DecimalFormat df = new DecimalFormat("###.##");
              for ( String partido: mapaResultados.keySet() ){
                sb.append(pos).append("º lugar: ").append(partido).append("\tperc. votos: ").append(  df.format( mapaResultadosPercentagem.get(partido) )).append(" % \n");
                pos++;
              }
              this.field_resultados.append(sb.toString());
              enviaMensagem( true, "Os resultados foram apresentados pelo admin: "+ this.cidadaoActivo.getNome() , false, true );
              this.eleicao.setPublicadoResultado(true);
            }
            else {
              enviaMensagem( true, "Os resultados já foram calculados!", true, false );

            }
          }
          else {
            enviaMensagem( true, "A votação ainda está a decorrer! Termine-a primeiramente!", true, false );

          }
        }
        else {
          enviaMensagem( true, "Existe uma Eleição mas a sua votação não foi ainda iniciada!", true, false );

        }
      }
      else {
        enviaMensagem( true, "Não existe uma votação marcada!", true, false );
      }

    }
    else {
      enviaMensagem( true, "Não tem permissões para apresentar resultados eleitorais!", true, false );
    }

  }//GEN-LAST:event_item_apresentar_resultadoActionPerformed

  private void butao_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butao_loginActionPerformed

    int cc =  Integer.parseInt(field_cc.getText());
    String pass = field_password.getText();
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

  private void botao_registar_votoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_registar_votoActionPerformed
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
  }//GEN-LAST:event_botao_registar_votoActionPerformed

  private void item_marcar_eleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_marcar_eleicaoActionPerformed
    if ( this.cidadaoActivo.getPermissaoRR() ){
      if ( this.eleicao.isMarcada() ){
        enviaMensagem( true, "A eleição já se encontra marcada!", true, false );
      }
      else{
        enablePanel("marcar_eleicao");   
      }
    }
    else {
      enviaMensagem( true, "Não tem permissões de Representante da República!", true, false );
    }             
  }//GEN-LAST:event_item_marcar_eleicaoActionPerformed

  private void field_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tipoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_field_tipoActionPerformed

  private void butao_marcar_eleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butao_marcar_eleicaoActionPerformed
    StringBuilder sb = new StringBuilder();
    sb.append(this.field_ano.getText()).append(this.field_mes.getText()).append(this.field_dia.getText());
    String dataFinal = sb.toString();
    if ( dataFinal.length() <= 8 && dataFinal.matches("[0-9]+") ) {
      this.eleicao.marcaEleicao( this.field_tipo.getText() , dataFinal, this.cidadaoActivo.getCC());
    }
    else {
      enviaMensagem( true, "A data apresentada não apresenta ter um formato válido!", true, false );
    }
    enablePanel("sessao");
  }//GEN-LAST:event_butao_marcar_eleicaoActionPerformed

  private void field_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_diaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_field_diaActionPerformed

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
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new MainWindow().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botao_registar_voto;
  private javax.swing.JButton butao_login;
  private javax.swing.JButton butao_marcar_eleicao;
  private javax.swing.ButtonGroup butoesVotar;
  private javax.swing.JTextField field_ano;
  private javax.swing.JTextField field_cc;
  private javax.swing.JTextField field_dia;
  private javax.swing.JTextField field_mes;
  private javax.swing.JPasswordField field_password;
  private javax.swing.JTextArea field_resultados;
  private javax.swing.JTextArea field_sessao_mensagem;
  private javax.swing.JTextField field_tipo;
  private javax.swing.JLabel field_titulo_sessao;
  private javax.swing.JMenuItem item_apresentar_resultado;
  private javax.swing.JMenuItem item_encerrar_votacao;
  private javax.swing.JMenuItem item_iniciar_votacao;
  private javax.swing.JMenuItem item_login;
  private javax.swing.JMenuItem item_logout;
  private javax.swing.JMenuItem item_marcar_eleicao;
  private javax.swing.JMenuItem item_votar;
  private javax.swing.JMenuItem item_votar_antecipadamente;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JLabel label_nome_cidadao;
  private javax.swing.JLabel label_sessao;
  private javax.swing.JTextArea mensagem;
  private javax.swing.JMenu menuAdmin;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu menuEleitor;
  private javax.swing.JMenu menuSistema;
  private javax.swing.JPanel painel_admin_apresentar_resultado;
  private javax.swing.JPanel painel_admin_encerrar_votacao;
  private javax.swing.JPanel painel_admin_iniciar_votacao;
  private javax.swing.JPanel painel_admin_marcar_eleicao;
  private javax.swing.JPanel painel_eleitor_votar;
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

  private String getStringInstrucoesVoto() {
    StringBuilder sb = new StringBuilder();
    sb.append("Informação Útil:\n-----------------------------------\n");
    sb.append(">>> Quais são os elementos que constam do boletim electrónico de voto?\n");
    sb.append("\n\tNa linha correspondente a cada candidatura, figura um círculo em branco destinado a ser assinalado com a escolha do eleitor. Após a seleção, o eleitor deverá clicar no botão 'registar voto'. Deverá receber uma mensagem de confirmação do registo.\n\n");
    sb.append(">>> Posso votar em Branco? Como procedo?\n");
    sb.append("\n\tSim. No boletim electónico de voto, figura um círculo em branco destinado a ser assinalado com a escolha do voto em branco por parte do eleitor.\n\n");
    return sb.toString();
  }

  private String getStringMensagemAguardarResultados() {
    StringBuilder sb = new StringBuilder();
    sb.append("Obrigado por exercer o seu direito de voto.\nAguarde a publicação dos resultados gerais.\n");
    return sb.toString();
  }

  private String getStringMensagemMarcadaNaoIniciada() {
    StringBuilder sb = new StringBuilder();
    sb.append("Existe neste momento uma eleição marcada do tipo: ").append(this.eleicao.getTipo()).append(", para o dia: ").append(this.eleicao.getDataEleicao());
    sb.append(".\nDeverá aguardar o seu início.");

    return sb.toString();
  }

  private String getStringMensagemSemEleicao() {
    StringBuilder sb = new StringBuilder();
    sb.append("Não existe de momento nenhuma eleição agendada. \n\nSe considerar estes dados anómalos por favor contacte a Comissão Nacional de Eleições:\n");           
    sb.append("Localização\n");
    sb.append("Av. D. Carlos I, 128 - 7º piso\n");
    sb.append("1249-065 LISBOA\n");
    sb.append("Telef.: 21 3923800\n");
    sb.append("Fax: 21 3953543\n");
    sb.append("e-mail: cne@cne.pt\n");
    sb.append("\n");
    sb.append("Horário de funcionamento\n");
    sb.append("Segunda a Sexta-feira - 9:30 / 18:00 horas\n");
    return sb.toString();
  }

  private void updateDadosCidadaoAtivo() {
    if (this.cidadaoActivo != null){
      this.cidadaoActivo = this.eleicao.getSessaoCidadao(this.cidadaoActivo.getCC());
    }
  }
}
