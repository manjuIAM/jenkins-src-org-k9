import org.k9.*

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
      new scm.Git(this,config).checkout("https://github.com/kloud9nyc/daac.git","master");
      new builder.Maven(this,config).build();
    }

}
