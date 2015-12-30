/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;
import dss_fase2.business.Lista;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

/**
 *
 * @author filipeoliveira
 */
public class MapaListasDAO  implements Map< String , Lista >{

  @Override
    public int size() {
      int tamanho = 0;
      try {
        String sql;
        sql = "select * from lista";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        while (rs.next()) {
          tamanho++;
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return tamanho;
    }

  @Override
    public boolean isEmpty() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public boolean containsKey(Object key) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public boolean containsValue(Object value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  protected Lista processRow(ResultSet rs) throws SQLException {
    Lista novaLista = new Lista();
    novaLista.setPartidoPolitico(rs.getString("partidoPolitico"));
    novaLista.setCandidatosFromString(rs.getString("candidatos"));
    novaLista.setUninominal(rs.getBoolean("uninominal") );
    novaLista.setPlurinominal(rs.getBoolean("plurinominal") );
    return novaLista; 
  }

  @Override
    public Lista get(Object key) {
      Lista listaGet = null;
      try {
        String sql;
        sql = "select * from lista where partidoPolitico='" + key+"'";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          listaGet = processRow(rs);
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return listaGet;
    }


  @Override
    public Lista put(String key, Lista value) {
      try {
        String sql;
        sql = "insert into lista ( partidoPolitico, candidadatos, uninominal, plurinominal )  values ('" 
          + value.getPartidoPolitico() + "','" + value.getCandidatosString() + "'," + value.isUninominal() + "," + value.isPlurinominal() +  ")" 
          + " ON DUPLICATE KEY UPDATE partidoPolitico='"+key+"' , candidatos='"+ value.getCandidatosString() 
          + "', uninominal=" + value.isUninominal() + ", plurinominal=" + value.isPlurinominal() ;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return value;
    }

  @Override
    public Lista remove(Object key) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void putAll(Map<? extends String, ? extends Lista> m) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void clear() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<String> keySet() {
      TreeSet<String> chaves = new TreeSet<String>();
      try {
        String sql;
        sql = "select * from lista";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        while (rs.next()) {
          String nomePartido = rs.getString("partidoPolitico");
          chaves.add(nomePartido);
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return chaves;
    }

  @Override
    public Collection<Lista> values() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<Entry<String, Lista>> entrySet() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
