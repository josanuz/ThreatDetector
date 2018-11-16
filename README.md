# ThreatDetector
Proyecto Final Base de datos Avanzadas


# Install JAVA


```bash
 $ sudo add-apt-repository ppa:webupd8team/java
 $ sudo apt update
 $ sudo apt install oracle-java8-installer
 $ sudo apt install oracle-java8-set-default
```

Now that JAVA is installed, run the commands below to set its home directory….


``` bash
 $ sudo nano /etc/environment
```
Then copy and paste the next code

```
    JAVA_HOME=/usr/lib/jvm/java-8-oracle
    export JAVA_HOME
```


# Install Maven

```bash
    $ sudo apt-get install maven
```



# Build Project


## Build project using Maven

Compile java  using Maven.

## Build the project using Maven
Simple build.

```bash
 $ mvn package
```

Clean and build project.

```bash
 $ mvn clean package
```
Download sources dependencies.
```bash
 $ mvn dependency:sources
```
## Execute the projec ( Start Srpint Server)

```bash
 $ java -jar ThreatDetectorServer/target/ThreatDetectorServer-1-X.jar 
```

## Project documentation

Generate java documentation for the java classes inside the project

```bash
$ mvn javadoc:javadoc

```
Then using a http server enter into the target/site/apidocs directory, you can
make use of the npm http-server, install it using npm

```bash
# npm -g install http-server
```
Start the http server:

```bash
$  http-server
```

## Build Project using Ant

From the root directory run the following command

```bash
 $ ant build
```
