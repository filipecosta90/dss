/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;

/**
 *
 * @author filipeoliveira
 */

import dss_fase2.business.Eleicao;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EleicaoDAO extends Eleicao{

  @Override
    public void setTipo(String tipo) {
      try {
        String sql;
        sql = "update eleicao set tipo = '" + tipo+ "'";
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public void setMarcadaPorRR(Integer marcadaPorRR) {
      try {
        String sql;
        sql = "update eleicao set marcadaPorRR = " + marcadaPorRR;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }

    }


  @Override
    public void setDataEleicao(String dataSql) {
      try {
        String sql;
        sql = "update eleicao set dataEleicao = " + dataSql;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public void setMarcada(boolean marcada) {
      try {
        String sql;
        sql = "update eleicao set marcada = " + marcada;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public void setIniciada(boolean iniciada) {
      try {
        String sql;
        sql = "update eleicao set iniciada = " + iniciada;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public void setTerminada(boolean terminada) {
      try {
        String sql;
        sql = "update eleicao set terminada = " + terminada;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public void setPublicadoResultado(boolean publicado) {
      try {
        String sql;
        sql = "update eleicao set publicadoResultado = " + publicado;
        DataBaseAccess.executeUpdate(sql);
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }

  @Override
    public String getTipo() {
      String get = "";
      try {
        String sql;
        sql = "select tipo from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getString("tipo");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }


  @Override
    public Integer getMarcadaPorRR() {
      Integer get = -1;
      try {
        String sql;
        sql = "select marcadaPorRR from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getInt("marcadaPorRR");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }

  @Override

    public String getDataEleicao() {
      String get = "";
      try {
        String sql;
        sql = "select dataEleicao from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getString("dataEleicao");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }

  @Override
    public boolean isMarcada() {

      boolean get = false;
      try {
        String sql;
        sql = "select marcada from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getBoolean("marcada");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }


  @Override
    public boolean isIniciada() {

      boolean get = false;
      try {
        String sql;
        sql = "select iniciada from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getBoolean("iniciada");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }

  @Override

    public boolean isTerminada() {

      boolean get = false;
      try {
        String sql;
        sql = "select terminada from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getBoolean("terminada");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }

  @Override
    public boolean isPublicadoResultado() {

      boolean get = false;
      try {
        String sql;
        sql = "select publicadoResultado from eleicao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          get = rs.getBoolean("publicadoResultado");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }      
      return get;
    }
}
