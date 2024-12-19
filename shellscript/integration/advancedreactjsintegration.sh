#!/bin/bash
#Completely automated public Turing test CAPTCHA

echo "Starting the script..."
echo "Exit status of last command: $?"  # Should be 0 because `echo` was successful

echo "Script's directory: $(dirname "$0")"
# when you want to find the directory where the script resides, regardless of where the script is run from.
echo "Provided argument's directory: $(dirname "$1")"
# This is used to extract the directory of a file or path provided as an argument to the script.
# ./script.sh /home/user/example/file.txt

set -e

# By default, in shell scripts, the shell continues executing subsequent
# commands even if one command fails. Using set -e ensures that the script
# stops executing at the point of the failure. This is useful in situations
# where you want to ensure the script does not proceed if something goes wrong.

# Get the directory where the script is located
SCRIPT_DIR=$(dirname "$0")
echo "Looking for config.properties at: $SCRIPT_DIR/config.properties"

if [[ -f $SCRIPT_DIR/config.properties ]]; then
    # Source the config file from the script's directory
    source "$SCRIPT_DIR/config.properties"
else
    echo "Error: config.properties file not found!"
    exit 1
fi



# Access the properties
echo "Starting $APP_NAME on port $APP_PORT with log level $LOG_LEVEL"

# Function to find an available port
# /dev/null 2>&1
# the expression /dev/null 2>&1 is commonly used in shell commands to manage output streams,
# particularly for redirecting or discarding output.

find_available_port() {
  local port=$1
  local max_attempts=5  # Maximum number of attempts to find an available port
  local attempts=0

  while lsof -i:$port >/dev/null 2>&1 && ((attempts < max_attempts)); do
    port=$((port+1))
    attempts=$((attempts+1))
  done

  if ((attempts >= max_attempts)); then
    echo "Error: No available port found after $max_attempts attempts."
    return 1  # Indicate failure
  fi

  echo $port
}

# Default values
REACT_DIR="/d/github/webapplication/cogreactjs"
SPRING_RESOURCES_DIR="/d/github/webapplication/app/src/main/resources"
SPRING_PROJECT_DIR="/d/github/webapplication"
# Find an available debug port starting from 5005
#The $? in a shell script  is a special variable that holds the exit status of the last executed command.
# This exit status is a number that represents the success or failure of the command.
DEBUG_PORT=$(find_available_port 5006)
if [ $? -eq 0 ]; then
  echo "Found available port: $DEBUG_PORT"
else
  echo "Failed to find an available port."
fi

#If you want to provide named options like -a or -b, you can use getopts:
# ./example_with_getopts.sh -a Value1 -b Value2
# Negative scenario = ./script.sh -n

# Parse options
while getopts "a:b:c:d" opt; do
  case $opt in
    a) REACT_DIR="$OPTARG" ;;
    b) SPRING_RESOURCES_DIR="$OPTARG" ;;
    c) SPRING_PROJECT_DIR="$OPTARG" ;;
    d) DEBUG_PORT="$OPTARG" ;;
   # *) echo "Invalid option"; exit 1 ;;
    *) echo "Usage: $0 [-a REACT_DIR] [-b SPRING_RESOURCES_DIR]"; exit 1 ;;
  esac
done

# Print the values
echo "Argument 1: $REACT_DIR"
echo "Argument 2: $SPRING_RESOURCES_DIR"
echo "Argument 3: $SPRING_PROJECT_DIR"
echo "Argument 4: $DEBUG_PORT"

if [ ! -d "$REACT_DIR" ]; then
  echo "Directory not found: $REACT_DIR"
  exit 1
fi

cd "$REACT_DIR" || { echo "Failed to change directory to $REACT_DIR"; exit 1; }

# Check if npm is available
if ! command -v npm &> /dev/null; then
  echo "npm is not installed or not in PATH"
  exit 1
fi

# Build the React application
if ! npm run build; then
  echo "React build failed"
  exit 1
fi

# Wait for 5 seconds
echo "Waiting for 5 seconds..."
sleep 5

# Navigate to the Spring Boot resources directory
if [ ! -d "$SPRING_RESOURCES_DIR" ]; then
  echo "Directory not found: $SPRING_RESOURCES_DIR"
  exit 1
fi

cd "$SPRING_RESOURCES_DIR" || { echo "Failed to change directory to $SPRING_RESOURCES_DIR"; exit 1; }

# Remove the existing 'public' directory and create a new one
if [ -d "public" ]; then
  if ! rm -r public; then
    echo "Failed to remove existing 'public' directory"
    exit 1
  fi
fi

if ! mkdir public; then
  echo "Failed to create 'public' directory"
  exit 1
fi

# Copy the React build output to the new 'public' directory
if ! cp -r "$REACT_DIR/build/"* public/; then
  echo "Failed to copy React build output"
  exit 1
fi

# Navigate to the Spring Boot project directory
if [ ! -d "$SPRING_PROJECT_DIR" ]; then
  echo "Directory not found: $SPRING_PROJECT_DIR"
  exit 1
fi

cd "$SPRING_PROJECT_DIR" || { echo "Failed to change directory to $SPRING_PROJECT_DIR"; exit 1; }


# Check if gradlew is available
if ! command -v ./gradlew &> /dev/null; then
  echo "Gradle Wrapper (./gradlew) is not found or not executable"
  exit 1
fi

# Run the Spring Boot application with debugging enabled using Gradle Wrapper
if ! ./gradlew clean bootRun -Dorg.gradle.jvmargs="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=*:5006"; --stacktrace --info; then
  echo "Failed to run Spring Boot application with debugging on port $DEBUG_PORT"
  exit 1
fi

echo "Spring Boot application started with JDWP debugging on port $DEBUG_PORT"