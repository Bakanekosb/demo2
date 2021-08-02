/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.sql.ResultSet;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Dell
 */
public class MyTask extends TimerTask{
    @Override
  public void run() {
    datSachKhongDenLay();
  }
  
  public void datSachKhongDenLay(){
      String sql = "{call sp_datSachKhongDenLay (?)}";
      JdbcHelper.executeUpdate(sql, EzHelper.now());
  }
}
