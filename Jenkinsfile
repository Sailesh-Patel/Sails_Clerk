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
        stage("package") {
            steps {
                bat "npm pack"
            }
        }
        
    }
    post {
          always {
            archiveArtifacts artifacts: '*.tgz', followSymlinks: false
        }
    }
}
