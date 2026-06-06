node {
    checkout scm
    docker.image('node:16-buster-slim').inside('-p 3000:3000') {
        stage('Build') {
            sh 'npm install'
        }
        stage('Test') {
            sh 'bash ./jenkins/scripts/test.sh'
        }
        stage('Deploy') {
            sh 'bash ./jenkins/scripts/deliver.sh'
            sh 'sleep 60'
            sh 'bash ./jenkins/scripts/kill.sh'
        }
    }
}
