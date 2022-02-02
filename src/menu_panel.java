import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class menu_panel extends JFrame implements ActionListener {
    private JButton sua_button2;
    private JButton xoa_button3;
    private JButton timkiem_button4;
    private JButton button5;
    private JButton indanhsach_button6;
    private JButton thoat_button;
    private JButton them_button1;
    private JPanel menu_panel;

    static JFrame menu_frame = new JFrame();

    public menu_panel() {
        this.setTitle("MENU PANEL");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(menu_panel);
        this.pack();

        them_button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                them_can_bo menu2 = new them_can_bo();
                menu2.setVisible(true);
            }
        }); //Set sự kiện cho button 1.Thêm Cán Bộ
        thoat_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); //Thoát cả chương trình.
        indanhsach_button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in_danh_sach in = null;
                try {
                    in = new in_danh_sach();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                in.setVisible(true);
            }
        });
        sua_button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sua_can_bo sua = new sua_can_bo();
                sua.setVisible(true);
            }
        });
        xoa_button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoa_can_bo xoa = new xoa_can_bo();
                xoa.setVisible(true);
            }
        });
        timkiem_button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tim_kiem_can_bo timkiem1 = new tim_kiem_can_bo();
                timkiem1.setVisible(true);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tim_kiem_theo_luong timkiem2 = null;
                try {
                    timkiem2 = new tim_kiem_theo_luong();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                timkiem2.setVisible(true);
            }
        });
    }

    private void build_panel() {
        //menu_frame.setTitle("MENU PANEL");

    }

    public static void main(String[] args){
        menu_panel menu1 = new menu_panel();
        menu1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

