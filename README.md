# 01-Staff Management System

## Frontend (Vue)

### 1. Staff System

- `/designLogin` 

  > Sign-in page for greeting staff

- `/homepage`

  > Menu page for staff

- `/info`

  > Show the personal information for staff

- `/requestForm`

  > Write a form to manager and show the status. e.g. Is it approved or disapproved or waiting

- `/approvecheque`

  > Pending from group 08 - Cheque System

- `/location-equipment`

  > Pending from group 02 - Location & Equipment System
    
- `/calendar`

  > Show the event from the bank or the manager

### 2. Manager System

- `/designLogin` 

  > Sign-in page for greeting manager

- `/manager`

  > Menu page for manager

- `/info1`

  > Show the personal information for manager

- `/getRequestStaff`

  > Approve request from staff and see request that are confirmed already

- `/register`

  > Staff Registration page which can be rigistered by the manager only

- `/allWork`

  > Show all the people in the bank

- `/calendar`

  > Create the event to the staff and view event

### 3. Assets

- `Ellipse 7.png`

  > Representing the profile picture for staff and manager

- `key-variant 1.png`

  > Icon representing the forget password feature

- `logo-white2.png`

  > Representing the transparent white logo in bank 

### 4. Components (ยกเว้น calendar)*

- `/Carousel`

  > Slide show for announcement of bank

- `/Nav`

  > Nav bar for staff

- `/NavForM`

  > Nav bar for manager

## Backend (Servlet)

### Sign in (Authentication) 
> Get username and password to check correction and check which position he is (staff or manager)
- **URL** : `/api/SigninServlet`
- **Method** : `POST`
- **Auth required** : NO
- **Parameters** : 
  *   username=`required`
  *   password=`required`
- **Body** : None
- **Function involved** :
  - checkPassword()

#### **Success Response**

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "role": "manager"
  }
  ```
  or

  ```json
  {
      "role": "staff"
  }
  ```

#### **Error Response**

- **Status code** : `400`

  **Respose body** : None

---

### Menu Page after login

> Get basic information and show to greeting board

- **URL** : `/api/GetStaffServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** : 
  * id=`require`
- **Body** : None
- **Function involved** :
  - getStaffFromId()

#### Success Response

- **Status code** : `400`

  **Response body** :

  ```json
  {
      "name": <String> ,
      "lastname": <String>,
      "id":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Personal Information

> Show all information of the people who login by choosing from id

- **URL** : `/api/PersonalInfoServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** : 
  * id=`require`
- **Body** : None
- **Function involved** :
  - getStaffFromId()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "id":<Integer>,
      "username":<String>,
      "name":<String>,
      "lastname":<String>,
      "email":<String>,
      "tel":<String>,
      "date_of_birth":<String>,
      "department":<String>,
      "branch":<String>,
      "address":<String>,
      "date_of_employed":<String>,
      "salary":<String>,
      "created_at":<String>,
      "citizen_id":<String>,
      "sex":<String>,
      "nickname":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### See waiting-sent request for staff

> to see the request that you had sent to manager and status still be waiting

- **URL** : `api/WaitingGetRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * ID=`required`
- **Body** : None
- **Function involved** :
  - getWaitingRequestFormById()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "form_no":<Integer>,
      "topic":<String>,
      "description":<String>,
      "status":<String>,
      "send_to":<String>
  }
  ```

#### Error Response

- **Status code** : ``

  **Response body** : None

---

### See approved-sent request for staff

> to see the request you had sent to manager and status is approved

- **URL** : `api/ApprovedGetRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * ID=`required`
- **Body** : None
- **Function involved** :
  - getApprovedRequestFormById()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "form_no":<Integer>,
      "topic":<String>,
      "description":<String>,
      "comment":<String>,
      "status":<String>,
      "return_date":<String>,
      "send_to":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### See disapproved-sent request for staff

> to see the request that you had sent to manager and status is disapproved

- **URL** : `api/DisapproveGetRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * id=`required`
- **Body** : None
- **Function involved** :
  - getDisapprovedRequestFormById()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "form_no":<Integer>,
      "topic":<String>,
      "description":<String>,
      "comment":<String>,
      "status":<String>,
      "return_date":<String>,
      "send_to":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Send request to manager

