pipeline {
  agent none
  options {
    copyArtifactPermission('*');
    skipDefaultCheckout true
  }
  environment { plugin = "Framework" }
  triggers {
    pollSCM '@monthly'
  }
  stages {
    stage('Ant Build') {
      agent { label 'ant' }
      tools {
        ant 'default'
        jdk 'default'
      }
      steps {
        checkout scm
        sh 'ant -f ant.xml'
        recordIssues enabledForFailure: true, tool: java(), unhealthy: 10
        archivePlugin 'runsafe', 'build/jar/*.jar,lib/*,lua', 'framework.tar'
      }
    }
    stage('Deploy to test server') {
      when { not { branch 'master' } }
      agent { label 'server4' }
      steps {
        installPlugin "${env.plugin}.tar"
        buildReport env.plugin, 'Deployed to test server'
      }
    }
    stage('Deploy to production') {
      when { branch 'master' }
      agent { label 'server1' }
      steps {
        stagePlugin "${env.plugin}.tar"
        buildReport env.plugin, 'Staged on production server'
      }
    }
  }
  post { failure { buildReport env.plugin, 'Build failed' } }
}
