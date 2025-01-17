def(Upload to artifactory : jfrog)
   def artifactoryUrl = 'http://52.4.16.44:8082/artifactory'
                    def repository = 'example-repo-local'
                    def username = 'admin'
                    def password = 'Sangeeth@1'  // Replace with your Artifactory password
                    def jarFile = 'kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar'
                    def jarFilePath = "${WORKSPACE}/${jarFile}"

                    // Run the curl command to upload the JAR file
                    def curlCommand = "curl -X PUT -u ${username}:${password} -T ${jarFilePath} ${artifactoryUrl}/${repository}/${jarFile}"
                    def uploadResult = bat(script: curlCommand, returnStatus: true)

                    if (uploadResult == 0) {
                        echo "JAR file successfully uploaded to Artifactory"
                    } else {
                        error "Failed to upload JAR file to Artifactory"
