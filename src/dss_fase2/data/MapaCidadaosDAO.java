/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;

import dss_fase2.business.Cidadao;
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
public class MapaCidadaosDAO  implements Map< Integer , Cidadao > {


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
      boolean exists = false;
      try {
        String sql;
        sql = "select * from cidadao where CC = " + key;
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          exists = true;
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return exists;    
    }

  @Override
    public boolean containsValue(Object value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  protected Cidadao processRow(ResultSet rs) throws SQLException {
    Cidadao cid = new Cidadao();
    cid.setCC(rs.getInt("cc"));
    cid.setNome(rs.getString("nome"));
    cid.setPassword(rs.getString("password"));
    cid.setPermissaoAdmin(rs.getBoolean("permissaoAdmin") );
    cid.setPermissaoRR(rs.getBoolean("permissaoRR") );
    cid.setPermissaoVotoAntecipado(rs.getBoolean("permissaoVotoAntecipado") );
    cid.setJaVotou(rs.getBoolean("jaVotou") );
    return cid; 

  }

  @Override
    public Cidadao get(Object key) {
      Cidadao cidGet = null;
      try {
        String sql;
        sql = "select * from cidadao where CC= " + key;
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          cidGet = processRow(rs);
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return cidGet;
    }

  @Override
    public Cidadao put(Integer key, Cidadao value) {
      try {
        String sql;
        sql = "replace into cidadao ( cc, nome, password, permissaoAdmin, permissaoRR, permissaoVotoAntecipado, jaVotou )  values (" 
          + value.getCC() + ",'" + value.getNome() + "','" + value.getPassword() + "'," + value.getPermissaoAdmin() + "," + value.getPermissaoRR() 
          + "," + value.getPermissaoVotoAntecipado() +  "," + value.getJaVotou() + ")" ;
        ResultSet rs = DataBaseAccess.executeQuery(sql);

      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
      return value;
    }

  @Override
    public Cidadao remove(Object key) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void putAll(Map<? extends Integer, ? extends Cidadao> m) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void clear() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<Integer> keySet() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Collection<Cidadao> values() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public Set<Entry<Integer, Cidadao>> entrySet() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
