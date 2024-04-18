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
                bat 'cd src/test/java/com/Inc/project1/BE ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class AddItemDeleteBETesting'
                junit 'src/reports/*-jupiter.xml'
            }
        }
    }

}
