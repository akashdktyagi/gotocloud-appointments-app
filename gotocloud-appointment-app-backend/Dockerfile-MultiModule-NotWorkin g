# cache as most as possible in this multistage dockerfile.
FROM maven:3.6-alpine as DEPS

WORKDIR /opt/app
COPY gotocloud-doctor-api/pom.xml gotocloud-doctor-api/pom.xml
#COPY module2/pom.xml module2/pom.xml

COPY pom.xml .
RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

# if you have modules that depends each other, you may use -DexcludeArtifactIds as follows
# RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline -DexcludeArtifactIds=module1

# Copy the dependencies from the DEPS stage with the advantage
# of using docker layer caches. If something goes wrong from this
# line on, all dependencies from DEPS were already downloaded and
# stored in docker's layers.
FROM maven:3.6-alpine as BUILDER
WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app/ /opt/app
COPY gotocloud-doctor-api/src /opt/app/gotocloud-doctor-api/src
#COPY module2/src /opt/app/module2/src

# use -o (--offline) if you didn't need to exclude artifacts.
# if you have excluded artifacts, then remove -o flag
RUN mvn -B -e -o clean install -DskipTests=true

# At this point, BUILDER stage should have your .jar or whatever in some path
FROM openjdk:8-alpine
WORKDIR /opt/app
COPY --from=builder /opt/app/gotocloud-doctor-api/target/gotocloud-doctor-api-1.0-SNAPSHOT.jar .
EXPOSE 9000
CMD [ "java", "-jar", "/opt/app/gotocloud-doctor-api-1.0-SNAPSHOT.jar" ]

#COPY --from=MAVEN_BUILD /gotocloud-doctor-api/target/gotocloud-doctor-api-1.0-SNAPSHOT.jar /gotocloud-doctor-api.jar
#
## set the startup command to execute the jar
#CMD ["java", "-jar", "/gotocloud-doctor-api.jar"]