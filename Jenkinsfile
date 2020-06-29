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
            
        echo 'Start docker services'
        sh """
            docker rm --force $(docker ps -aq)
            docker-compose up -d --build """
        }
}
