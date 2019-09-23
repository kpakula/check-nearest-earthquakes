# Nearest Earthquakes

### Requirements
  - Java 8 +
  - Maven

### How to run
If you are familiar with Maven, you can use your IDE and run as default Maven project. You have to use : 

```
# mvn clean
# mvn install
and run application. 
```


If you are unfamiliar with Maven, you can :

``` 
Go to the project root folder where is pom.xml 
Open command prompt / terminal (in this folder).
```

And use:
```
    # mvn clean
    # mvn install
```

Now, you have two options to choose:

#### #1 Run by Maven command
```
    mvn exec:java
```
OR
#### #2 Run jar
```
    cd target
    java -jar earthquake-1.0-SNAPSHOT-jar-with-dependencies.jar
```

