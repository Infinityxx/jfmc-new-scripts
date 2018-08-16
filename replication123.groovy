artifactoryToUserInput = userInput (
    name : "Input to name artifactory",
    type : "ARTIFACTORY",
    description : "please provide a to name artifactory"
)

artifactory(artifactoryToUserInput.name) {
  localRepository("example-repo-local-2") {
    replication(artifactoryToUserInput) {
      username artifactoryToUserInput.credentials.userName
      password artifactoryToUserInput.credentials.password

      cronExp "0 0/9 14 * * ?"
      socketTimeoutMillis 15000
    }
  }
}