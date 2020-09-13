properties([parameters([choice(choices: ['master', 'sfg-pet-clinic-mongo'], description: 'Select Branch To Build', name: 'branch')])])
node{
  stage('SCM Ckeckout'){
    echo "Pulling From Branch ${params.branch}"
    git url: 'https://github.com/OussamaMJ/sfg-pet-clinic', branch: "${params.branch}"
  }
  stage('Compile-package'){
    sh 'mvn package'
  }
  stage('Email Notification'){
    mail bcc: '', body: 'Hello After Build', cc: '', from: '', replyTo: '', subject: 'Jenkings After Buils Email', to: 'oussama.mjihil@gmail.com'
  }
}
