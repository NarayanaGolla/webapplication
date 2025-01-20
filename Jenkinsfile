pipeline {
    agent any // Run on any available Jenkins agent

    environment {
        // Add any environment variables here
        MAVEN_HOME = tool 'Maven_3.8.1' // Use Maven configured in Jenkins
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out the code...'
                git branch: 'main', url: 'https://github.com/your-repo/sample-java-app.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh "${MAVEN_HOME}/bin/mvn package"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                sh 'cp target/sample-app.jar /path/to/deployment/directory/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }
    }
}