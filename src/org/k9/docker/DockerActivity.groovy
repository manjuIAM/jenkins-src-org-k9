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
        this.script.sh('docker build -t maven:springboot -f resources/org/k9/docker/maven.docker')
  }
}
}
