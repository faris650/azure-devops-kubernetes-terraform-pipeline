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
		stage("build") {           
			steps {
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
			  echo 'testing the application'
			}
		}
		stage("deploy") {
			steps {
			  echo 'deploying the application'
              echo "deploying version ${params.VERSION}"
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

