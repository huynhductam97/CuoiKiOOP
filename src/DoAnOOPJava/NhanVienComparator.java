package DoAnOOPJava;

import java.util.Comparator;


//dùng class này để làm điều kiện lặp cho Collection sort
public class NhanVienComparator implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        int luong1 = o1.tinhluong();
        int luong2 = o2.tinhluong();
        if(luong1<luong2)
        {
            return 1;
        }
        else if(luong1==luong2)
        {
            return 0;
        }
        return -1;
    }


}
