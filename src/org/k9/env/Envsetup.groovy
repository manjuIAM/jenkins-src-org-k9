package org.k9.builder

class Maven implements Serializable {
  def config
  def script

  Maven(script,config) {
    this.config = config
    this.script = script
  }

  void build() {
    this.script.stage('Environment Setup') {
        this.script.sh("echo '***********************ENV Setup Done***********************'")
    }
  }
}
