
package de_an_gk;
import java.util.*;

public abstract class SanPham implements INhapXuat,Comparable<SanPham> {
    
    private String masp;
    private String tensp;
    private int gia;
    private int soluong;
    Scanner input = new Scanner(System.in);
    public SanPham()
    {
    }
    public SanPham(String masp,String tensp,int gia, int soluong)
    {
        this.tensp = tensp;
        this.masp = masp;
        this.gia = gia;
        this.soluong = soluong;
    }
    public String getTensp()
    {
        return tensp;
    }
    public void setTensp(String tensp)
    {
        this.tensp=tensp;
    }
    public String getMasp()
    {
        return masp;
    }
    public void setMasp(String masp)
    {
        this.masp=masp;
    }
    public int getGia()
    {
        return gia;
    }
    public void setGia(int gia)
    {
        this.gia=gia;
    }
    public int getSoluong()
    {
        return soluong;
    }
    public void setSoluong(int soluong)
    {
        this.soluong=soluong;
    }
    @Override
    public void nhap()
    {
        masp = LayMaSanPham();
        System.out.print("Nhập tên sản phẩm: ");
        tensp=input.nextLine();
        gia = LayDuLieuSo("giá");
        soluong = LayDuLieuSo("số lượng");
    }
    
    @Override
    public void xuat()
    {
        System.out.printf("%-15s %-35s %-15s %-15s", masp, tensp, gia, soluong);
    }
    public void ShowOptionSua()
    {
        System.out.println("\nBạn muốn sửa:\n"
                + "1. Mã sản phẩm\n"
                + "2. Tên sản phẩm\n"
                + "3. Đơn Giá\n"
                + "4. Số lượng");
    }
    public abstract int sua();
 
    public void nhaptruma()
    {
        System.out.print("Nhập tên sản phẩm: ");
        tensp = input.nextLine();
        gia = LayDuLieuSo("giá");
        soluong = LayDuLieuSo("số lượng");
    }

    @Override
    public int compareTo(SanPham h) {
        return this.masp.compareTo(h.masp);
    }
        public String LayMaSanPham()
    {
        String tmp = "";
        boolean done = true;
        do
        {
            System.out.print("\nNhập mã sản phẩm: ");
            tmp = input.nextLine().toUpperCase();
            if ( tmp.contains(" ") || tmp.contains("\t"))
            {
               System.out.println("Mã sản phẩm không được chứa khoảng cách !");
               done = false;
               continue;
            }

            if (tmp.length() < 5 || tmp.length() > 8)
            {

               System.out.println("Mã sản phẩm phải từ 5 đến 8 kí tự !");
               done = false; 
               continue;
            }
            done = true;
        } while ( done == false); 
        return tmp;
    }
        
    public int LayDuLieuSo(String loai)
    {
        int tmp = 0;
        boolean done = true;
        do
        {
            try{
                System.out.print("Nhập " + loai + " của sản phẩm : ");
                tmp = Integer.parseInt(input.nextLine());
                done = true;

            }
            catch(NumberFormatException e){
                System.out.println("Lỗi, "+ loai +" không được chứa kí tự hay khoảng trắng !");
                done = false;
            }
        } while(done == false);
        return tmp;
    }
}
    
    
    
    
    
 





