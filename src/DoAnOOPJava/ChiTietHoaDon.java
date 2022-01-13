package DoAnOOPJava;

import de_an_gk.*;
import java.text.NumberFormat;
import java.util.*;

public class ChiTietHoaDon {

  private String masanpham;
  private String tensanpham;
  private int gia;
  private int soluong;
  private String loai;
  int tongTienHang=0;
  Scanner sc = new Scanner(System.in);
  Locale localeVn  = new Locale("vi","VN");
  NumberFormat countryCurrency = NumberFormat.getCurrencyInstance(localeVn);

  public ChiTietHoaDon() {
  }

  public ChiTietHoaDon(String masanpham, String tensanpham, int gia, int soluong,
      String loai, int tongTienHang, Scanner sc, Locale localeVn,
      NumberFormat countryCurrency) {
    this.masanpham = masanpham;
    this.tensanpham = tensanpham;
    this.gia = gia;
    this.soluong = soluong;
    this.loai = loai;
    this.tongTienHang = tongTienHang;
    this.sc = sc;
    this.localeVn = localeVn;
    this.countryCurrency = countryCurrency;
  }

  public int getTongTienHang() {
    return tongTienHang;
  }

  public void setTongTienHang(int tongTienHang) {
    this.tongTienHang = tongTienHang;
  }

  public String getMasp() {
    return masanpham;
  }

  public void setMasp(String masp) {
    this.masanpham = masp;
  }

  public String getTensanpham() {
    return tensanpham;
  }

  public void setTensanpham(String tensanpham) {
    this.tensanpham = tensanpham;
  }

  public int getGia() {
    return gia;
  }

  public void setGia(int gia) {
    this.gia = gia;
  }

  public int getSoluong() {
    return soluong;
  }

  public void setSoluong(int soluong) {
    this.soluong = soluong;
  }

  public String getLoai() {
    return loai;
  }

  public void setLoai(String loai) {
    this.loai = loai;
  }

  public Scanner getSc() {
    return sc;
  }

  public void setSc(Scanner sc) {
    this.sc = sc;
  }

  public String ChuanHoaMaSanPham(String a) {
    return a.toUpperCase();
  }

  public String ChuanHoaTen(String ten) {
    ten = ten.trim().replaceAll("\\s+", " ");

    char[] charten = ten.toCharArray();
    boolean foundSpace = true;
    int n = charten.length;
    for (int i = 0; i < n; i++) {
      if (Character.isLetter(charten[i])) {
        if (foundSpace) {
          charten[i] = Character.toUpperCase(charten[i]);
          foundSpace = false;
        }
      } else {
        foundSpace = true;
      }
    }
    return String.valueOf(charten);
  }

  public int Tien1MonHang(ChiTietHoaDon p) {
    return p.getGia() * p.getSoluong();
  }
  //dùng để nhập

//  public void LapChiTietHoaDonNhap(HoaDon hd, NhanVienBanHang nvbh, QLSP qlsp) {
//    System.out.print("Số lượng sản phẩm muốn nhập: ");
//    int n=0;
//    boolean checkInteger=true;
//    do {
//      try {
//        n = Integer.parseInt(sc.nextLine());
//        checkInteger=true;
//      }catch (NumberFormatException nfe)
//      {
//        System.out.println("Giá trị đầu vào không hợp lệ");
//        checkInteger=false;
//      }
//    }while(checkInteger=false);
//    ChiTietHoaDon p=null;
//    for (int i = 0; i < n; i++) {
//      p = new ChiTietHoaDon();
//      qlsp.them();
//      System.out.println();
//      for(int  j=0;j<qlsp.getSp().length;j++)
//      {
//        if(p.masanpham.equalsIgnoreCase(qlsp.getSp()[j].getMasp()))
//        {
//          p.tensanpham=qlsp.getSp()[j].getTensp();
//          p.gia=qlsp.getSp()[j].getGia();
//          p.soluong=qlsp.getSp()[j].getSoluong();
//          tongTienHang+=Tien1MonHang(p);
//        }
//      }
//      hd.dschitiethoadon.add(p);
//    }
//    nvbh.getDshoadon().add(hd);
//    System.out.println("Lập hóa đơn thành công!");
//  }
public void LapChiTietHoaDonNhap(HoaDon hd, NhanVienBanHang nvbh, QLSP qlsp) {

  System.out.print("Số lượng sản phẩm muốn nhập: ");
  int n=0;
  boolean checkInteger=true;
  do {
    try {
      n = Integer.parseInt(sc.nextLine());
      checkInteger=true;
    }catch (NumberFormatException nfe)
    {
      System.out.println("Giá trị đầu vào không hợp lệ");
      checkInteger=false;
    }
  }while(checkInteger=false);

  ChiTietHoaDon p=null;
  for (int i = 0; i < n; i++) {
    p= new ChiTietHoaDon();
    qlsp.them(p);
    System.out.println();
    System.out.println("Thêm thành công!");
    for(int  j=0;j<qlsp.getSp().length;j++)
    {
      if(p.masanpham.equals(qlsp.getSp()[j].getMasp()))
      {
        p.tensanpham=qlsp.getSp()[j].getTensp();
        p.gia=qlsp.getSp()[j].getGia();
        p.soluong=qlsp.getSp()[j].getSoluong();
        tongTienHang+=Tien1MonHang(p);
      }
    }
    hd.dschitiethoadon.add(p);
  }
  nvbh.getDshoadon().add(hd);
}


  public void LapChiTietHoaDonXuat(HoaDon hd, NhanVienBanHang nvbh,QLSP qlsp) {
    int length = qlsp.getSp().length;
    qlsp.xuat();
    System.out.println();
    int n=0;
    boolean checkIsInteger=true;
    do {
      try {
        System.out.print("Số lượng sản phẩm muốn mua: ");
        n = Integer.parseInt(sc.nextLine());
        checkIsInteger=true;
      }catch (NumberFormatException ie)
      {
        System.out.println("Dữ liệu đầu vào không hợp lệ!");
        checkIsInteger=false;
      }
    }while(checkIsInteger==false);

    //exist để kiễm tra mã sản phẩm có tồn tại hay không
    int exist;

    for (int i = 0; i < n; i++) {
      SanPham sanPham = new MiGoi();
      String masp;
      do {
        System.out.print("Nhập mã sản phẩm: ");
        masp=ChuanHoaMaSanPham(sc.nextLine());
        exist = qlsp.isExist(masp);
        if(exist==0)
        {
          System.out.println("Mã sản phẩm không tồn tại trong hệ thống!");
        }
      }while(exist==0);
      for (int j = 0; j <qlsp.getSp().length; j++) {
        ChiTietHoaDon p = new ChiTietHoaDon();
        if (qlsp.getSp()[j].getMasp().equals(masp)) {
          p.masanpham=masp;
          p.tensanpham = qlsp.getSp()[j].getTensp();
          p.gia=qlsp.getSp()[j].getGia();
          System.out.print("Nhập số lượng sản phẩm: ");
          p.soluong=sc.nextInt();
          //lấy cái \n của Int
          sc.nextLine();
          int soluongtontrongkho=qlsp.getSp()[j].getSoluong()-p.soluong;
          if(soluongtontrongkho>= 0)
          {
            qlsp.getSp()[j].setSoluong(soluongtontrongkho);
            tongTienHang+=Tien1MonHang(p);
            hd.dschitiethoadon.add(p);
          }
          else
          {
            System.out.println("Số  lượng trong kho không đủ");
          }
        }
      }
    }

    nvbh.getDshoadon().add(hd);
    System.out.println("Lập hóa đơn thành công");
  }
}
