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
        archivePlugin 'runsafe', 'build/jar/*.jar,lib/*,lua', 'framework.tar'
      }
    }
    stage('Deploy to test server') {
      agent { label 'server4' }
      steps {
        installPlugin 'framework.tar'
        buildReport 'Framework', 'Deployed to test server'
      }
    }
    stage('Ask for promotion') {
      steps {
        build wait: false, job: '/Runsafe/Deployment/main', parameters: [string(name: 'project', value: currentBuild.fullProjectName), string(name: 'build', value: env.BUILD_NUMBER)]
      }
    }
  }
  post { failure { buildReport 'Framework', 'Build failed' } }
}
