/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

/**
 *
 * @author grupo19
 */

public class Cidadao {

  private int CC;
  private String nome;
  private String password;
  private boolean permissaoAdmin;
  private boolean permissaoRR;
  private boolean permissaoVotoAntecipado;
  private boolean sessaoActiva;
  private boolean jaVotou;

  public Cidadao() {
    this.CC = -1;
    this.nome = "";
    this.password = "";
    this.permissaoAdmin = false;
    this.permissaoRR = false;
    this.permissaoVotoAntecipado = false;
    this.sessaoActiva = false;
    this.jaVotou = false;
  }

  public void setCC(Integer CC) {
    this.CC = CC;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPermissaoAdmin(boolean permissaoAdmin) {
    this.permissaoAdmin = permissaoAdmin;
  }

  public void setPermissaoRR(boolean permissaoRR) {
    this.permissaoRR = permissaoRR;
  }

  public void setPermissaoVotoAntecipado(boolean permissaoVotoAntecipado) {
    this.permissaoVotoAntecipado = permissaoVotoAntecipado;
  }

  public void setSessaoActiva(boolean sessaoActiva){
    this.sessaoActiva = sessaoActiva;
  }

  public void setJaVotou(boolean jaVotou) {
    this.jaVotou = jaVotou;
  }

  public Integer getCC() {
    return CC;
  }

  public String getNome() {
    return nome;
  }

  public String getPassword() {
    return password;
  }

  public boolean getPermissaoAdmin() {
    return permissaoAdmin;
  }

  public boolean getPermissaoRR() {
    return permissaoRR;
  }

  public boolean getPermissaoVotoAntecipado() {
    return permissaoVotoAntecipado;
  }

  public boolean getSessaoActiva(){
    return sessaoActiva;
  }

  public boolean getJaVotou() {
    return jaVotou;
  }

  public boolean verificaPassword(String pass){
    return pass.equals(this.password);
  }

  public void ativaSessao(){
    this.setSessaoActiva(true);
  }

  public void terminaSessao(){
    this.setSessaoActiva(false);
  }

  public boolean podeVotar(){
    return !this.getJaVotou();
  }

  public boolean podeVotarAntecipadamente(){
    return this.getPermissaoVotoAntecipado();
  }

  public boolean verificaPermissoesRR(){
    return this.getPermissaoRR();
  }

  public boolean verificaPermissoesAdmin(){
    if(this.getPermissaoAdmin())
      return true;
    else return false;
  }

}
