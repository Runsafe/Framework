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
        sh "tar -cvf framework.tar -C build/jar/ ."
        sh "tar -rvf framework.tar -C lib/ ."
        archiveArtifacts artifacts: 'framework.tar', onlyIfSuccessful: true
        discordSend description: 'Build finished', enableArtifactsList: true, footer: '', image: '', link: env.BUILD_URL, result: 'SUCCESS', scmWebUrl: '', showChangeset: true, thumbnail: '', title: env.JOB_NAME, webhookURL: env.DISCORD_WEBHOOK
      }
    }
  }
}
