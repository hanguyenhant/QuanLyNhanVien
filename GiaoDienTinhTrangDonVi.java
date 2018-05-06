
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GiaoDienTinhTrangDonVi extends JPanel implements ActionListener{

    JLabel lb;
    JButton bt;
    JTextField tf;
    JTextArea ta;
    JScrollPane sp;
    
    public GiaoDienTinhTrangDonVi() {
        
            super.setSize(600,500);
            super.setLayout(null);
            super.setBackground(Color.WHITE);
            super.setVisible(true);
        
            lb = new JLabel("Hiển thị tình trạng đơn vị");       
            lb.setBounds(170,20,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
            
            lb = new JLabel("-------------------------");       
            lb.setBounds(190,40,400,30);   
            lb.setFont(new Font("Consolas", Font.BOLD, 14));
            lb.setForeground(Color.BLACK);
            super.add(lb);
            
            lb = new JLabel("Danh sách các đơn vị: ");
            lb.setBounds(100,60,200,30);
            super.add(lb);
                                                    
            ta = new JTextArea(350,350);       
            ta.setFont(new Font("Consolas", Font.BOLD, 14));
            
            String s = "";
            int i = 1;
            for(DonVi dv : QuanLy.list)
		{
                    s += i + ", " + dv.getTenDonVi() +"\n";
                    i++;
                }
                       
            ta.setText(s); 
            
            sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            sp.setBounds(100, 90, 350, 200);
            super.add(sp);
                                   
            lb = new JLabel("Chọn đơn vị số: ");
            lb.setBounds(100,310,100,30);
            super.add(lb);
        
            tf = new JTextField(20);
            tf.setBounds(190,310,100,30);
            super.add(tf);
        
            bt = new JButton("Hiển thị");
            bt.setBounds(300,310,100,30);        
            bt.addActionListener(this);
            super.add(bt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt){
            JFrame f = new JFrame("Tinh trang don vi");
            f.setSize(600, 500); 
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
            int donVi = Integer.parseInt(tf.getText());
            
            JPanel p = new TinhTrangDonVi(donVi);
            f.add(p);
        }
    }
    
}
