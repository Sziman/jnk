@Library('devops_shared')
pipeline {
    agent {
        node{
            label 'shahar_jnk'
        }
    }
    stages {

        stage('checkout'){
        steps{
            checkout ([$class: 'GitSCM', 
            branches: [[name: '*/main']],
            extensions: [],
            userRemoteConfigs: [[credentialsId: 'shahar_jnk', url: 'git@gitlab.rafael.co.il:devops/jenkins_test.git']]])

        }
    }
       stage('Build and Run Docker Image') {
            steps {
                script {
                    // Define the Dockerfile path
                    def dockerfilePath = '${WORKSPACE}/Dockerfile'
                    // def dockerfilePath = '/home/shaharzi/Documents/git_tutorial/tst/jenkins_test/Dockerfile'
                    sh 'echo $(pwd)'
                    
                    // Build the Docker image
                    def customImage = docker.build("myApp", "-f ${dockerfilePath} .")
                    sh 'echo $(myApp)'
                    
                    // Run a container from the built image
                    customImage.inside {
                        // Commands to run inside the Docker container
                        sh 'echo "Running inside Docker container"'
                        // Add more commands as needed
                    }
                }
            }
        }
    }
}
