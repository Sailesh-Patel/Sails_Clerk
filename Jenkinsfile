pipeline {

    agent any
    stages {

        stage('Build'){
            steps{
                bat 'mkdir lib'
                bat 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'

            }
        }
    }

}
