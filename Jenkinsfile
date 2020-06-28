node {
  def app

  stage('Clone') {
	checkout scm
  }
  stage('Gradle Build') {
	withGradle {
		sh './gradlew build'
	}
  }
  stage('Build Image'){
	app = docker.build("logikdev/spring")
  }
  stage('Test Image') {
	docker.image("logikdev/spring").withRun('-p 80:8080') {
		c -> 
		sh 'docker ps'
		sh 'curl localhost'
	}
  }
}
