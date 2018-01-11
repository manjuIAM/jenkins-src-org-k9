package org.k9.docker

class DockerActivity {
  def config
  def script

  DockerActivity(script, config) {
    this.config = config
    this.script = script
  }

  void buil() {
    this.script.stage('Building Image') {
        def request = libraryResource 'org/k9/dockerfile/'+this.config.env
        this.script.sh('docker build -t '+  +' .')
  }
}
