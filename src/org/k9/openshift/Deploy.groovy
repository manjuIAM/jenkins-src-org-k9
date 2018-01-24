package org.k9.openshift

class Deploy implements Serializable {
  def config
  def script

  Deploy(script, config) {
    this.config = config
    this.script = script
  }

  void deployFromDimage() {
    this.script.stage('Deploying In OpenShift') {
	this.script.sh("oc new-app --docker-image=docker.io/amydocker/springboot:latest --name=" + this.config.appname + " -n " + this.config.namespace)
	this.script.sh("oc expose svc/springboot")
	//this.script.sh("oc new-app docker.io/amydocker/springboot:latest --name=springboot -n automata-daac")
    }
  }
}
