pipeline {
  agent none
  options {
    copyArtifactPermission('*');
    skipDefaultCheckout true
  }
  triggers { pollSCM '@monthly' }
  stages {
    stage('Ant Build') {
      agent { label 'ant' }
      tools {
        ant 'Ant 1.10.14'
        jdk 'JDK 1.8'
      }
      steps {
        checkout scm
        sh 'ant -f ant.xml'
        recordIssues enabledForFailure: true, tool: java(), unhealthy: 10
        archivePlugin 'runsafe', '../build/jar/*.jar,../lib/*,../lua', 'framework.tar'
      }
    }
    stage('Deploy to test server') {
      agent { label 'server4' }
      steps { installPlugin 'framework.tar' }
    }
  }
  post { always { buildReport 'Framework' } }
}
