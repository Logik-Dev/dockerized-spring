node {

  stage('Clone') {
    git 'https://github.com/Logik-Dev/dockerized-spring'
  }
  stage('Gradle Build') {
    sh 'gradle build'
  }
  stage('Docker Compose') {
    sh """
     echo 'Launching services'
     docker-compose up -d --build
     
     echo 'Waiting for localhost'
     sleep(10)
	
     echo 'Testing localhost'
     curl localhost

     echo 'Kill services'
     docker-compose down
	"""   
    
  }

}
