package DoAnOOPJava;

public class TestQLNV {

  public static void main(String[] args) {
    QLNV qlnv = new QLNV();
    qlnv.DocFileNhanVien();
    qlnv.them();
    qlnv.xuat();
    for(var i: qlnv.dsnv )
    {
      if(i instanceof NhanVienBanHang)
      {
        i.xuat();
        System.out.println("Lương: "+i.tinhluong());
      }

      if(i instanceof NhanVienQuanLy)
      {
        i.xuat();
        System.out.println("Lương: "+i.tinhluong());
      }
    }
  }

}
