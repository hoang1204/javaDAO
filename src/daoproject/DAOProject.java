/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daoproject;
import java.sql.*;
/**
 *
 * @author macbookairm1
 */
public class DAOProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SinhVienView sinhvienView = new SinhVienView();
        try {
            SinhVienimplDAO sinhVienDAO = new SinhVienimplDAO();
            SinhVienTableModel sinhvienModel = new SinhVienTableModel(sinhVienDAO.getAllSinhVien());
            SinhVienController controller = new SinhVienController(sinhvienView, sinhvienModel);
            controller.showSinhVienView();
        } catch (SQLException e) {
          e.printStackTrace();
        }
    }
    
}
// thu tu: Tao du lieu SQL
// tao class vd: SACH/SINHVIEN
// xay dung lop DAO - luu y: Lien quan den String vut' len thuoc tinh
// xay dung table model: Đổ tu array list ra table model. đổ array list ra mang 2 chieu de khoi tao cho table model
// xay dung phan view
// - mot so phuong thuc: constructor, ham show
// - điền thông tin sinh viên vào bảng. lấy data từ bảng (getValueAt) đổ ra txt (setText)
// - Có thể để ý phần setEnable và setDisable trng button
// - tạo các phương thức lắng nghe cho Jtable, button parameter là các th có khả năng lắng nghe
// ví dụ: actionlistener, Listselectionlistener và add luôn



// bên controller Tạo phương thức show, gọi hàm show bên view. Thêm những phần lắng nghe sự kiên ở đây (phương thức show)
// bên controller Sẽ viết các sự kiện cho các button hay bảng. Bằng cách tạo class rồi implements actionlistener, Listselectionlistener