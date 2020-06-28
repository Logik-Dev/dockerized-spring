node {

  stage('Clone') {
    git 'https://github.com/Logik-Dev/dockerized-spring'
  }
  stage('Gradle Build') {
    sh 'gradle build'
  }
  stage('Docker Compose') {
    sh """
     docker-compose up -d --build
     ./wait-for-it.sh --timeout=30 localhost
     curl localhost
     docker-compose down
	"""   
    
  }

}
