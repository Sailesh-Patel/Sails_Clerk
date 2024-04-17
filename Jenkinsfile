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
        stage("selenium test") {
            steps {
            bat 'java -cp target/selenium-1.0-SNAPSHOT.jar com.Inc.Project1.BE.selenium'
        }
        }
    
    }
    post {
          always {
            archiveArtifacts artifacts: 'src/test/java/com/Inc/Project1/BE/selenium/testfile.txt', followSymlinks: false
        }
    }
}
