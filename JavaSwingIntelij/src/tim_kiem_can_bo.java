/**
 * Bài của Hoàng Hà My 20207644
 *
 * */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;

public class tim_kiem_can_bo extends JFrame{
    private JButton timKiemButton;
    private JPanel timKiemCanBo_panel;
    private JCheckBox maCheckBox;
    private JCheckBox donViCheckBox;
    private JCheckBox tenCheckBox;
    private JCheckBox chucVuCheckBox;
    private JTable table1;
    private JButton thoatButton;
    private JTextField maField;
    private JTextField donViField;
    private JTextField tenField;
    private JScrollPane ID;
    private JComboBox chucVuComboBox;
    private boolean check = false;
    private ArrayList<Customer> list;
    DefaultTableModel model;

    public tim_kiem_can_bo() {
        setTitle("Tìm Kiếm Cán Bộ");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(timKiemCanBo_panel);
        tenField.setEditable(false);
        maField.setEditable(false);
        donViField.setEditable(false);
        chucVuComboBox.setEnabled(false);
        setVisible(true);
        //tạo table
        list = new ArrayList<>();
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "ID","Chức Vụ", "Tên", "Mã", "Đơn Vị", "Số Ngày Làm Việc", "Lương" ,"Ngày Thêm"
        }); //Tạo ra các cột với các tiêu đề
        thoatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        timKiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                try {
                    duyetCanBo();
                    check = false;
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                //timKiemButton.setEnabled(true);
            }
        });
        maCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    maField.setEditable(true);
                    tenField.setText("");
                    donViField.setText("");
                    chucVuComboBox.setSelectedIndex(0);
                }else maField.setEditable(false);
            }
        });
        tenCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    tenField.setEditable(true);
                    maField.setText("");
                    donViField.setText("");
                    chucVuComboBox.setSelectedIndex(0);
                }else tenField.setEditable(false);
            }
        });
        donViCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    donViField.setEditable(true);
                    tenField.setText("");
                    maField.setText("");
                    chucVuComboBox.setSelectedIndex(0);
                }else donViField.setEditable(false);
            }
        });
        chucVuCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    chucVuComboBox.setEnabled(true);
                    donViField.setText("");
                    tenField.setText("");
                    maField.setText("");
                }else chucVuComboBox.setEnabled(false);
            }
        });
    }
    private void duyetCanBo() throws IOException, ClassNotFoundException {
        File objectFile = new File("src/user/");
        if(!objectFile.exists())
        {
            objectFile.mkdir();
        }
        String canBo[] = objectFile.list();
        for (int i = 0; i < canBo.length; i++) {
            kiemTra_in_CanBo(canBo[i]);//duyệt từng đối tượng trong mảng để kiểm tra và in
        }
        if (check == false){
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả! \nHãy tìm kiếm lại!!!", "Tìm Kiếm Lỗi", JOptionPane.INFORMATION_MESSAGE);
//            setVisible(false);
//            new tim_kiem_can_bo();
        }
    }
    int i = 1;
    public void kiemTra_in_CanBo(String identity) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("src/user/" + identity); // Get thư mục user
        ObjectInputStream objectInput = new ObjectInputStream(fileInput); //Khởi tạo đối tượng nhập vào với phương thức "lấy đường dẫn đối tượng"
        Customer newObject = (Customer) objectInput.readObject();
        if(tenCheckBox.isSelected()){
            if(newObject.getTen().equals(tenField.getText())){
                model.addRow(new Object[]{
                        i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
                });
                check = true;
            }
        }
        else if(maCheckBox.isSelected()){
            if(newObject.getMaCanBo().equals(maField.getText())){
                model.addRow(new Object[]{
                        i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
                });
                check = true;
            }
        }
        else if(donViCheckBox.isSelected()){
            if(newObject.getDonVi().equals(donViField.getText())){
                model.addRow(new Object[]{
                        i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
                });
                check = true;
            }
        }
        else if(chucVuCheckBox.isSelected()){
            int index = chucVuComboBox.getSelectedIndex();
            Object text = chucVuComboBox.getItemAt(index);
            if(newObject.getChuc_vu().equals(text)){
                model.addRow(new Object[]{
                        i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
                });
                check = true;
            }
        }
        fileInput.close();
        objectInput.close();
    }

    public static void main(String[] args){
         new tim_kiem_can_bo();
    }
}

