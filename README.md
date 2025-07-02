
# Selenium Level 1 - Railway Test Automation

## Project Overview
This project contains basic test automation for the **Railway** web application using **Selenium** WebDriver with Java. The project follows a **Page Object Model (POM)** design pattern and is structured to allow easy extension of test cases.

## Test Cases
The project contains **16 test cases** that can be referenced from this [Google Sheet](https://docs.google.com/spreadsheets/d/1UmENZ4MLLyFM80n-kjD5HRGLdKnwCbtPewzfUkLV27E/edit?usp=sharing).

## Tools and Technologies
- **Java**: JDK 11
- **IDE**: IntelliJ IDEA
- **Testing Browser**: Chrome Version 137.0.7151.122 (Official Build) (64-bit)
- **Testing Framework**: TestNG
- **Libraries**:
    - Selenium 4
    - TestNG
    - Allure
    - MailSlurp
    - Log4j
    - ExtentReports

## Project Structure

The project structure is as follows:

```
src
 ├── main
 │    ├── java
 │    │    ├── com.Railway
 │    │    │    ├── constant
 │    │    │    ├── data
 │    │    │    ├── dataObject
 │    │    │    ├── driver
 │    │    │    ├── element
 │    │    │    ├── listener
 │    │    │    ├── log
 │    │    │    ├── pages 
 │    │    │    ├── report
 │    │    │    ├── untilities
 │    │    │    └── model
 │    └── resources
 │         ├── testSuites
 │         └── allure.properties
 ├── test
 │    ├── java   
 │    │    ├── base
 │    │    ├── book_ticket
 │    │    ├── change_password
 │    │    ├── data
 │    │    ├── listener
 │    │    ├── login
 │    │    ├── my_ticket
 │    │    ├── register
 │    │    └── train_timetable
 │    └── resources 
 ├── logs
 └── ExtentReports
```

### Explanation of Key Directories:
- **com.Railway**:
    - `constant`: Holds constants used across the project.
    - `data`: Reads and handles the test data (e.g., JSON reader).
    - `dataObject`: Contains data models such as `Account`, `ArriveStation`, etc.
    - `driver`: Manages the WebDriver instances (`DriverManager`).
    - `element`: Contains helper functions for interacting with WebElements (`Element` class).
    - `listener`: TestNG listener for logging and test reports.
    - `log`: Utility classes for logging (using Log4j).
    - `model`: Defines the test data models like `AccountModel`, `RegisterInfo`, etc.
    - `pages`:Contains page object classes (e.g., BookTicketPage, LoginPage).
    - `report`: Contains classes for managing reports (e.g., ExtentReports, Allure reports).
    - `untilities`: Contains utility classes for common functionality.

- **test**:
    - `java` : Contains the individual test cases organized by feature (e.g., `login`, `book_ticket`, `change_password`).
    - `resources` : Contains the data file for data provider.
- **logs**: Stores log files generated during test executions.
- **ExtentReports**: Stores the ExtentReports HTML reports.
- **resources**: Contains configuration files such as `test.xml`, environment properties, and Allure configurations.

## Features and Techniques Applied
- **Page Object Model (POM)** design pattern to separate page objects and actions.
- **Dynamic WebElement Locators**: Handles dynamic locators using XPath.
- **Clean Code & Java Coding Conventions**: Follows naming conventions, structure, and modularity.
- **Parallel Test Execution**: Supports parallel test execution with TestNG.
- **Screenshot on Test Failures**: Captures screenshots for test failures.
- **Logger (Log4j)**: Logs the test execution process for better debugging.
- **Extent Reports**: Detailed reports with test steps, failures, and screenshots.
- **Data Models**: Utilizes data objects (enums like `SeatType`, `DepartStation`, etc.) for more structured data handling.
- **Allure Reports**: Integrated Allure for detailed test reporting.
- **API Testing**: Test case for resetting passwords using **MailSlurp API** (TC12).
- **Data Provider**: Used @DataProvider to load data from JSON files for various test cases, making the testing process more flexible and efficient.


---

## How to Run the Tests

Follow these steps to run the test suite and view the results:

1. **Clone the repository**:

    * Clone the repository to your local machine using Git:

      ```bash
      git clone <repository-url>
      ```

2. **Open the project in IntelliJ IDEA**:

    * Open IntelliJ IDEA, go to **File > Open** and select the folder where you cloned the repository.

3. **Set up the necessary environment variables**:

    * Make sure that Java JDK 11 and Maven are installed on your machine.
    * Set up any required environment variables for the project (e.g., paths to necessary tools or configuration files).

4. **Execute the test suite**:

    * In IntelliJ IDEA, locate the **`test.xml`** file under `src/main/resources/testSuites/test.xml`.
    * Right-click on **`test.xml`** and select **Run** to execute the test suite using TestNG.
    * Alternatively, you can use Maven to run the tests. Navigate to the project root directory and run the following command:

      ```bash
      mvn test
      ```

5. **View the results**:

    * After running the tests, view the results using **ExtentReports** and **Allure**:

        * **ExtentReports**: Check the `ExtentReports` folder for the generated HTML reports.
        * **Allure Reports**: To view Allure reports, navigate to the project folder and run the following command:

          ```bash
          allure serve
          ```

      This will launch a local server where you can view the detailed Allure test report.

---




## Allure Report Setup Guide
Follow these steps to set up and view Allure reports:

### Step 1: Download Allure CLI
- Download from the official [Allure 2.34.1](https://github.com/allure-framework/allure2/releases/download/2.34.1/allure-2.34.1.zip).

### Step 2: Set Up Environment Variables
- Unzip the downloaded `.zip` file.
- Add the `bin` directory path of Allure to your system `PATH` variable.

### Step 3: Verify Allure Installation
- Open a terminal and run the following command:

  ```bash
  allure --version
  ```

### Step 4: Run Test Cases
- Use IDE (IntelliJ) or Maven/TestNG commands to execute the tests.

### Step 5: View Allure Report
- Navigate to the project folder:

  ```bash
  cd SeleniumLevel1
  ```

- Run the following command to serve the Allure report:

  ```bash
  allure serve
  ```

📝 **Note**: Make sure Java is properly installed and configured to run Allure.




---

