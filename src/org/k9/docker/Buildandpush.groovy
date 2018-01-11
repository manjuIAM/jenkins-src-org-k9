package org.k9.scm
import org.k9.*

class BuildDockerImage implements Serializable {
  def dockerimageurl
  def projectname
  def dockerimagebranch

  BuildDockerImage(dockerimageurl, projectname, dockerimagebranch) {
    this.dockerimageurl = dockerimageurl
    this.projectname = projectname
    this.dockerimagebranch = dockerimagebranch
  }

  void buildandpushDocker(){
    this.script.stage('Pulling Docker Image')   
    new scm.Git(this,config).checkout(this.dockerimageurl,this.dockerimageurl);
    this.script.stage('Building and Pushing Docker Image to OCR')   
    this.script.sh('docker build -t springboot-app .')
    this.script.sh('docker tag springboot-app 172.19.1.1.:5000/springboot-app/springboot-app')
    this.script.sh('docker push 172.19.1.1.:5000/springboot-app/springboot-app')
    //format: openshift cluster ip/projectname/app name
    //this.script.sh('docker build .')

  }
