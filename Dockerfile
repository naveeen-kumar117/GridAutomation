FROM openjdk:17-alpine
RUN apk add curl jq

#Workspace
WORKDIR /usr/share/ground
#Add Jar from host to image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
#ADD Suite files

ADD flight_suite.xml flight_suite.xml

# ADD health check script
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh
 
# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh

#java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE