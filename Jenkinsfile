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
             }
         }
     }
 }
