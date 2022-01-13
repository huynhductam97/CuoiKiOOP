/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Gao extends SanPham {
    Scanner sc = new Scanner(System.in);
    private String giong;
    private int trongluong;

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public int getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(int trongluong) {
        this.trongluong = trongluong;
    }
    public Gao()
    {
    }
    
    public Gao(String masp, String tensp, int gia, int soluong, String giong, int trongluong)
    {
        super(masp,tensp,gia,soluong);
        this.giong = giong;
        this.trongluong = trongluong;
    }
   
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.print("Nhập giống lúa: ");
        giong = sc.nextLine().toUpperCase();
        trongluong = LayDuLieuSo("trọng lượng");  
    }
    @Override
    public void nhaptruma()
    {
        super.nhaptruma();     
        System.out.print("Nhập giống lúa: ");
        giong = sc.nextLine().toUpperCase();
        trongluong = LayDuLieuSo("trọng lượng"); 
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.println("Giống: " + giong);   
        System.out.println("Trọng lượng: " + trongluong +" kg"); 
    }
    @Override
    public void ShowOptionSua()
    {
        super.ShowOptionSua();
        System.out.println(
                "5. Giống\n"
               +"6. Trọng lượng\n"
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
            System.out.print("Nhập giống mới: ");
            giong = sc.nextLine();
        }
        if ( s == 6)
        {
            trongluong = LayDuLieuSo("trọng lượng mới");
        }   
        if ( s == 7)
            nhap();
        if ( s == 8)
            nhaptruma();
        if ( s < 1 || s > 8)
        {
            System.out.print("Lựa chọn sai, sửa không thành công ");
            return 0;
        }
        return 1;
    }
    
}
