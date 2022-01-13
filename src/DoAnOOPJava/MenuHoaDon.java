package DoAnOOPJava;

import de_an_gk.QLSP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHoaDon implements kiemTraNhanVien{

  Scanner sc = new Scanner(System.in);

  public MenuHoaDon() {
  }

  public NhanVien TimKiemNhanVien(String ma, QLNV dsnv) {
    for (var i : dsnv.getDsnv()) {
      if (i.getManv().equals(ma.toUpperCase())) {
        return i;
      }
    }
    System.out.println("Mã nhân viên không tồn tại!");
    return null;
  }


  public String ChuanHoaTen(String ten) {
    ten = ten.trim().replaceAll("\\s+", " ");
    char[] charten = ten.toCharArray();
    boolean foundSpace = true;
    int n = charten.length;
    for (int i = 0; i < n; i++) {
      if (Character.isLetter(charten[i])) {
        if (foundSpace) {
          charten[i] = Character.toUpperCase(charten[i]);
          foundSpace = false;
        }
      } else {
        foundSpace = true;
      }
    }
    return String.valueOf(charten);
  }

  public void LapHoaDon(QLNV dsnv, QLSP qlsp,DanhSachHoaDon danhSachHoaDon) {
    Byte luachon = null;
    boolean checkLuaChon=true;

    try {
      String ma;
      System.out.print("Nhập mã nhân viên lập hóa đơn: ");
      ma = sc.nextLine();
      NhanVienBanHang nv=null;
      try
      {
        nv = (NhanVienBanHang) TimKiemNhanVien(ma.toUpperCase(), dsnv);
      }catch(Exception e)
      {
        System.out.println("Mã nhân viên bán hàng không hợp lệ!");
        return;
      }
      //phòng trường hợp user nhập vào mã nhân viên không tồn tại nhưng vẫn lập dc hóa đơn
      if(nv==null)
      {
        System.out.println("Nhân viên bán hàng không tồn tại");
        return;
      }
      while (true) {
        HoaDon hd = new HoaDon();
        System.out.print("\n\n\t\tQUẢN LÝ LẬP HÓA ĐƠN\n" +
            "\n1.Lập hóa đơn nhập: " +
            "\n2.Lập hóa đơn xuất: " +
            "\n0.Kết thúc" +
            "\n\n\t\t\tEND\n");
        do {
          try
          {
            System.out.print("Lựa chọn thứ: ");
            luachon=sc.nextByte();
            checkLuaChon=true;
          }catch (NumberFormatException  ie)
          {
            System.out.println("Dữ liệu đầu vào không hợp lệ!");
            checkLuaChon=false;
          }
        }while(checkLuaChon==false);

        sc.nextLine();
        if (luachon == 0) {
          break;
        } else if (luachon == 1) {
          hd.LapHoaDonNhap(nv, qlsp,danhSachHoaDon);
        } else if (luachon == 2) {
          hd.LapHoaDonXuat(nv, qlsp,danhSachHoaDon);
        }  else {
          System.out.println("Lựa chọn không hợp lệ!");
        }
      }

    } catch (Exception e) {
      System.out.println("Lập hóa đơn bị lỗi gì đếiiii");
    }
    finally {
      System.out.println("Trở lại menu tổng");
    }
  }

  @Override
  public NhanVien kiemTraNhanVien(DanhSachNhanVien danhSachNhanVien, String manv) {
    for (var i : danhSachNhanVien.getDsnhanvien()) {
      if (manv.equalsIgnoreCase(i.getManv())) {
        return i;
      }
    }
    return null;
  }
}
