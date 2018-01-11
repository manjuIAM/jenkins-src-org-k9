package org.k9.utilities

class PostRequest implements Serializable {
  def config

  PostRequest(config) {
    this.config = config
  }

  void get() {
    if (this.config.url.trim()) {
        def post = new URL(this.config.url.trim()).openConnection();
        def message = this.config.bodymessage.trim()
        post.setRequestMethod("POST")
        post.setDoOutput(true)
        post.setRequestProperty("Content-Type", "application/json")
        post.getOutputStream().write(message.getBytes("UTF-8"));
        def postRC = post.getResponseCode();

        println(postRC);

        if(postRC.equals(200)) {
            println(post.getInputStream().getText());
        } else {
            error get.getInputStream().getText()
        }
    } else {
        error "no URL found for GET request"
    }
  }
}
