pipeline {
    agent any
    stages {
         stage("clean install") {
            steps {
               bat "mvn clean install" 
            }
        }
        stage("run tests") {
            steps {
               bat "mvn test" 
            }
        }
             stage("build artifact") {
            steps {
               sh 'echo "Test successful" > Success.txt'
            }
        }
    }
    post {
        always {
          'Success.txt'
        }
    }
}
