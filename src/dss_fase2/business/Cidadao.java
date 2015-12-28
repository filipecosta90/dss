/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

/**
 *
 * @author filipeoliveira
 */

public class Cidadao {

  private Integer CC;
  private String nome;
  private String password;
  private boolean permissaoAdmin;
  private boolean permissaoRR;
  private boolean permissaoVotoAntecipado;
  private boolean sessaoAtiva;
  private boolean jaVotou;

  public Cidadao() {
    this.CC = -1;
    this.nome = "";
    this.password = "";
    this.permissaoAdmin = false;
    this.permissaoRR = false;
    this.permissaoVotoAntecipado = false;
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

  public boolean getJaVotou() {
    return jaVotou;
  }
  
  


}
