package Model;

import java.io.Serializable;

public class DatHang implements Serializable {
    int id;
    int idtaikhoanDatHang;
    float totalpriceDatHang;
    String createdDatHang;
    String updatedDatHang;
    int statusDatHang;

    public DatHang() {
    }

    public DatHang(int id, int idtaikhoanDatHang, float totalpriceDatHang, String createdDatHang, String updatedDatHang, int statusDatHang) {
        this.id = id;
        this.idtaikhoanDatHang = idtaikhoanDatHang;
        this.totalpriceDatHang = totalpriceDatHang;
        this.createdDatHang = createdDatHang;
        this.updatedDatHang = updatedDatHang;
        this.statusDatHang = statusDatHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtaikhoanDatHang() {
        return idtaikhoanDatHang;
    }

    public void setIdtaikhoanDatHang(int idtaikhoanDatHang) {
        this.idtaikhoanDatHang = idtaikhoanDatHang;
    }

    public float getTotalpriceDatHang() {
        return totalpriceDatHang;
    }

    public void setTotalpriceDatHang(float totalpriceDatHang) {
        this.totalpriceDatHang = totalpriceDatHang;
    }

    public String getCreatedDatHang() {
        return createdDatHang;
    }

    public void setCreatedDatHang(String createdDatHang) {
        this.createdDatHang = createdDatHang;
    }

    public String getUpdatedDatHang() {
        return updatedDatHang;
    }

    public void setUpdatedDatHang(String updatedDatHang) {
        this.updatedDatHang = updatedDatHang;
    }

    public int getStatusDatHang() {
        return statusDatHang;
    }

    public void setStatusDatHang(int statusDatHang) {
        this.statusDatHang = statusDatHang;
    }

    @Override
    public String toString() {
        return "DatHang{" +
                "id=" + id +
                ", idtaikhoan=" + idtaikhoanDatHang +
                ", totalpriceDathang=" + totalpriceDatHang +
                ", createDathang='" + createdDatHang + '\'' +
                ", updateDathang='" + updatedDatHang + '\'' +
                ", statusDathang=" + statusDatHang +
                '}';
    }
}
