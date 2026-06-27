pipeline {
    agent {
        docker {
            image 'my-jenkins-agent:latest'
            args '''
            -e DOCKER_HOST=tcp://docker:2376
            -e DOCKER_TLS_VERIFY=1
            -e DOCKER_CERT_PATH=/certs/client
            -v /certs/client:/certs/client
            '''
        }
    }

    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage('Docker Deploy') {
            steps {
                sh '''
                    docker compose down || true
                    docker compose up --build -d
                '''
            }
        }
    }
}