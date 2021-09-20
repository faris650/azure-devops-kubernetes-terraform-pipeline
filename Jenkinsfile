
def gv
pipeline {
    /*environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = Credentilas('server-credentials')
    }*/
	agent any
    paramters {
        //string(name: 'VERSION', defualtValue: '',description: 'version to deploy on prod')
        choice(name: 'VERSION', choices:['1.1.0','1.2.0','1.3.0'],description: '')
        booleanParam(name: 'executeTests',defualtValue: 'True',description: '')
    }
    /*tools {
        Maven
        Gradle
    }*/
	stages {
 		stage("init") {           
			steps {
                //script block to load groovy script
                script {
                    gv = load "script.groovy"
                }
			}
		}       
		stage("build") {           
			steps {
                script{
                    gv.buildApp()
                }
			    echo 'building the application'
                //echo "building version ${NEW_VERSION}"
                //echo "building with credential ${SEREVER_CREDENTIALS}"
			}
		}
		stage("test") {
            when {
                expression {
                    if params.executeTests
                    //BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                }
            }
			steps {
			    script {
                    gv.testApp()
                }
			}
		}
		stage("deploy") {
			steps {
                script {
                    gv.deploApp()
                    //All environment variables in Jenkins are avaialable in groovy script
                }
			}
		}
	}
	post {
	   always {
		    echo "Completed...!"
	   }
	   failure {
        
	   }
	}
}

