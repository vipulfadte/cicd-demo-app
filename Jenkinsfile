pipeline {
     agent {
                docker {
                    image 'vipulfadtedev/arm64v8-jenkins-builder-openjdk8-mvn-docker-kubectl'
                    args '-v /docker_volumes/.m2:/.m2 -v /docker_volumes/.kube:/.kube -v /var/run/docker.sock:/var/run/docker.sock'
                }
     }
    stages {
        stage('Build') {
            steps {
                sh 'echo $HOME'
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
                sh 'pwd'
                sh 'ls -lart'
                sh 'ls -lart deploy'
                sh 'kubectl apply -f deploy/deployment.yml'
                sh 'kubectl apply -f deploy/service.yml'
                sh 'kubectl apply -f deploy/ingress.yml'
			}
		}
    }
}