import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TinhTrangDonVi extends JPanel {
    JLabel lb;
    JTextArea ta;
    JScrollPane sp;
    
    public TinhTrangDonVi(int donVi){
   
        super.setSize(600,500);
        super.setLayout(null);
        super.setBackground(Color.WHITE);
        super.setVisible(true); 

        lb = new JLabel("TÌNH TRẠNG ĐƠN VỊ");
        lb.setBounds(215,30,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 20));
        lb.setForeground(Color.BLACK);
        super.add(lb);
            
        ta = new JTextArea(350,350);       
        ta.setFont(new Font("Consolas", Font.BOLD, 14));
                       
        if (donVi<=QuanLy.soDV)
            ta.setText(QuanLy.thongTinDonVi(QuanLy.list.get(donVi-1))); 
        else ta.setText("Khong ton tai don vi!");
            
        sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBounds(100, 120, 400, 350);
        super.add(sp);

    }

}