//package DoAnOOPJava;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DanhSachSanPham {
//
//  private List<SanPham> danhSachSanPham = new ArrayList<>();
//
//  public String ChuanHoaMaSanPham(String a) {
//    return a.toUpperCase();
//  }
//
//
//  public void DocFileSanPham() {
//    File p = new File("/HocJava/src/DoAnOOPJava/danhsachsanpham.txt");
//    try {
//      BufferedReader br = Files.newBufferedReader(p.toPath(), StandardCharsets.UTF_8);
//      String s = null;
//      SanPham sanPham = null;
//      while (true) {
//        s = br.readLine();
//        if (s == null) {
//          br.close();
//          break;
//        } else {
//          String[] cut = s.split("  ");
//          sanPham = new SanPham();
//          sanPham.setMasp(cut[0]);
//          sanPham.setTensanpham(cut[1]);
//          sanPham.setGia(Integer.parseInt(cut[2]));
//          sanPham.setSoluong(Integer.parseInt(cut[3]));
//          danhSachSanPham.add(sanPham);
//        }
//      }
//    } catch (IOException ie) {
//      System.out.println("Đọc file sản phẩm bị lỗi gì ấy bạn êiiii");
//    }
//  }
//
//  public void xuatDanhSachSanPham() {
//    String.format("|-%20s| |-%20s| |-%20s| |-%20s| |-%20s|", "Mã sản phẩm", "Tên sản phẩm",
//        "Giá", "Số lượng");
//    for (int i = 0; i < danhSachSanPham.size(); i++) {
//      String.format("|-%20s| |-%20s| |-%20s| |-%20s| |-%20s|", danhSachSanPham.get(i).getMasp(),
//          danhSachSanPham.get(i).getTensanpham()
//          , danhSachSanPham.get(i).getGia(), danhSachSanPham.get(i).getSoluong());
//    }
//  }
//
//}