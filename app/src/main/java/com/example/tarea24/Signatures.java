package com.example.tarea24;

public class Signatures {

    private Integer id;
    private byte[] image;
    private String description;

    public Signatures(){}
    public Signatures(Integer id, byte[] image, String descripcion) {
        this.id = id;
        this.image = image;
        this.description = descripcion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
