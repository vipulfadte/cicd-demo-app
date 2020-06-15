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
                sh 'mvn clean install -Dmaven.repo.local=/.m2/repository'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t vipulfadtedev/cicd-demo-app:latest .'
                sh 'docker push vipulfadtedev/cicd-demo-app:latest'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deploy/deployment.yml'
                sh 'kubectl apply -f deploy/service.yml'
                sh 'kubectl apply -f deploy/ingress.yml'
            }
        }
    }
}