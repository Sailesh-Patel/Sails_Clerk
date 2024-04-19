pipeline {
    agent any
    stages {
        stage("npm install") {
            steps {
                dir('Frontend') {
               bat "npm install" 
                }
            }
        }
                stage("npm run build") {
            steps {
                dir('Frontend') {
               bat "npm run build" 
                }
            }
        }
                stage("xcopy") {
            steps {
                  dir('Frontend') {
               bat "xcopy /y /i build c:\\reactApp" 
                  }
            }
        }
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
