
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TimKiemMaSo extends JPanel implements ActionListener{
    JLabel lb;
    JTextArea ta;
    JScrollPane sp;
    JTextField tf;
    JButton bt;
    
    public TimKiemMaSo(){
   
        super.setSize(600,500);
        super.setLayout(null);
        super.setBackground(Color.WHITE);
        super.setVisible(true); 

        lb = new JLabel("TÌM KIẾM THEO MÃ SỐ");
        lb.setBounds(215,30,400,30);   
        lb.setFont(new Font("Consolas", Font.BOLD, 20));
        lb.setForeground(Color.BLACK);
        super.add(lb);
        
        lb = new JLabel("Nhập MSNV: ");
        lb.setBounds(100,80,100,30);
        super.add(lb);
        
        tf = new JTextField(20);
        tf.setBounds(190,80,100,30);
        super.add(tf);
        
        bt = new JButton("Hiển thị");
        bt.setBounds(300,80,100,30);        
        bt.addActionListener(this);
        super.add(bt);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt){
            
            String s = tf.getText();      
            
            ta = new JTextArea(350,350);       
            ta.setFont(new Font("Consolas", Font.BOLD, 14));
            ta.setText(QuanLy.timKiemTheoMSNV(s)); 
            
            sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            sp.setBounds(100, 120, 400, 350);
            super.add(sp);
            
        }
    }
}
