# buggycars
A test project to perform automated testing on web application https://buggy.justtestit.org/

## Description

Buggy Cars Rating is an online web application that presents Popular Make, Popular Model and the Overall Rating of each of the model in the car segment. 

Test automation has been performed using Selenium WebDriver and the scripts are written using Java.

## Technologies

Selenium Webdriver - Browser automation framework  
Java - Programming Language  
TestNG - Testing Framework  
Maven - Build automation tool  
Eclipse - IDE for development

## Maven Dependencies

Selenium-java 4.8.3
TestNG 7.7.1

## Tools Installation

### 1. Java JDK  

Download and install latest JDK version from https://www.oracle.com/java/technologies/downloads/  

### 2. Eclipse IDE for Java Developers

Download and install latest Eclipse IDE for Java Developers https://www.eclipse.org/downloads/packages/

### 3. Maven  

Download and extract latest Maven Binary zip archive version from https://maven.apache.org/download.cgi  

#### Cloning the project  

Clone this git hub repository to your local machine using the following command:  

	$ git clone https://github.com/heenarahurikar/BuggyCarsProject.git

### Prerequisites to run the test 

Download chromedriver depending upon the chrome version from https://chromedriver.chromium.org/downloads  

#### Running the test  

Execute the command to run all the tests in the project  

	$ mvn clean test  

Execute the command to run only one test in the project  

	$ mvn test -Dtest=HomePageTest    
  
#### View Test Results

Surfire Test reports gets generated in the following project folder "target\surefire-reports"  
 
Click on the "index.html" file in the above folder location to view the test report  
 
