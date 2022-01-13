package DoAnOOPJava;


import de_an_gk.MenuQLSP;
import de_an_gk.QLSP;
import java.util.Arrays;

public class MainDoAn {

  public static void main(String[] args) {
  QLNV qlnv = new QLNV();
  //qlnv.them();
//    HoaDon hd = new HoaDon();
    QLSP qlsp = new QLSP();
    MenuHoaDon menuHoaDon = new MenuHoaDon();
    MenuQLNV menuQLNV = new MenuQLNV();
    DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
    DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
    MenuQLSP menuQLSP = new MenuQLSP();
    MenuTong menuTong = new MenuTong();
    menuTong.menuTong(danhSachHoaDon,danhSachNhanVien,menuHoaDon,menuQLNV,qlsp,menuQLSP,qlnv);

  }
}
