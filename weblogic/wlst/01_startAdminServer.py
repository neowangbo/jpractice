# startServer('demoServer','demoDomain','t3://localhost:8001', 'myweblogic','wlstdomain','c:/mydomains/wlst','false', 60000, jvmArgs='-XX:MaxPermSize=75m, -Xmx512m, -XX:+UseParallelGC')
startServer('AdminServer','base_domain')
startServer('AdminServer','base_domain','t3://localhost:7001', 'weblogic','gemalto51','/Users/wangbo/DevHome/servers/wls12213/user_projects/domains/base_domain')
startServer(username='weblogic',password='gemalto51',domainDir='/Users/wangbo/DevHome/servers/wls12213/user_projects/domains/base_domain')