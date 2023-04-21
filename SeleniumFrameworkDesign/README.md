1. The basic Maven framework(java) is built base on Selenium and TestNG
2. In order to run the tests, please download Maven and set Maven Environment Variables
3. Open project with Eclipse IDE
4. Configure the desired browser to run under \\src\\main\\java\\resources\\GlobalData.properties
5. The current capabilities, if you want to run other multiple browser version, please download the corresponding browser driver:   
    5.1 chromedriver 112.0.5615.28   => Chrome version 112
    5.2 geckodriver 0.32.0  => Firefox version ≥106
    5.3 msedgedriver 112.0.1722.34 => Edge version 112
6. The tests are defined under \\src\\test\\java\\tests
7. Can run the test via command line or via Eclipse IDE (testng.xml)
   7.1 run command line "mvn test" under D:\realworldTest\SeleniumFrameworkDesign
   7.2 Open project in Eclipse and run testng.xml to run tests
8. HTML report will be generated under realworldTest/SeleniumFrameworkDesign/test-output/emailable-report.html, if the test is failed, the report will show the failed log.

