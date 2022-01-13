package DoAnOOPJava;

import de_an_gk.INhapXuat;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class NhanVienBanHang extends NhanVien implements INhapXuat {
    private List<HoaDon> dshoadon = new ArrayList<>();
    public List<HoaDon> getDshoadon() {
        return dshoadon;
    }
    public void setDshoadon(List<HoaDon> dshoadon) {
        this.dshoadon = dshoadon;
    }
    private int heso_luong;
    private int luong_coban;
    Locale locale = new Locale("vi","VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);


    public int getHeso_luong() {
        return heso_luong;
    }

    public void setHeso_luong(int heso_luong) {
        this.heso_luong = heso_luong;
    }
    public int getLuong_coban() {
        return luong_coban;
    }

    public void setLuong_coban(int luong_coban) {
        this.luong_coban = luong_coban;
    }
    
    
    public NhanVienBanHang()
    {
    }
    
    public NhanVienBanHang(String manv, String hoten, String ngaysinh, int heso_luong, int luong_coban) 
    {
        super(manv, hoten, ngaysinh);
        this.heso_luong = heso_luong;
        this.luong_coban = luong_coban;
    }
    
    @Override
    public void nhap()
    {
        super.nhap();
        heso_luong = LayDuLieuSoInt("hệ số lương");
        luong_coban = LayDuLieuSoInt("lương cơ bản");
    }
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.printf("%-10d %-20s Hệ số lương: %-10d Lương cơ bản: %d VNĐ\n",tinhluong(),"VNĐ",heso_luong,luong_coban);
    }
    @Override
    public int tinhluong()
    {
        double tmp = (heso_luong * luong_coban) * 1.2;
        return (int)tmp;
    }

    @Override
    public void sua()
    {
        super.sua();
        heso_luong = LayDuLieuSoInt("hệ số lương");
        luong_coban = LayDuLieuSoInt("lương cơ bản");
    }
  
    @Override
    public void nhaptufile(String line)
    {
        super.nhaptufile(line);
        String cut[] = line.split(", ");
        setHeso_luong(Integer.parseInt(cut[3]));
        setLuong_coban(Integer.parseInt(cut[4]));
    }
    @Override
    public void ghidatarafile(FileWriter fw) throws IOException
    {
        super.ghidatarafile(fw);
        fw.write(heso_luong + ", " + luong_coban + "\n");
    }

}
