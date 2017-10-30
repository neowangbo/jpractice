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


Data Encryption Standard (DES) - It can be cracked by brute force
Advanced Encryption Standard (AES) - Successor of DES


===========================================================================================
3. Keystore - Keystore class

This class represents a storage facility for cryptographic keys and certificates.
- Private key, most likely private key and public key pair
- Secret key
- Trusted key



keytool -genkey -keyalg RSA -alias selfsigned -keystore keystore.jks -storepass password -validity 360 -keysize 2048
-genkeypair
{-alias alias} {-keyalg keyalg} {-keysize keysize} {-sigalg sigalg}
[-dname dname] [-keypass keypass] {-startdate value} {-ext ext}*
{-validity valDays} {-storetype storetype} {-keystore keystore}
[-storepass storepass]
{-providerClass provider_class_name {-providerArg provider_arg}}
{-v} {-protected} {-Jjavaoption}
Example:
keytool -genkeypair -alias martian -keyalg RSA



RSA keypair:
> keytool -genkeypair -keyalg RSA -keysize 2048 -validity 3650 -v -keystore keystore.jks
by default alias is mykey
> keytool -genkeypair -keyalg RSA -keysize 2048 -alias rsa_cipher -validity 3650 -v -keystore keystore.jks


DSA keypair
> keytool -genkeypair -keyalg DSA -keysize 1024 -alias dsa_sign -validity 3650 -v -keystore keystore.jks

