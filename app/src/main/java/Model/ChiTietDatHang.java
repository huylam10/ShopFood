package Model;

import java.io.Serializable;

public class ChiTietDatHang implements Serializable {
    int id;
    int idDatHang;
    int productid;
    float unitprice;
    float amount;

    public ChiTietDatHang() {
    }

    public ChiTietDatHang(int id, int idDatHang, int productid, float unitprice, float amount) {
        this.id = id;
        this.idDatHang = idDatHang;
        this.productid = productid;
        this.unitprice = unitprice;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDatHang() {
        return idDatHang;
    }

    public void setIdDatHang(int idDatHang) {
        this.idDatHang = idDatHang;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "ChiTietDatHang{" +
                "id=" + id +
                ", idDathang=" + idDatHang +
                ", productid=" + productid +
                ", unitprice=" + unitprice +
                ", amount=" + amount +
                '}';
    }
}
