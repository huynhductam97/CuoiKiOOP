/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAnOOPJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import DoAnOOPJava.NhanVienBaoVe;

/**
 *
 * @author ADMIN
 */
public class QLNV {
    Scanner input = new Scanner( System.in);
    int n;
    Locale localeVN = new Locale("vi","VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(localeVN);
    NhanVien dsnv[];

    public NhanVien[] getDsnv() {
        return dsnv;
    }

    public void setDsnv(NhanVien[] dsnv) {
        this.dsnv = dsnv;
    }

    public QLNV()
    {
        n = 0;
        dsnv = new NhanVien[0];
    }
    public NhanVien timKiemNhanVienQuanLy(String manv,NhanVien[] dsnv)
    {
      for(var i : dsnv)
      {
          if(i.getManv().equalsIgnoreCase(manv))
          {
              return i;
          }
      }
      return null;
    }

    public void timKiemHoaDon(String mahd, List<HoaDon> danhSachHoaDon)
    {
        for(var i : danhSachHoaDon)
        {
            if(i.getMahoadon().equalsIgnoreCase(mahd))
            {
                i.Xuat1HoaDon();
                return;
            }
        }
        System.out.println("Không tìm thấy mã hóa đơn trong hệ thống");
    }

    public void thongKeThuChi(List<HoaDon>danhSachHoaDon)
    {   int tongHoaDonNhap = 0;
        int tongHoaDonXuat = 0;
        int hoaDonNhap=0;
        int hoaDonXuat=0;
        for(var i : danhSachHoaDon)
        {
           if(i.isLoaihoadon())
           {
               tongHoaDonNhap+=i.getTongTienHang();
               hoaDonNhap+=1;
           }
           else if(!i.isLoaihoadon())
           {
               tongHoaDonXuat+=i.getTongTienHang();
               hoaDonXuat+=1;
           }
        }
        System.out.println("\t\t\tHÓA ĐƠN NHẬP\n");
        System.out.printf("%-20s %-20s\n","Số lượng","Tổng tiền hàng");
        System.out.printf("%-20s %-20s\n",hoaDonNhap,nf.format(tongHoaDonNhap));
        System.out.println("========================================\n");
        System.out.println("\t\t\tHÓA ĐƠN XUẤT\n");
        System.out.printf("%-20s %-20s\n","Số lượng","Tổng tiền hàng");
        System.out.printf("%-20s %-20s\n",hoaDonXuat,nf.format(tongHoaDonXuat));
    }
    public void chucNangNhanVienQuanLy(DanhSachNhanVien danhSachNhanVien,DanhSachHoaDon danhSachHoaDon)
    {  boolean checkInteger=true;
        Byte luachon=0;
        NhanVienQuanLy nhanVienQuanLy=null;
        String manv  = null;
        System.out.print("Nhập mã nhân viên quản lý: ");
        manv = input.nextLine();
        nhanVienQuanLy= (NhanVienQuanLy) timKiemNhanVienQuanLy(manv,dsnv);
        if(nhanVienQuanLy==null)
        {
            System.out.println("Không tìm thấy nhân viên quản lý");
            return;
        }
        nhanVienQuanLy.setDanhSachHoaDon(danhSachHoaDon.getDsHoaDon());
        do {
            try
            {
                System.out.println("\n-----------NHÂN VIÊN QUẢN LÝ------------");
                System.out.println("1.       Xem danh sách hóa đơn");
                System.out.println("2.          Tìm kiếm hóa đơn");
                System.out.println("3.          Tìm kiếm nhân viên");
                System.out.println("4.       Thống kê thu chi hóa đơn");
                System.out.println("5.       Thống kê lương nhân viên giảm dần");
                System.out.println("0.                  Thoát");
                System.out.println("------------------------------------------");
                System.out.print("Chọn chức năng : ");
                luachon=Byte.parseByte(input.nextLine());
                checkInteger=true;
                if(luachon==1)
                {
                    danhSachHoaDon.xuatDanhSachHoaDon(danhSachNhanVien);
                }
                else if(luachon==2)
                {   String mahd;
                    System.out.print("Nhập mã hóa đơn cần tìm: ");
                    mahd = input.nextLine();
                    timKiemHoaDon(mahd,nhanVienQuanLy.getDanhSachHoaDon());
                }
                else if(luachon==3)
                {
                    timkiem();
                }
                else if(luachon==4)
                {
                    thongKeThuChi(nhanVienQuanLy.getDanhSachHoaDon());
                }
                else if(luachon==5)
                {
                    Collections.sort(Arrays.asList(dsnv),new NhanVienComparator());
                    for(var  i  :dsnv)
                    {
                        i.xuat();
                    }
                }

                else if(luachon==0)
                {
                    break;
                }
            }catch (NumberFormatException ie)
            {
                System.out.println("Chức năng không hợp lệ!");
                checkInteger=false;
            }
        }while(checkInteger==true);
        System.out.println("Trở về menu tổng");
    }

    public void DocFileNhanVien() {
        n = 0;
        dsnv  = new NhanVien[0];
        try {
           // BufferedReader input = new BufferedReader(new FileReader("D:\\DoAnOOPV2\\src\\DoANOOPJava\\DataNhanVien.txt"));

            BufferedReader input = new BufferedReader(new FileReader("/DoAnOOPV3/src/DoAnOOPJava/DataNhanVien.txt"));
            String line = input.readLine();
            while (line != null)
            {
                dsnv  = Arrays.copyOf(dsnv,n+1);
                String arr[] = line.split(", ");
                String key = arr[0].substring(0, 2);
                switch(key)
                {
                    case "BH":
                        dsnv[n] = new NhanVienBanHang();
                        dsnv[n].nhaptufile(line);
                        break;
                    case "BV":
                        dsnv[n] = new NhanVienBaoVe();
                        dsnv[n].nhaptufile(line);
                        break;
                    case "VS":
                        dsnv[n] = new NhanVienVeSinh();
                        dsnv[n].nhaptufile(line);
                        break;
                    case "QL":
                        dsnv[n] = new NhanVienQuanLy();
                        dsnv[n].nhaptufile(line);
                        break;
                    default:
                        break;
                }
                n++;
                line = input.readLine();
            }
            input.close();
        }
        catch (IOException ex) {
            System.out.println("File không tồn tại ! Đọc không thành công !");
            return;
        }
        catch (Exception ex)
        {
            System.out.println("Có dữ liệu lỗi ! Chưa đọc hết file !");
            return;
        }
        System.out.println("Đọc thành công !");
    }
    public void GhiFileNhanVien()
    {
        try
        {
            try (FileWriter fw = new FileWriter("/DoAnOOPV3/src/DoAnOOPJava/DataNhanVien.txt",true)) {
                int i = 0;
                while(i < n)
                {
                    dsnv[i].ghidatarafile(fw);
                    i++;
                }
            }
            System.out.println("Ghi Data nhân viên ra File thành công !");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    public void xuat()
    {
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN ---");
        Arrays.sort(dsnv);
        System.out.printf("\n%-20s %-25s %-25s", "Mã nhân viên","Tên nhân viên","Ngày sinh");
        System.out.printf("%-35s %-20s\n","Tổng tiền lương","Thông tin chi tiết");
        int dsnvLength = dsnv.length;
        for(int i = 0;i<dsnvLength;i++)
        {
            dsnv[i].xuat();
        }
    }
    public int isExist(String manv_them)
    {
        for (int i = 0;i<n;i++)
            if(dsnv[i].getManv().equals(manv_them))
                return 1;
        return 0;
    }
    public void them()
    {
        System.out.println("\n--- THÊM NHÂN VIÊN ---");
        dsnv  = Arrays.copyOf(dsnv,n+1);
        int x = 0 ;
        do
        {
            do
            {
                System.out.println("Nhân Viên Bán Hàng: 1 - Nhân Viên Bảo Vệ: 2\nNhân Viên Vệ Sinh: 3"
                    + " - Nhân Viên Quản Lý: 4");
                System.out.print("Bạn muốn thêm ? ");
                boolean done = true;
                do
                {
                    try{
                        x = Integer.parseInt(input.nextLine());
                        done = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Thao tác không chứa ký tự hay khoảng trắng ! Vui lòng thử lại !");
                        System.out.print("Bạn muốn thêm : ");
                        done = false;
                    }
                } while(done == false);
                
                if( x < 1 || x > 4)
                    System.out.println("Chọn từ 1 đến 4. Vui lòng thử lại !");
                
            } while ( x < 1 || x > 4);
            
            String manv_them = LayMaNhanVien();
            
            if (isExist(manv_them) == 1)
            {
                System.out.println("Mã nhân viên này đã tồn tại !");
                return;
            }
            switch (x)
            {
                case 1:
                    dsnv[n] = new NhanVienBanHang();
                    dsnv[n].setManv(manv_them) ;
                    dsnv[n].sua();
                    break;

                case 2:
                    dsnv[n] = new NhanVienBaoVe();
                    dsnv[n].setManv(manv_them) ;
                    dsnv[n].sua();
                    break;
                case 3:
                    dsnv[n] = new NhanVienVeSinh();
                    dsnv[n].setManv(manv_them) ;
                    dsnv[n].sua();
                    break;
                case 4:
                    dsnv[n] = new NhanVienQuanLy();
                    dsnv[n].setManv(manv_them) ;
                    dsnv[n].sua();
                    break;
                default:
                    System.out.println("\nVui lòng nhập lại");
                    break;
            }
        } while(x < 1 || x > 4);
        n++;
    }
    
    
    public void timkiem()
    {
        System.out.print("\n--- TÌM KIẾM NHÂN VIÊN ---");
        String manv_cantim = LayMaNhanVien();
        timkiem(manv_cantim);
    }
    
    public void timkiem(String manv_cantim)
    {
        boolean find = false;
        for(int i = 0;i<n;i++)
        {
            if(dsnv[i].getManv().equals(manv_cantim))
            {
                find = true;
                System.out.printf("\n%-20s %-25s %-25s", "Mã nhân viên","Tên nhân viên","Ngày sinh");
                System.out.printf("%-35s %-20s\n","Tổng tiền lương","Thông tin chi tiết");
                dsnv[i].xuat();
            }
        }
        if(find == false)
            System.out.println("\nKhông tìm thấy nhân viên mã: " + manv_cantim);
    }

   public void sua()
    {
        System.out.print("\n--- SỬA THÔNG TIN NHÂN VIÊN ---");
        String manv_cansua = LayMaNhanVien();
        sua(manv_cansua);      
    }
    
    public void sua(String manv_cansua)
    {        
        boolean fix = false;
        for(int i = 0;i<n;i++)
        {
            if(dsnv[i].getManv().equals(manv_cansua))
            {
                fix = true;              
                System.out.println("Đang sửa thông tin nhân viên mã " + manv_cansua + " ...");
                dsnv[i].sua();
                
                System.out.println("\n-- Thông tin sau khi sửa -- ");
                System.out.printf("\n%-20s %-25s %-25s", "Mã nhân viên","Tên nhân viên","Ngày sinh");
                System.out.printf("%-35s %-20s\n","Tổng tiền lương","Thông tin chi tiết");
                dsnv[i].xuat();         
            }
        }
        if(fix == false)
            System.out.println("\nKhông tìm thấy nhân viên mã: " + manv_cansua);
        else
            System.out.println("\nSửa thông tin nhân viên mã " + manv_cansua + " thành công !");
    }
    
    public void xoa()
    {
        System.out.print("\n--- XÓA NHÂN VIÊN ---");
        String manv_canxoa = LayMaNhanVien();
        xoa(manv_canxoa);
    }
    public void xoa(String manv_canxoa)
    {
        boolean delete = false;
        for(int i = 0;i<n;i++)
        {
            if(dsnv[i].getManv().equals(manv_canxoa))
            {
                for(int j = i;j<n-1;j++)
                    dsnv[j] = dsnv[j+1];
                dsnv = Arrays.copyOf(dsnv, n-1);
                n--;
                delete = true;
                break;
            }
        }
        if(delete == false)
            System.out.println("Không tìm thấy nhân viên mã: " + manv_canxoa);
        else
            System.out.println("Đã xóa nhân viên mã " + manv_canxoa+ " !");

    }
    public String LayMaNhanVien()
    {
        String tmp = "";
        boolean done = true;
        do
        {
            System.out.print("\nNhập mã nhân viên: ");
            tmp = input.nextLine().toUpperCase();
            if ( tmp.contains(" ") || tmp.contains("\t"))
            {
                System.out.println("Mã nhân viên không được chứa khoảng cách !");
                done = false;
                continue;
            } else {
            }

            if (tmp.length() < 5 || tmp.length() > 8)
            {

               System.out.println("Mã nhân viên phải từ 5 đến 8 kí tự !");
               done = false; 
               continue;
            }
            done = true;
        } while ( done == false); 
        return tmp;
    }

}
