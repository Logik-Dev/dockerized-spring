node {
    def image
    stage('Clone') {
        scm checkout
    }
    stage('Copy static files') {
        sh 'mkdir -p src/main/resources/static'
        sh """ cp $JENKINS_HOME/workspace/FrontEnd/dist/angular-dockerized/* src/main/resources/static """
    }
    stage('Build jar') {
        sh 'gradle build'
    }
    stage('Build Image') {
        image = docker.build("logikdevfr/spring")
    }
    stage('Push Image') {
        docker.withRegistry('https://registry.hub.docker.com', 'DockerHub') {
            image.push("${env.BUILD_ID}")
            image.push("latest")
        }
    }
}
