import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GiaoDienChinh implements ActionListener{
    
    JFrame f;
    JLabel lb;
    JButton bt1, bt2;
    JPanel p1;
    
    public GiaoDienChinh(){
        f = new JFrame("Bài tập lớn - KTLT - Quản lý nhân viên");
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        lb = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN");       
        lb.setBounds(140,120,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 20));
        lb.setForeground(Color.BLACK);
        p1.add(lb);
        
        lb = new JLabel("BK CORPORATION"); 
        lb.setBounds(220,150,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 20));
        lb.setForeground(Color.BLACK);
        p1.add(lb);
        
        lb = new JLabel("Bài tập lớn - Môn Kĩ thuật lập trình");
        lb.setBounds(120,180,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 18));
        lb.setForeground(Color.BLACK);
        p1.add(lb);
        
        bt1 = new JButton("Bắt đầu");
        bt1.setBounds(180,240,100,30);   
        p1.add(bt1);
        
        bt2 = new JButton("Thoát");
        bt2.setBounds(320,240,70,30);   
        p1.add(bt2);
        
        p1.setVisible(true);
        f.add(p1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
    
        f.setVisible(true);               
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == bt1){
            //Mở giao diện chức năng
            p1.setVisible(false);           
            JPanel p2 = new JPanel();
            f.add(p2);
            GiaoDienChucNang giaoDienChucNang = new GiaoDienChucNang(p2);       
        }
        
        if (e.getSource() == bt2)
            System.exit(0);
    }
    
    
}
