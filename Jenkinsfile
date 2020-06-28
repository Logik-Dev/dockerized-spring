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
     ./wait-for-it.sh localhost:80 --timeout=30 
     curl localhost
     docker-compose down
	"""   
    
  }

}
