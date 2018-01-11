pipeline {
    agent any
    tools {
    maven 'maven'
  }
    stages {
        stage('Back-end') {
            steps {
                git 'https://github.com/safirh/petclinic.git'
            }
        }
        stage('maven') {
            steps {
                sh 'mvn clean install -DskipTests=true'
                
            }
        }
        stage('maven Upload') {
            steps {
                sh 'curl -v -u admin:admin123 --upload-file target/*.jar http://104.198.70.215:8081/repository/demo/'
                
            }
        }
        stage('maven Download ') {
            steps {
                sh 'curl -o springboot.jar -u admin:admin123 http://104.198.70.215:8081/repository/demo/spring-petclinic-1.5.1.jar'
            }
        }
    }
}
