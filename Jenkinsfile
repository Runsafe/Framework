pipeline {
  agent { label 'kubeagent' }
  stages {
    stage('Debug') {
      steps {
        sh 'ant -version'
	      sh 'java -version'
	      sh 'git --version'
      }
    }
    stage('Ant Build') {
      steps {
        checkout scm
        sh 'ant'
      }
    }
  }
}
