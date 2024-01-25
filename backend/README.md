# Backend 🛠

The brains of the project - communicates with the bot to update the database of rides and compiles travel information and neatly packages it for both the frontend and the bot.

## Docs

### Features

- [ ] Compiled Info
  - [ ] Traffic times/estimate
  - [x] ATL TSA wait times
  - [ ] Uber/Lyft price estimates
  - [ ] Emory Transportation (Transloc)
- [ ] Rideshare Info
  - [ ] Email sign-on
  - [ ] Ride filters
  - [ ] Adding rides through website

### File Structure

- `src/main/`
  - `java/com/projectpanas/ridemory` (API source code)
    - `config` (Spring Boot configuration files)
    - `repositories` (MongoDB related files)
    - `controllers`, `models`, `services` (self explanatory, review MVC components)
    - The only loose files in this folder should be `RidemoryApplication.java` and related files that don't fit in any of the other folders
  - `resources`
    - `static`, `templates` (static resources such as html files go here, we likely will never use this)
    - `application.properties` (general configurations for Spring Boot go here)
  - `secrets.properties` (secrets used by the backend go here and are imported as environment variables - _DO NOT COMMIT THESE!_)
- `src/test/java/com/projectpandas/ridemory` (tests for code)

### Setup

In order to set up the project for development on your own device, you'll need the following: [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Maven 3.6.3+](https://maven.apache.org/download.cgi), and a [MongoDB Atlas account](https://www.mongodb.com/).

First, check if you have Java installed by running `java --version`. If it isn't already installed, or your current version is lower than Java 17, download and install the JDK 17 installer from the page linked above. Make sure to add Java to your path when prompted, and open a new terminal and type in `java --version` to make sure you have it installed properly. If you have an outdated version installed, you may need to change your default Java installation; just google instructions and ask for help if necessary.

Next, install Maven. If you are running MacOS or a Linux distro, you can use [homebrew](https://formulae.brew.sh/formula/maven) or your favorite package manager ([apt](https://phoenixnap.com/kb/install-maven-on-ubuntu), [pacman](https://www.atlantic.net/dedicated-server-hosting/how-to-install-apache-maven-on-arch-linux/), etc) respectively. On Windows, the process is more involved, but all you have to do is download the binary from the link above and follow the instructions [here](https://phoenixnap.com/kb/install-maven-windows). Once you have it installed, close and reopen your terminal and run `mvn -V` to check you have it properly installed.

Finally, go to [MongoDB](https://www.mongodb.com/) and create a new account (if you do not have one already) and a new free cluster (M0 Sandbox). Most of the configuration settings don't matter; however, when you are editing your security settings, make sure your password doesn't contain any special characters (`$`, `:`, `/`, `?`, `#`, `[`, `]`, or `@`). If it does, you will have to follow the instructions [here](https://www.mongodb.com/docs/manual/reference/connection-string/) in order to convert it into an acceptable string. (Using a password you don't use for any other accounts would be the most secure, as this password could be accidentally leaked if you force add `secrets.properties` to any commits.)

Once that is done, go to the "Network Access" tab and add your current IP address. Then, go to the "Deployment" tab in MongoDB, find the "Database Deployment" section on the page, and hit the connect button and then the compass button. Download, install, and open MongoDB Compass, copy the connection string, replace `<password>` with your password, and hit "Save & Connect". If you successfully connect to the cluster, move on; else, double check your password and that there are no extra characters in the connection string.

Now, open the RIDEmory project in your favorite IDE, go to `RIDEmory/backend/src/main/resources/` and create a file called `secrets.properties`. In this file, paste the following:

```
spring.data.mongodb.uri=<connection string goes here>
spring.data.mongodb.database=ridemory
```

and save the file. Now, go to your terminal, navigate to the `backend/` directory, and run `mvn spring-boot:run`. If it launches with no error messages and a new "ridemory" database pops up on the left of MongoDB Compass (make sure you're still connected), you are all set!

### Testing

To launch the backend, make sure you are in the `backend/` directory and run `mvn spring-boot:run`. The service is running on port 8080, so you can run test requests at `localhost:8080/` and monitor the database using MongoDB Compass (manually pressing reload on the right) Download Postman, install it (you do not need to log in), and look through the controllers in `backend/src/main/java/.../controllers/` to see some example requests you can test. An example is as follows:

```
POST localhost:8080/rides/new

{
  "id": 25,
  "messageID": 400,
  "to": "Hartsfield Jackson",
  "from": "Emory University ATL"
}
```

After running this request, if the ride does not already exist you should be able to refresh the "ridemory.rides" collection and see the number of documents increase by one.

## Getting Started (Automatically generated by Spring Boot)

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
- [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
