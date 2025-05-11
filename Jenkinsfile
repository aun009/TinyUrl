#!/usr/bin/env groovy

pipeline {
    agent any  // Runs the pipeline on any available agent

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                // Add your build commands here (e.g., mvn clean install, npm build)
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Run your test commands here
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add deploy logic (e.g., scp, kubectl, ssh deploy scripts)

                script {

                    // Example of using SSH to deploy   
//                     def dockerCmd = "docker run -p 8080:8080 -d arun2232/spring-boot-url-shortener:latest"
//                         def dockerComposeCmd = "docker-compose -f compose.yaml up -d --build --detach"
                        def shellCmd = "bash ./server-cmd.sh"

                    sshagent(['jenkins-aws-1']) {
                        sh "scp server-cmd.sh ubuntu@13.203.78.180:/home/ubuntu" // should be there on ec2
                        sh "scp docker/compose.yaml ubuntu@13.203.78.180:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@13.203.78.180 ${shellCmd}"
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
