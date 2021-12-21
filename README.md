# project-gladiator

## PROJECT - AIRLINES	(a SpringBoot-Angular Application)
> Repository for Part A:	project-gladiator (https://github.com/manchal395/project-gladiator) <br/>
> Repository for Part B:	angular-project-gladiator (https://github.com/manchal395/angular-project-gladiator)

### Project Abstract
Online Airline Reservation is a web application developed using <b><i>Scrum Based Agile Methodology</i></b> which provides a user-friendly User Interface and an easy efficient way to search, book and cancel flight tickets.
This application is currently working for multiple airline companies and only for domestic flights. <br/>
User have access to search flights and apply for it. User can register on website to search for flights and book tickets. It also allows user to cancel
flights before a specific time. <br/>

Application is implemented in two parts: <br/>
> Part A - RESTfull web services &nbsp;: API's build using spring boot are used for handling all the backend operations. <br/>
> Part B - Front End &nbsp;: User interfaces designed and developed using Angular utilising web services for handling appropriate user actions.

### Features available based on the user role
- Admin
  - Login
  - Add Flight
  - Delete Flight

- Public
  - Search Flights
  - View Searched Flights
  - Register
  - Login
  - View Dashboard (for Bookings)
  - Booking
    - Book seats
    - Cancel booking
 
 ### Project Details
 - Technologies Used
  - Spring Boot
  - Java 8
  - Hibernate, JPA
  - Oracle Database
  - Angular 8
  - HTML. CSS
 
## Steps to Run the complete Airline Application (Part A + Part B)
### 1. Connect Oracle Database

### 2. Run Angular Project
- Open the Project
  - After downloading the project clone zip from github, open it in Visual Studio Code
    - File -> Open Folder -> (Navigate to the unzipped path of project clone folder)
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/Angular_Project_Setup/Open_Project_1.png?raw=true" />

- Install Dependencies
  - Open Visual Studio Code's Terminal
  - Terminal -> New Terminal
  - Install any missing libraries using below command in terminal and press enter (Make sure directory path is of current project folder)
    ```
    npm install
    ```
  - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/Angular_Project_Setup/npm_install.png?raw=true" />

- Run the Angular Application using below command in terminal
```
ng serve -o
```

### 3. Run Spring Boot Project
- Open the Project 
  - After downloading the project clone zip from github, open it in SpringToolSuite
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/SpringBoot_Project_Setup/Open_Project_1.png?raw=true" />
  - Navigate to the unzipped path of project clone folder
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/SpringBoot_Project_Setup/Open_Project_2.png?raw=true" />
  - Make sure project-gladiator-master/gladiator is selected
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/SpringBoot_Project_Setup/Open_Project_3.png?raw=true" />
  - Finish

- Syncing the Eclipse project settings with that of the pom
  - Right Click on project 'gladiator' -> Maven -> Update Project
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/SpringBoot_Project_Setup/Maven_Update_1.png?raw=true" />
  - Make sure "Force Update of Snapshots/Releases" is checked.
    - <img src="https://github.com/manchal395/Airline-Reservation-SpringBoot-Angular/blob/main/Screenshots/SpringBoot_Project_Setup/Maven_Update_2.png?raw=true" />
  - OK

- Running the Spring Boot Project
  - 

- Right click on project -> M
