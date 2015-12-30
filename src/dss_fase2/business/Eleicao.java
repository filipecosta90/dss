/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

import dss_fase2.data.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author grupo19
 */

public class Eleicao {
  String tipo;
  MapaVotos mapaVotos;
  Map < Integer , Cidadao > mapaCidadaos;
  Map < String , Lista > mapaListas;
  Integer marcadaPorRR;
  GregorianCalendar dataEleicao;
  boolean marcada;
  boolean iniciada;
  boolean terminada;
  boolean publicadoResultado;
  TreeMap  < String , Integer > resultadoFinal;
  private static DataBaseAccess d = new DataBaseAccess();

  public Eleicao () {

    this.tipo = "";
    this.mapaVotos = new MapaVotos();
    this.mapaCidadaos = new MapaCidadaosDAO();
    this.mapaListas = new MapaListasDAO();
    this.marcadaPorRR = -1;
    this.dataEleicao = new GregorianCalendar();
    this.marcada=false;
    this.iniciada = false;
    this.terminada = false; 
    this.publicadoResultado=false;

  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setMapaVotos(MapaVotos mapaVotos) {
    this.mapaVotos = mapaVotos;
  }

  public void setMapaCidadaos(Map<Integer, Cidadao> mapaCidadaos) {
    this.mapaCidadaos = mapaCidadaos;
  }

  public void setMapaListas(Map<String, Lista> mapaListas) {
    this.mapaListas = mapaListas;
  }

  public void setMarcadaPorRR(Integer marcadaPorRR) {
    this.marcadaPorRR = marcadaPorRR;
  }

  public void setDataEleicao(String dataMarcar ) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    Date date;
    try {
      date = sdf.parse(dataMarcar);
      this.dataEleicao  = new GregorianCalendar();
      this.dataEleicao.setTime(date);
    } catch (ParseException ex) {
      Logger.getLogger(Eleicao.class.getName()).log(Level.SEVERE, null, ex);  
    }

  }

  public void setMarcada(boolean marcada) {
    this.marcada = marcada;
  }


  public void setIniciada(boolean iniciada) {
    this.iniciada = iniciada;
  }

  public void setTerminada(boolean terminada) {
    this.terminada = terminada;
  }

  public void setPublicadoResultado(boolean publicado) {
    this.publicadoResultado = publicado;
  }

  public void setResultadoFinal(TreeMap<String, Integer> resultadoFinal) {
    this.resultadoFinal = resultadoFinal;
  }

  public String getTipo() {
    return tipo;
  }

  public MapaVotos getMapaVotos() {
    return mapaVotos;
  }

  public Map<Integer, Cidadao> getMapaCidadaos() {
    return mapaCidadaos;
  }

  public Map<String, Lista> getMapaListas() {
    return mapaListas;
  }

  public Integer getMarcadaPorRR() {
    return marcadaPorRR;
  }

  public String getDataEleicao() {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String dataSql = sdf.format(this.dataEleicao.getTime());

    return dataSql;
  }

  public boolean isMarcada() {
    return this.marcada;
  }


  public boolean isIniciada() {
    return iniciada;
  }

  public boolean isTerminada() {
    return terminada;
  }

  public boolean isPublicadoResultado() {
    return this.publicadoResultado;
  }


  public TreeMap<String, Integer> getResultadoFinal() {
    return this.mapaVotos.getResultadoFinal();
  }

  public TreeMap<String, Float> getResultadoFinalPercentagem() {
    return this.mapaVotos.getResultadoFinalPercentagem();
  }

  public boolean verificaLogin(int cc, String password){
    Cidadao c1 = null;
    boolean flag = false;
    c1=this.mapaCidadaos.get(cc);
    if(c1 != null && c1.verificaPassword(password) ){
      flag = true;
    }
    return flag;
  }

  public Cidadao iniciaSessaoNaEleicao ( int cc ){
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    c1.ativaSessao();
    this.mapaCidadaos.put(cc , c1 );
    return c1;
  }

  public boolean registaVotoCidadaoNaEleicao( int cc , String lista ){
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    boolean flag = false;
    if ( c1 != null ){
      this.mapaVotos.registaVoto (lista);
      c1.setJaVotou(true);
      this.mapaCidadaos.put(cc , c1 );
      flag = true;
    }
    return flag;
  }

  public void logout(int cc){
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if(c1 != null ){
      c1.terminaSessao();
      this.mapaCidadaos.put(cc , c1 );
    }
  }

  public boolean podeVotarAntecipadamente(int cc){
    boolean res = false;
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if (c1 != null && c1.getPermissaoVotoAntecipado()){
      res=true;
    }
    return res;
  }

  public boolean podeVotar(int cc){
    boolean res = false;
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if (c1 != null && !(c1.getJaVotou())){
      res=true;
    }
    return res;
  }

  public boolean verificaPermissoesAdmin(int cc){
    boolean res = false;
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if (c1 != null && c1.verificaPermissoesAdmin()) res=true;
    return res;
  }

  public boolean verificaPermissoesRR(int cc){
    boolean res = false;
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if (c1 != null && c1.verificaPermissoesRR()) res=true;
    return res;
  }

  public boolean abreVotacao(int cc){
    setIniciada(true);
    return true;
  }


  public boolean encerraVotacao (int cc){
    setTerminada(true);
    return true;
  }

  public boolean marcaEleicao(String tipo, String data, int CCCriador){
    this.setTipo( tipo );
    this.setDataEleicao(data);
    this.setMarcada(true);
    this.setMarcadaPorRR(CCCriador);   
    return true;
  }

  public Cidadao getSessaoCidadao(Integer cc) {    
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    return c1;    
  }



}
