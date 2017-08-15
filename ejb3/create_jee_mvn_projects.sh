//Create parent pom


// Create EJB module
mvn -DarchetypeGroupId=org.codehaus.mojo.archetypes 
    -DarchetypeArtifactId=ejb-javaee7 
    -DarchetypeVersion=1.1 
    -DarchetypeRepository=http://repo.maven.apache.org/maven2 
    -DgroupId=org.nwb.jpractice.ejb3 
    -DartifactId=helloworld-ejb-api 
    -Dversion=1.0-SNAPSHOT 
    -Dpackage=org.nwb.jpractice.ejb3.helloworld.ejb.api 
    -Dbasedir=/Users/wangbo/DevHome/projects/GitHub/jpractice/ejb3 
    -Darchetype.interactive=false 
    --batch-mode 
    archetype:generate

    
// Create EAR module, package some EJB and WAR modules together as JEE application
mvn -DarchetypeGroupId=org.codehaus.mojo.archetypes 
    -DarchetypeArtifactId=ear-javaee7 
    -DarchetypeVersion=1.0 
    -DarchetypeRepository=http://repo.maven.apache.org/maven2 
    -DgroupId=org.nwb.jpractice.ejb3 
    -DartifactId=helloworld-ejb-ear 
    -Dversion=1.0-SNAPSHOT 
    -Dbasedir=/Users/wangbo/DevHome/projects/GitHub/jpractice/ejb3/helloworld-ejb-ear/helloworld-ejb-ear 
    -Darchetype.interactive=false 
    --batch-mode 
    archetype:generate