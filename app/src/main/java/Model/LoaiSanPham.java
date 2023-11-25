package Model;

import java.io.Serializable;

public class LoaiSanPham implements Serializable {
    int id;
    int idCuahang;
    String nameLoaiSanPham;
    String imageLoaiSanPham;
    String createdLoaiSanPham;
    String updatedLoaiSanPham;
    int statusLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int id, int idCuahang, String nameLoaiSanPham, String imageLoaiSanPham, String createdLoaiSanPham, String updatedLoaiSanPham, int statusLoaiSanPham) {
        this.id = id;
        this.idCuahang = idCuahang;
        this.nameLoaiSanPham = nameLoaiSanPham;
        this.imageLoaiSanPham = imageLoaiSanPham;
        this.createdLoaiSanPham = createdLoaiSanPham;
        this.updatedLoaiSanPham = updatedLoaiSanPham;
        this.statusLoaiSanPham = statusLoaiSanPham;
    }

    public LoaiSanPham(String nameLoaiSanPham, String imageLoaiSanPham, String createdLoaiSanPham) {
        this.nameLoaiSanPham = nameLoaiSanPham;
        this.imageLoaiSanPham = imageLoaiSanPham;
        this.createdLoaiSanPham = createdLoaiSanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuahang() {
        return idCuahang;
    }

    public void setIdCuahang(int idCuahang) {
        this.idCuahang = idCuahang;
    }

    public String getNameLoaiSanPham() {
        return nameLoaiSanPham;
    }

    public void setNameLoaiSanPham(String nameLoaiSanPham) {
        this.nameLoaiSanPham = nameLoaiSanPham;
    }

    public String getImageLoaiSanPham() {
        return imageLoaiSanPham;
    }

    public void setImageLoaiSanPham(String imageLoaiSanPham) {
        this.imageLoaiSanPham = imageLoaiSanPham;
    }

    public String getCreatedLoaiSanPham() {
        return createdLoaiSanPham;
    }

    public void setCreatedLoaiSanPham(String createdLoaiSanPham) {
        this.createdLoaiSanPham = createdLoaiSanPham;
    }

    public String getUpdatedLoaiSanPham() {
        return updatedLoaiSanPham;
    }

    public void setUpdatedLoaiSanPham(String updatedLoaiSanPham) {
        this.updatedLoaiSanPham = updatedLoaiSanPham;
    }

    public int getStatusLoaiSanPham() {
        return statusLoaiSanPham;
    }

    public void setStatusLoaiSanPham(int statusLoaiSanPham) {
        this.statusLoaiSanPham = statusLoaiSanPham;
    }
    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "id=" + id +
                ", idCuahang=" + idCuahang +
                ", nameLoaisanpham='" + nameLoaiSanPham + '\'' +
                ", imgLoaisanpham='" + imageLoaiSanPham + '\'' +
                ", createLoaisanpham='" + createdLoaiSanPham + '\'' +
                ", updatedLoaisanpham='" + updatedLoaiSanPham + '\'' +
                ", statusLoaisanpham=" + statusLoaiSanPham +
                '}';
    }
}
