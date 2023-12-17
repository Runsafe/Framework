#!/bin/bash
cd ..
mkdir spigotmc
cd spigotmc
curl https://hub.spigotmc.org/jenkins/job/BuildTools/lastStableBuild/artifact/target/BuildTools.jar -o BuildTools.jar
java -jar BuildTools.jar --rev 1.12.2
