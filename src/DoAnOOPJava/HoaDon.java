package DoAnOOPJava;

import de_an_gk.QLSP;
import de_an_gk.SanPham;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class HoaDon {

  //loại hóa đơn true là nhập false là xuất
  private boolean loaihoadon = true;
  private String mahoadon;
  private static int masohoadon = 1;
  private String tenNhanVienLapHoaDon;
  private int tongTienHang=0;
  List<ChiTietHoaDon> dschitiethoadon = new ArrayList<>();
  Locale localeVn  = new Locale("vi","VN");
  NumberFormat countryCurrency = NumberFormat.getCurrencyInstance(localeVn);
  Calendar cal = Calendar.getInstance();
  private Date date = cal.getTime();
  Scanner sc = new Scanner(System.in);

 public static int taoMaSoHoaDon() {
   return masohoadon++;
 }

  public HoaDon(boolean loaihoadon, String mahoadon, String tenNhanVienLapHoaDon, int tongTienHang,
      List<ChiTietHoaDon> dschitiethoadon, Locale localeVn, NumberFormat countryCurrency,
      Calendar cal, Date date, Scanner sc) {
    this.loaihoadon = loaihoadon;
    this.mahoadon = mahoadon;
    this.tenNhanVienLapHoaDon = tenNhanVienLapHoaDon;
    this.tongTienHang = tongTienHang;
    this.dschitiethoadon = dschitiethoadon;
    this.localeVn = localeVn;
    this.countryCurrency = countryCurrency;
    this.cal = cal;
    this.date = date;
    this.sc = sc;
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

  //dùng để nhập các mặt hàng của siêu thị
  public HoaDon() {
    setMahoadon("HD0" + taoMaSoHoaDon());
  }

  public boolean isLoaihoadon() {
    return loaihoadon;
  }

  public void setLoaihoadon(boolean loaihoadon) {
    this.loaihoadon = loaihoadon;
  }

  public int getTongTienHang() {
    return tongTienHang;
  }

  public void setTongTienHang(int tongTienHang) {
    this.tongTienHang = tongTienHang;
  }

  public String getMahoadon() {
    return mahoadon;
  }

  public void setMahoadon(String mahoadon) {
    this.mahoadon = mahoadon;
  }

  public static int getMasohoadon() {
    return masohoadon;
  }

  public static void setMasohoadon(int masohoadon) {
    HoaDon.masohoadon = masohoadon;
  }

  public Calendar getCal() {
    return cal;
  }

  public void setCal(Calendar cal) {
    this.cal = cal;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  public void LapHoaDonNhap(NhanVienBanHang nvbh, QLSP qlsp,DanhSachHoaDon danhSachHoaDon) {
    //loại hóa đơn bằng true
    //chi tiết hóa đơn
    System.out.println("Mã hóa đơn: "+mahoadon);
    loaihoadon = true;
    ChiTietHoaDon cthd = new ChiTietHoaDon();
    cthd.LapChiTietHoaDonNhap(this, nvbh, qlsp);
    tongTienHang = cthd.tongTienHang;
    tenNhanVienLapHoaDon=nvbh.hoten;
    danhSachHoaDon.getDsHoaDon().add(this);
  }

  public void LapHoaDonXuat(NhanVienBanHang nvbh, QLSP qlsp,DanhSachHoaDon danhSachHoaDon) {
    System.out.println("Mã hóa đơn: "+mahoadon);
    loaihoadon = false;
    ChiTietHoaDon cthd = new ChiTietHoaDon();
    cthd.LapChiTietHoaDonXuat(this, nvbh,qlsp);

    tongTienHang=cthd.tongTienHang;
    tenNhanVienLapHoaDon=nvbh.hoten;
    danhSachHoaDon.getDsHoaDon().add(this);
  }

  public void Xuat1HoaDon() {
    System.out.println("Mã hóa đơn: "+mahoadon);
    System.out.println("Nhân viên lập hóa đơn: " + tenNhanVienLapHoaDon);
    String loai;
    if (loaihoadon == true) {
      loai = "Nhập";
    } else {
      loai = "Xuất";
    }
    System.out.println("Loại hóa đơn: " + loai);
    System.out.println("Thời gian lập hóa đơn: " + getDate());
    System.out.printf("%-20s %-20s %-20s %-20s\n", "Mã sẩn phẩm", "Tên sẩn phẩm","Giá", "Số lượng");
    int tongTienHang=0;
    for (var i : dschitiethoadon) {
            System.out.printf("%-20s %-20S %-20s %-20s\n"
                ,i.getMasp(),i.getTensanpham(),countryCurrency.format(i.getGia()),i.getSoluong());
            tongTienHang+=i.getGia()*i.getSoluong();
      //i.XuatChiTietHoaDon();
    }
    System.out.println("Tổng tiền hàng: "+countryCurrency.format(tongTienHang));
    System.out.println();
  }


}
