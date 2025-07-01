#!/bin/bash

mvn archetype:generate -DgroupId=local.antropodus -DartifactId=$1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
