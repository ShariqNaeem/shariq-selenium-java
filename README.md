# shariq-selenium-java

**Project Tools:** Selenium, Cucumber, TestNG, Allure report
This project is an automation testing framework for the **SAUCE DEMO** application that uses Java as the programming language and combines several popular tools and technologies for automated testing, including Selenium, Cucumber, TestNG, and Allure Reporting.

## Table of Contents

- [Overview](#overview)
- [Key Features](#keyfeatures)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Reporting](#reporting)

### Overview

The main objective of this project is to demonstrate how to create a robust and maintainable test automation framework for web applications using Java and various open-source testing tools. The framework follows best practices in test automation, including BDD (Behavior-Driven Development) with Cucumber and comprehensive test reporting with Allure.

### Key Features

- **Selenium WebDriver**: Selenium is used as the automation tool for driving web browsers. It provides support for multiple browsers and platforms.

- **Cucumber**: Cucumber is employed for writing and managing test scenarios in a human-readable format, using Gherkin syntax. It allows collaboration between non-technical stakeholders and the testing team.

- **TestNG**: TestNG serves as the test execution framework, allowing the organization of tests into suites and providing powerful test configuration options.

- **Allure Report**: Allure Reporting is used to generate rich and visually appealing test reports. It provides insights into test results, including step-by-step execution details, screenshots, and more.


### Project Structure

The project structure is organized as follows:

- The `src` directory contains the source code, including page objects, step definations, test runner, feature files and utility classes.
- The `src/test/java/saucedemo/pageobjects` directory holds the page objects classes that contain the locators, assertions, and performing actions.
- The `src/test/java/saucedemo/stepdefinations` directory contain the Hook file, and step defination files that are working as a bridge between feature files and the page object files.
- The `src/test/java/saucedemo/utils` directory has the class DriverManager where we defined the WebDriver and setting up the browser capabilities.
- The `src/test/java/features` directory contains the feature files written in Gherkin.
- The `src/test/java/saucedemo/TestRunner.java` This file has the cucumber runner, where we defined the @CucumberOptions for running the test cases.
- The `allure-results` directory stores the output of test runs, which is used to generate Allure reports.
- The `src/test/resources` directory contain the config.properties file. We defined the baseURL, and title. Also we can add the browser name for the headless / cross browsing testing.

### Prerequisites

Before you begin, ensure you have the following tools and dependencies installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- I have used open JDK 17 for this project. Make sure that you already set the JDK path as well.
- Make Sure you have the Chrome browser in your local machine.
- A suitable Integrated Development Environment (IDE) such as IntelliJ IDEA.
- Also you need to set the ALLURE path in the environment variable.

### Getting Started

To get started with the project, follow these steps:

1. Clone this repository to your local machine.
2. Install the required dependencies and tools mentioned in the Prerequisites section.
3. Open the project in your preferred Java IDE.

### Running Tests

-  Goto the TestRunner.java file. Right click on the file and select the 'Run `TestRunner`' option.

### Reporting

-  After running the test cases, you will getting the 'allure-results' directory
-  Now you have to run the following command for the allure reoprting:
  ```allure serve allure-results```


For detailed instructions on running tests and generating reports, please refer to the relevant sections below.
