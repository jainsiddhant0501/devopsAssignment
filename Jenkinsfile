pipeline {
    agent any
    stages {
    	stage("Verify installation"){
    		steps {
    			sh '''
    				docker version
    				docker info
    				docker compose version
    				curl --version
    				jq --version
    		}
    	}
 	}
 	
 	post{
 		always{
 			sh 'docker images'
 		}
 	}
 }