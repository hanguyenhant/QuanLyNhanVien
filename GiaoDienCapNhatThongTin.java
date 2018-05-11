
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaoDienCapNhatThongTin extends JPanel implements ActionListener {
    
    JLabel lb;
    JButton bt;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
    
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
    
    public GiaoDienCapNhatThongTin() {
            super.setSize(600,500);
            super.setLayout(null);
            super.setBackground(Color.WHITE);
            super.setVisible(true);
        
            lb = new JLabel("Cập nhật thông tin nhân viên");       
            lb.setBounds(170,20,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
            
            lb = new JLabel("-------------------------");       
            lb.setBounds(190,40,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
            
            lb = new JLabel("MSNV: ");
            lb.setBounds(100,60,100,30);
            super.add(lb);
        
            tf1 = new JTextField(20);
            tf1.setBounds(230,60,150,30);           
            super.add(tf1);
            
            lb = new JLabel("Họ: ");
            lb.setBounds(100,90,100,30);
            super.add(lb);
        
            tf2 = new JTextField(20);
            tf2.setBounds(230,90,150,30);            
            super.add(tf2);
            
            lb = new JLabel("Tên: ");
            lb.setBounds(100,120,100,30);
            super.add(lb);
        
            tf3 = new JTextField(20);
            tf3.setBounds(230,120,150,30);            
            super.add(tf3);
            
            lb = new JLabel("Đơn vị: ");
            lb.setBounds(100,150,150,30);
            super.add(lb);
        
            tf4 = new JTextField(20);
            tf4.setBounds(230,150,150,30);            
            super.add(tf4);
            
            lb = new JLabel("Chức vụ: ");
            lb.setBounds(100,180,150,30);            
            super.add(lb);
        
            tf5 = new JTextField(20);
            tf5.setBounds(230,180,150,30);            
            super.add(tf5);                      
            
            lb = new JLabel("Ngày sinh: ");
            lb.setBounds(100,210,150,30);
            super.add(lb);
        
            tf6 = new JTextField(20);
            tf6.setBounds(230,210,150,30);           
            super.add(tf6);
            
            lb = new JLabel("Quê quán: ");
            lb.setBounds(100,240,150,30);
            super.add(lb);
        
            tf7 = new JTextField(20);
            tf7.setBounds(230,240,150,30);            
            super.add(tf7);
            
            lb = new JLabel("Địa chỉ: ");
            lb.setBounds(100,270,100,30);
            super.add(lb);
        
            tf8 = new JTextField(20);
            tf8.setBounds(230,270,150,30);            
            super.add(tf8);
            
            lb = new JLabel("Email: ");
            lb.setBounds(100,300,150,30);
            super.add(lb);
        
            tf9 = new JTextField(20);
            tf9.setBounds(230,300,150,30);           
            super.add(tf9);
            
            lb = new JLabel("Số điện thoại: ");
            lb.setBounds(100,330,200,30);
            super.add(lb);
        
            tf10 = new JTextField(20);
            tf10.setBounds(230,330,150,30);           
            super.add(tf10);
            
            lb = new JLabel("Ngày bắt đầu làm việc: ");
            lb.setBounds(100,360,200,30);
            super.add(lb);
        
            tf11 = new JTextField(20);
            tf11.setBounds(230,360,150,30);           
            super.add(tf11);
        
            bt = new JButton("Cập nhật");
            bt.setBounds(250,400,100,30);        
            bt.addActionListener(this);
            super.add(bt);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt){
                                                  
            try {                          
                MSNV = tf1.getText();
                ho = tf2.getText();
                ten = tf3.getText();
                tenDonVi = tf4.getText();
                chucVu = tf5.getText();
                ngaySinh = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(tf6.getText()).getTime());
                queQuan = tf7.getText();
                diaChi = tf8.getText();
                email = tf9.getText();
                SDT = tf10.getText();
                ngayBatDauLV = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(tf11.getText()).getTime());
                LinkedList<NgayLamViec> ngayLamViec = new LinkedList();
                
                NhanVien nvsua = new NhanVien(MSNV,ho,ten,tenDonVi,chucVu,ngaySinh,queQuan,
                                              diaChi,email,SDT,ngayBatDauLV,ngayLamViec);
                
                NhanVien nv = QuanLy.timKiemMSNV(MSNV);
                               
                JFrame frame = new JFrame("Thong bao");     
                if (nv.edit(nv, nvsua, QuanLy.list) == true)
                    {
			JOptionPane.showMessageDialog(frame, "Cập nhật thành công!");
                    }
		else
                    {
			JOptionPane.showMessageDialog(frame, "Cập nhật thất bại!");
                    }                              
                
            } catch (ParseException ex) {
                JFrame frame = new JFrame("Thong bao");             
                JOptionPane.showMessageDialog(frame, "Vui lòng không đúng định dạng ngày dd/MM/yyyy!");
            }
        }
        
    }
    
}
