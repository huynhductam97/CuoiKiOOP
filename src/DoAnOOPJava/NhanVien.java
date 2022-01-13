package DoAnOOPJava;
import de_an_gk.INhapXuat;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class NhanVien implements Comparable<NhanVien>, INhapXuat {
    protected String manv;
    protected String hoten;
    protected String ngaysinh;
    Locale localeVn = new Locale("vi","VN");
    NumberFormat countrycurrency = NumberFormat.getCurrencyInstance(localeVn);
    Scanner reader = new Scanner(System.in);


    public NhanVien(String manv, String hoten, String ngaysinh, Locale localeVn,
        NumberFormat countrycurrency, Scanner reader) {
        this.manv = manv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.localeVn = localeVn;
        this.countrycurrency = countrycurrency;
        this.reader = reader;
    }

    public String ChuanHoaTen(String ten)
    {   ten=ten.trim().replaceAll("\\s+"," ");

        char[] charten = ten.toCharArray();
        boolean foundSpace = true;
        int n= charten.length;
        for(int i=0;i<n;i++)
        {
            if(Character.isLetter(charten[i]))
            {
                if(foundSpace)
                {
                    charten[i]=Character.toUpperCase(charten[i]);
                    foundSpace=false;
                }
            }
            else
            {
                foundSpace=true;
            }
        }
        return String.valueOf(charten);
    }
    
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    
    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public NhanVien()
    {     
    }
    
    public NhanVien(String manv, String hoten, String ngaysinh) {
        this.manv = manv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
    }

    public void nhap()
    {
        System.out.print("\nNhập mã nhân viên: ");
        manv = LayMaNhanVien();
        System.out.print("Nhập họ và tên: ");
        hoten = ChuanHoaTen(reader.nextLine());
        System.out.print("Nhập ngày sinh: ");
        ngaysinh = reader.nextLine();
    }
    public void xuat()
    {
       System.out.printf("%-20s %-25s %-25s", manv, hoten, ngaysinh);
    }
    public void sua()
    {
        System.out.print("Nhập họ và tên: ");
        hoten = ChuanHoaTen(reader.nextLine());
        System.out.print("Nhập ngày sinh: ");
        ngaysinh = reader.nextLine();     
    }
    public String LayMaNhanVien()
    {
        String tmp = "";
        boolean done = true;
        do
        {
            System.out.print("\nNhập mã nhân viên: ");
            tmp = reader.nextLine().toUpperCase();
            if ( tmp.contains(" ") || tmp.contains("\t"))
            {
               System.out.println("Mã nhân viên không được chứa khoảng cách !");
               done = false;
               continue;
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
    public int LayDuLieuSoInt(String loai)
    {
        int tmp = 0;
        boolean done = true;
        do
        {
            try{
                System.out.print("Nhập " + loai + " của nhân viên: ");
                tmp = Integer.parseInt(reader.nextLine());
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Lỗi, "+ loai +" không được chứa kí tự !");
                done = false;
            }
        } while(done == false);
        return tmp;
    }

    public abstract int tinhluong();
    @Override
    public int compareTo(NhanVien h) {
        return this.manv.compareTo(h.manv);
    }
    
    public void nhaptufile(String line)
    {
        String cut[] = line.split(", ");
        setManv(cut[0]);
        setHoten(cut[1]);
        setNgaysinh(cut[2]);
    }
    public void ghidatarafile(FileWriter fw) throws IOException
    {
        fw.write(manv + ", " + hoten + ", " + ngaysinh + ", ");
    }


}
