import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class in_danh_sach extends JFrame {
    JFrame f;
    private JTable table1;
    private JPanel in_danh_sach_Panel;
    private JButton exitButton;
    private ArrayList<Customer> list;
    DefaultTableModel model;
    private String[][] data ={};

    /**Constructor */
    in_danh_sach() throws IOException, ClassNotFoundException {
        this.setTitle("Thêm Cán Bộ"); // set tiêu đề của cửa sổ
        this.setSize(1200,700); //set tỉ lệ khung hình
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Ấn X để ẩn cửa sổ
        this.setContentPane(in_danh_sach_Panel); //Thêm panel

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        list = new ArrayList<>(); //khởi tạo một list mảng
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "ID","Chức Vụ", "Tên", "Mã", "Đơn Vị", "Số Ngày Làm Việc", "Lương" ,"Ngày Thêm"
        }); //Tạo ra các cột với các tiêu đề

        Customer[] objects = new Customer[50]; //Khởi tạo một mảng các đối tượng giới hạn là 50, nhưng mỗi lần chạy không đùng hết 50 :D
        objects[them_can_bo.customer_count] = new Customer(); // ví dự them_can_bo.customer_count=5, thì sẽ là khởi tạo đối tượng object[5] là đối tượng thứ 6.
        File objectFile = new File("src/user/"); //Gọi phương thức File để lấy đường dẫn.
        if(!objectFile.exists()) //nếu thư mục user không tồn tại thì
        {
            objectFile.mkdir(); //tạo thư mục user
        }
        String name[] = objectFile.list(); //khởi tạo mảng name với 5 phần tử (nếu objectFile.list() = 4);
        for (int i = 0; i < name.length; i++) {
            showResult(name[i]);//duyệt từng đối tượng trong mảng.
        }

    }

    /**Tạo hàm hiện kết quả sau khi đọc file */
    int i = 1;
    public void showResult(String identity) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("src/user/"+identity); // Get thư mục user
        ObjectInputStream objectInput = new ObjectInputStream(fileInput); //Khởi tạo đối tượng nhập vào với phương thức "lấy đường dẫn đối tượng"
        Customer newObject = (Customer) objectInput.readObject();

        model.addRow(new Object[]{
              i++, newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi(), newObject.getSoNgayLamViec(), newObject.getLuong(),newObject.getDateCreated()
        });
        //System.out.printf("%10s  |%10s  |%15s    |  %20s   |  %10s  \n", newObject.getID(), newObject.getChuc_vu(), newObject.getTen(), newObject.getMaCanBo(), newObject.getDonVi());
        fileInput.close();
        objectInput.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        in_danh_sach table = new in_danh_sach();
        table.setVisible(true);
    }


}

