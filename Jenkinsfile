pipeline {
    agent {
        docker {
            image 'vipulfadtedev/arm64v8-jenkins-builder-openjdk8-mvn-docker-kubectl'
            args '-v /docker_volumes/mvn:/root -v /var/run/docker.sock:/var/run/docker.sock'
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