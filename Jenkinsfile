pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
                steps {
                    sh 'docker build -t vipulfadtedev/cicd-demo-app .'
                    sh 'docker push vipulfadtedev/cicd-demo-app:latest'
                }
            }
        }
        stage('Deploy') {
                  steps {
                            sh 'cd deploy'
                            sh 'kubectl apply -f .'
                        }
                    }
                }
}