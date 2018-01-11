package org.k9.scm
import org.k9.*

class Ocdeploy {
  //def dockerimagename
  //def appname
  //def projectname
  def config
  def script

  Ocdeploy(script, config) {
      this.config = config
      this.script = script
    }

  void deploy(){
    this.script.stage('Starting Deployment on OC') {
    this.script.sh('oc this.config.appname this.config.dockerimagename')
  //  this.script.sh('oc this.appname this.dockerimagename')
    }
}
