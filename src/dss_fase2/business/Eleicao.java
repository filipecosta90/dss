/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

import dss_fase2.data.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;




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
  boolean iniciada;
  boolean terminada;
  TreeMap  < String , Integer > resultadoFinal;
  ArrayList < String > log_erros_local;
  private static DataBaseAccess d = new DataBaseAccess();

  public Eleicao (){

    this.tipo = null;
    this.mapaVotos = new MapaVotos();
    this.mapaCidadaos = new MapaCidadaosDAO();
    this.mapaListas = new MapaListasDAO();
    this.marcadaPorRR = -1;
    this.dataEleicao = new GregorianCalendar();
    this.iniciada = false;
    this.terminada = false;
    this.resultadoFinal = new TreeMap < String , Integer >();
    this.log_erros_local = new ArrayList < String > (); 

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

  public void setDataEleicao(GregorianCalendar dataEleicao) {
    this.dataEleicao = dataEleicao;
  }

  public void setIniciada(boolean iniciada) {
    this.iniciada = iniciada;
  }

  public void setTerminada(boolean terminada) {
    this.terminada = terminada;
  }

  public void setResultadoFinal(TreeMap<String, Integer> resultadoFinal) {
    this.resultadoFinal = resultadoFinal;
  }

  public void setLog_erros_local(ArrayList<String> log_erros_local) {
    this.log_erros_local = log_erros_local;
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

  public GregorianCalendar getDataEleicao() {
    return dataEleicao;
  }

  public boolean isIniciada() {
    return iniciada;
  }

  public boolean isTerminada() {
    return terminada;
  }

  public TreeMap<String, Integer> getResultadoFinal() {
    return resultadoFinal;
  }

  public ArrayList<String> getLog_erros_local() {
    return log_erros_local;
  }

  public boolean verificaLogin(int cc, String password){
    Cidadao c1 = null;
    boolean flag = false;
    System.out.println("testing for cc");
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
      System.out.println("entrou registo");
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

  public boolean verificaPermissoesAdmin_elei(int cc){
    boolean res = false;
    Cidadao c1 = null;
    c1=this.mapaCidadaos.get(cc);
    if (c1 != null && c1.verificaPermissoesAdmin()) res=true;
    return res;
  }

  public boolean verificaPermissoesRR_elei(int cc){
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

  public boolean marcaEleicao(String tipo, GregorianCalendar data, int CCCriador){
    setMarcadaPorRR(CCCriador);
    setDataEleicao(data);
    setTipo(tipo);
    return true;
  }

  public TreeMap  <String , Integer> getResultadoGeral(){
    return getResultadoFinal();  
  }


}
