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
    }
    post {
          always {
            archiveArtifacts artifacts: 'src/test/java/com/Inc/Project1/BE/selenium/testfile.txt', followSymlinks: false
        }
    }
}
