package model;


public class StaffInfo {
    int id;
    String username;
    String name;
    String lastname;
    String email;
    String tel;
    String date_of_birth;
    String department;
    String branch;
    String address;
    String date_of_employed;
    String salary;
    String created_at;
    String update_at;
    String citizen_id;
    String sex;
    String nickname;
    String profile_image;

    public StaffInfo(int id, String username, String name, String lastname, String email, String tel, String date_of_birth, String department, String branch, String address, String date_of_employed, String salary, String created_at, String update_at, String citizen_id, String sex, String nickname, String profile_image) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.tel = tel;
        this.date_of_birth = date_of_birth;
        this.department = department;
        this.branch = branch;
        this.address = address;
        this.date_of_employed = date_of_employed;
        this.salary = salary;
        this.created_at = created_at;
        this.update_at = update_at;
        this.citizen_id = citizen_id;
        this.sex = sex;
        this.nickname = nickname;
        this.profile_image = profile_image;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_employed() {
        return date_of_employed;
    }

    public void setDate_of_employed(String date_of_employed) {
        this.date_of_employed = date_of_employed;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(String citizen_id) {
        this.citizen_id = citizen_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

