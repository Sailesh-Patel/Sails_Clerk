pipeline {

    agent any
    stages {

     stage("clean install") {
            steps {
               bat "mvn clean install" 
            }
        }
        stage("Test"){
            steps{
                bat "mvn AddItemDeleteBETesting"
            }
        }
    }

}
