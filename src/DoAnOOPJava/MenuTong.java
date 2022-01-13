package DoAnOOPJava;

import de_an_gk.MenuQLSP;
import de_an_gk.QLSP;
import java.util.Scanner;

public class MenuTong {
Scanner sc = new Scanner(System.in);

  public MenuTong() {
  }

  public void menuTong(DanhSachHoaDon danhSachHoaDon,DanhSachNhanVien danhSachNhanVien, MenuHoaDon menuHoaDon,MenuQLNV menuQLNV,QLSP qlsp,
    MenuQLSP menuQLSP,QLNV qlnv)
{ byte luachon=0;
  while(true) {
    System.out.println("================SIÊU THỊ MINI================");
    System.out.println("\t\t\t\t1.Quản lý nhân viên");
    System.out.println("\t\t\t\t2.Quản lý sản phẩm");
    System.out.println("\t\t\t\t3.Quản lý hóa đơn");
    System.out.println("\t\t\t\t\t\t0.Kết thúc");
    System.out.println("==============================================");
    System.out.print("Lựa chọn của bạn: ");
    try
    {
      luachon =Byte.parseByte(sc.nextLine());
    }catch (NumberFormatException nf)
    {
      System.out.println("Dữ liệu đầu vào không hợp lệ");
    }
    if (luachon == 0)
    {
      break;
    } else if (luachon == 1)
    {
      menuQLNV.goiMenu(danhSachHoaDon,danhSachNhanVien);
    }
    else if(luachon==2)
    {
      menuQLSP.goiMenu();
    }
    else if(luachon==3)
    {
      qlnv.DocFileNhanVien();
      menuHoaDon.LapHoaDon(qlnv,qlsp,danhSachHoaDon);
    }
    else
    {
      System.out.println("Lựa chọn không hợp lệ!");
    }

  }
}

}
