pipeline {
  agent { label 'ant' }
  stages {
    stage('Ant Build') {
      steps {
        withAnt(installation: 'Ant 1.10.14', jdk: 'JDK 1.8') {
          sh "ant -f ant.xml"
        }
        archiveArtifacts artifacts: 'build/jar/*.jar, lib/*', followSymlinks: false, onlyIfSuccessful: true
      }
    }
  }
}
