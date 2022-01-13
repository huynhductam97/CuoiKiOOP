package DoAnOOPJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachHoaDon implements kiemTraNhanVien{

  private List<HoaDon> dsHoaDon = new ArrayList<>();

  public List<HoaDon> getDsHoaDon() {
    return dsHoaDon;
  }
  public void setDsHoaDon(List<HoaDon> dsHoaDon) {
    this.dsHoaDon = dsHoaDon;
  }

  public DanhSachHoaDon() {
  }

  public DanhSachHoaDon(List<HoaDon> dsHoaDon) {
    this.dsHoaDon = dsHoaDon;
  }

  public void xuatDanhSachHoaDon(DanhSachNhanVien danhSachNhanVien)
  {
//    Scanner sc = new Scanner(System.in);
//    String maNhanVienQuanly;
//     System.out.print("Nhập mã nhân viên quản lý: ");
//     maNhanVienQuanly=sc.nextLine();
//     NhanVienQuanLy nhanVienQuanLy  = (NhanVienQuanLy) kiemTraNhanVien(danhSachNhanVien,maNhanVienQuanly);
//     if(nhanVienQuanLy==null)
//     {
//       System.out.println("Mã nhân viên quản lý không tồn tại");
//       return;
//     }

     for(int i=0;i<dsHoaDon.size();i++)
     {
        dsHoaDon.get(i).Xuat1HoaDon();
     }
  }

  @Override
  public NhanVien kiemTraNhanVien(DanhSachNhanVien danhSachNhanVien,String manv) {
    for (var i : danhSachNhanVien.getDsnhanvien()) {
      if (manv.equalsIgnoreCase(i.getManv())) {
        return i;
      }
    }
    return null;
  }


}
