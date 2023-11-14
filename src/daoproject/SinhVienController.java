/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoproject;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
/**
 *
 * @author macbookairm1
 */
public class SinhVienController {
    private SinhVienTableModel sinhvienModel;
    private SinhVienView sinhvienView;
    DAO Dao = new SinhVienimplDAO();
    public SinhVienController(SinhVienView _sinhvienView, SinhVienTableModel _sinhvienModel) {
        this.sinhvienView = _sinhvienView;
        sinhvienModel = _sinhvienModel;
    }
    public void showSinhVienView() {
         sinhvienView.showListSinhVien(sinhvienModel);
            sinhvienView.addListSinhVienSelectionListener(new ListStudentSelectionListener());
            //sinhvienView.addDeleteSinhVientListener(new DeleteStudentListener());
            sinhvienView.addUpdateSinhVienListener(new UpdateSinhVienListener());
            sinhvienView.addInsertSinhVientListener(new InsertSinhVientListener());
            sinhvienView.addClearSinhVientListener(new ClearStudentListener());
            sinhvienView.setVisible(true);
            sinhvienView.setEnabled(true);
    }
    class ListStudentSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                sinhvienView.fillSinhVienFromSelectedRow();
            }
        }
    class ClearStudentListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                sinhvienView.clearSinhVientInfo();
            }
        }

        class InsertSinhVientListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                SinhVien sv = sinhvienView.getSinhVienInfo();
                
                if (sv != null) {
                    try {
                        Dao.insert(sv);
                        sinhvienView.clearSinhVientInfo();
                        sinhvienView.showListSinhVien(new SinhVienTableModel(Dao.getAllSinhVien()));
                        sinhvienView.showMessage("Thêm thành công!");
                    } catch (SQLException e1) {
                        sinhvienView.showMessage(e1.toString());
                    }
                }
            }
        }
//        class DeleteStudentListener implements ActionListener {
//
//            public void actionPerformed(ActionEvent e) {
//                SinhVien sv = sinhvienView.getSinhVienInfo();
//
//                if (sv != null) {
//                    try {
//                        DAO.(sv);
//                        sinhvienView.clearSinhVientInfo();
//                        ArrayList<SinhVien> ds = DAO.getAllSinhVien();
//                        if (ds != null) {
//                            sinhvienView.showListSinhVien(new SinhVienTableModel(ds));
//                        } else {
//                            sinhvienView.showMessage("Dữ liệu rỗng");
//                        }
//                        sinhvienView.showMessage("Xóa thành công!");
//                    } catch (SQLException e1) {
//                        sinhvienView.showMessage(e1.toString());
//                    }
//                }
//            }
//        }

            class UpdateSinhVienListener implements ActionListener {

                public void actionPerformed(ActionEvent e) {
                    SinhVien sv = sinhvienView.getSinhVienInfo();
                    if (sv != null) {
                        try {
                            Dao.updateSinhVien(sv);
                            // sinhvienView.showStudent(sv);
                            sinhvienView.showListSinhVien(new SinhVienTableModel(Dao.getAllSinhVien()));
                            sinhvienView.showMessage("Cập nhật thành công!");
                        } catch (SQLException e1) {
                            sinhvienView.showMessage(e1.toString());
                        }
                    }
                }
            }
}
