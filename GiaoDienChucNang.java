import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GiaoDienChucNang implements ActionListener{

    JLabel lb;
    JButton b1, b2, b3, b4, b5, b6, b7;
        
    public GiaoDienChucNang(JPanel p){

            p.setSize(600,500);
            p.setLayout(null);
            p.setBackground(Color.WHITE);
            p.setVisible(true); 
            
            lb = new JLabel("Quản lý nhân sự BK Corporation");       
            lb.setBounds(170,20,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            p.add(lb);
            
            lb = new JLabel("-------------------------");       
            lb.setBounds(190,40,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            p.add(lb);
                        
            b1 = new JButton("1. Thông tin cơ bản");
            b1.setBounds(150,80,280,30);   
            p.add(b1);
            
            b2 = new JButton("2. Tìm kiếm thông tin nhân viên");
            b2.setBounds(150,130,280,30);   
            p.add(b2);
            
            b3 = new JButton("3. Hiển thị tình trạng làm việc của nhân viên");
            b3.setBounds(150,180,280,30);   
            p.add(b3);
            
            b4 = new JButton("4. Hiển thị tình trạng của một đơn vị");
            b4.setBounds(150,230,280,30);   
            p.add(b4);
            
            b5 = new JButton("5. Thêm nhân viên mới");
            b5.setBounds(150,280,280,30);   
            p.add(b5);
            
            b6 = new JButton("6. Cập nhật thông tin nhân viên");
            b6.setBounds(150,330,280,30);   
            p.add(b6);
            
            b7 = new JButton("7. Thoát");
            b7.setBounds(150,380,280,30);   
            p.add(b7);
            
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b7.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1){
            
            JFrame f = new JFrame("Thong tin co ban");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new GiaoDienThongTinCoBan();
            f.add(p);
            
        }
        
        if (e.getSource() == b2){
            
            JFrame f = new JFrame("Tim kiem thong tin nhan vien");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new GiaoDienTimKiemThongTin();
            f.add(p);
  
        }
        
        if (e.getSource() == b3){
            
            JFrame f = new JFrame("Tinh trang lam viec");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new GiaoDienTinhTrangLamViec();
            f.add(p);
  
        }
        
        if (e.getSource() == b4){
            JFrame f = new JFrame("Tinh trang don vi");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new GiaoDienTinhTrangDonVi();
            f.add(p);
  
        }
        
        if (e.getSource() == b5){
            try {
                JFrame f = new JFrame("Them nhan vien moi");
                f.setSize(600, 500);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                
                JPanel p = new GiaoDienThemNhanVien();
                f.add(p);
                
            } catch (ParseException ex) {
                Logger.getLogger(GiaoDienChucNang.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
        
        if (e.getSource() == b6){
            JFrame f = new JFrame("Cap nhat thong tin nhan vien");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new GiaoDienCapNhatThongTin();
            f.add(p);
  
        }

        if (e.getSource() == b7)
            System.exit(0);
    }
}

    
