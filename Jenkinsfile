node {
  def app

  stage('Clone') {
	git 'https://github.com/Logik-Dev/dockerized-spring'
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
	step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: false])
	sh 'curl localhost'
  }

}
