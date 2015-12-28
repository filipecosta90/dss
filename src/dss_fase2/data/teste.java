/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_fase2.data;

import java.sql.ResultSet;

/**
 *
 * @author filipeoliveira
 */
public class teste {
    public static void main (String args[]){
    try {
        String sql;
        sql = "select * from cidadao";
        ResultSet rs = DataBaseAccess.executeQuery(sql);
        if (rs.next()) {
          System.out.println("consegui\n");
        }
      } catch (Exception ex) {
        throw new NullPointerException(ex.getMessage());
      }
    }
}
