cd ..
mkdir spigotmc
cd spigotmc
powershell -Command "Invoke-WebRequest https://hub.spigotmc.org/jenkins/job/BuildTools/lastStableBuild/artifact/target/BuildTools.jar -OutFile BuildTools.jar"
"C:\Program Files\Eclipse Adoptium\jre-8.0.392.8-hotspot\bin\java" -jar BuildTools.jar --rev 1.12.2
