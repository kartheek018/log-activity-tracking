 pipeline {
     agent any

     stages {
         stage('mvn build') {
            agent{
                docker{
                    image 'maven:3.9-eclipse-temurin-21'
                }
            }
             steps {
                 echo 'Hello World'
                 sh 'mvn -version'
                 sh 'mvn clean compile'
             }
         }

        stage('Unit Tests') {
            agent {
                docker {
                    image 'maven:3.9-eclipse-temurin-21'
                }
            }
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            agent {
                docker {
                    image 'maven:3.9-eclipse-temurin-21'
                }
            }
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
