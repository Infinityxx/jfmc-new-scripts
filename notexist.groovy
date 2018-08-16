repoName = userInput (
    name : "User",
    type : "STRING",
    value : "devops-repo-multi-branch",
    description : "please provide a value"
  )


artifactory('MyLocal') {
  localRepository(repoName + "-local") {
    description "Public description"
    notes "Some internal notes"
    repoLayoutRef "maven-2-default"
    archiveBrowsingEnabled false
    packageType "maven"
    snapshotVersionBehavior "unique"
  }

  virtualRepository(repoName + "-virtual") {
    description "Public description"
    notes "Some internal notes"
    repoLayoutRef "maven-2-default"
    repositories (["libs-releases-local", repoName + "-local", "platform-dependencies", "third-party-snapshots-local"])
    artifactoryRequestsCanRetrieveRemoteArtifacts false
    defaultDeploymentRepo ""
    packageType "maven"
  }
  
}