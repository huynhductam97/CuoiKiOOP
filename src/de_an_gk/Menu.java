/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import DoAnOOPJava.DanhSachHoaDon;
import DoAnOOPJava.DanhSachNhanVien;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public abstract class Menu {
    Scanner input = new Scanner(System.in);
    protected int choose;
    protected boolean exit;
    public abstract void showMenu();
//    public abstract void goiMenu();
    public void goiMenu()
    {   
    }
    public void goiMenu(DanhSachHoaDon danhSachHoaDon,DanhSachNhanVien danhSachNhanVien)
    {
    }
    public int LayChucNang()
    {
        int tmp = 0;
        boolean done = true;
        do
        {
            try{
                tmp = Integer.parseInt(input.nextLine());
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Chức năng không chứa ký tự hay khoảng trắng ! Vui lòng thử lại !");
                System.out.print("Chọn chức năng : ");
                done = false;
            }
        } while(done == false);
        return tmp;
    }
    public void BaoLoi(int n)
    {
        System.out.println("Không có chức năng này\nChọn từ 0 đến " + n + ". Vui lòng thử lại !");
    }
}
