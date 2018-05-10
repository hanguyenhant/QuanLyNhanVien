
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GiaoDienTimKiemThongTin extends JPanel implements ActionListener {

    JLabel lb;
    JButton b1, b2, b3, b4;
    public GiaoDienTimKiemThongTin() {
        
            super.setSize(600,500);
            super.setLayout(null);
            super.setBackground(Color.WHITE);
            super.setVisible(true);
        
            lb = new JLabel("Tìm kiếm thông tin nhân viên");       
            lb.setBounds(180,20,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
            
            lb = new JLabel("-------------------------");       
            lb.setBounds(190,40,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
                        
            b1 = new JButton("1. Tìm theo họ tên");
            b1.setBounds(150,80,280,30);   
            super.add(b1);
            
            b2 = new JButton("2. Tìm theo chức vụ");
            b2.setBounds(150,130,280,30);   
            super.add(b2);
            
            b3 = new JButton("3. Tìm theo ngày sinh");
            b3.setBounds(150,180,280,30);   
            super.add(b3);
            
            b4 = new JButton("4. Tìm theo mã số nhân viên");
            b4.setBounds(150,230,280,30);   
            super.add(b4);
                                   
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);                 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            JFrame f = new JFrame("Tim kiem theo ho ten");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new TimKiemHoTen();
            f.add(p);
  
        }
        
        if (e.getSource() == b2){
            JFrame f = new JFrame("Tim kiem theo chuc vu");            
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new TimKiemChucVu();          
            f.add(p);
  
        }
        
        if (e.getSource() == b3){
            JFrame f = new JFrame("Tim kiem theo ngay sinh");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new TimKiemNgaySinh();
            f.add(p);
  
        }
        
        if (e.getSource() == b4){
            JFrame f = new JFrame("Tim kiem theo ma so");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            JPanel p = new TimKiemMaSo();
            f.add(p);
  
        }

    }
    
}
