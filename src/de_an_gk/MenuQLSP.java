/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import DoAnOOPJava.ChiTietHoaDon;
import java.util.Scanner;

public class MenuQLSP extends Menu {
    Scanner reader = new Scanner(System.in);
    private QLSP dssp;
    
    public QLSP getDssp() {
        return dssp;
    }

    public void setDssp(QLSP dssp) {
        this.dssp = dssp;
    }
    
    public MenuQLSP()
    {
        dssp = new QLSP();
    }
    @Override
    public void showMenu() 
    {
        System.out.println("\n-----------MENU QUẢN LÍ SẢN PHẨM------------");
        System.out.println("1.              Thêm sản phẩm");
        System.out.println("2.       Chỉnh sửa thông tin sản phẩm");
        System.out.println("3.               Xóa sản phẩm");
        System.out.println("4.             Tìm kiếm sản phẩm");
        System.out.println("5.        Hiển thị danh sách sản phẩm");
        System.out.println("6.             Đọc file sản phẩm");
        System.out.println("7.           Ghi sản phẩm vào file");
        System.out.println("0.                  Thoát");
        System.out.println("------------------------------------------");
        System.out.print("Chọn chức năng : ");
    }
    
    @Override
    public void goiMenu()
    {   
        showMenu();
        choose = 0;
        exit = false;
        while(true)
        {
            choose = LayChucNang();
            switch(choose)
            {
                case 1:
                    ChiTietHoaDon p = new ChiTietHoaDon();
                    dssp.them(p);
                    break;
                case 2:
                    dssp.sua();
                    break;
                case 3:
                    dssp.xoa();
                    break;
                case 4:
                    dssp.timkiem();
                    break;
                case 5:
                    dssp.xuat();
                    break;
                case 6:
                    //doc file
                    break;
                case 7:
                    //ghi file
                    break;
                case 0:
                    exit  = true;
                    break;
                default:
                    BaoLoi(7);
                    break;
            }
            if(exit == true)
                break;
            showMenu();
        }
    }  
    
}
