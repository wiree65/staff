package model;

public class RequestFrom {
int staff_id;
String topic;
String description;
String from_date;
String to_date;
String send_date;
String attach_file;
String return_date;
String comment;
String firstname;
String lastname;
String email;
String phone;
int department;
int branch;
String status;

    public RequestFrom(int staff_id, String topic, String description, String from_date, String to_date, String send_date, String attach_file, String return_date, String comment, String firstname, String lastname, String email, String phone, int department, int branch, String status) {
        this.staff_id = staff_id;
        this.topic = topic;
        this.description = description;
        this.from_date = from_date;
        this.to_date = to_date;
        this.send_date = send_date;
        this.attach_file = attach_file;
        this.return_date = return_date;
        this.comment = comment;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.branch = branch;
        this.status = status;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getFrom_date() {
        return from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public String getSend_date() {
        return send_date;
    }

    public String getAttach_file() {
        return attach_file;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getComment() {
        return comment;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getDepartment() {
        return department;
    }

    public int getBranch() {
        return branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }

    public void setAttach_file(String attach_file) {
        this.attach_file = attach_file;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
