package org.k9.scm
import org.k9.*

class Git implements Serializable {
  def config
  def script

  Git(script,config) {
    this.config = config
    this.script = script
  }

  void checkout(def url=false, def branch=false) {
    if (url != false) {
       this.config.url = url
       if (branch != false) {
           this.config.branch = branch
       }
    }
    if (this.config.url) {
       this.script.stage('Initialize') {
         this.script.git(url: this.config.url, branch: this.config.branch.trim())
       }
    } else {
        error "no URL found for git config --get remote.origin.url "
    } 
  }
}
