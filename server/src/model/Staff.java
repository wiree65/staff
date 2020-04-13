package model;

public class Staff {
    int id;
    String username;
    String password;
    String name;
    String lastname;
    String email;
    String tel;
    String date_of_birth;
    int department; //dont want
    String address;
    String date_of_employed;
    String date_of_fired;
    float salary;
    int branch;
    String nickname;
    String citizen_id;
    String sex;

    public Staff(int id, String username, String password, String name, String lastname, String email, String tel, String date_of_birth, int department, String address, String date_of_employed, String date_of_fired, float salary, int branch,String nickname, String citizen_id, String sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.tel = tel;
        this.date_of_birth = date_of_birth;
        this.department = department;
        this.address = address;
        this.date_of_employed = date_of_employed;
        this.date_of_fired = date_of_fired;
        this.salary = salary;
        this.branch = branch;
        this.citizen_id = citizen_id;
        this.nickname = nickname;
        this.sex = sex;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDate_of_fired() {
        return date_of_fired;
    }

    public void setDate_of_fired(String date_of_fired) {
        this.date_of_fired = date_of_fired;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
