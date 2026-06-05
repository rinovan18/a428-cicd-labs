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
            input message: 'Aplikasi berjalan di http://localhost:3000. Klik Proceed setelah selesai mencoba.'
            sh 'bash ./jenkins/scripts/kill.sh'
        }
    }
}
