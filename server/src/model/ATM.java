package model;

public class ATM {
    private int id;
    private String description;
    private String address;
    private float lat,longg;
    private String status;
    private float total_money;
    private int manage_by;
    private int province_id;
    private String province_name;

    public ATM(int id, String description, String address, float lat, float longg, String status, float total_money, int manage_by, int province_id, String province_name) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.lat = lat;
        this.longg = longg;
        this.status = status;
        this.total_money = total_money;
        this.manage_by = manage_by;
        this.province_id = province_id;
        this.province_name = province_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLongg() {
        return longg;
    }

    public void setLongg(float longg) {
        this.longg = longg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public int getManage_by() {
        return manage_by;
    }

    public void setManage_by(int manage_by) {
        this.manage_by = manage_by;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }
}
