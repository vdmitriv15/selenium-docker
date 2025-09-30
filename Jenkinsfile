pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                bat "mvn clean package -DskipTest"
            }
        }

        stage('Build Image'){
            steps{
                bat "docker build -t=vdmitriv/selenium"
            }
        }

        stage('Push Image'){
            steps{
                echo "docker push vdmitriv/selenium"
            }
        }
    }

}