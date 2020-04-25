package model;

public class RequestForm {
    int staff_id;
    String name;
    String lastname;
    String tel;
    String email;
    String department;
    String branch;
    int form_no;
    String topic;
    String description;
    String from_date;
    String to_date;
    String send_date;
    String attach_file;
    String comment;
    String status;
    String return_date;
    String send_to;




    public RequestForm(int staff_id, String name, String lastname, String tel, String email, String department, String branch, int form_no, String topic, String description, String from_date, String to_date, String send_date, String attach_file, String comment, String status, String return_date,String send_to) {
        this.staff_id = staff_id;
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.department = department;
        this.branch = branch;
        this.form_no = form_no;
        this.topic = topic;
        this.description = description;
        this.from_date = from_date;
        this.to_date = to_date;
        this.send_date = send_date;
        this.attach_file = attach_file;
        this.comment = comment;
        this.status = status;
        this.return_date = return_date;
        this.send_to = send_to;
    }

    public RequestForm(int form_no, String topic, String description, String send_date, String comment, String status, String return_date, String send_to) {
        this.form_no=form_no;this.topic=topic;this.description=description;this.send_date=send_date;this.comment=comment;this.status=status;this.return_date=return_date;this.send_date=send_to;

    }

    public RequestForm(int form_no, String topic, String description, String comment, String status, String return_date, String send_to) {
        this.form_no=form_no;this.topic=topic;this.description=description;this.send_date=send_date;this.comment=comment;this.status=status;this.return_date=return_date;this.send_to=send_to;
    }

    public String getSend_to() {
        return send_to;
    }

    public void setSend_to(String send_to) {
        this.send_to = send_to;

    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getForm_no() {
        return form_no;
    }

    public void setForm_no(int form_no) {
        this.form_no = form_no;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }

    public String getAttach_file() {
        return attach_file;
    }

    public void setAttach_file(String attach_file) {
        this.attach_file = attach_file;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
