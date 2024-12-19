#!/bin/bash

# Set the absolute path to the root directory of your Spring Boot application
ROOT_DIR="D:/github/webapplication/app/"

# Set the path to the JAR file inside the project directory
JAR_PATH="$ROOT_DIR/build/libs/app-1.0.0.jar"

# Run the Spring Boot application
java -jar $JAR_PATH