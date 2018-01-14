package org.k9.docker

class DockerActivity implements Serializable {
  def config
  def script
  def dbuild

  DockerActivity(script, config) {
    this.config = config
    this.script = script
  }

  void build() {
    this.script.stage('Building Image') {
        this.dbuild = this.script.docker.build('maven:springboot', '.')
    }
  }

  void dpush() {
    this.script.stage('Pushing Image') {
        this.script.docker.withRegistry('https://registry.hub.docker.com', 'dlogin') {
            this.dbuild.(this.script.push('springboot'))
        }
    }
  }
}
