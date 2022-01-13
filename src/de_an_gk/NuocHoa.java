/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_an_gk;

import java.util.Scanner;


public class NuocHoa extends SanPham {
    Scanner sc = new Scanner(System.in);
    private String huong;

    public String getHuong() {
        return huong;
    }

    public void setHuong(String huong) {
        this.huong = huong;
    }
    public NuocHoa()
    {
    }
    public NuocHoa(String masp, String tensp, int gia, int soluong, String huong)
    {
        super(masp,tensp,gia,soluong);
        this.huong = huong;
    }
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.print("Nhập mùi hương: ");
        huong = sc.nextLine();
    }
    @Override
    public void nhaptruma()
    {
        super.nhaptruma();
        System.out.print("Nhập mùi hương: ");
        huong = sc.nextLine();
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.println("Hương: " + huong);     
    }
    @Override
    public void ShowOptionSua()
    {
        super.ShowOptionSua();
        System.out.println(
                "5. Hương\n"
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
            System.out.print("Nhập hương: ");
            huong = sc.nextLine();
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
