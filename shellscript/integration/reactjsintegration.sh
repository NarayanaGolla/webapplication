#!/bin/bash

echo "Starting the script..."

set -e

# By default, in shell scripts, the shell continues executing subsequent
# commands even if one command fails. Using set -e ensures that the script
# stops executing at the point of the failure. This is useful in situations
# where you want to ensure the script does not proceed if something goes wrong.

# Check if the first argument is provided, otherwise use a default
if [ -z "$1" ]; then
  echo "No argument passed for the file. Using default'"
  REACT_DIR=${1:-"/d/github/webapplication/cogreactjs"}
else
  REACT_DIR=${1:-"/d/github/webapplication/cogreactjs"}
  echo "Using provided argument: $REACT_DIR"
fi

# Variable
# Navigate to the React project directory
#REACT_DIR="/d/github/webapplication/cogreactjs"
# Assign arguments with defaults
#REACT_DIR=${1:-"/d/github/webapplication/cogreactjs"}
SPRING_RESOURCES_DIR=${2:-"/d/github/webapplication/app/src/main/resources"}
SPRING_PROJECT_DIR=${3:-"/d/github/webapplication"}
DEBUG_PORT=${4:-5006}

# Print the values
echo "Argument 1: $REACT_DIR"
echo "Argument 2: $SPRING_RESOURCES_DIR"