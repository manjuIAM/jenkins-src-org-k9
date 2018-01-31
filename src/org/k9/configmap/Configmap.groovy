package org.k9.openshift
import org.k9.*

class Configmap implements Serializable {
  def config
  def script

  Configmap(script, config) {
    this.config = config
    this.script = script
  }

  void createconfigmap() {

      if (this.config.cmurl != 'none') {
        this.config.cmurl = cmurl
        if ( this.config.cmbranch != 'none' ) {
          this.config.cmbranch = cmbranch
          this.script.stage('Clone and deploy ConfigMap') {
            scm.Git(this.config,this.script).checkout(url=this.config.cmurl,branch=this.config.cmbranch)

            // new configmap.Configmap(this,param).createconfigmap()

          }

        } else {
          error "No ConfigMap github branch specified or branch doesn't exist"
        }
      } else {
        error "No ConfigMap git url specified"
      }

    }
  }
}
