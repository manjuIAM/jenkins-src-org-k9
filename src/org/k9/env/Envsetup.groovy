package org.k9.env

class Envsetup implements Serializable {
  def config
  def script

  Envsetup(script,config) {
    this.config = config
    this.script = script
  }

  void tool() {
    this.script.stage('Environment Setup') {
        this.script.sh("echo '***********************ENV Setup Done***********************'")
    }
  }
}
