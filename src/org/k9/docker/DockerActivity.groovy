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
        sleep 1000;
        this.script.sh('/usr/bin/docker build -t maven:springboot .')
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
