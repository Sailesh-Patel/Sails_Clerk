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
bat 'xcopy "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Sails_Clerk\\Frontend\\build\\static" "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Sails_Clerk\\src\\main\\resources\\static" /E /H /K /Y'
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
