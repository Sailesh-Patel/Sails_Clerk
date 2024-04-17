pipeline {
    agent any
    stages {
         stage("clean install") {
            steps {
               bat "mvn clean install" 
            }
        }
         stage("springboot") {
            steps {
               bat "mvn spring-boot:run" 
            }
        }
        stage("run tests") {
            steps {
               bat "mvn test" 
            }
        }
    }
    post {
        always {
        echo "Test outcome" > Test.txt
        }
    }
}
