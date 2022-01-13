/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAnOOPJava;

import de_an_gk.INhapXuat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienBaoVe extends NhanVien implements INhapXuat {
    private int so_ngaycong;
    private int luong_phucap;
    
    public int getSo_ngaycong() {
        return so_ngaycong;
    }

    public void setSo_ngaycong(int so_ngaycong) {
        this.so_ngaycong = so_ngaycong;
    }

    public int getLuong_phucap() {
        return luong_phucap;
    }

    public void setLuong_phucap(int luong_phucap) {
        this.luong_phucap = luong_phucap;
    }
    
    public NhanVienBaoVe()
    {
    }

    public NhanVienBaoVe(String manv, String hoten, String diachi, int so_ngaycong, int luong_phucap) 
    {
        super(manv, hoten, diachi);
        this.so_ngaycong = so_ngaycong;
        this.luong_phucap = luong_phucap;
    }
    
    @Override
    public void nhap()
    {
        super.nhap();
        so_ngaycong = LayDuLieuSoInt("số ngày công");
        luong_phucap = LayDuLieuSoInt("lương phụ cấp");
    }
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.printf("%-10d %-20s Số ngày công: %-10d Lương phụ cấp: %d VNĐ\n",tinhluong(),"VNĐ",so_ngaycong,luong_phucap);
    }
    
    @Override
    public int tinhluong()
    {
        return so_ngaycong * 100000 + luong_phucap;
    }
    @Override
    public void sua()
    {
        super.sua();
        so_ngaycong = LayDuLieuSoInt("số ngày công");
        luong_phucap = LayDuLieuSoInt("lương phụ cấp");    
    }
    
    @Override
    public void nhaptufile(String line)
    {
        super.nhaptufile(line);
        String cut[] = line.split(", ");
        setSo_ngaycong(Integer.parseInt(cut[3]));
        setLuong_phucap(Integer.parseInt(cut[4]));
    }
    @Override
    public void ghidatarafile(FileWriter fw) throws IOException
    {
        super.ghidatarafile(fw);
        fw.write(so_ngaycong + ", " + luong_phucap + "\n");
    }
}
