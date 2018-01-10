@Library("GIT_URL@BRANCH")_

GROOVY_FILE_NAME {
    giturl = 'https://github.com/spring-projects/spring-petclinic.git'
    branch = 'master'
    credentialsId = 'credentialsId'
    buildstep = './mvnw spring-boot:run'
    url = 'https://www.google.co.in/'
}
