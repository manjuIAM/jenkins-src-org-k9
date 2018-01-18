package org.k9.docker

class DockerActivity implements Serializable {
  def config
  def script

  DockerActivity(script, config) {
    this.config = config
    this.script = script
  }

TODO
1.  Delte Dockerfile first then Create Dockerfile from ENV name
2.  need to take CMD from user
3.  add into Dockerfile
4.  Check file exists
https://jenkins.io/doc/book/pipeline/docker/

  void writeInJobWorkspaceDockerfile() {
      def dcontent = this.script.libraryResource 'org/k9/docker/maven';
      this.script.writeFile file: 'Dockerfile', text: dcontent
  }

  void build() {
    this.script.stage('Building Image') {
        this.dbuild = this.script.docker.build('maven:springboot', '.')
    }
  }

  void dbuild() {
    this.script.stage('Pushing Image') {
       def app = this.script.docker.build("amydocker/springboot:latest")
       return app
    }
  }
  void dpush(def app) {
    this.script.stage('Pushing Image') {
        this.script.docker.withRegistry('https://registry.hub.docker.com', 'dlogin') {
            app.push()
        }
    }
  }
}
