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
           this.script.sh(this.config.buildstep.trim() + '-Dmaven.test.skip='this.config.testis_required)
       } else {
           this.script.sh(this.config.buildstep.trim())
       }
    }
  }
}
