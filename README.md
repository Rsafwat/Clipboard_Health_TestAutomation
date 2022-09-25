# Clipboard_Health_TestAutomation
## Concepts Included

* Common web page interaction methods
* Externalised test configuration
* page object model design patterns
* Commonly used test utility classes
* Screenshots
* Reporting

## Tools & libraries

The test automation framework tools and libraries

* Java
* Maven
* Selenium Web Driver
* TestNG Framework
* Extent Reports

## Framework Setup

In order to start executing tests, you need to have the following installed locally:


## 1. The Testing project

* Clone the `Clipboard_Health_TestAutomation` project

    ```shell
    $ git clone git@github.com:Rsafwat/Clipboard_Health_TestAutomation.git
    ```


## Executing the test suite (browser mode)

### 1. Open Clipboard_Health_TestAutomation  repo in IntelliJ IDEA or eclipse IDE

### 2. Setup for the environmental variables for  Clipboard_Health_TestAutomation repo

1. Delete any resource file if exists, Copy the `browser-config.properties.example` file and rename it to be `browser-config.properties`

2. Set the environmental variable `base.url` to `https://www.amazon.in/`. 
3. Set the environmental variable `test.target.browser` to `chrome`. 

### 3. Executing tests

1. For tests execution, Run  `chrome.testsuite` file.

 

## Local reports

### 2. Pretty Extent Report

A report for tests results will be generated at `target/reports.chrome`

A screenshot folder will be genrated for failed tests `target/screenshots.chrome`



