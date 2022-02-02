import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;


public class CongTy extends JFrame implements ActionListener {
    private JTextField taikhoan_field;
    private JPasswordField matkhau_field;
    private JPanel login_panel;
    private JButton okButton;
    private JButton cancelButton;
    private JButton exitButton;
    private JLabel matkhauIcon;
    private JLabel taikhoanIcon;
    private JLabel icon_app;
    private JCheckBox showPasswordCheckBox;

    static JFrame frame;
    private String username = "admin"; //Set tài khoản
    private char[] password = {'a','d','m','i','n'}; //Set mật khẩu

    public CongTy(String title){

        this.setTitle("Quản Lý Công Ty");
        this.setSize(500,300);
        this.setLocationRelativeTo(null); //Hiện ra giữa màn hình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ấn X để tắt
        this.setContentPane(login_panel);

        //this.pack();
        okButton.setToolTipText("Ấn để đăng nhập."); //Set gợi ý
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput; //Gọi biến để nhận ký tự rồi so sánh
                char[] passwordInput;

                usernameInput = taikhoan_field.getText();
                passwordInput = matkhau_field.getPassword();

                if((username.equals(usernameInput)) && (Arrays.equals(password, passwordInput))){
                    JOptionPane.showMessageDialog(null, "Bạn đã nhập chuẩn.");

                    menu_panel menu = new menu_panel();
                    menu.setVisible(true);
                    dispose();

                }else{
                    JOptionPane.showMessageDialog(null, "SAI !!!!");
                }
            }
        });
        exitButton.setToolTipText("Ấn để thoát.");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        matkhau_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER){ //Set nút Enter khi nhập mật khẩu xong.
                    String usernameInput;
                    char[] passwordInput;

                    usernameInput = taikhoan_field.getText();
                    passwordInput = matkhau_field.getPassword();

                    if((username.equals(usernameInput)) && (Arrays.equals(password, passwordInput))){
                        JOptionPane.showMessageDialog(null, "Bạn đã nhập chuẩn.");
                        menu_panel menu = new menu_panel();
                        menu.setVisible(true);
                        dispose(); // Ẩn cửa sổ Đăng nhập
                    }else{
                        JOptionPane.showMessageDialog(null, "SAI!!!");
                    }
                }
            }
        });
        cancelButton.setToolTipText("Ấn xoá trường tài khoản mật khẩu.");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taikhoan_field.setText("");
                matkhau_field.setText("");
            }
        }); //Nhấn Cancel thì sẽ xoá text trong khung mật khẩu và tài khoản.
        showPasswordCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(showPasswordCheckBox.isSelected()){
                    matkhau_field.setEchoChar((char)0);
                }else {
                    matkhau_field.setEchoChar('*');
                }
            }
        });//Show password
    }

    public static void main(String[] args) {
        frame = new CongTy("Quản Lý Công Ty 1");
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        icon_app = new JLabel((new ImageIcon("src/icon/icons8-manager-64.png")));
        taikhoanIcon = new JLabel(new ImageIcon("src/icon/icons8-user-30.png"));
        matkhauIcon = new JLabel(new ImageIcon("src/icon/icons8-password-30.png"));
    }
}