> Insertion request to manager(head of department)

- **URL** : `api/requestServlet`
- **Method** : `POST`
- **Auth required** : YES
- **Parameters** :
  * id=`required`
- **Body** :

  ```json
  {
      "topic":<String>,
      "description":<String>,
      "from_date":<String>,
      "to_date":<String>,
      "send_to":<String>
  }
  ```

- **Function involved** :
  - insertRequestForm()

#### Success Response

- **Status code** : `200`

  **Response body** : None

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Calendar

> get all events that has been set by manager in each department

- **URL** : `api/getCalendarServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** : None
- **Body** : None
- **Function involved** :
  - getCalendar()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "name":<String>,
      "start":<String>,
      "end":<String>,
      "detail":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Insert Calendar

> Insertion Calendar 

- **URL** : `api/InsertCalendar`
- **Method** : `POST`
- **Auth required** : YES
- **Parameters** : None
- **Body** :

  ```json
  {
      "start_date":<String>,
      "end_date":<String>,
      "detail":<String>,
      "event_name":<String>
  }
  ```

- **Function involved** :
  - InsertCalendar()

#### Success Response

- **Status code** : `200`

  **Response body** : None

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Approve Cheque

> approve cheque by staff that choose from signed picture

- **URL** : ``
- **Method** : ``
- **Auth required** :
- **Parameters** :
- **Body** :
- **Function involved** :
  - function 1

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      
  }
  ```

#### Error Response

- **Status code** : ``

  **Response body** : None

---

### Location & Equipment

> To see equipment such as ATM or Branch in terms of location (Google Map)

- **URL** : `api/`
- **Method** : ``
- **Auth required** :
- **Parameters** :
- **Body** :
- **Function involved** :
  - function 1

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      
  }
  ```

#### Error Response

- **Status code** : ``

  **Response body** : None

---

### See Waiting Request for manager

> To see request that has been sent to you(manager) choose by send_to and status is waiting

- **URL** : `api/WaitingReceivedRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * id=`require`
- **Body** : None
- **Function involved** :
  - getWaitingRequestFormBySendTo()
  - getDepartmentFromId()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "name":<String>,
      "lastname":<String>,
      "tel":<String>,
      "email":<String>,
      "department":<String>,
      "branch":<String>,
      "form_no":<String>,
      "topic":<String>,
      "description":<String>,
      "from_date":<String>,
      "to_date":<String>,
      "send_date":<String>,
      "status":<String>,
      "send_to":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### See Approved Request for Manager

>  To see request that has been sent to you(manager) choose by send_to and status is approved

- **URL** : `api/ApprovedReceivedRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * id=`required`
- **Body** : None
- **Function involved** :
  - getApprovedRequestFormBySendTo()
  - getDepartmentFromId()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "name":<String>,
      "lastname":<String>,
      "tel":<String>,
      "email":<String>,
      "department":<String>,
      "branch":<String>,
      "form_no":<String>,
      "topic":<String>,
      "description":<String>,
      "from_date":<String>,
      "to_date":<String>,
      "send_date":<String>,
      "comment":<String>,
      "status":<String>,
      "return_date":<String>
  }
  ```

#### Error Response

- **Status code** : ``

  **Response body** : None

---

### See disapproved Request for Manager

>  To see request that has been sent to you(manager) choose by send_to and status is disapproved

