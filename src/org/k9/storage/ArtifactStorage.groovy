package org.k9.storage

class ArtifactStorage implements Serializable {
  def config
  def script

  ArtifactStorage(script,config) {
    this.config = config
    this.script = script
  }

  void upload() {
    this.script.stage('Upload Artifcat') {
      this.script.sh("curl -v -u admin:admin123 --upload-file ${this.script.env.WORKSPACE}/target/spring-boot-rest-example-0.4.0.war http://35.193.79.215:8081/repository/demo/")
    }
  }
  void download() {
    this.script.stage('Upload Artifcat') {
           this.script.sh("curl -o spring-boot-rest-example-0.4.0.war -u admin:admin123 http://35.193.79.215:8081/repository/demo/spring-boot-rest-example-0.4.0.war")
    }
  }
}
