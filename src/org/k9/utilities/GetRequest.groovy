package org.k9.utilities

class GetRequest implements Serializable {
  def config

  GetRequest(config) {
    this.config = config
  }

  void get() {
    if (this.config.url.trim()) {
      try {
        def get = new URL(this.config.url.trim()).openConnection();
        def getRC = get.getResponseCode();
        println(getRC);
        if(getRC.equals(200)) {
            println(get.getInputStream().getText());
        } else {
            error get.getInputStream().getText()
        }
      } catch (e) {
        throw e
      }
    } else {
        error "no URL found for GET request"
    }
  }
}
