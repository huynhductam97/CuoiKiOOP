package DoAnOOPJava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nakng
 */
public class Sieuthimini {

  public static void main(String[] args) {
    quanlisanpham ql = new quanlisanpham();
    ql.quanli();
  }

}

class quanlisanpham {

  sanpham[] sp;
  int n;

  public quanlisanpham() {
    n = 3;
    sp = new sanpham[3];
    sp[0] = new khangiay("khan giay n1", 1, 12000, "21/12/2020", "khan giay kho");
    sp[1] = new nuochoa("Nuoc hoa nina", 2, 3000000, "12/12/2000", "classical");
    sp[2] = new kinh("Kinh thoi trang", 3, 200000, "21/03/2020", "Kinh ram");
  }

  public void quanli() {
    System.out.println("Nhập mã số thao tác cần thực hiện:");
    System.out.println("1. Thêm sản phẩm");
    System.out.println("2. Xóa sản phẩm");
    System.out.println("3. Sửa sản phẩm");
    System.out.println("4. Xem danh sách sản phẩm");
    System.out.println("5. Quay lại menu chung");//quay lai menu quan ly truoc
    System.out.println("Thao tác:");
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    switch (t) {
      case 1: {
        them();
        break;
      }
      case 2: {
        xoa();
        break;
      }
      case 3: {
        sua();
        break;
      }
      case 4: {
        xuat();
        break;
      }
      case 5: {
        // code quay lại menu quản lý trước
        break;
      }
    }
  }

  public void them() {
    System.out.println("Bạn muốn thêm sản phẩm nào ");
    System.out.println("1. Khăn giấy ");
    System.out.println("2. Nước hoa");
    System.out.println("3. Mắt kính ");
    System.out.println("4. Quay lại");
    System.out.println("Thao tác:");
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    switch (s) {
      case 1: {
        sp = Arrays.copyOf(sp, n + 1);
        int m, g;
        String nsx, l, t;
        System.out.printf("Nhập tên sản phẩm\n");
        t = sc.nextLine();
        t = sc.nextLine();
        System.out.printf("Nhập mã sản phẩm(số)\n");
        m = sc.nextInt();
        System.out.printf("Nhập giá sản phẩm\n");
        g = sc.nextInt();
        System.out.printf("Nhập ngày sản xuất\n");
        nsx = sc.nextLine();
        nsx = sc.nextLine();
        System.out.printf("Nhập loại khăn giấy(khăn giấy khô,ướt...)\n");
        l = sc.nextLine();
        sp[n] = new khangiay(t, m, g, nsx, l);
        n++;
        break;
      }
      case 2: {
        sp = Arrays.copyOf(sp, n + 1);
        int m, g;
        String nsx, h, t;
        System.out.printf("Nhập tên sản phẩm\n");
        t = sc.nextLine();
        t = sc.nextLine();
        System.out.printf("Nhập mã sản phẩm(số)\n");
        m = sc.nextInt();
        System.out.printf("Nhập giá sản phẩm\n");
        g = sc.nextInt();
        System.out.printf("Nhập ngày sản xuất\n");
        nsx = sc.nextLine();
        nsx = sc.nextLine();
        System.out.printf("Nhập hương nước hoa(hoa hồng, classic...)\n");
        h = sc.nextLine();
        sp[n] = new nuochoa(t, m, g, nsx, h);
        n++;
        break;
      }
      case 3: {
        sp = Arrays.copyOf(sp, n + 1);
        int m, g;
        String nsx, l, t;
        System.out.printf("Nhập tên sản phẩm\n");
        t = sc.nextLine();
        t = sc.nextLine();
        System.out.printf("Nhập mã sản phẩm(số)\n");
        m = sc.nextInt();
        System.out.printf("Nhập giá sản phẩm\n");
        g = sc.nextInt();
        System.out.printf("Nhập ngày sản xuất\n");
        nsx = sc.nextLine();
        nsx = sc.nextLine();
        System.out.printf("Nhập loại kính(kính cận, kính râm,...)\n");
        l = sc.nextLine();
        sp[n] = new kinh(t, m, g, nsx, l);
        n++;
        break;
      }
      case 4:
        quanli();
        break;
      default:
        quanli();
    }
    quanli();
  }

  public void xuat() {
    System.out.printf("Danh sach san pham:\n");
    for (int i = 0; i < n; i++) {
      sp[i].xuat();
    }
    quanli();

  }

