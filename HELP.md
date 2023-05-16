# Contents

* [Reference Documentation](#reference-documentation).

* [Description Of Each Package](#description-of-each-package).

# Reference Documentation

## [Springboot Project Getting Started](https://spring.io/guides/gs/spring-boot/)

In this guide we recommend using Spring Initialzr(https://start.spring.io/) to get a fully structured Spring Boot Initial setup.

To complete setting up the mongoDB and implement RESTful APIs, complete task 2, etc..., we added some dependencies/plugins in pom.xml. Please refer to pom.xml for documentation for each dependencies and plugins. 

Since there can be some dependencies conflicts depending on which distribution version you get, you can use our the dependencies with the same versions as ours. 

After setting up the pom.xml and having ONLY App.java in src/main/java/com/example, you should be able to start the server with `mvn spring-boot:run`

## [MongoDB Set Up](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/)

Now we can start setting up mongoDB for our LOCAL machine and connect our Springboot application with it.

Since we are setting up our application on Ubuntu, please refer to the link above to install MongoDB Community Edition on Ubuntu (Step 1-4)

After finishing installing MongoDB on your Ubuntu, run `sudo systemctl start mongod` to start MongoDB, and `sudo systemctl status mongod` for checking if MongoDB started. 

For WSL2 users, you might not have `systemctl`, please refer to this link to solve the issue: https://askubuntu.com/questions/1379425/system-has-not-been-booted-with-systemd-as-init-system-pid-1-cant-operate (make sure you have the latest version of WSL2)

To connect to MongoDB you need to create an user, so that our application can connect to this user's database. Please refer to this link for User Administrator creation: https://www.mongodb.com/docs/v2.6/tutorial/add-user-administrator/ (access mongo shell with `mongosh` to create an user)

After creating an user, please configure your `application.properties` file so that your application can connect to this user's database. Running `mvn spring-boot:run` should show that application connected to MongoDB on port 27017(stdout)

## [Import Data into MongoDB](https://hevodata.com/learn/mongoimport/)

To import the data into MongoDB for part 2, we recommend converting .dat files into .csv files. In our case we converted the .csv files sub-manually(using VSC's parrtern matching) but you can refer to some online guides for it (https://unix.stackexchange.com/questions/711205/how-to-convert-a-dat-files-with-comma-separated-values-into-a-csv-file)

To upload the corresponding databases, we used the `mongoimport` method with the correct format to load our csv files, you can refer to our commands in `run.sh`. Running the `mongoimport` command on the CLI should show that `n document(s) imported succesfully. 0 document(s) failed to import.` assuming that your csv file is well structured.

## [Query the database](https://www.mongodb.com/docs/manual/tutorial/query-documents/)

To do the query required by the milestone's handout, you can refer to [the official documentation of mongoDB](https://www.mongodb.com/docs/manual/tutorial/query-documents/), and [the documentation of Comparision Operators](https://www.mongodb.com/docs/manual/reference/operator/query-comparison/).

### MongoDB Shell
In this section, I'm going to explain how you can play arround with the command. To get started, you can type `mongosh` in the terminal to open up a MongoDB shell. Then, type `use cse364` to access the database named **cse364** that is imported from the `run.sh` file. 

In this database, there are three different collections:
1. user
1. rating
1. movie

### Query in spring-boot
There are several approaches to do the required query. To begin with, you can do it naively by querying all movies and ratings and then do a simple for loop to filter. However, this brute force approach is very slow.

To efficiently query the movies, you can utilize the `Aggregate`, and `Group` methods provided by mongoDB. You can refer to [this tutorial for more information](https://www.baeldung.com/spring-data-mongodb-projections-aggregations). Also, you can refer to our source code in the file [RatingServiceImpl.java](./src/main/java/com/example/service/RatingServiceImpl.java)

## [Setting up DockerFile and MongoDB in Docker Container](https://www.youtube.com/watch?v=eGz9DS-aIeY&ab_channel=NetworkChuck)

Be careful about setting up your Dockerfile, as well as dependencies in it. 
About setting up MongoDB in Docker Container, the steps is fairly similar with the process in our local Linux machine with a little twist regarding starting up the MongoDB service. Please refer to our Dockerfile for this matter. 

After getting the Dockerfile ready with its dependency, with MongoDB running, you should be ready to pull your source code. Remember to create an User Administratior in MongoDB. Here we do it with our shell script `run.sh` with a couple of commands. The import data process is similar to above. 

### To build and test your Dockerfile/Docker container: 
`$ docker build -t image_name /path/to/Dockerfile`
`$ docker run -it image_name` this command will create a temporary Docker container that will disappear as soon as you exit it.
### Therefore, we suggest a new way to test your Docker container because you need to open the Docker container in another terminal to test your `curl` commands:
`$ docker build -t image_name /path/to/Dockerfile`
`$ docker run -itd image_name` this command will preserve your container even if you exit it, and it allows you to enter the container in another terminal, access container with `$ docker exec -it container_id bash`. Check your `container_id` with `docker -ps a`.

---
# Description Of Each Package

## Controller

This package contains the controllers in the MVC architecture that controls the view of the client. There are three files

* [MovieController](./src/main/java/com/example/controller/MovieController.java)
    * One `GET` endpoint: `/{movie}` that returns the requested movie

* [RatingController](./src/main/java/com/example/controller/RatingController.java)
    * One `GET` endpoint: `/{rating}` that returns all movies that have average rating greater than or equal to `{rating}`.

* [UserController](./src/main/java/com/example/controller/UserController.java)
    * One `GET` endpoint: `/{id}` that returns the requested user information.
    * One `POST` endpoint that insert new user.
    * One `PUT` endpoint that updates the existing user.

All of them have expection check to handle errors.

## Exception

This package contains the definition of the exceptions which can be used to handle invalid input. There are three types of exceptions:

* [Object ID Exception](./src/main/java/com/example/exception/ObjectIdException.java): Should mean that the object ID is invalid, but in our code, we only use this when there is an error when saving a user.

* [Parameter Error Number Exception](./src/main/java/com/example/exception/ParameterErrorNumberException.java): This exception is thrown when an invalid **number** is entered as an input to our API.

* [Parameter Error String Exception](./src/main/java/com/example/exception/ParameterErrorStringException.java): This exception is thrown when an invalid **string** is entered as an input to our API.

## Model

This package contains the schemas of our database. There are four files:

* [Movie](./src/main/java/com/example/model/Movie.java): Movie collection

* [Rating](./src/main/java/com/example/model/Rating.java): Rating collection

* [Result](./src/main/java/com/example/model/Result.java): The `Result` object to check if the returned value is an error or not (I think we don't use this so you don't have to worry about this file).

* [User](./src/main/java/com/example/model/User.java): User collection

## Repositories

This package follows the standard implementation from [the official documentation](https://spring.io/guides/gs/accessing-data-mongodb/)