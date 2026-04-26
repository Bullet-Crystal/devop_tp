pipeline {
	agent any
		stages {
			stage('Build & Deploy') {
				steps {
					withCredentials([
							file(credentialsId: 'env-mysql-file', variable: 'MYSQL_ENV_FILE'),
							file(credentialsId: 'env-api-file',   variable: 'API_ENV_FILE')
					]) {
						sh '''

							docker compose down
							cp $MYSQL_ENV_FILE .env.mysql
							cp $API_ENV_FILE   .env.api
							docker compose up -d --build --scale api=3
							'''
					}
				}
			}
		}
	post {
		failure {
			sh 'docker compose down'
		}
	}
}
