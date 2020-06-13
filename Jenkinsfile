pipeline {
     agent {
                docker {
                    image 'arm64v8/openjdk:8u171-jdk-alpine3.8'
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
        stage('Deploy') {
            steps {
                sh 'cd deploy'
                sh 'kubectl apply -f .'
			}
		}
    }
}