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
        this.script.sh('docker login https://registry.hub.docker.com -u amydocker -p @mitabh.91')
            this.script.sh("docker tag maven:springboot amydocker/maven:springboot")
            this.script.sh("docker push amydocker/maven:springboot")
    }
  }
}
