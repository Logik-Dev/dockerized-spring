node {

  stage('Clone') {
    git 'https://github.com/Logik-Dev/dockerized-spring'
  }
  stage('Gradle Build') {
    sh 'gradle build'
  }

  stage('Docker Compose') {
    sh 'docker-compose up -d --build'    
  }
  stage('Test Working') {
    sh 'curl localhost:80'
  }

}