- **URL** : `api/DispprovedReceivedRequestFormServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** :
  * id=`require`
- **Body** : None
- **Function involved** :
  - getDisapprovedRequestFormBySendTo()
  - getDepartmentFromId()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "staff_id":<Integer>,
      "name":<String>,
      "lastname":<String>,
      "tel":<String>,
      "email":<String>,
      "department":<String>,
      "branch":<String>,
      "form_no":<String>,
      "topic":<String>,
      "description":<String>,
      "from_date":<String>,
      "to_date":<String>,
      "send_date":<String>,
      "comment":<String>,
      "status":<String>,
      "return_date":<String>  
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Staff Registration

> Insertion staff record with important information and must be registered by manager account only.

- **URL** : `api/RegisterServlet`
- **Method** : `POST`
- **Auth required** : YES
- **Parameters** : None
- **Body** :

  ```json
  {
      "username":<String>,
      "password":<String>,
      "name":<String>,
      "lastname":<String>,
      "email":<String>,
      "tel":<String>,
      "date_of_birth":<String>,
      "department":<String>,
      "address":<String>,
      "date_of_employed":<String>,
      "salary":<String>,
      "branch":<String>,
      "citizen_id":<String>,
      "sex":<String>,
      "nickname":<String>,
  }
  ```

- **Function involved** :
  - createAccountAndSalary()

#### Success Response

- **Status code** : `200`

  **Response body** : None

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

### Access History (use PersonalInfoServlet again)

> To get personal information of all staff in your department. Can access only by manager account.

- **URL** : `/api/PersonalInfoServlet`
- **Method** : `GET`
- **Auth required** : YES
- **Parameters** : 
  * id=`require`
- **Body** : None
- **Function involved** :
  - getStaffFromId()

#### Success Response

- **Status code** : `200`

  **Response body** :

  ```json
  {
      "id":<Integer>,
      "username":<String>,
      "name":<String>,
      "lastname":<String>,
      "email":<String>,
      "tel":<String>,
      "date_of_birth":<String>,
      "department":<String>,
      "branch":<String>,
      "address":<String>,
      "date_of_employed":<String>,
      "salary":<String>,
      "created_at":<String>,
      "citizen_id":<String>,
      "sex":<String>,
      "nickname":<String>
  }
  ```

#### Error Response

- **Status code** : `400`

  **Response body** : None

---

## Functions (Model)
---
### getStaff()

- **Description** : `Get all information of all staff`
- **Package** : `model.QueryModel`

### getApprovedRequestFormBySendTo(String department)

- **Description** : `Get all approved request that send to the manager(you) for manager account`
- **Package** : `model.QueryModel`

### getWaitingRequestFormById(String id)

- **Description** : `Get all requests that you had sent and status is Waiting`
- **Package** : `model.QueryModel`

### getApprovedRequestFormById(String id)

- **Description** : `Get all requests that you had sent and status is Approved`
- **Package** : `model.QueryModel`

### getDisapprovedRequestFormById(String id)

- **Description** : `Get all requests that you had sent and status is Disapproved`
- **Package** : `model.QueryModel`

### getWaitingRequestFormBySendTo(String department)

- **Description** : `Get all waiting request that send to the manager(you) for manager account`
- **Package** : `model.QueryModel`

### getDisapprovedRequestFormBySendTo(String department)

- **Description** : `Get all disapproved request that send to the manager(you) for manager account`
- **Package** : `model.QueryModel`

### approveRequestFormByFormNO(String comment,String status,String form_no)

- **Description** : `Update status of requestform such as Approved or Disapproved`
- **Package** : `model.QueryModel`

### checkPassword(String username, String password)

- **Description** : `To check password is correct or not`
- **Package** : `model.QueryModel`

### createAccountAndSalary(String username, String password, String salary, String nickname, String name, String lastname, String date_of_birth, String tel, String email, String citizen_id, String sex, String address, String date_of_employed, String department,String branch)

- **Description** : `To create the full staff account`
- **Package** : `model.QueryModel`

### isManager(int id)

- **Description** : `To check that this username is the manager or normal staff`
- **Package** : `model.QueryModel`

### getStaffId(String username)

- **Description** : `To get staff id by inputing username`
- **Package** : `model.QueryModel`

### insertRequestForm(String staff_id,String from_date,String topic,String description,String to_date,String send_to)

- **Description** : `To send new request to manager or department (insertion new requestform)`
- **Package** : `model.QueryModel`

### getCalendar()

- **Description** : `To get all events from staff_calendar table`
- **Package** : `model.QueryModel`

### toHexString(byte[] hash)

- **Description** : `To encrypt the pass word into hexString`
- **Package** : `model.QueryModel`

### InsertCalendar(String start_date,String end_date, String detail, String event_name)

- **Description** : `To insert new event in staff_calendar table`
- **Package** : `model.QueryModel`

### getDepartmentFromId(String id)

- **Description** : `To get department number from staff id`
- **Package** : `model.QueryModel`

### getStaffFromId(String id)

- **Description** : `To get all information of staff from staff id`
- **Package** : `model.QueryModel`