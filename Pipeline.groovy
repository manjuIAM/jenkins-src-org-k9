def slavenode = [cloud: 'openshift', name: 'automata', label: 'automata', sa: 'mjenkin', image: 'docker.io/amydocker/mavendocker:latest', privileged: true, volume: '/var/run/docker.sock', arg: '${computer.jnlpmac} ${computer.name}', jobworkspace: '/tmp/', cli: '', ]

podTemplate(cloud: slavenode.cloud, name: label.name, label: slavenode.label, serviceAccount: slavenode.sa, containers: [
    containerTemplate(
            name: 'jnlp',
            image: slavenode.image,
            command: slavenode.cli,
            args: slavenode.arg,
            workingDir: slavenode.jobworkspace,
            privileged: slavenode.privileged,
            alwaysPullImage: true,
            ttyEnabled: false,
            resourceRequestCpu: '50m',
            resourceLimitCpu: '100m',
            resourceRequestMemory: '100Mi',
            resourceLimitMemory: '200Mi',
            envVars: [
                containerEnvVar(key: 'SLAVE_NODE', value: slavenode.name),
            ]
    )],
    volumes: [hostPathVolume(hostPath: slavenode.volume, mountPath: slavenode.volume)]) {

        node('automata') {
            sh "ls -l /tmp/"
            sh "docker ps"
            sh "docker images"
        }
}
