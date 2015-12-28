/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.business;

import dss_fase2.data.MapaVotosDAO;
import java.util.Map;

/**
 *
 * @author filipeoliveira
 */
public class MapaVotos {
  Map < String , Integer > votos;

  public MapaVotos (){
    this.votos = new MapaVotosDAO();
  }

  public boolean registaVoto(String Lista){
    Integer numeroVotos;
    numeroVotos = this.votos.get(Lista);
    this.votos.put(Lista, numeroVotos);
    return true;
  }
}
