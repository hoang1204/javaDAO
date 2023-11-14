/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoproject;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author macbookairm1
 */
public interface DAO {
    public ArrayList<SinhVien> getAllSinhVien()throws SQLException;

    public void insert(SinhVien sv)throws SQLException;

    public void updateSinhVien(SinhVien sv)throws SQLException;

   
}
