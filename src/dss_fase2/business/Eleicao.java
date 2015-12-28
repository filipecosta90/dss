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
  MapaVotos mapaVotos;
  Map < Integer , Cidadao > mapaCidadaos;
  Map < String , Lista > mapaListas;
  Integer marcadaPorRR;
  GregorianCalendar dataEleicao;
  boolean iniciada;
  boolean terminada;
  TreeMap  < String , Integer > resultadoFinal;
  ArrayList < String > log_erros_local;

  public Eleicao (){

    this.mapaVotos = new MapaVotos();
    this.mapaCidadaos = new MapaCidadaosDAO();
    this.mapaListas = new MapaListasDAO();
    this.marcadaPorRR = -1;
    this.iniciada = false;
    this.terminada = false;
    this.resultadoFinal = new TreeMap < String , Integer >();
    this.log_erros_local = new ArrayList < String > (); 
  }
}
