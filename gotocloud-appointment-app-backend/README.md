# GOTO CLOUD - Doctors API


* Tags:
    * Run ```git tag``` =>v2-working-app
        * Whats there?
            * Spring boot based Doctors API impl: Create, Delete, Update, Get end points
            * With Swagger Documentation
            * H2 embedded DB
            * Google JIB Docker Containerization: https://hub.docker.com/repository/docker/yantraqa/gotocloud-doctor-api
            * Sonar Project Impl: https://sonarcloud.io/project/overview?id=akashdktyagi_gotocloud-appointments-app
            * Jenkins CI Job: Check here: gotocloud-doctor-api/Jenkinsfile
        * Whats Next?
            * Jacoco Impl for code Coverage
            * Unit Tests
            * Cucumber Integration Tests
    * Run ```git tag``` ==> v3-jacoco-impl
    

----

#### How to deal with git tags:
1. Git Tag: https://git-scm.com/book/en/v2/Git-Basics-Tagging
    1. Show all tags: git tag
    2. Crate new tag: git tag -a v2.5 -m” details on tagging”
    3. Show git tag info: git show v2.5
    4. Tag later
        1. Git log —pretty=online
        2. Git tag -a v2.6 9fgdhd
    5. Publish tag: git push origin v2.6
    6. Delete tag: git push origin —delete v2.4
    7. Check out tag:
        1. Git checkout v2.0
        2. This will detach
        3. Create a new branch from it: git checkout -b version2 v2.0