pipeline {
    agent any
    stages {
        stage("run tests") {
            step {
               bat "mvn test" 
            }
        }
    }
    post {}
}