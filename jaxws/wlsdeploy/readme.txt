# JAX-WS Java API for XML Web Service
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=1.1 -DgroupId=com.nwb.jpractice.jee7.jaxws -DartifactId=parent -Dversion=1.0-SNAPSHOT

mvn archetype:generate -B -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1 -DgroupId=com.nwb.jpractice.jee7.jaxws -DartifactId=helloservice-war -Dversion=1.0-SNAPSHOT
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee7 -DgroupId=com.nwb.jpractice.jee7.jaxws -DartifactId=hellows-war -Dversion=1.0-SNAPSHOT


Shufengs-iMac:bin wangbo$ ./wlst.sh 

Initializing WebLogic Scripting Tool (WLST) ...

Jython scans all the jar files it can find at first startup. Depending on the system, this process may take a few minutes to complete, and WLST may not return a prompt right away.

Welcome to WebLogic Server Administration Scripting Shell

Type help() for help on available commands


nmConnect('nodemanager','gemalto51','localhost','5556','base_domain','/Users/wangbo/DevHome/servers/wls12213/user_projects/domains/base_domain','SSL')
nmStart('AdminServer')
nmServerStatus('AdminServer')

nmStop('AdminServer')
start('wlscluster','Cluster')



progress= deploy(appName='hellows-war',path='/Users/wangbo/DevHome/projects/GitHub/jpractice/jaxws/hellows-war/target/hellows-war-1.0-SNAPSHOT.war')