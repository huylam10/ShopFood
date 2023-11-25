package Model;

import java.io.Serializable;

public class CuaHang {

    int id;
    String nameCuaHang;
    String imgCuaHang;
    String phoneCuaHang;
    String emailCuaHang;
    String adressCuaHang;
    String createdCuaHang;
    String updatedCuaHang;
    int statusCuaHang;

    public CuaHang() {
    }

    public CuaHang(int id, String nameCuaHang, String imgCuaHang, String phoneCuaHang, String emailCuaHang, String adressCuaHang, String createdCuaHang, String updatedCuaHang, int statusCuaHang) {
        this.id = id;
        this.nameCuaHang = nameCuaHang;
        this.imgCuaHang = imgCuaHang;
        this.phoneCuaHang = phoneCuaHang;
        this.emailCuaHang = emailCuaHang;
        this.adressCuaHang = adressCuaHang;
        this.createdCuaHang = createdCuaHang;
        this.updatedCuaHang = updatedCuaHang;
        this.statusCuaHang = statusCuaHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCuaHang() {
        return nameCuaHang;
    }

    public void setNameCuaHang(String nameCuaHang) {
        this.nameCuaHang = nameCuaHang;
    }

    public String getImgCuaHang() {
        return imgCuaHang;
    }

    public void setImgCuaHang(String imgCuaHang) {
        this.imgCuaHang = imgCuaHang;
    }

    public String getPhoneCuaHang() {
        return phoneCuaHang;
    }

    public void setPhoneCuaHang(String phoneCuaHang) {
        this.phoneCuaHang = phoneCuaHang;
    }

    public String getEmailCuaHang() {
        return emailCuaHang;
    }

    public void setEmailCuaHang(String emailCuaHang) {
        this.emailCuaHang = emailCuaHang;
    }

    public String getAdressCuaHang() {
        return adressCuaHang;
    }

    public void setAdressCuaHang(String adressCuaHang) {
        this.adressCuaHang = adressCuaHang;
    }

    public String getCreatedCuaHang() {
        return createdCuaHang;
    }

    public void setCreatedCuaHang(String createdCuaHang) {
        this.createdCuaHang = createdCuaHang;
    }

    public String getUpdatedCuaHang() {
        return updatedCuaHang;
    }

    public void setUpdatedCuaHang(String updatedCuaHang) {
        this.updatedCuaHang = updatedCuaHang;
    }

    public int getStatusCuaHang() {
        return statusCuaHang;
    }

    public void setStatusCuaHang(int statusCuaHang) {
        this.statusCuaHang = statusCuaHang;
    }
}
