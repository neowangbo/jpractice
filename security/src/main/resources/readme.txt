===========================================================================================
1. Create keypair
Create sample.certs:
    $ keytool -genkeypair -keystore sample.certs -alias nwb
    Both password: gemalto51

    There are public key and private key in sample.certs.
    Public key is certificate, you can export certificate and send to your friends.
    $ keytool -exportcert -keystore sample.certs -alias nwb -file nwb.cer
    
===========================================================================================
2. Using openssl to create root certificate



