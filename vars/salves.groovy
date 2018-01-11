def call (slave){

podTemplate(cloud: 'mcluster',name: 'maven-node',label: 'maven-node',namespace: 'maven-node',serviceAccount: 'jenkins',slaveConnectTimeout: 120,activeDeadlineSeconds: 30 * 120,containers: [containerTemplate(name: 'maven',image: 'maven:3.3.9-jdk-8-alpine',ttyEnabled: true,command: 'cat')])

node('maven-node') {
openshift.withCluster( 'mcluster' ) {
    openshift.withProject( 'anand' ) {
        echo "Hello from project: ${openshift.project()}"
    }
}
}
}
