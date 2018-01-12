package org.k9.docker

class DockerActivity implements Serializable {
  def config
  def script

  DockerActivity(script, config) {
    this.config = config
    this.script = script
  }

  void build() {
    this.script.stage('Building Image') {
        this.script.sh('docker build -t maven:springboot -f maven.docker resources/org/k9/docker/')
    }
  }

  void dpush() {
    this.script.stage('Pushing Image') {
        this.script.docker.withRegistry('https://registry.hub.docker.com', 'dlogin') {
            docker.image('maven').push('springboot')
        }
    }
  }
}
