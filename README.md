# RestAssuredBDDFramework
Description
The BDD framework is built using Rest Assured JAVA library along with TestNG,Cucumber
The framework is built using Builder pattern
The project dependencies are maintained using MAVEN dependency management
The Request/Response payload are transformed as POJO class 

Installation
1) Install ORACLE JAVA JDK 1.8 version
2) Install APACHE Maven software
3) Install ECLIPSE IDE

Folder Structure :
1) src/main/java - the pojo classes,api utilities
2) src/test/java - test runner file,step definitions
3) src/test/resources - feature files,configuration files
4) the test results are generated under ExtentReports folder
    
Usage
 To execute a test script,perform the following steps
 1) Open the feature file for execution.The files are located under apifmwk\src\test\resources\features\covidCountryCases.Get the tag denoted by @ to execute a scenario
 2) Open the Test Runner file.The file is located at apifmwk\src\test\java\runners\TestRunner.java
 3) Provide the tag within double quotes .For ex : tags= {"@get_covid_api"}
 4) Change the @DataProvider(parallel=true) for the scenarios() within TestRunner class to enable parallel test execution or false otherwise.
 5) Configure the project build path as jdk1.8 by right click project->Configure Build Path->Libraries->JDK 1.8
 6) Open/Right Click the pom.xml file.The file is located at apifmwk\pom.xml..Choose Run As Maven test 

Author
Swathiraj Agaram Venkatavaradan
