/**
 * Bài của  Đỗ Văn Hải 20207600
 *
 * */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

public class xoa_can_bo extends JFrame{
    private JLabel xoaLabel;
    private JTextField timIDField;
    private JButton resetButton;
    private JButton quaylaiButton;
    private JPanel xoaPanel;
    private JButton xoaButton;
    private JButton timButton;
    boolean check = false;

    public xoa_can_bo() {
        setContentPane(xoaPanel);
        setTitle("Xóa cán bộ");
        setSize(450,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        xoaButton.setEnabled(false);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timIDField.setText("");
            }
        });

        quaylaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new menu_panel();
            }
        });

        timButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = timIDField.getText();
                Customer obj1 = new Customer();
                File checkFile = new File("src/user/"+ID);
                if(checkFile.exists()){
                    check = true;
                    JOptionPane.showMessageDialog(rootPane, "Tồn Tại!");
                    xoaButton.setEnabled(true);
                    xoaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             if(checkFile.delete())
                             {
                                 JOptionPane.showMessageDialog(null, "Xóa thành công");
                             }
                             else
                             {
                                 JOptionPane.showMessageDialog(null,"Xóa thất bại");
                             }

                        }
                    });
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Không Tồn Tại ID: "+ID);
                    xoaButton.setEnabled(false);
                }
            }
        });



    }

    public static void main(String[] args) {
        xoa_can_bo xoa = new xoa_can_bo();
    }
}
