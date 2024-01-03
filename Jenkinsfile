pipeline {
  agent { label 'ant' }
  options { copyArtifactPermission('*'); }
  triggers { pollSCM '@monthly' }
  stages {
    stage('Ant Build') {
      steps {
        withAnt(installation: 'Ant 1.10.14', jdk: 'JDK 1.8') {
          sh "ant -f ant.xml"
        }
        sh "tar -cvf framework.tar build/jar/*.jar lib/*"
        archiveArtifacts artifacts: 'framework.tar', onlyIfSuccessful: true
      }
    }
  }
}
