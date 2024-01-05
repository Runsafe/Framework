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
        dir('artifacts') {
          sh 'rm -rf runsafe'
          sh 'mkdir -p runsafe'
          sh 'cp -a ../build/jar/*.jar runsafe/'
          sh 'cp -a ../lib/* runsafe/'
          sh 'cp -a ../lua runsafe/'
          sh 'tar -cvf framework.tar runsafe'
          archiveArtifacts artifacts: 'framework.tar', onlyIfSuccessful: true
          stash includes: 'framework.tar', name: 'archive'
        }
        recordIssues enabledForFailure: true, tool: java(), unhealthy: 10
        discordSend description: 'Build finished', enableArtifactsList: true, footer: '', image: '', link: env.BUILD_URL, result: currentBuild.currentResult, scmWebUrl: '', showChangeset: true, thumbnail: '', title: env.JOB_NAME, webhookURL: env.DISCORD_WEBHOOK
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
