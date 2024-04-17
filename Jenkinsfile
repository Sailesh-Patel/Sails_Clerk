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
        stage('Selenium Test') {
            steps {
                dir('front') {
                  bat 'npm run build'
                  bat 'xcopy /y /i build c:\\reactApp'
                }
                // bat 'appcmd add site /name:myapp /id:2 /physicalPath:c:\\reactApp /bindings:http/*:3000:'
                withMaven(maven: 'M3') {
                  bat 'mvn clean install'
                }
                bat 'java -cp target/selenium-1.0-SNAPSHOT.jar com.qa.selenium.SeleniumTests'
            }
        }
    
    }
    post {
          always {
            archiveArtifacts artifacts: 'src/test/java/com/Inc/Project1/BE/selenium/testfile.txt', followSymlinks: false
        }
    }
}