  public void xoa() {
    System.out.println("Nhập mã sản phẩm cần xóa:");
    Scanner sc = new Scanner(System.in);
    int i, j;
    int t = sc.nextInt();
    for (i = 0; i < n; i++) {
      if (sp[i].getMsp() == t) {
        for (j = i; j < n - 1; j++) {
          sp[j] = sp[j + 1];
        }
        n--;
        sp = Arrays.copyOf(sp, n);
        System.out.println("đã xóa sản phẩm");
      }
      quanli();
    }


  }

  public void sua() {
    System.out.println("Nhập mã sản phẩm cần Sửa:");
    Scanner sc = new Scanner(System.in);
    int i, j, t, d;
    t = sc.nextInt();
    for (i = 0; i < n; i++) {
      if (sp[i].getMsp() == t) {
        System.out.println("Sửa thông tin:\n"
            + "1. Tên sản phẩm\n"
            + "2. Mã sản phẩm\n"
            + "3. Giá\n"
            + "4. Ngày sản xuất\n");
        if (sp[i] instanceof khangiay || sp[i] instanceof kinh) {
          System.out.println("5. Loại");
        } else {
          System.out.println("5. Mùi hương");
        }

      }
      d = sc.nextInt();
      switch (d) {
        case 1: {
          System.out.println("Nhập tên mới:");
          String newname = sc.nextLine();
          newname = sc.nextLine();
          sp[i].setTen(newname);
          break;
        }
        case 2: {
          System.out.println("Nhập mã sản phẩm mới:");
          int m = sc.nextInt();
          sp[i].setMsp(m);
          break;
        }
        case 3: {
          System.out.println("Nhập giá mới:");
          int g = sc.nextInt();
          sp[i].setGia(g);
          break;
        }
        case 4: {
          System.out.println("Nhập NSX mới:");
          String newname = sc.nextLine();
          newname = sc.nextLine();
          sp[i].setNsx(newname);
          break;
        }
        case 5: {
          if (sp[i] instanceof khangiay || sp[i] instanceof kinh) {
            System.out.println("Nhập loại mới");
            String newl = sc.nextLine();
            newl = sc.nextLine();
            if (sp[i] instanceof khangiay) {
              khangiay k = (khangiay) sp[i];
              k.setLoaiKhan(newl);
              sp[i] = k;
            } else {
              kinh k = (kinh) sp[i];
              k.setLoaiKinh(newl);
              sp[i] = k;
            }
          } else {
            System.out.println("Nhập Mùi hương mới");
            String newl = sc.nextLine();
            newl = sc.nextLine();
            nuochoa h = (nuochoa) sp[i];
            h.setHuong(newl);
            sp[i] = h;
          }
          break;
        }
      }
      break;
    }
    quanli();
  }

}

abstract class sanpham {

  int msp, gia;
  String ngaysanxuat, ten;

  public sanpham(String t, int m, int g, String nsx) {
    ten = t;
    msp = m;
    gia = g;
    ngaysanxuat = nsx;
  }

  public int getMsp() {
    return msp;
  }

  public void setTen(String t) {
    ten = t;
  }

  public void setMsp(int m) {
    msp = m;
  }

  public void setGia(int g) {
    gia = g;
  }

  public void setNsx(String n) {
    ngaysanxuat = n;
  }

  public void xuat() {
    System.out.printf("Tên sản phẩm:%S ,mã sản phẩm: %d, giá sản phẩm: %d, NSX: %s ,", ten, msp,
        gia, ngaysanxuat);
  }

  public void set(int m, int g, String nsx) {
    msp = m;
    gia = g;
    ngaysanxuat = nsx;
  }

}

class khangiay extends sanpham {

  String loai;

  public khangiay(String t, int m, int g, String nsx, String l) {
    super(t, m, g, nsx);
    loai = l;
  }

  @Override
  public void xuat() {
    super.xuat();
    System.out.printf("Khan giay loai:%s \n", loai);
  }

  public void setLoaiKhan(String l) {
    loai = l;
  }

}

class nuochoa extends sanpham {

  String huong;

  public nuochoa(String t, int m, int g, String nsx, String h) {
    super(t, m, g, nsx);
    huong = h;
  }

  @Override
  public void xuat() {
    super.xuat();
    System.out.printf("nước hoa hương:%s \n", huong);
  }

  public void setHuong(String h) {
    huong = h;
  }

}

class kinh extends sanpham {

  String loai;

  public kinh(String t, int m, int g, String nsx, String l) {
    super(t, m, g, nsx);
    loai = l;
  }

  @Override
  public void xuat() {
    super.xuat();
    System.out.printf("Kính loại:%s \n", loai);
  }

  public void setLoaiKinh(String l) {
    loai = l;
  }

}
