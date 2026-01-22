# E-Commerce Automation Testing Project

## Project Overview
This project demonstrates **end-to-end testing** of an e-commerce web application using both **Manual Testing** and **Automation Testing** approaches.

The application under test is **SauceDemo (demo e-commerce website)**.  
The project is designed to reflect **real-world QA practices**, including test planning, execution, automation framework design, and regression strategy.

---------------------------------------------------

## Testing Scope

### Automation Testing
Automation testing is implemented using **Selenium WebDriver with Java**, following the **Page Object Model (POM)** design pattern.

#### Automated Test Scenarios:
- Valid Login
- Add Product to Cart
- End-to-End Checkout Flow
- Smoke Test Suite
- Regression Test Suite

-------------------------------------------------------

## Tools & Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub
- Eclipse IDE
  
-------------------------------------------------------

## Project Structure

    automation
    │
    ├── pom.xml
    ├── testng-smoke.xml
    ├── testng-regression.xml
    ├── screenshots/
    │
    ├── src
    │ ├── main
    │ │ └── java
    │ │ ├── base
    │ │ ├── pages
    │ │ └── utils
    │ │
    │ └── test
    │ └── java
    │ ├── tests
    │ ├── listeners
    │ └── runners


-------------------------------------------------------

## How to Run the Tests

### Run Smoke Tests
    Right-click testng-smoke.xml → Run As → TestNG Suite

### Run Regression Tests
    Right-click testng-regression.xml → Run As → TestNG Suite

### Run Tests Using Maven
    mvn test -DsuiteXmlFile=testng-smoke.xml
    mvn test -DsuiteXmlFile=testng-regression.xml

-------------------------------------------------------

## Additional Features
- Screenshot capture on test failure
- Separate Smoke and Regression test suites
- Stable regression suite with flaky UI scenarios handled professionally
- Proper WebDriver lifecycle management

-------------------------------------------------------


## Key Learnings
- Designing scalable automation frameworks using POM
- Handling synchronization issues using explicit waits
- Managing flaky UI tests in regression
- Implementing TestNG listeners
- Version control using Git and GitHub

-------------------------------------------------------

##  Author
**Atharv Kulkarni**  
Computer Engineering Student 

-------------------------------------------------------

## Note
This project is created for **learning, practice, and interview demonstration purposes**.


