# spring_boot_snaillube

This is the server component for 'Snail Lube,' a fictitious automotive oil change shop that operates at a slower pace, hence the name. The server component utilizes Spring Boot to implement REST APIs, which handle appointments.

1. See all appointments (all/today)
2. Search appointment by id.
3. Schedule a new appointment.
4. Cancel the appointment.
5. TBD

The API stores data on MySQL database (in this case, AWS RDS Mysql).  

## Prerequisites: 
- Spring Initializr 
- Spring Boot
- Java

## APPOINTMENT OBJECT
The Appointment object contains the following fields:
- id = appointment id, create by database
- name = customer name
- phoneNumber = customer phone number
- email = customer email
- appointmentDate = appointment date 
- timeslot = timeslot for the oil change, b/c Snail Lube is working slow, they only perform 8 oil changes per day

## APIs
1. GET ALL APPOINTMENTS
    >   **Method**: GET
    >
    >   **URL**: http://wamornkul26.com/api/v1/appointments
    >
    >   **Result**: Returns all appointments

2. GET TODAY'S APPOINTMENTS
    >   **Method**: GET
    >
    >   **URL**: http://wamornkul26.com/api/v1/appointments/today
    >
    >   **Result**: Returns today's appointments

3. GET APPOINTMENT BY APPOINTMENT ID
    >   **Method**: GET
    >
    >   **URL**: http://wamornkul26.com/api/v1/appointments/[appointment id]
    >
    >   **Result**: Returns the appointment

4. CREATE AN APPOINTMENT
    >   **Method**: POST
    >
    >   **URL**: http://wamornkul26.com/api/v1/appointments
    >
    >   **Body**: (raw/json)
    >    ```
    >       {
    >           "name" : "Bob Minor",
    >           "phoneNumber" : "(333) 333-3333",
    >           "email" : "bminor@gmail.com",
    >           "appointmentDate" : "2023-05-01",
    >           "timeslot" : 3
    >       }
    >    ```
    >
    >   **Result**: 

    >       Http Status 200 if valid
    >       Http Status 400 if invalid
    >
    >   There are several business logics built into this api.  
    >   - The customer name, appointment date, and timeslot are required. Exception is thrown if one of these three fields are missing. 
    >   - Appointment date cannot be older that today's date.
    >   - Timeslot is between 1 and 8.
    >   - Timeslot has to be available.

5. CANCEL APPOINTMENT
    >   **Method**: DELETE
    >
    >   **URL**: http://wamornkul26.com/api/v1/appointments/[appointment id]
    >
    >   **Result**: 
    
    >       Http Status 200 if valid
    >       Http Status 404 if invalid
    >
    >   The api checks if the appointment id is valid.  Exception is thrown if the appointment id is not found.



