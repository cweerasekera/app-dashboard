REST API Java Application
Copyright (C) 2015 1833833 Alberta Inc.

## Application endpoint for AppDirect app integration project.

Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 7+ in order to run.

To build, run

    mvn package

Building will run the tests, but to explicitly run tests you can use the test target

    mvn test

To start the app, use the Heroku Webapp Runner (TM) that is already included in this demo.  Just run the command.

    java -jar target/dependency/webapp-runner.jar target/*.war

Your application should start up on port 8080

TODO Endpoint API Documentation