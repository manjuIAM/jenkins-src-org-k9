package org.k9.scm
import org.k9.*

class Ocdeploy implements Serializable {
  def dockerimagename
  def appname
  def projectname

  Ocdeploy(dockerimagename,appname, projectname) {
    this.dockerimagename = dockerimagename
    this.appname = appname
    this.projectname = projectname
  }

  void deploy(){
    this.script.stage('Starting Deployment on OC')      
    this.script.sh(oc this.appname this.dockerimagename)
}