nmConnect('nodemanager','gemalto51','localhost','5556','base_domain','/Users/wangbo/DevHome/servers/wls12213/user_projects/domains/base_domain','SSL')

nmStart('AdminServer')
nmServerStatus('AdminServer')