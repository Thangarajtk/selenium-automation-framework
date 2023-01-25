# Selenium - Web Automation Framework
Test automation framework for web applications using Selenium 4 and Java

![WebDriver-W3C-Protocol-1](https://user-images.githubusercontent.com/48508827/155773516-432123c9-a3fe-40d0-8c95-1aaea1c7ec91.png)

## :rocket: Quick Start
1) Install [Java JDK11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) 
2) Download [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
3) Download [Docker Desktop](https://docs.docker.com/desktop/windows/install/)

## :pushpin: Tech stack
<a href="https://www.java.com" target="_blank" rel="noreferrer">
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> 
<a href="https://www.selenium.dev" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/detain/svg-logos/780f25886640cef088af994181646db2f6b1a3f8/svg/selenium-logo.svg" alt="selenium" width="40" height="40"/> </a> 
<a href="https://testng.org/" target="_blank" rel="noreferrer"> 
<img src="https://avatars.githubusercontent.com/u/12528662?s=200&v=4" alt="testng" width="40" height="40"/> </a> 
<a href="https://www.jenkins.io" target="_blank" rel="noreferrer"> 
<img src="https://www.vectorlogo.zone/logos/jenkins/jenkins-icon.svg" alt="jenkins" width="40" height="40"/> </a> 
<a href="https://www.docker.com/" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a>

## :pushpin: Running tests through testng xml
:point_right: Create or Select the required testng xml -> Right click and select Run

## :pushpin: Running tests through Maven
:point_right: Run test using command `mvn test -Dsurefire.suiteXmlFiles=<provide the testng xml to execute>`

## :pushpin: Key Features
:point_right: Supports cross browser testing in local and remote.

:point_right: Ability to execute tests in Selenium Grid or Selenoid using Docker.

:point_right: Page object model design.

:point_right: Supports parallel and sequential execution of tests.

:point_right: Supports capturing screenshots for passed/failed/skipped steps which is configurable through `config.properties`

:point_right: Ability to retry failed tests which is configurable through `config.properties`

:point_right: Customised exception handling to provide the exceptions in a meaningful way.

:point_right: Custom framework annotation to provide author name and category for each test.

:point_right: Supports utilities to read test data from excel workbook and provides data to each test based on the test name.

:point_right: Ability to configure and schedule jenkins job to build triggers automatically

## :rocket: Selenoid Quick Start Guide
[Click here for Selenoid Quick Start Guide](https://aerokube.com/selenoid/latest/)

## Docker commands

### To Run Elasticsearch
```
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch -e "discovery.type=single-node"  docker.elastic.co/elasticsearch/elasticsearch:7.11.1
```

### To Run Kibana
```
docker run -p 5601:5601 --name kibana --link elasticsearch:elasticsearch docker.elastic.co/kibana/kibana:7.11.1
```

### Credits
This framework is built by following [Testing Mini Bytes](https://www.youtube.com/playlist?list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB) YouTube channel.