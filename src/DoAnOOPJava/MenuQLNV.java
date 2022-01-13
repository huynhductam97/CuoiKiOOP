/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAnOOPJava;

import java.util.Scanner;
import de_an_gk.Menu;

public class MenuQLNV extends Menu  {
    Scanner reader = new Scanner(System.in);
    
    private QLNV dsnv;

    public QLNV getDsnv() {
        return dsnv;
    }

    public void setDsnv(QLNV dsnv) {
        this.dsnv = dsnv;
    }
    public MenuQLNV()
    {
        dsnv = new QLNV();
    }

    @Override
    public void showMenu() 
    {
        System.out.println("\n-----------MENU QUẢN LÍ NHÂN VIÊN------------");
        System.out.println("1.              Thêm nhân viên");
        System.out.println("2.       Chỉnh sửa thông tin nhân viên");
        System.out.println("3.               Xóa nhân viên");
        System.out.println("4.             Tìm kiếm nhân viên");
        System.out.println("5.        Hiển thị danh sách nhân viên");
        System.out.println("6.             Đọc file nhân viên");
        System.out.println("7.         Ghi data nhân viên ra file");
        System.out.println("8.             Nhân viên quản lý");
        System.out.println("0.                  Thoát");
        System.out.println("------------------------------------------");
        System.out.print("Chọn chức năng : ");
    }

    @Override
    public void goiMenu(DanhSachHoaDon danhSachHoaDon,DanhSachNhanVien danhSachNhanVien)
    {   
        showMenu();
        int choose = 0;
        boolean exit = false;
        while(true)
        {
            choose = LayChucNang();
            switch(choose)
            {
                case 1:
                    dsnv.them();
                    break;
                case 2:
                    dsnv.sua();
                    break;
                case 3:
                    dsnv.xoa();
                    break;
                case 4:
                    dsnv.timkiem();
                    break;
                case 5:
                    dsnv.xuat();
                    break;
                case 6:
                    dsnv.DocFileNhanVien();
                    break;
                case 7:
                    dsnv.GhiFileNhanVien();
                    break;
                case 8:
                    dsnv.chucNangNhanVienQuanLy(danhSachNhanVien,danhSachHoaDon);
                    break;
                case 0:
                    exit  = true;
                    break;
                default:
                    BaoLoi(8);
                    break;
            }
            if(exit == true)
                break;
            showMenu();
        }
    }
}

 