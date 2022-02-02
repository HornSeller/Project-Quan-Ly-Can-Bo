/**
 * Bài của  Minh Đức 20207592
 *
 * */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class tim_kiem_theo_luong extends JFrame {
    private JTextField nhapSoTienBatKy;
    private JTable inDanhSachCanBo;
    private JPanel panelTimKiemTheoLuong;
    private JButton OKButton;
    private JButton EXITButton;
    private ArrayList<Customer> list;
    DefaultTableModel model;

    public tim_kiem_theo_luong() throws IOException, ClassNotFoundException {
        this.setTitle("Tim kiem can bo co luong lon hon so tien nhap vao");
        this.setSize(1200, 700);
        this.setContentPane(panelTimKiemTheoLuong);
        this.setVisible(true);
        list = new ArrayList<>(); //khởi tạo một list mảng
        model = (DefaultTableModel) inDanhSachCanBo.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "ID","Chuc Vu", "Tên", "Mã", "Đơn Vị", "Số Ngày Làm Việc", "Lương" ,"Ngày Thêm"
        }); //Tạo ra các cột với các tiêu đề
        EXITButton.addActionListener(e -> this.dispose());
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer[] objects = new Customer[50]; //Khởi tạo một mảng các đối tượng giới hạn là 50, nhưng mỗi lần chạy không đùng hết 50 :D
                objects[them_can_bo.customer_count] = new Customer(); // ví dự them_can_bo.customer_count=5, thì sẽ là khởi tạo đối tượng object[5] là đối tượng thứ 6.
                File objectFile = new File("src/user/"); //Gọi phương thức File để lấy đường dẫn.
                if(!objectFile.exists()) //nếu thư mục user không tồn tại thì
                {
                    objectFile.mkdir(); //tạo thư mục user
                }
                String name[] = objectFile.list(); //khởi tạo mảng name với 5 phần tử nếu objectFile.list() = 4;
                    try {
                        renewTable();
                        for(int i = 0; i < name.length; i++) {
                            FindUser(name[i]);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

            }
        });
    }
    int i = 1;
    public void FindUser(String identity) throws IOException, ClassNotFoundException{
        FileInputStream fileInput = new FileInputStream("src/user/" + identity); // Get thư mục user
        ObjectInputStream objectInput = new ObjectInputStream(fileInput); //Khởi tạo đối tượng nhập vào với phương thức "lấy đường dẫn đối tượng"
        Customer newObject = (Customer) objectInput.readObject();
        if(newObject.getLuong() > Double.parseDouble(nhapSoTienBatKy.getText())){
            model.addRow(new Object[]{
                    i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
            });
        }

        fileInput.close();
        objectInput.close();
    }
    public void renewTable(){
        model = (DefaultTableModel) inDanhSachCanBo.getModel();
        model.setRowCount(0);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        tim_kiem_theo_luong Menu = new tim_kiem_theo_luong();
        Menu.setVisible(true);
    }
}
