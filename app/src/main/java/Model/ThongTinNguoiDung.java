package Model;

import java.io.Serializable;

public class ThongTinNguoiDung implements Serializable {

    int id;
    int idTaiKhoan;
    String fullName;
    String emailNguoiDung;
    String SDTNguoiDung;
    String adressNguoiDung;
    String avatarNguoiDung;
    String birthdayNguoiDung;
    int gender;
    String createdNguoiDung;
    String updatedNguoiDung;

    public ThongTinNguoiDung() {
    }

    public ThongTinNguoiDung(int id, int idTaiKhoan, String fullName, String emailNguoiDung, String SDTNguoiDung, String adressNguoiDung, String avatarNguoiDung, String birthdayNguoiDung, int gender, String createdNguoiDung, String updatedNguoiDung) {
        this.id = id;
        this.idTaiKhoan = idTaiKhoan;
        this.fullName = fullName;
        this.emailNguoiDung = emailNguoiDung;
        this.SDTNguoiDung = SDTNguoiDung;
        this.adressNguoiDung = adressNguoiDung;
        this.avatarNguoiDung = avatarNguoiDung;
        this.birthdayNguoiDung = birthdayNguoiDung;
        this.gender = gender;
        this.createdNguoiDung = createdNguoiDung;
        this.updatedNguoiDung = updatedNguoiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getFullName() {
        return fullName;
    }

    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getSDTNguoiDung() {
        return SDTNguoiDung;
    }

    public void setSDTNguoiDung(String SDTNguoiDung) {
        this.SDTNguoiDung = SDTNguoiDung;
    }

    public String getAdressNguoiDung() {
        return adressNguoiDung;
    }

    public void setAdressNguoiDung(String adressNguoiDung) {
        this.adressNguoiDung = adressNguoiDung;
    }

    public String getAvatarNguoiDung() {
        return avatarNguoiDung;
    }

    public void setAvatarNguoiDung(String avatarNguoiDung) {
        this.avatarNguoiDung = avatarNguoiDung;
    }

    public String getBirthdayNguoiDung() {
        return birthdayNguoiDung;
    }

    public void setBirthdayNguoiDung(String birthdayNguoiDung) {
        this.birthdayNguoiDung = birthdayNguoiDung;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCreatedNguoiDung() {
        return createdNguoiDung;
    }

    public void setCreatedNguoiDung(String createdNguoiDung) {
        this.createdNguoiDung = createdNguoiDung;
    }

    public String getUpdatedNguoiDung() {
        return updatedNguoiDung;
    }

    public void setUpdatedNguoiDung(String updatedNguoiDung) {
        this.updatedNguoiDung = updatedNguoiDung;
    }

    @Override
    public String toString(){
        return "ThongTinNguoiDung{" +
                "id=" + id +
                ", idtaikhoan=" + idTaiKhoan +
                ", fullname='" + fullName + '\'' +
                ", emailNguoidung='" + emailNguoiDung + '\'' +
                ", sdtNguoidung='" + SDTNguoiDung + '\'' +
                ", addresNguoidung='" + adressNguoiDung + '\'' +
                ", avatarNguoidung='" + avatarNguoiDung + '\'' +
                ", birthdayNguoidung='" + birthdayNguoiDung + '\'' +
                ", gender=" + gender +
                ", createNguoidung='" + createdNguoiDung + '\'' +
                ", updateNguoidung='" + updatedNguoiDung + '\'' +
                '}';
    }
}
