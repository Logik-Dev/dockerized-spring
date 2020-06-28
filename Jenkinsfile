node {
    stage('Clone Frontend') {

        dir('angular') {

            echo 'Clone Frontend'
            git 'https://github.com/Logik-Dev/angular-dockerized'
            
            echo 'Install angular cli'
            sh 'npm install @angular/cli'
            
            echo 'Build FrontEnd'
            sh 'ng build --prod=true'
        
        }

    }
    stage('Clone Backend') {

        dir('spring'){

            echo 'Clone backend'
            git 'https://github.com/Logik-Dev/dockerized-spring'
        }
    }
    stage('Build Backend') { 

       dir('spring'){

            echo 'Copying static files'
            sh """
                mkdir -p src/main/resources/static
                cp ${env.WORKSPACE}/angular/dist/angular-dockerized/* src/main/resources/static """
            
            echo 'Make jar'
            sh 'gradle build'
            
            echo 'Start docker services'
            sh """
                docker-compose up -d --build
                sleep 10
                curl localhost """
        }
    }
}
