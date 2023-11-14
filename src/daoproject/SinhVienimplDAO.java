/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoproject;
import java.sql.*;
import java.util.ArrayList;
/**DAO
 *
 * @author macbookairm1
 */
public class SinhVienimplDAO implements DAO{
    private String selectall = "select * from sinhvien";
    private String sqlInsert = "Insert into sinhvien (hoten,diachi,tenlop,namsinh) values (?,?,?,?)";
    private String sqlUpdate = "update sinhvien set hoTen=?,diaChi=?,tenLop=?,namSinh=? where id=?";
    private static void closeConnec(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    @Override
    public ArrayList<SinhVien> getAllSinhVien() throws SQLException {
      Connection con = getConnection();
        Statement st = null;
        ArrayList<SinhVien> listAll = new ArrayList<SinhVien>();
        ResultSet rs = null;
        if (con != null) {
            st = con.createStatement();
            rs = st.executeQuery(selectall);
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listAll.add(sv);
            }
        }
        return listAll;
    }

    @Override
    public void insert(SinhVien sv) throws SQLException {
        Connection con = getConnection();
        PreparedStatement pr = null;
        if (con != null) {
            pr = con.prepareStatement(sqlInsert);
            //  pr.setInt(1, _id);
            pr.setString(1, sv.getHoTen());
            pr.setString(2, sv.getDiaChi());
            pr.setString(3, sv.getTenLop());
            pr.setString(4, sv.getNamSinh());
            System.out.println(pr.toString());
            pr.executeUpdate();
            pr.close();

        }
    }

    @Override
    public void updateSinhVien(SinhVien sv) throws SQLException {
        Connection con = getConnection();
        PreparedStatement pr = null;

        pr = con.prepareStatement(sqlUpdate);
        pr.setString(1, sv.getHoTen());
        pr.setString(2, sv.getDiaChi());
        pr.setString(3, sv.getTenLop());
        pr.setString(4, sv.getNamSinh());
        pr.setInt(5, sv.getId());
        pr.executeUpdate();
        pr.close();
    }
    
}
