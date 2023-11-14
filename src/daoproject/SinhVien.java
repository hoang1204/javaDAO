/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoproject;

/**
 *
 * @author macbookairm1
 */
public class SinhVien {
    private int id;
    private String hoTen,diaChi,tenLop,namSinh;
    // neu muon lay id su dung cai nay get data
    public SinhVien(int id, String hoTen, String diaChi, String tenLop, String namSinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }
    // khai bao khi muon nhap sv tu ban phim
    public SinhVien() {
    }
    //id la auto incre -> k can id
    public SinhVien(String hoTen, String diaChi, String tenLop, String namSinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    @Override
   public String toString(){
       return "Ho Ten: "+ hoTen +" Dia chi: " + diaChi +"Ten lop: " + tenLop;
   }
    
}
