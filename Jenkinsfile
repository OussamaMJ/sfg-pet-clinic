node{
  stage('SCM Ckeckout'){
    git 'https://github.com/OussamaMJ/sfg-pet-clinic'
  }
  stage('Compile-package'){
    sh 'mvn package'
  }
}
