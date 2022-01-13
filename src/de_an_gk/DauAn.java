/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import java.util.Scanner;

public class DauAn extends SanPham {
    Scanner sc = new Scanner(System.in);
    private String loai;
    private int dungtich; // tinh theo lit

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

    
    public DauAn()
    {
    }
    
    public DauAn(String masp, String tensp, int gia, int soluong, String loai, int dungtich)
    {
        super(masp,tensp,gia,soluong);
        this.loai = loai;
        this.dungtich = dungtich;
    }
   
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.print("Nhập loại dầu: ");
        loai = sc.nextLine();
        dungtich = LayDuLieuSo("dung tích");
    }
    @Override
    public void nhaptruma()
    {
        super.nhaptruma();
        System.out.print("Nhập loại dầu mới: ");
        loai = sc.nextLine();
        dungtich = LayDuLieuSo("dung tích");
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.print("Loại: " + loai);   
        System.out.println("   Dung tích: " + dungtich+" ml"); 
    }
    @Override
    public void ShowOptionSua()
    {
        super.ShowOptionSua();
        System.out.println(
                "5. Dung tích\n"
               +"7. Tất cả thông tin\n"
               +"8. Tất cả thông tin trừ mã\n");
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
            System.out.print("Nhập loại: ");
            loai = sc.nextLine();
        }
        if ( s == 6) 
            dungtich = LayDuLieuSo("dung tích mới");
        if ( s == 7)
            nhap();
        if (s == 8)
            nhaptruma();
        if ( s < 1 || s > 8)
        {
            System.out.print("Lựa chọn sai, sửa không thành công ");
            return 0;
        }
        return 1;
    }
}
