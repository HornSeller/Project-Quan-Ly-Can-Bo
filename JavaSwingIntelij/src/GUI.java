//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.*;
//
//public class GUI extends JFrame implements ActionListener {
//    private JFrame frame;
//    private JPanel dangnhap_panel;
//    private JButton okButton;
//    private JButton cancelButton;
//    private JButton exitButton;
//    private JLabel title_label, statusLabel;
//    private JTextField taikhoan_textField;
//    private JPasswordField matkhau_textField;
//
//
//    public GUI() {
//        buildPanel();
//    }
//    public static void main(String[] args) {
//        GUI gui1 = new GUI();
//        gui1.showTextField();
//    }
//
//    private void buildPanel() {
//        frame = new JFrame("Quản Lý Cán Bộ");
//        frame.setSize(300, 400);
//        frame.setLocationRelativeTo(null); // hien thi ra giua man hinh
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new GridLayout(3,1));
//
//        //Tạo tiêu đề cho Panel
//        title_label = new JLabel("", JLabel.CENTER);
//        title_label.setSize(350,100);
//
//        statusLabel = new JLabel("", JLabel.CENTER);
//        statusLabel.setSize(350,100);
//
//        //Tạo đăng nhập panel
//        dangnhap_panel = new JPanel();
//        dangnhap_panel.setLayout(new GridLayout(3,1));
//
//        //Thêm các phần vào Frame
//        //frame.add(title_label);
//        frame.add(statusLabel);
//        frame.add(dangnhap_panel);
//        //frame.add(statusLabel);
//
//        frame.setVisible(true);
//
//        // TODO: place custom component creation code here
//
//
////        taikhoan_label = new JLabel("Tai Khoan:", JLabel.CENTER);
////        taikhoan_textField = new JTextField(30);
////
////        matkhau_label = new JLabel("Mat Khau:", JLabel.CENTER);
////        matkhau_textField = new JPasswordField(30);
////
////        okButton = new JButton("OK");
////        exitButton = new JButton("Exit");
////        cancelButton = new JButton("Cancel");
////
////        dangnhap_panel = new JPanel();
////        dangnhap_panel.add(title_label);
////        dangnhap_panel.add(taikhoan_label);
////        dangnhap_panel.add(taikhoan_textField);
////
////        dangnhap_panel.add(matkhau_label);
////        dangnhap_panel.add(matkhau_textField);
////
////        dangnhap_panel.add(okButton);
////        okButton.setActionCommand("ok");
////        okButton.addActionListener(this);
////
////        dangnhap_panel.add(cancelButton);
////        cancelButton.setSize(20,20);
////        cancelButton.setActionCommand("cancel");
////        cancelButton.addActionListener(this);
////
////        dangnhap_panel.add(exitButton);
////        exitButton.setSize(20,20);
////        exitButton.setActionCommand("exit");
////        exitButton.addActionListener(this);
//    }
//    //Tạo hàm để hiện các thành phần.
//    private void showTextField(){
//        //title_label.setText("");
//        statusLabel.setText("Quản Lý Nhân Viên");
//
//        //Thêm các Label
//        JLabel taikhoan_label = new JLabel("Tài Khoản: ", JLabel.CENTER);
//        //taikhoan_textField.add(BorderLayout.WEST);
//        JLabel matkhau_label = new JLabel("Mật Khẩu: ", JLabel.CENTER);
//
//        //Thêm các TextField
//        final JTextField taikhoan_textField = new JTextField(10);
//        taikhoan_textField.setSize(10,5);
//        final JPasswordField matkhau_textField = new JPasswordField(10);
//
//        //Thêm Button
//        JButton okButton = new JButton("OK");
//        okButton.setActionCommand("ok");
//        //okButton.setLocation(JButton.RIGHT);
//
//
//        //Thêm các thành phần vào dangnhap_panel
//
//        dangnhap_panel.add(taikhoan_label);
//        dangnhap_panel.add(taikhoan_textField);
//        dangnhap_panel.add(matkhau_label);
//        dangnhap_panel.add(matkhau_textField);
//        frame.add(okButton, BorderLayout.LINE_END);
//        frame.setVisible(true);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if("ok".equals(e.getActionCommand())){
//            JOptionPane.showMessageDialog(rootPane, "cutmemaydi");
//        }else {
//            JOptionPane.showMessageDialog(rootPane,"????");
//        }
//    }
//}
//
