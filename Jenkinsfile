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
               bat 'echo' "artifact file" > generatedFile.txt 
            }
        }
    }
    post {
        always {
          archiveArtifacts artifacts: 'generatedFile.txt', onlyIfSuccessful: true
        }
    }
}
