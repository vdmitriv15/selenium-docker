pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Build Image') {
            steps {
                bat "docker build -t=vdmitriv/selenium ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_HUB_USR',
                    passwordVariable: 'DOCKER_HUB_PSW'
                )]) {
                    bat '''
                        docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%
                        docker push docker.io/vdmitriv/selenium
                    '''
                }
            }
        }
    }

    post {
        always {
            bat "docker logout"
            bat "docker system prune -f"
        }
    }
}