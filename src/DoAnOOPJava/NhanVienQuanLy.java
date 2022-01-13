package DoAnOOPJava;

import de_an_gk.INhapXuat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienQuanLy extends NhanVien implements INhapXuat {
  private List<HoaDon> danhSachHoaDon;
  private int heso_luong;
  private int luong_coban;

  public NhanVienQuanLy(List<HoaDon> danhSachHoaDon,int heso_luong,int luong_coban) {
    this.danhSachHoaDon = new ArrayList<>(danhSachHoaDon);
    this.luong_coban = luong_coban;
    this.heso_luong = heso_luong;
  }

  public List<HoaDon> getDanhSachHoaDon() {
    return danhSachHoaDon;
  }

  public void setDanhSachHoaDon(List<HoaDon> danhSachHoaDon) {
    this.danhSachHoaDon = danhSachHoaDon;
  }

  public NhanVienQuanLy() {
  }


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
  public void sua()
  {
    super.sua();
    heso_luong = LayDuLieuSoInt("hệ số lương");
    luong_coban = LayDuLieuSoInt("lương cơ bản");
  }

  @Override
  public int tinhluong() {
    double tmp = (heso_luong * luong_coban) * 3.8;
    return (int)tmp;
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
