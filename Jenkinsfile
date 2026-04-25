pipeline {
    agent any
    stages {
        stage('Build & Deploy') {
            steps {
                sh 'docker-compose up --build -d --scale api=3'
            }
        }
    }
    post {
        failure {
            sh 'docker-compose down'
        }
    }
}
