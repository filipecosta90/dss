/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

import dss_fase2.data.MapaVotosDAO;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author grupo19
 */
public class MapaVotos {
  Map < String , Integer > votos;

  public MapaVotos (){
    this.votos = new MapaVotosDAO();
  }

  public boolean registaVoto(String Lista){
    Integer numeroVotos;
    numeroVotos = this.votos.get(Lista);
    numeroVotos++;
    this.votos.put(Lista, numeroVotos);
    return true;
  }

  public int getTotalVotos(){
    int totalVotos = 0;  
    for (String partido : votos.keySet() ){
      totalVotos += votos.get(partido);
    }
    return totalVotos;
  }

  private float percentagemVotosLista ( String lista ){
    int totalVotos = this.getTotalVotos();
    int votosLista = this.votos.get(lista);
    float percentagem = ( float ) votosLista / ( float ) totalVotos;
    return percentagem * 100;
  }


  Comparator<String> valueComparator =  new Comparator<String>() {
    @Override
      public int compare(String o1, String o2) {
        return votos.get(o2) - votos.get(o1);
      }
  };

  public TreeMap<String, Integer> getResultadoFinal() {
    TreeMap<String, Integer> novoMapa = new TreeMap<String, Integer>( valueComparator );
    for ( String partido : votos.keySet() ){
      novoMapa.put(partido, votos.get(partido));
    }
    return novoMapa;
  }

  public TreeMap<String, Float> getResultadoFinalPercentagem() {
    TreeMap<String, Float> novoMapa = new TreeMap<String, Float>( valueComparator );
    for ( String partido : votos.keySet() ){
      novoMapa.put(partido, this.percentagemVotosLista(partido));
    }
    return novoMapa;
  }


}
