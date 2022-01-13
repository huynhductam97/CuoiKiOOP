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

public class NhanVienVeSinh extends NhanVien implements INhapXuat {
    private int so_giocong;

    public int getSo_giocong() {
        return so_giocong;
    }

    public void setSo_giocong(int so_giocong) {
        this.so_giocong = so_giocong;
    }

    public NhanVienVeSinh()
    {
    }
    
    public NhanVienVeSinh(String manv, String hoten, String ngaysinh, int so_giocong) 
    {
        super(manv, hoten, ngaysinh);
        this.so_giocong = so_giocong;
    }
    
    @Override
    public void nhap()
    {
        super.nhap();
        so_giocong = LayDuLieuSoInt("số giờ công");
    }
    
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.printf("%-10d %-20s Số giờ công: %d\n",tinhluong(),"VNĐ",so_giocong);
    }
    
    @Override
    public int tinhluong()
    {
        return so_giocong * 70000;
    }
    @Override
    public void sua()
    {
        super.sua();
        so_giocong = LayDuLieuSoInt("số giờ công");    
    }
    
    @Override
    public void nhaptufile(String line)
    {
        super.nhaptufile(line);
        String cut[] = line.split(", ");
        setSo_giocong(Integer.parseInt(cut[3]));
    }
    @Override
    public void ghidatarafile(FileWriter fw) throws IOException
    {
        super.ghidatarafile(fw);
        fw.write(so_giocong + "\n");
    }
}
