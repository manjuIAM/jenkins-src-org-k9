podTemplate(cloud: 'openshift', name: 'automata', label: 'automata', serviceAccount: 'mjenkin', containers: [
    containerTemplate(
            name: 'jnlp',
            image: "docker.io/amydocker/mavendocker:latest",
            command: '',
            args: '${computer.jnlpmac} ${computer.name}',
            workingDir: '/tmp/',
            privileged: true,
            alwaysPullImage: true,
            ttyEnabled: false
    )],
    volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]) {

        node('automata') {
            sh "ls -l /tmp/"
            sh "docker ps"
            sh "docker images"
        }
}
