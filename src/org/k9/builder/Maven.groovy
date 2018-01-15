package org.k9.builder

class Maven implements Serializable {
  def config
  def script

  Maven(script,config) {
    this.config = config
    this.script = script
  }

  void mbuild() {
    this.script.stage('Build Artifcat') {
           this.script.sh("mvn clean install")
    }
  }
}
