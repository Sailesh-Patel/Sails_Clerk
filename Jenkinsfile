pipeline {

    agent any
    stages {

     stage("clean install") {
            steps {
               bat "mvn clean install" 
            }
        }
        stage("Folder"){
            steps{
                bat "ls"
            }
        }
                stage("Folder src"){
            steps{
                bat "cd src"
            }
        }
                stage("Test"){
            steps{
                bat "mvn test"
            }
        }
    }

}
