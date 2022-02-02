import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class sua_can_bo extends JFrame{
    private JPanel suaCanBo_panel;
    private JTextField IDtext;
    private JButton resetButton;
    private JButton luuButton;
    private JTextField tenText;
    private JTextField maText;
    private JTextField donviText;
    private JTextField soNgayLamText;
    private JCheckBox tenCheckBox;
    private JCheckBox donViCheckBox;
    private JCheckBox maCheckBox;
    private JCheckBox soNgayLamCheckBox;
    private JButton timKiemButton;
    private JLabel tenLabel;
    private JLabel maLabel;
    private JLabel donViLabel;
    private JLabel songaylamLabel;
    boolean check = false;
    sua_can_bo(){
        this.setTitle("Sua Thong Tin Can Bo");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(suaCanBo_panel);

        tenText.setEditable(false);
        maText.setEditable(false);
        donviText.setEditable(false);
        soNgayLamText.setEditable(false);

        timKiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDtext.getText();
                Customer obj1 = new Customer();
                File checkFile = new File("src/user/"+ID);
                if(checkFile.exists()){
                    check = true;
                    JOptionPane.showMessageDialog(rootPane, "Tồn Tại!");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Không Tồn Tại ID: "+ID);
                }
            }
        });
        tenCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    tenText.setEditable(true);
                }else tenText.setEditable(false);
            }
        });
        maCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    maText.setEditable(true);
                }else maText.setEditable(false);
            }
        });
        donViCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    donviText.setEditable(true);
                }else donviText.setEditable(false);
            }
        });
        soNgayLamCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    soNgayLamText.setEditable(true);
                }else soNgayLamText.setEditable(false);
            }
        });

        luuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDtext.getText();
                Customer obj1 = new Customer();
                File checkFile = new File("src/user/"+ID);
                if(checkFile.exists()){
                    check = true;
                }else JOptionPane.showMessageDialog(rootPane, "Khong Tim Thay ID", "Error", JOptionPane.INFORMATION_MESSAGE);

                if(check) {
                    FileInputStream fileInput = null;
                    try {
                        fileInput = new FileInputStream("src/user/" + ID);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    ObjectInputStream objectInput = null;
                    try {
                        objectInput = new ObjectInputStream(fileInput);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Customer newObject = null;
                    try {
                        newObject = (Customer) objectInput.readObject();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("Tên cũ: "+newObject.getTen());
                    if(tenCheckBox.isSelected()) {
                        newObject.setTen(obj1.doiTen(tenText.getText()));
                    }
                    if(maCheckBox.isSelected()){
                        newObject.setMaCanBo(obj1.doiMaCanBo(maText.getText()));
                    }
                    if(donViCheckBox.isSelected()){
                        newObject.setDonVi(obj1.doiDonVi(donviText.getText()));
                    }
                    if(soNgayLamCheckBox.isSelected()){
                        int so_ngay = Integer.parseInt(soNgayLamText.getText());
                        if(newObject.getChuc_vu().equals("1. Giám Đốc")){
                            newObject.setLuong(obj1.doiSoNgayLamViec_giamDoc(so_ngay));
                        }
                        if(newObject.getChuc_vu().equals("2. Trưởng Phòng")){
                            double thuong = Double.parseDouble(JOptionPane.showInputDialog("Chức vụ của ID là Trưởng Phòng nên mời bạn nhập lại tiền thưởng:"));
                            newObject.setLuong(thuong + obj1.doiSoNgayLamViec_truongPhong(so_ngay));
                            JOptionPane.showMessageDialog(rootPane,"Đã xong!");
                        }
                        if(newObject.getChuc_vu().equals("3. Nhân Viên")){
                            double thuong = Double.parseDouble(JOptionPane.showInputDialog("Chức vụ của ID là Nhân Viên nên mời bạn nhập lại tiền thưởng:"));
                            newObject.setLuong(thuong + obj1.doiSoNgayLamViec_nhanVien(so_ngay));
                            JOptionPane.showMessageDialog(rootPane,"Đã xong!");
                        }
                    }
                    obj1 = newObject;
                    try {
                        fileInput.close();
                        objectInput.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    File objFile = new File("src/user/" + ID);
                    FileOutputStream fileOutput = null;
                    try {
                        fileOutput = new FileOutputStream(objFile);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    ObjectOutputStream objOutput = null;
                    try {
                        objOutput = new ObjectOutputStream(fileOutput);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        objOutput.writeObject(obj1);
                        System.out.println("Tên mới: "+obj1.getTen());
                        fileOutput.close();
                        objOutput.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
    }

    public static void main(String[] args) {
        sua_can_bo sua = new sua_can_bo();
        sua.setVisible(true);
    }
}
