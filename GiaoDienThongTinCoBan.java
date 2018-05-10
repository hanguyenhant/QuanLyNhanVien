
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GiaoDienThongTinCoBan extends JPanel{
    
    JLabel lb;
    JTextArea ta;
    JScrollPane sp;
    
    public GiaoDienThongTinCoBan(){
        
        super.setSize(600,500);
        super.setLayout(null);
        super.setBackground(Color.WHITE);
        super.setVisible(true); 

        lb = new JLabel("THÔNG TIN CƠ BẢN");
        lb.setBounds(215,30,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 20));
        lb.setForeground(Color.BLACK);
        super.add(lb);
        
        ta = new JTextArea(350,400);       
        ta.setFont(new Font("Consolas", Font.BOLD, 14));
        ta.setText(QuanLy.thongTinCoBan());      
        
        sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBounds(130, 80, 350, 370);
        super.add(sp);
   
    }
}
