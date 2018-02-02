pipeline {
    agent any
    stages {
		stage('Code Analysis') {
			steps {
				withSonarQubeEnv('sonar') {
					sh 'mvn sonar:sonar'
				}
				script {
					def qg =waitForQualityGate()
					if (qg.status != 'OK') {
						error "Pipeline aborted due to quality gate failure: ${qg.status}"
					}
				}
			}
		}
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
		stage('Artifactory Demo') {
			steps {
				script {
					def server = Artifactory.server 'artifactory'
					def uploadSpec = """{
							"files": [
										{
											"pattern": "target/micro.war",
											"target": "generic-local",
											"props": "p1=v1;p2=v2"
										}  
									]
						}"""
					def buildInfo1 = server.upload spec: uploadSpec
					def downloadSpec = """{
							"files": [
										{
											"pattern": "generic-local/micro.war",
											"target": "./{1}/",
											"props": "p1=v1;p2=v2"
										}
									]
						}"""
					def buildInfo2 = server.download spec: downloadSpec
					buildInfo1.append buildInfo2
					server.publishBuildInfo buildInfo1
				}
			}
		}
    }
}
