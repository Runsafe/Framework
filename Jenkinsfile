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
        scanForIssues tool: java()
        archivePlugin(
          targetFolder: 'runsafe',
          artifacts: '../build/jar/*.jar,../lib/*,../lua',
          archive: 'framework.tar'
        )
        recordIssues enabledForFailure: true, tool: java(), unhealthy: 10
        buildReport 'Framework'
      }
    }
    stage('Deploy to test server') {
      agent { label 'server4' }
      steps {
        unstash 'archive'
        sh 'mkdir -p ~/bukkit/plugins'
        sh 'tar -xvf framework.tar -C ~/bukkit/plugins'
      }
    }
  }
}
