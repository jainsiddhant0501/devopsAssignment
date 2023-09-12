pipeline {
    agent any
    stages {
        stage("Verify installation") {
            steps {
                script {
                    def toolVersions = []
                    def installed = true

                    // Check Docker version
                    def dockerVersion = sh(script: 'docker version', returnStatus: true)
                    if (dockerVersion != 0) {
                        echo "Docker is not installed or not working."
                        installed = false
                    } else {
                        toolVersions << sh(script: 'docker --version', returnStdout: true).trim()
                    }

                    // Check Docker Compose version
                    def dockerComposeVersion = sh(script: 'docker compose version', returnStatus: true)
                    if (dockerComposeVersion != 0) {
                        echo "Docker Compose is not installed or not working."
                        installed = false
                    } else {
                        toolVersions << sh(script: 'docker compose --version', returnStdout: true).trim()
                    }

                    // Add checks for other tools here

                    if (!installed) {
                        error "One or more required tools are missing or not working."
                    } else {
                        echo "Installed tool versions:"
                        toolVersions.each { version -> echo version }
                    }
                }
            }
        }
    }
}
