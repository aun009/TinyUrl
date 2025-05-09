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
                    def dockerCmd = "docker run -p 8080:8080 -d arun2232/spring-boot-url-shortener:1.0"

                    sshagent(['jenkins-aws-1']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@15.207.100.199 ${dockerCmd}"
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
