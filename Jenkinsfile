 pipeline {
    agent{
        docker{
            image 'maven:3.9-eclipse-temurin-21'
        }
    }

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
     }
 }
