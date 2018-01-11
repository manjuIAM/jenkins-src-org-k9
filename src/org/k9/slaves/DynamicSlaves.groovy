package org.k9.slaves

class DynamicSlaves implements Serializable {
  def config
  def script

  DynamicSlaves(script,config) {
    this.config = config
    this.script = script
  }

  void createPod() {
      this.script.sh(this.config.buildstep.trim())
  }
}
