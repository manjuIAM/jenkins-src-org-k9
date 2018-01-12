package org.k9.builder

class Maven implements Serializable {
  def config
  def script

  Maven(script,config) {
    this.config = config
    this.script = script
  }

  void build() {
    this.script.stage('Build Artifcat') {
       if (this.config.testis_required == false) {
           this.script.sh(this.config.buildstep.trim())
       } else {
           this.script.sh(this.config.buildstep)
       }
    }
  }
}
