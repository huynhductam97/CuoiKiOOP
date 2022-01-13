/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import java.util.Scanner;

public class SuaTuoi extends SanPham {
    private int dungtich;
    Scanner sc = new Scanner(System.in);
    public SuaTuoi()
    {
    }
    public SuaTuoi(String masp, String tensp, int gia, int soluong, int dungtich)
    {
        super(masp,tensp,gia,soluong);
        this.dungtich=dungtich;
    }
     public int getDungtich()
    {
        return dungtich;
    }
    public void setDungtich(int dungtich)
    {
        this.dungtich=dungtich;
    }
    
    @Override
    public void nhap()
    {
        boolean done = true;
        super.nhap();
        do
        {
            try{
                System.out.println("Nhập dung tích (ml): ");
                dungtich = Integer.parseInt(sc.nextLine());
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Dung tích không được chứa kí tự !");
                done = false;
            }
        } while(done == false);
    }
    @Override
    public void nhaptruma()
    {
        super.nhaptruma();
        dungtich = LayDuLieuSo("dung tích (ml)");
    }
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Dung tích: "+dungtich+" ml");
    }
    @Override
    public void ShowOptionSua()
    {
        super.ShowOptionSua();
        System.out.println(
                "5. Dung tích\n"
              + "6. Tất cả thông tin\n"
              + "7. Tất cả thông tin trừ mã sản phẩm\n");
    }

    @Override
    public int sua()
    {
        ShowOptionSua();
        String masp_moi, tensp_moi;
        System.out.print("Thao tác: "); 
        int s = Integer.parseInt(sc.nextLine());
        if ( s == 1)
        {
            System.out.print("Nhập mã sản phẩm: ");
            masp_moi = LayMaSanPham();
            setMasp(masp_moi);
        }
        if ( s == 2)
        {
            System.out.print("Nhập tên: ");
            tensp_moi = input.nextLine();
            setTensp(tensp_moi);
        }
        if ( s == 3) 
            setGia(LayDuLieuSo("giá mới"));
        if ( s == 4) 
            setSoluong(LayDuLieuSo("số lượng mới"));
        if ( s == 5)
        {
            boolean done = true;
            do
            {
                try{
                    System.out.println("Nhập dung tích: ");
                    dungtich = Integer.parseInt(sc.nextLine());
                    done = true;
                }
                catch(NumberFormatException e){
                    System.out.println("Dung tích không được chứa kí tự !");
                    done = false;
                }
            } while(done == false);
        }
        if ( s == 6)
            nhap();
        if ( s == 7)
            nhaptruma();        
        if ( s < 1 || s > 7)
        {
            System.out.print("Lựa chọn sai, sửa không thành công ");
            return 0;
        }
        return 1;
    }

}
