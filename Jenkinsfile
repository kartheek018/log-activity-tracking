 pipeline {
    agent any

     stages {
         stage('mvn build') {
             steps {
                 echo 'Hello World'
                 sh 'mvn -version'
                 sh 'mvn clean compile'
             }
         }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }
        stage('Build docker image'){
            steps{
                sh '''
                    docker build -t kartheek018/activity-api:latest .
                '''
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )
                ]) {

                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin

                        docker push kartheek018/activity-api:latest
                    '''
                }
            }
        }
     }
 }