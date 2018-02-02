pipeline {
    agent any
    stages {
		stage('Code Analysis') {
			withSonarQubeEnv('sonar') {
				sh 'mvn sonar:sonar -Dsonar.login=f3916ccf7f175572bc3fce10c2b00316aa608d42'
			}
		}
		stage('Quality Gate') {
			timeout(time: 1, unit: 'HOURS') {
				def qg =waitForQualityGate()
				if (qg.status != 'OK') {
					error "Pipeline aborted due to quality gate failure: ${qg.status}"
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
    }
}
