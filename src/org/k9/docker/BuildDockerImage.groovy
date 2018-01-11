package org.k9.scm
import org.k9.*

class BuildDockerImage {
  // def dockerimageurl
  // def projectname
  // def dockerimagebranch
  // ocregistry, appname, projectname,

  def config
  def script

  BuildDockerImage(script, config) {
    this.config = config
    this.script = script
  }

  void buildandpushDocker(){
    this.script.stage('Building & Deploying Docker Image') {
    new scm.Git(this,config).checkout(this.config.dockerimageurl, this.config.dockerimagebranch);
    // this.script.stage('Building and Pushing Docker Image to OCR')
  //  this.script.sh('docker build -t springboot-app .')
    this.script.sh('docker build -t this.config.appname .')
    // this.script.sh('docker tag springboot-app 172.19.1.1:5000/springboot-app/springboot-app')
    this.script.sh('docker tag this.config.appname this.config.ocregistry/this.config.appname')
    // this.script.sh('docker push 172.19.1.1:5000/springboot-app/springboot-app')
    this.script.sh('docker push this.config.ocregistry')
  }
    //format: openshift cluster ip/projectname/app name
    //this.script.sh('docker build .')

  }
