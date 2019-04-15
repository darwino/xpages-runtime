# add all the asset files in directories starting with an underscore to the APK
find assets -type d -name "_*" -print | zip $1 -r -@
# resign the APK with the new files in place
jarsigner -digestalg SHA1 -sigalg MD5withRSA -verbose -keystore $HOME/.android/debug.keystore -storepass android -keypass android $1 androiddebugkey
## TODO: the below script to rename the ANDROIDD.{SF, RSA} to CERT.{SF, RSA} could probably be done in a cleaner way
## jarsigner adds the files as "ANDROIDD", but they need to be named "CERT"
# create a temp META-INF directory
mkdir META-INF
# extract ANDROIDD.SF and ANDROIDD.RSA from the APK
unzip -j $1 "META-INF/ANDROIDD.RSA" "META-INF/ANDROIDD.SF" -d META-INF
# remove the old files from the APK
zip -d $1 META-INF/CERT.SF META-INF/CERT.RSA META-INF/ANDROIDD.SF META-INF/ANDROIDD.RSA
# rename ANDROIDD.SF and ANDROIDD.RSA to CERT.SF and CERT.RSA
mv META-INF/ANDROIDD.SF META-INF/CERT.SF
mv META-INF/ANDROIDD.RSA META-INF/CERT.RSA
# add the ANDROIDD files back to the APK as CERT
zip $1 META-INF/CERT.SF META-INF/CERT.RSA
#cleanup
rm META-INF/CERT.SF META-INF/CERT.RSA
rmdir META-INF
