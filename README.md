Upload Download File Using Old Spring Framework
===============================================

This is example upload and downloading files using old spring artifacts (Spring 2.0.8 used).

Clone this project and simply run using following command inside project root directory via command prompt
```mvn clean tomcat6:run```
Please make sure maven already installed on your machine. Or import into IDE supporting maven and run equivalent command.

Then you can access http://localhost:8080/old-spring-upload/list list of all uploaded files. No file listed there if the server just started. Please note, all uploaded files stored on temporary directory, history of all downloaded files managed on memory, so if you restarting the server all old records will be destroyed. 