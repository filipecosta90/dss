/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author filipeoliveira
 */
public class MapaVotosDAO implements Map < String , Integer > {

  @Override
    public int size() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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


  protected Integer processRow(ResultSet rs) throws SQLException {
    return rs.getInt("totalVotos");
  }

  @Override
    public Integer get(Object key) {
      Integer votoGet = null;
      try {
        String sql;
        sql = "select * from mapaVotos where partidoPolitico='" + key+"'";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          votoGet = processRow(rs);
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return votoGet;
    }

  @Override
    public Integer put(String key, Integer value) {
      try {
        String sql;
        sql = "insert into mapaVotos ( partidoPolitico, totalVotos )  values ('" 
          + key + "' , "  + value  +  ") " + 
          " ON DUPLICATE KEY UPDATE partidoPolitico='"+key+"' , totalVotos="+value;
        System.out.println(sql);       
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return value;
    }

  @Override
    public Integer remove(Object key) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void clear() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<String> keySet() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Collection<Integer> values() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<Entry<String, Integer>> entrySet() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
