
import java.util.LinkedList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class NhanVien {
    private String MSNV;
    private String ho;
    private String ten;
    private DonVi tenDonVi;
    private String chucVu;
    private Date ngaySinh;
    private String queQuan;
    private String diaChi;
    private String email;
    private String SDT;
    private Date ngayBatDauLV;
    private static LinkedList<String> ngayLamViec;
    
    
    public NhanVien(String data){} // Lấy dữ liệu từ file txt
    
    public NhanVien()
	{
		Scanner input = new Scanner(System.in);
		// Nhập dữ liệu từ bàn phím
		
	}
    
    // Các phương thức getter và setter

    public int soGioThieuHut(){
        //Giả sử ngày làm việc 8 tiếng từ 8:30 đến 17:30
        //đọc từng dòng của ngayLamViec -> tính số giờ thiếu hụt
        //Tính tổng 
    }  
    
    public String toString(){
    // Hiển thị thông tin cơ bản của nhân viên
    }
    
}
