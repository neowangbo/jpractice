Reference:

JDK8 Standard algorithm name: https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html
JDK8 JCA (Java Cryptograph Architecture): https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html




302c02144d8c026f7d5043625629acbb43fd5493d3298c0502141014fb516924ffeeb014c300af1adb4e13887c24


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


Security 2 important points:
A. Authentication through digital signature. Merely verify the imformation is not changed, imformation is visible.
B. Encryption, imformation is invisible.



