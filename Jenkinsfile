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
                bat 'src\test\java\com\Inc\project1\BE ; java -jar "." --select-class AddItemDeleteBETesting'
                junit 'src/reports/*-jupiter.xml'
            }
        }
    }

}
