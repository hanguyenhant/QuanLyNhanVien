import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuanLy {
    static LinkedList<DonVi> list = new LinkedList();
    static int soDV;
    static int soNhanVien = 0;
            
    public static DonVi timKiemDonVi(String tenDonVi){
    	//tìm kiếm đơn vị theo tên
    	//trả về tham chiếu đến đơn vị đó, không tìm thấy thì trả về null
        int i; 
        
        for (i=0;i<list.size();i++)
            if (list.get(i).getTenDonVi().equals(tenDonVi))               
                return list.get(i);
        
        return null;        
    }
    
    public static String timKiemTheoHoTen(String hoVaTen){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoHoTen() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s = "";                        
        
        for (int i=0;i<list.size();i++){
            
            LinkedList<NhanVien> listnv;   
            
            //Lấy ra 1ist NhanVien có họ tên này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoHoTen(hoVaTen);
            
            //trả về xâu thông tin
            for (int j=0;j<listnv.size();j++)
                s += listnv.get(j).toString();           
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        
        return s;          	
    }
    
    public static String timKiemTheoChucVu(String s){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoChucVu() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên 
        
        String s1 = "";         
        
        for (int i=0;i<list.size();i++){
            
            LinkedList<NhanVien> listnv;  
            
            //Lấy ra 1ist NhanVien có chức vụ này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoChucVu(s);
            
            //trả về xâu thông tin
            for (int j=0;j<listnv.size();j++)
                s1 += listnv.get(j).toString();           
        }
        
        if (s1.equals(""))
            s1 = "Khong tim thay!";
        
        return s1;
    }
    
    public static String timKiemTheoNgaySinh(Date d){
    	//Trả về các nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng DonVi.timKiemTheoNgaySinh() để tìm kiếm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s = "";        
        
        for (int i=0;i<list.size();i++){
            
            LinkedList<NhanVien> listnv;   
            
            //Lấy ra 1ist NhanVien có ngày sinh này trong từng đơn vị 
            listnv = list.get(i).timKiemTheoNgaySinh(d);
            
            //trả về xâu thông tin
            for (int j=0;j<listnv.size();j++)
                s += listnv.get(j).toString();           
        }
        
        if (s.equals(""))
            s = "Khong tim thay!";
        return s;
        
    }
    
    public static NhanVien timKiemMSNV(String msnv)
    {
    	//dùng DonVi.timKiemTheoMSNV() để tìm kiếm
        NhanVien nv = null;
        for (int i=0;i<list.size();i++){
            nv = list.get(i).timKiemTheoMSNV(msnv);
            if (nv != null) break;
        }
        return nv;
    }
    
    public static String timKiemTheoMSNV(String s){
    	//Trả về nhân viên dạng xâu, không có thì trả về "Không tìm thấy"
    	//dùng timKiemMSNV để tìm
    	//dùng NhanVien.toString() để hiển thị thông tin nhân viên
        
        String s1;   
        NhanVien nv = null;
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra nhân viên có MSNV này 
            nv = list.get(i).timKiemTheoMSNV(s);
            
            if (nv != null) break;
            
        }
        
        if (nv == null)
            s1 = "Khong tim thay!";
        else s1 = nv.toString();
        return s1;
        
    }
    
    public static String tinhTrangLamViec(String MSNV){
    	//Trả về, thông tin cơ bản và tình trạng làm việc của nhân viên
    	//Nếu không tồn tại nhân viên, trả về "Không tìm thấy"
    	//Dùng DonVi.timKiemTheoMSNV() để tìm nhân viên, rồi dùng NhanVien.thongTinLamViec(), NhanVien.soGioThieuHut()
        String s = "";
        NhanVien nv = null;
        int i;
        
        for (i=0;i<list.size();i++){
            //Lấy ra nhân viên có MSNV này 
            nv = list.get(i).timKiemTheoMSNV(MSNV);
            if (nv != null) break;
        }
        
        //trả về xâu thông tin
        s = nv.thongTinLamViec();
        
        if (s.equals(""))
            s = "Khong tim thay!";
        
        return s;
    } 
   
    public static String thongTinDonVi(DonVi donVi){
    	//trả về xâu chứa thông tin của 1 đơn vị, dùng DonVi.toString()
    	//nếu không tồn tại đơn vị, trả về "Không tồn tại đơn vị"
        String s = "";
        DonVi dv = null;           
        int i;
        int soNV = 0;
        
        String tenDonVi = donVi.getTenDonVi();
        
        if (tenDonVi.equals("BK Corporation")){
            for (i=0;i<list.size();i++){
                s += list.get(i).toString();
                soNV += list.get(i).getSoNV();
            }
            s += "So nhan vien cua don vi la: " + soNV;
            
        }  
        
        if (!"BK Corporation".equals(tenDonVi)){
            if (tenDonVi.substring(0,2).equals("BK")){
                
            LinkedList<DonVi> listdv = new LinkedList();
            for (i=0;i<list.size();i++){
                String s1 = list.get(i).getTenDonVi();
                if (s1.substring(s1.length()-tenDonVi.length(),s1.length()).equals(tenDonVi)){
                    listdv.add(list.get(i));
                    soNV += list.get(i).getSoNV();
                }
            }
            
            for (i=0;i<listdv.size();i++)
                s += listdv.get(i).toString();
            s += "So nhan vien cua don vi la: " + soNV;
            }    
        }
        
        if (tenDonVi.substring(0,5).equals("Phong")){
            for (i=0;i<list.size();i++){
            //Lấy ra đơn vị có tên đơn vị này
            dv = QuanLy.timKiemDonVi(donVi.getTenDonVi());
            if (dv != null) break;
            }
                           
            //trả về xâu thông tin
            s = dv.toString();
            s += "So nhan vien cua don vi la: " + dv.getSoNV();
        
            if (s.equals(""))
                s = "Khong tim thay!";
 
        }     
        return s;     
    }
    
    public static void themNhanVien(NhanVien nv){  
        
        //Kiểm tra xem đơn vị tồn tại chưa
        //Nếu có rồi thì thêm nhân viên
        //Chưa có thì tạo 1 đơn vị mới rồi thêm nhân viên
        
        String tenDV = nv.getTenDonVi().getTenDonVi();
        DonVi dv = timKiemDonVi(tenDV);
                              
        if (dv != null){            
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getTenDonVi().equals(tenDV)){
                    list.get(i).themNhanVien(nv);
                    break;
                }
        }
        else{
                dv = new DonVi(tenDV);
                soDV++;
                list.add(dv);
                dv.themNhanVien(nv);
            }
        
        //Mở file để ghi nhân viên mới vào
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            File f = new File("ThongTinNhanVien.txt");
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter out = new BufferedWriter(fw);

            out.write(nv.getMSNV()); out.newLine();                      
            out.write(nv.getHo()); out.newLine();            
            out.write(nv.getTen()); out.newLine();           
            out.write(nv.getTenDonVi().getTenDonVi()); out.newLine();         
            out.write(nv.getChucVu()); out.newLine();                                   
            out.write(formatter1.format(nv.getNgaySinh())); out.newLine();          
            out.write(nv.getQueQuan()); out.newLine();           
            out.write(nv.getDiaChi()); out.newLine();            
            out.write(nv.getEmail()); out.newLine();            
            out.write(nv.getSDT()); out.newLine();           
            out.write(formatter1.format(nv.getNgayBatDauLV())); out.newLine();
                         
            out.flush();
            out.close();
        }
        catch (IOException e){}                                  
    }   
    
    public static String thongTinCoBan(){
        //Tên chủ tịch
        //tên các công ty con và giám đốc, phó giám đốc tương ứng
        //tên các phòng ban và trưởng, phó phòng tương ứng
        //tổng số nhân viên của công ty
        
        int i;
        String s;
        String chuTich = null, gdBKEn = null, pgdBKEn = null, gdBKF = null, pgdBKF = null, gdBKT = null, pgdBKT = null;
        
        for (i=0;i<list.size();i++){
            
            if (list.get(i).getTenDonVi().equals("BK Corporation"))
                chuTich = list.get(i).getTruongDonVi();                       
                       
            if (list.get(i).getTenDonVi().equals("BK Entertainment")){
                gdBKEn = list.get(i).getTruongDonVi();
                pgdBKEn = list.get(i).getPhoDonVi();               
            }
                       
            if (list.get(i).getTenDonVi().equals("BK Food")){
                gdBKF = list.get(i).getTruongDonVi();
                pgdBKF = list.get(i).getPhoDonVi();
            }
                       
            if (list.get(i).getTenDonVi().equals("BK Tech")){
                gdBKT = list.get(i).getTruongDonVi();
                pgdBKT = list.get(i).getPhoDonVi();
            }                                     
        }
        s = "Chủ tịch: " + chuTich + "\n";
        s += "1. Công ty BK Entertainment: " + "\n";
        s += "Giám đốc: " + gdBKEn + "\n";
        s += "Phó giám đốc: \n" + pgdBKEn + "\n";
        s += "2. Công ty BK Food: " + "\n";
        s += "Giám đốc: " + gdBKF + "\n";
        s += "Phó giám đốc: \n" + pgdBKF + "\n";
        s += "3. Công ty BK Tech: " + "\n";
        s += "Giám đốc: " + gdBKT + "\n";
        s += "Phó giám đốc: \n" + pgdBKT + "\n";
        s += "Tổng số nhân viên: " + soNhanVien ; 
        
        return s;
    }
    
    public static void init() throws FileNotFoundException, java.text.ParseException
    {
    	//đọc dữ liệu từ file
    	//đặt giờ bắt đầu làm việc, kết thúc làm việc trong NgayLamViec
                
        String line1, line2 = null;
        LinkedList<String> lines;
        String MSNV;
        String ho;
        String ten;
        String tenDonVi;
        String chucVu;
        Date ngaySinh;
        String queQuan;
        String diaChi;
        String email;
        String SDT;
        Date ngayBatDauLV;
        LinkedList<NgayLamViec> ngayLamViec;
        NhanVien nv;
        
        try {
            File f = new File("ThongTinNhanVien.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);   
                        
            
            while((line1 = br.readLine()) != null){
                //Đọc dữ liệu của từng nhân viên
                lines = new LinkedList();
                if (line2 != null && line2.substring(0,2).compareTo("NV")==0)
                    lines.add(line2);
                lines.add(line1);                 
                while ((line2 = br.readLine()) != null && line2.substring(0,2).compareTo("NV")!=0)
                    lines.add(line2);
                                           
                
                //Khởi tạo nhân viên mới
                MSNV = lines.get(0);
                ho = lines.get(1);
                ten = lines.get(2);
                tenDonVi = lines.get(3);
                chucVu = lines.get(4);               
                ngaySinh = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(lines.get(5)).getTime());
                queQuan = lines.get(6);
                diaChi = lines.get(7);
                email = lines.get(8);
                SDT = lines.get(9);
                ngayBatDauLV = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(lines.get(10)).getTime());
                
                ngayLamViec = new LinkedList();
                for (int i = 11; i < lines.size(); i++){
                    NgayLamViec ngaylv = new NgayLamViec(lines.get(i));
                    ngayLamViec.add(ngaylv);                                       
                }
                
                nv = new NhanVien(MSNV, ho, ten, tenDonVi, chucVu, ngaySinh, 
                                  queQuan, diaChi, email, SDT, ngayBatDauLV, ngayLamViec);
                
                soNhanVien++;
                
                if (list.isEmpty()){
                    DonVi dv = new DonVi(tenDonVi);
                    soDV++;
                    list.add(dv);
                    dv.themNhanVien(nv);
                } else{
                        boolean flag = false;
                        for (int i = 0; i < list.size(); i++)
                            if (list.get(i).getTenDonVi().equals(tenDonVi)){
                                list.get(i).themNhanVien(nv);
                                flag = true;
                            }
                        if (!flag){
                            DonVi dv = new DonVi(tenDonVi);
                            soDV++;
                            list.add(dv);
                            dv.themNhanVien(nv);
                        }
                            
                }                                                                                                                                      
            }
                                                         
            fr.close();
            br.close();
            }
        catch (IOException ex) {}                     
    }        
}