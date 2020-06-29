node {
    stage('Clone') {
        echo 'Clone backend'
        git 'https://github.com/Logik-Dev/dockerized-spring'
    }
    stage('Copy') {
        echo 'Copying static files'
        sh 'mkdir -p src/main/resources/static'
        sh """ cp $JENKINS_HOME/workspace/FrontEnd/dist/angular-dockerized/* src/main/resources/static """
    }
    stage('Build') { 
        echo 'Make jar'
        sh 'gradle build'
            
        echo 'Delete all containers'
        sh 'docker rm --force $(docker ps -aq)'

	echo 'Launch containers'
        sh 'docker-compose up -d --build'
    }
}
