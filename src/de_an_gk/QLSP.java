
package de_an_gk;

/**
 *
 * @author nakng
 */
import DoAnOOPJava.ChiTietHoaDon;
import java.util.*;

public class QLSP {
    Scanner sc = new Scanner(System.in);
    private SanPham sp[];

    private int n;
    
    public SanPham[] getSp() {
        return sp;
    }

    public void setSp(SanPham[] sp) {
        this.sp = sp;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public QLSP(){
        n = 0;
        sp = new SanPham[0];
        n = 4;
        sp = new SanPham[4]; 
        sp[0] = new KhanGiay("KG001","Khăn giấy N1",12000,20,"Khô");
        sp[1] = new NuocHoa("NH001","Nước hoa NiNa",300000,5,"Hoa hồng quyến gũ");
        sp[2] = new SuaTuoi("ST004","Sữa tươi VinaMilk",6000,50,150);
        sp[3] = new DauAn("DA001","Dầu Neptune",5000,10,"Thực vật",200);
    }
    public int isExist(String masp_them)
    {
        for(int i = 0;i<n;i++)
            if(sp[i].getMasp().equals(masp_them))
                return 1;
        return 0;
    }
    public void them(ChiTietHoaDon p){
        System.out.println("\n--- THÊM SẢN PHẨM ---");
        sp = Arrays.copyOf(sp,n+1); 
        int x = 0 ;
        do{
            System.out.println("Sữa Tươi: 1 - Khăn Giấy: 2 - Nước Hoa: 3\nGạo: 4 - Dầu Ăn: 5 - Mì Gói: 6");
            boolean done = true;
            do
            {
                try{
                    System.out.print("Bạn muốn thêm sản phẩm nào: ");
                    x = Integer.parseInt(sc.nextLine());
                    done = true;
                }
                catch(NumberFormatException e){
                    System.out.println("Thao tác không chứa kí tự !");
                    done = false;
                }
            } while(done == false);

            if ( x < 1 || x > 6)
            {
                System.out.println("Không tìm thấy thao tác, vui lòng thử lại !");
                continue;
            }
            String masp_them = LayMaSanPham();
            
            if (isExist(masp_them) == 1)
            {
                System.out.println("Mã sản phẩm này đã tồn tại !");
                return;
            }
            
            switch (x){
                case 1:
                    sp[n] = new SuaTuoi();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;

                case 2:
                    sp[n] = new KhanGiay();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;
                case 3:
                    sp[n] = new NuocHoa();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;
                case 4:
                    sp[n] = new Gao();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;
                case 5:
                    sp[n] = new DauAn();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;
                case 6:
                    sp[n] = new MiGoi();
                    sp[n].setMasp(masp_them);
                    sp[n].nhaptruma();
                    p.setMasp(masp_them);
                    break;
                default:
                    System.out.println("\nVui lòng nhập lại");
                    break;
            }
        } while(x < 1 || x > 6);
        n++;
    }
    
    public void xuat(){
        System.out.println("\n----- DANH SÁCH SẢN PHẨM -----"); 
        Arrays.sort(sp);
        System.out.printf("\n%-15s %-35s %-15s %-15s", "Mã sản phẩm","Tên sản phẩm","Giá(VNĐ)","Số lượng");
        System.out.printf("%-15s\n","Thông tin chi tiết");
        for(int i = 0;i< n;i++){
            sp[i].xuat();
        }
    }
    public void xoa(){
        System.out.println("\n----- XÓA SẢN PHẨM -----:"); 
        int i,j;
        String masp_xoa = LayMaSanPham();
        masp_xoa = masp_xoa.toUpperCase();
        for(i = 0; i < n;i++){
            if(sp[i].getMasp().equals(masp_xoa)){
                for(j = i;j<n-1;j++){
                    sp[j]=sp[j+1];
                }
                n--;
                sp = Arrays.copyOf(sp,n);
                System.out.println("Đã xóa sản phẩm"); 
                return;
            }     
        }
        System.out.println("Không tồn tại mã sản phẩm "+ masp_xoa + "\nXóa không thành công !");
    }

    public void sua(){
        System.out.println("\n--- SỬA THÔNG TIN SẢN PHẨM ---");    
        String masp_sua = LayMaSanPham();
        for(int i = 0; i < n;i++){
            if(sp[i].getMasp().equals(masp_sua))
            {
                System.out.print("\n-- Thông tin hiện tại -- ");
                System.out.printf("\n%-15s %-35s %-15s %-15s", "Mã sản phẩm","Tên sản phẩm","Giá(VNĐ)","Số lượng");
                System.out.printf("%-15s\n","Thông tin chi tiết");                
                sp[i].xuat();
                
                while(sp[i].sua() == 0)
                    sp[i].sua();
                
                System.out.println("\nSửa thành công !\n-- Thông tin sau khi sửa -- ");
                System.out.printf("\n%-15s %-35s %-15s %-15s", "Mã sản phẩm","Tên sản phẩm","Giá(VNĐ)","Số lượng");
                System.out.printf("%-15s\n","Thông tin chi tiết");   
                sp[i].xuat();
                return ;
            }        
        }
        System.out.println("Không tồn tại mã sản phẩm " + masp_sua +"\nSửa không thành công !");
    }
    public void timkiem()
    {
        System.out.print("\n--- TÌM KIẾM SẢN PHẨM ---");
        String masp_cantim = LayMaSanPham();
        timkiem(masp_cantim);
    }
    
    public void timkiem(String masp_cantim)
    {
        boolean find = false;
        for(int i = 0;i<n;i++)
        {
            if(sp[i].getMasp().equals(masp_cantim))
            {
                find = true;
                System.out.printf("\n%-15s %-35s %-15s %-15s", "Mã sản phẩm","Tên sản phẩm","Giá(VNĐ)","Số lượng");
                System.out.printf("%-15s\n","Thông tin chi tiết");                   
                sp[i].xuat();
            }
        }
        if(find == false)
            System.out.println("\nKhông tìm thấy sản phẩm mã: " + masp_cantim);
    }
    public String LayMaSanPham()
    {
        String tmp = "";
        boolean done = true;
        do
        {
            System.out.print("\nNhập mã sản phẩm: ");
            tmp = sc.nextLine().toUpperCase();
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
                tmp = Integer.parseInt(sc.nextLine());
                done = true;

            }
            catch(NumberFormatException e){
                System.out.println("Lỗi, "+ loai +" không được chứa kí tự hay khoảng trắng !");
                done = false;
            }
        } while(done == false);
        return tmp;
    }
    public void themsoluong(String masp_them)
    {
        
    }
}
