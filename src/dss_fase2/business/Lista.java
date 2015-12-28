/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author grupo19
 */

public class Lista {
  private String partidoPolitico;
  private ArrayList <Integer> candidatos;
  private boolean uninominal;
  private boolean plurinominal;

  public Lista (){
    this.partidoPolitico = "";
    this.candidatos = new ArrayList <>();
    this.uninominal = false;
    this.plurinominal = false;
  }

  public Lista ( boolean uni, boolean pluri, ArrayList <Integer> cand, String partido ){
    this.uninominal = uni;
    this.plurinominal = pluri;
    for ( Integer cid : cand ){
      this.candidatos.add(cid);
    }
    this.partidoPolitico = partido;
  }

  public boolean isUninominal() {
    return uninominal;
  }

  public void setUninominal(boolean uninominal) {
    this.uninominal = uninominal;
  }

  public boolean isPlurinominal() {
    return plurinominal;
  }

  public void setPlurinominal(boolean plurinominal) {
    this.plurinominal = plurinominal;
  }

  public ArrayList <Integer> getCandidatos() {
    return candidatos;
  }

  public String getCandidatosString(){
    StringBuilder strbul  = new StringBuilder();
    Iterator<Integer> iter = candidatos.iterator();
    while(iter.hasNext())
    {
      strbul.append(iter.next());
      if(iter.hasNext()){
        strbul.append(",");
      }
    }
    return strbul.toString();
  }

  public void setCandidatos(ArrayList <Integer> candidatos) {
    this.candidatos = candidatos;
  }

  public void setCandidatosFromString( String stringCCs ){
    ArrayList<String> arrayListCCs = new ArrayList<String>    (Arrays.asList(stringCCs.split(",")));
    for(String cc:arrayListCCs){
      this.candidatos.add(Integer.parseInt(cc.trim()));
    }
  }

  public String getPartidoPolitico() {
    return partidoPolitico;
  }

  public void setPartidoPolitico(String partidoPolitico) {
    this.partidoPolitico = partidoPolitico;
  }


}
