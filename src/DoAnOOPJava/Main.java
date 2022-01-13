//package DoAnOOPJava;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//interface IXuat {
//
//  void xuat();
//}
//
//interface INhap {
//
//  void nhap();
//}
//
////public class SanPham implements IXuat, INhap {
////
////  private String tensp, masp;
////  private int gia, soluong;
////  Scanner sc = new Scanner(System.in);
////
////  public SanPham() {
////  }
////
////  public SanPham(String tensp, String masp, int gia, int soluong) {
////    this.tensp = tensp;
////    this.masp = masp;
////    this.gia = gia;
////    this.soluong = soluong;
////  }
////
////  public String getTensanpham() {
////    return tensp;
////  }
////
////  public void setTensanpham(String tensp) {
////    this.tensp = tensp;
////  }
////
////  public String getMasp() {
////    return masp;
////  }
////
////  public void setMasp(String masp) {
////    this.masp = masp;
////  }
////
////  public int getGia() {
////    return gia;
////  }
////
////  public void setGia(int gia) {
////    this.gia = gia;
////  }
////
////  public int getSoluong() {
////    return soluong;
////  }
////
////  public void setSoluong(int soluong) {
////    this.soluong = soluong;
////  }
////
////  @Override
////  public void nhap() {
////    System.out.println("Nhap ten sp: ");
////    tensp = sc.nextLine();
////    System.out.println("Nhap ma sp: ");
////    masp = sc.nextLine();
////    System.out.println("Nhap gia sp: ");
////    gia = Integer.parseInt(sc.nextLine());
////    System.out.println("Nhap so luong sp: ");
////    soluong = Integer.parseInt(sc.nextLine());
////  }
////
////  @Override
////  public void xuat() {
////    System.out.println("Ten sp: " + tensp);
////    System.out.println("Ma sp: " + masp);
////    System.out.println("Gia sp: " + gia);
////    System.out.println("SO luong sp: " + soluong);
////  }
////}
//
//class SuaTuoi extends de_an_gk.SanPham {
//
//  private String dungtich;
//  Scanner sc = new Scanner(System.in);
//
//  public SuaTuoi() {
//  }
//
//  public SuaTuoi(String tensp, String masp, int gia, int soluong, String dungtich) {
//    super(tensp, masp, gia, soluong);
//    this.dungtich = dungtich;
//  }
//
//  public String getDungtich() {
//    return dungtich;
//  }
//
//  public void setDungtich(String dungtich) {
//    this.dungtich = dungtich;
//  }
//
//  @Override
//  public void nhap() {
//    super.nhap();
//    System.out.println("Nhap dung tich: ");
//    dungtich = sc.nextLine();
//  }
//
//  @Override
//  public void xuat() {
//    super.xuat();
//    System.out.println("Dung tich: " + dungtich);
//  }
//
//  @Override
//  public int sua() {
//    return 0;
//  }
//}
//
//class SuaBot extends de_an_gk.SanPham {
//
//  private String khoiluong;
//  Scanner sc = new Scanner(System.in);
//
//  public SuaBot() {
//  }
//
//  public SuaBot(String tensp, String masp, int gia, int soluong, String khoiluong) {
//    super(tensp, masp, gia, soluong);
//    this.khoiluong = khoiluong;
//  }
//
//  public String getKhoiluong() {
//    return khoiluong;
//  }
//
//  public void setKoiluong(String khoiluong) {
//    this.khoiluong = khoiluong;
//  }
//
//  @Override
//  public void nhap() {
//    super.nhap();
//    System.out.println("Nhap khoiluong: ");
//    khoiluong = sc.nextLine();
//  }
//
//  @Override
//  public void xuat() {
//    super.xuat();
//    System.out.println("Khoi luong: " + khoiluong);
//  }
//
//  @Override
//  public int sua() {
//    return 0;
//  }
//}
//
//class QLSua {
//
//  Scanner sc = new Scanner(System.in);
//  SanPham[] dssua;
//  int n;
//
//  public QLSua() {
//    n = 0;
//    dssua = new SanPham[0];
//  }
//
//  public QLSua(int n, SanPham[] ds) {
//    this.n = n;
//    dssua = new SanPham[this.n];
//    System.arraycopy(ds, 0, dssua, 0, this.n);
//  }
//
//  public void xuat() {
//    System.out.println("\n--- Danh sach sua ---");
//    if (n == 0) {
//      System.out.println(" danh sach rong");
//    }
//    for (int i = 0; i < n; i++) {
//      System.out.println("");
//      if (dssua[i] instanceof SuaTuoi) {
//        System.out.println(" ______________Sua Tuoi______________");
//      } else if (dssua[i] instanceof SuaBot) {
//        System.out.println(" ______________Sua Bot______________");
//      }
//      dssua[i].xuat();
//    }
//  }
//
//  public void them() {
//    System.out.println("\n--- Them sua ---");
//    dssua = Arrays.copyOf(dssua, n + 1);
//    int x;
//    while (true) {
//      System.out.println("1.Sua tuoi   2.Sua bot");
//      System.out.println("Moi nhap lua chon: ");
//      x = Integer.parseInt(sc.nextLine());
//      if (x == 1) {
//        dssua[n] = new SuaTuoi();
//        dssua[n].nhap();
//        break;
//      } else if (x == 2) {
//        dssua[n] = new SuaBot();
//        dssua[n].nhap();
//        break;
//      } else if (x < 1 && x > 2) {
//        System.out.println("xin nhap lai");
//      }
//    }
//    n++;
//  }
//
//  public void sua() {
//    boolean fix = false;
//    System.out.println("nhap ma sp muon sua: ");
//    String ma = sc.nextLine();
//    for (int i = 0; i < n; i++) {
//      if (ma.compareTo(dssua[i].getMasp()) == 0) {
//        dssua[i].nhap();
//      }
//    }
//    if (fix == false) {
//      System.out.println("k tim thay ma sp nay.");
//    }
//  }
//
//  public void timkiem() {
//    boolean fix = false;
//    System.out.println("nhap ma sp muon tim ");
//    String ma = sc.nextLine();
//    for (int i = 0; i < n; i++) {
//      if (dssua[i].getMasp().equals(ma)) {
//        dssua[i].xuat();
//        fix = true;
//      }
//    }
//    if (fix == false) {
//      System.out.println("k tim thay ma nay.");
//    }
//  }
//
//  public void xoa() {
//    boolean fix = false;
//    System.out.println("nhap ma sp muon xoa: ");
//    String ma = sc.nextLine();
//    for (int i = 0; i < n; i++) {
//      if (dssua[i].getMasp().equals(ma)) {
//        for (int j = i; j < n - 1; j++) {
//          dssua[j] = dssua[j + 1];
//        }
//        dssua = Arrays.copyOf(dssua, n - 1);
//        n--;
//        fix = true;
//        break;
//      }
//
//    }
//    if (fix == false) {
//      System.out.println("k tim thay ma nay.");
//    }
//  }
//}
//
//class MENU {
//
//  Scanner sc = new Scanner(System.in);
//  int choose;
//  QLSua ds;
//
//  public MENU() {
//    ds = new QLSua();
//  }
//
//  public MENU(QLSua ds) {
//    this.ds = ds;
//  }
//
//  public void showmenu() {
//    System.out.println("+++++++++++MENU DS SUA+++++++++++");
//    System.out.println("0.thoat ");
//    System.out.println("1.nhap them sua ");
//    System.out.println("2.hien thi danh sach sua ");
//    System.out.println("3.tim kiem ma sp ");
//    System.out.println("4.sua  ");
//    System.out.println("5.xoa  ");
//    System.out.println("________________________________ ");
//    System.out.println("chon chuc nang: ");
//  }
//
//  public void goimenu() {
//    while (true) {
//      showmenu();
//      choose = Integer.parseInt(sc.nextLine());
//      if (choose == 1) {
//        ds.them();
//      } else if (choose == 2) {
//        ds.xuat();
//      } else if (choose == 0) {
//        System.out.println("thoat chuong trinh");
//        break;
//      } else if (choose == 3) {
//        ds.timkiem();
//      } else if (choose == 4) {
//        ds.sua();
//      } else if (choose == 5) {
//        ds.xoa();
//      } else if (choose < 0 || choose >= 6) {
//        System.out.println("nhap lai");
//      }
//    }
//  }
//}
//
//public class Main {
//
//  public static void main(String[] args) {
//    MENU a = new MENU();
//    a.goimenu();
//
//  }
//}
