package Model;

import java.io.Serializable;

public class VaiTro {

    int id;
    String nameVaiTro;
    String descriptionVaiTro;
    String createdVaiTro;
    String updatedVaiTro;

    public VaiTro() {
    }

    public VaiTro(int id, String nameVaiTro, String descriptionVaiTro, String createdVaiTro, String updatedVaiTro) {
        this.id = id;
        this.nameVaiTro = nameVaiTro;
        this.descriptionVaiTro = descriptionVaiTro;
        this.createdVaiTro = createdVaiTro;
        this.updatedVaiTro = updatedVaiTro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVaiTro() {
        return nameVaiTro;
    }

    public void setNameVaiTro(String nameVaiTro) {
        this.nameVaiTro = nameVaiTro;
    }

    public String getDescriptionVaiTro() {
        return descriptionVaiTro;
    }

    public void setDescriptionVaiTro(String descriptionVaiTro) {
        this.descriptionVaiTro = descriptionVaiTro;
    }

    public String getCreatedVaiTro() {
        return createdVaiTro;
    }

    public void setCreatedVaiTro(String createdVaiTro) {
        this.createdVaiTro = createdVaiTro;
    }

    public String getUpdatedVaiTro() {
        return updatedVaiTro;
    }

    public void setUpdatedVaiTro(String updatedVaiTro) {
        this.updatedVaiTro = updatedVaiTro;
    }
}
