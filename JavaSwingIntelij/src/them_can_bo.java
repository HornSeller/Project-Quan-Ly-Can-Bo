import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class them_can_bo extends JFrame implements ActionListener {
    static int customer_count=0;
    private JPanel themcanbo_panel;
    private JTextField ten_textfield;
    private JComboBox comboBox1;
    private JLabel thaydoi_label;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTable hienthongtin_table1;
    private JButton addButton;
    private JButton exitButton;
    private JTextField textField5;
    private JButton resetButton;
    String ID;

    DefaultTableModel model;

    JFrame themcanbo_frame = new JFrame();

    public them_can_bo(){
        this.setTitle("Thêm Cán Bộ");
        this.setSize(1200,700);
        themcanbo_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(themcanbo_panel); //Thêm panel
        this.showComboBox(); //Set dữ liệu trong ComboBox
        hienthongtin_table1.setModel(new DefaultTableModel(
                null, new String[]{"STT", "ID","Chức Vụ", "Tên", "Mã", "Đơn Vị", "Số Ngày Làm Việc", "Lương" ,"Ngày Thêm"}
        ));
        exitButton.setSize(10,10); //Cài đặt độ dài rộng
        textField5.setEditable(false); //Không cho điền dữ liệu vào bảng
        //this.pack();
        exitButton.addActionListener(e -> this.dispose()); // Đóng cửa sổ windows.
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox1.getSelectedIndex();
//                if (index >= 0){
//                    String selectValue = (String) comboBox1.getItemAt(index);
//                    System.out.println("Gia tri: "+selectValue);
//                }
                if(index == 0 ){
                    thaydoi_label.setText("   Chọn chức vụ đi đã.");
                    thaydoi_label.setVisible(true);
                    textField5.setVisible(true);
                    textField5.setEditable(false);
                }
                if(index == 1 ){
                    thaydoi_label.setVisible(false);
                    textField5.setVisible(false);
                }
                if(index == 2 ){
                    thaydoi_label.setText("   Nhập vào số tiền phụ cấp quản lý");
                    textField5.setEditable(true);
                    thaydoi_label.setVisible(true);
                    textField5.setVisible(true);
                }
                if(index == 3 ){
                    thaydoi_label.setText("   Nhập vào số tiền thưởng theo phòng");
                    textField5.setEditable(true);
                    thaydoi_label.setVisible(true);
                    textField5.setVisible(true);
                }
            }
        }); //Thêm các ActionListener cho Combobox

        final String[] chucvu = new String[1];
        final String[] ten = new String[1];
        final String[] ma = new String[1];
        final String[] donvi = new String[1];
        final int[] soNgayLamViec = new int[1];
        final double[] tienthuong = new double[1];
        final double[] luong = new double[1];
        final double[] thuong = new double[1];
        final int[] i = {0};
        Customer cus = new Customer();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Customer[] objects = new Customer[50];
                objects[customer_count] = new Customer();
                File objectFile = new File("src/user/");
                if(objectFile.exists())
                {
                    objectFile.mkdir();
                }
                String name[] = objectFile.list();
                customer_count= name.length;

                LocalDateTime myDateObject = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E");
                DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd");
                DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("yyyy");

                int date = Integer.parseInt(myDateObject.format(myFormatObj1));
                String day = myDateObject.format(myFormatObj);
                String year = myDateObject.format(myFormatObj2);

                int index = comboBox1.getSelectedIndex();
                if (index == 1) {
                    chucvu[0] = (String) comboBox1.getItemAt(index);
                    System.out.println("Gia tri: " + chucvu[0]);
                    ten[0] = String.valueOf(ten_textfield.getText());
                    ma[0] = String.valueOf(textField2.getText());
                    donvi[0] = String.valueOf(textField3.getText());
                    soNgayLamViec[0] = Integer.parseInt(textField4.getText());
                    luong[0] = Double.valueOf(soNgayLamViec[0] * 1000000);
                }
                if (index == 2) {
                    chucvu[0] = (String) comboBox1.getItemAt(index);
                    System.out.println("Gia tri: " + chucvu[0]);
                    ten[0] = String.valueOf(ten_textfield.getText());
                    ma[0] = String.valueOf(textField2.getText());
                    donvi[0] = String.valueOf(textField3.getText());
                    soNgayLamViec[0] = Integer.parseInt(textField4.getText());
                    thuong[0] = Double.parseDouble(textField5.getText());
                    luong[0] = Double.valueOf(soNgayLamViec[0] * 500000 + thuong[0]);
                }
                if (index == 3) {
                    chucvu[0] = (String) comboBox1.getItemAt(index);
                    System.out.println("Gia tri: " + chucvu[0]);
                    ten[0] = String.valueOf(ten_textfield.getText());
                    ma[0] = String.valueOf(textField2.getText());
                    donvi[0] = String.valueOf(textField3.getText());
                    soNgayLamViec[0] = Integer.parseInt(textField4.getText());
                    thuong[0] = Double.parseDouble(textField5.getText());
                    luong[0] = Double.valueOf(soNgayLamViec[0] * 200000 + thuong[0]);
                }
                cus.setChuc_vu(chucvu[0]);
                cus.setTen(ten[0]);
                cus.setMaCanBo(ma[0]);
                cus.setDonVi(donvi[0]);
                cus.setSoNgayLamViec(soNgayLamViec[0]);
                cus.setLuong(luong[0]);
                try {
                    cus.scanCustomer(year);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                customer_count++;
                System.out.println("Gia tri: " + cus.getID());
                System.out.println("Gia tri: " + cus.getTen());
                System.out.println("Gia tri: " + cus.getMaCanBo());
                System.out.println("Gia tri: " + cus.getDonVi());
                System.out.println("Gia tri: " + cus.getLuong());

                model = (DefaultTableModel) hienthongtin_table1.getModel();
                model.setColumnIdentifiers(new Object[]{
                        "STT", "ID","Chức Vụ", "Tên", "Mã", "Đơn Vị", "Số Ngày Làm Việc", "Lương", "Ngày Thêm"
                });
                model.addRow(new Object[]{
                        i[0]++, cus.getID(), cus.getChuc_vu(), cus.getTen(), cus.getMaCanBo(), cus.getDonVi(), cus.getSoNgayLamViec(), cus.getLuong(),cus.getDateCreated()
                });

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox1.setSelectedIndex(0);
                ten_textfield.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });

    }
    private void showComboBox(){ //Thêm dữ liệu vào combobox
        List<String> data = new ArrayList<String>();
        data.add("Mời chọn:"); //data[0]
        data.add("1. Giám Đốc");
        data.add("2. Trưởng Phòng");
        data.add("3. Nhân Viên");
        for(String s : data){
            comboBox1.addItem(s);
        }
    }
    public static void main(String[] args){
        them_can_bo menu3 = new them_can_bo();
        menu3.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
