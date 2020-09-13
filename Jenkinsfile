node{
  stage('SCM Ckeckout'){
    git 'https://github.com/OussamaMJ/sfg-pet-clinic'
  }
  stage('Compile-package'){
    sh 'mvn package'
  }
  stage('Email Notification'){
    mail bcc: '', body: 'Hello After Build', cc: '', from: '', replyTo: '', subject: '', to: 'oussama.mjihil@gmail.com'
  }
}
