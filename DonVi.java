import java.util.Date;
import java.util.LinkedList;

public class DonVi {
    private final LinkedList<NhanVien> list;
    private int soNV;
    private String tenDonVi;
    
    
    public DonVi(String tenDonVi){
        this.soNV = 0;
        this.tenDonVi = tenDonVi;
        LinkedList<NhanVien> nv = new LinkedList();
        this.list = nv;                	
    }

    public String getTenDonVi(){
	return tenDonVi;
    }
    
    public String getTruongDonVi(){
    // Tìm kiếm trong list i = 1:soNV
    // Nếu list.get(i).chucVu = "Chu tich" or "Giam doc" or "Truong phong"
    // ==> Lấy
    String truongDonVi = null;
    int i;
    for (i=0;i<list.size();i++)
        switch (list.get(i).getChucVu()) {
            case "Chu tich":                
            case "Giam doc":               
            case "Truong phong":
                truongDonVi = list.get(i).getHo() + " " + list.get(i).getTen();
            default:
                break;
        } 
    return truongDonVi;    
    }
    
    public String getPhoDonVi(){
    //Tìm kiếm trong list
    // Nếu list.get(i).ChucVu = "Pho chu tich" or "Pho giam doc" or "Pho phong"
    // ==> Lấy
    String phoDonVi = "";
    
    int i;
    for (i=0;i<list.size();i++)
        switch (list.get(i).getChucVu()) {
            case "Pho chu tich":              
            case "Pho giam doc":               
            case "Pho phong":
                phoDonVi += list.get(i).getHo() + " " + list.get(i).getTen() + "\n";
            default:
                break;
        }    
    return phoDonVi;  
    }
    
    void themNhanVien(NhanVien nv){        
    // list.add(nv);    
    // tăng số nhân viên lên 1

        list.add(nv);
        soNV++;      
    }
    
    void xoaNhanVien(NhanVien nv){
        
        //Xóa khỏi list
        //cập nhật lại số nhân viên
        
        list.remove(nv);
        soNV--;          	
    }
    
    @Override
    public String toString() {
    	//hiển thị thông tin đơn vị
        //Liệt kê tất cả các nhân viên trong đơn vị
        
        int i;
        String s = "";
        
        for (i=0;i<this.list.size();i++)
            s += this.list.get(i).toString();
        
        s += "So nhan vien cua don vi: " + this.soNV;
        
        return s;
    }
    
    
    public LinkedList<NhanVien> timKiemTheoHoTen(String s){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        String s2;        
        for (i=0;i<list.size();i++){
            s2 = list.get(i).getHo() + " " + list.get(i).getTen();
            if (s2.equals(s))
                listnv.add(list.get(i));
        }
        
        return listnv;
        
    } 
    
    public LinkedList<NhanVien> timKiemTheoChucVu(String s){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getChucVu().equals(s)){
                listnv.add(list.get(i));
            }
        
        return listnv;
    } 
    
    public LinkedList<NhanVien> timKiemTheoNgaySinh(Date d){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getNgaySinh().equals(d)){
                listnv.add(list.get(i));
            }
        
        return listnv;
        
    }
    
    public NhanVien timKiemTheoMSNV(String s){
        
        NhanVien nv = null;        
        int i;
        for (i=0;i<list.size();i++){
            if (list.get(i).getMSNV().equals(s)){
                nv = list.get(i);
                if (nv != null) break;
            }
        }
        
        return nv;
    }
}
