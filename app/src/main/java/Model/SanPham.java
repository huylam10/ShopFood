package Model;

import java.io.Serializable;

public class SanPham implements Serializable {
    int id, maLoaiSanPham;
    String nameSanPham;
    String imageSanPham;
    int priceSanPham;
    String loaiSanPham;
    String createdSanPham;
    String updatedSanPham;
    int statusSanPham;

    public SanPham() {
    }

    public SanPham(int id, String nameSanPham, String imageSanPham, int priceSanPham, String loaiSanPham, String createdSanPham, String updatedSanPham, int statusSanPham) {
        this.id = id;
        this.nameSanPham = nameSanPham;
        this.imageSanPham = imageSanPham;
        this.priceSanPham = priceSanPham;
        this.loaiSanPham = loaiSanPham;
        this.createdSanPham = createdSanPham;
        this.updatedSanPham = updatedSanPham;
        this.statusSanPham = statusSanPham;
    }

    public SanPham(String nameSanPham, String imageSanPham, int priceSanPham, String loaiSanPham, String createdSanPham) {
        this.nameSanPham = nameSanPham;
        this.imageSanPham = imageSanPham;
        this.priceSanPham = priceSanPham;
        this.loaiSanPham = loaiSanPham;
        this.createdSanPham = createdSanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSanPham() {
        return nameSanPham;
    }

    public void setNameSanPham(String nameSanPham) {
        this.nameSanPham = nameSanPham;
    }

    public String getImageSanPham() {
        return imageSanPham;
    }

    public void setImageSanPham(String imageSanPham) {
        this.imageSanPham = imageSanPham;
    }

    public int getPriceSanPham() {
        return priceSanPham;
    }

    public void setPriceSanPham(int priceSanPham) {
        this.priceSanPham = priceSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getCreatedSanPham() {
        return createdSanPham;
    }

    public void setCreatedSanPham(String createdSanPham) {
        this.createdSanPham = createdSanPham;
    }

    public String getUpdatedSanPham() {
        return updatedSanPham;
    }

    public void setUpdatedSanPham(String updatedSanPham) {
        this.updatedSanPham = updatedSanPham;
    }

    public int getStatusSanPham() {
        return statusSanPham;
    }

    public void setStatusSanPham(int statusSanPham) {
        this.statusSanPham = statusSanPham;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", nameSanpham='" + nameSanPham + '\'' +
                ", imgSanpham='" + imageSanPham + '\'' +
                ", priceSanpham=" + priceSanPham +
                ", loaiSanpham='" + loaiSanPham + '\'' +
                ", createSanpham='" + createdSanPham + '\'' +
                ", updatedSanpham='" + updatedSanPham + '\'' +
                ", statusSanpham=" + statusSanPham +
                '}';
    }
}
