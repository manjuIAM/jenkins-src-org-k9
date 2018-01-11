#!/usr/bin/groovy
def call() {

openshift.withCluster( 'mcluster' ) {


  podTemplate(label: anand,
        containers: [
                containerTemplate(
                        name: 'maven',
                        image: 'maven:3.3.9-jdk-8-alpine'
                )
        ]
  ) {

node('anand') {

    openshift.withProject( 'anand' ) {
        echo "Hello from project: ${openshift.project()}"
    }

}

    } }
}
