package org.k9.docker

class DockerActivity {
  def config
  def script

  DockerActivity(script, config) {
    this.config = config
    this.script = script
  }

  void build() {
    this.script.stage('Building Image') {
        def request = libraryResource "org/k9/docker/maven.docker"
        this.script.sh('docker build -t maven:springboot -f '+ request)
  }
}
}
