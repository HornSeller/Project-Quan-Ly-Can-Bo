import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer implements Serializable {

    private  String chuc_vu;
    private String ten;
    private String maCanBo;
    private String donVi;
    private double luong;
    private int soNgayLamViec;
    String dateCreated;
    private String ID;

    Customer(){}

    public Customer(Customer object) {
        this.ten = object.ten;
        this.maCanBo = object.maCanBo;
        this.donVi = object.donVi;
        this.luong = object.luong;
        this.soNgayLamViec = object.soNgayLamViec;
        this.dateCreated = object.dateCreated;
    }
    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    void scanCustomer(String year) throws IOException {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

        String fullDate = myDateObj.format(myFormatObj3);

        ID = year + ten.substring(0,2).toUpperCase() + Integer.toString( them_can_bo.customer_count+101);
        System.out.println("Your Account ID: "+ ID);
        System.out.println("Account created on: "+fullDate);

        dateCreated = fullDate;

        File objectFile = new File("src/user/"+ID);
        FileOutputStream fileOutput = new FileOutputStream(objectFile);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        objectOutput.writeObject(this);
        System.out.println("ID: "+this.ID); //Test this


        fileOutput.close();
        objectOutput.close();
    }

    String doiTen(String ten){
        return ten;
    }
    String doiMaCanBo(String ma){
        return ma;
    }
    String doiDonVi(String donvi){
        return donvi;
    }
    double doiSoNgayLamViec_giamDoc(int soNgay){
        return (double) soNgay*1000000;
    }
    double doiSoNgayLamViec_truongPhong(int soNgay){
        return (double) soNgay*500000;
    }
    double doiSoNgayLamViec_nhanVien(int soNgay){
        return (double) soNgay*200000;
    }


}
