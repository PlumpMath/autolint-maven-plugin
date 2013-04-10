# autolint-maven-plugin

A maven plugin for linting your javascript with
[autolint](https://github.com/magnars/autolint).

## Getting started

At the moment, this plugin does not exists in the public maven repo.
So for now you will need to clone the project and do a `mvn install`.

### Configure plugin

     <plugin>
       <groupId>com.magnars.autolint</groupId>
       <artifactId>autolint-maven-plugin</artifactId>
       <version>1.0.0-SNAPSHOT</version>
       <configuration>
         <rootDirectory>${basedir}/src/test/javascript/</rootDirectory>
       </configuration>
     </plugin>

The rootDirectory is the location that contains your autolint.js config file.

## Running the plugin

    mvn autolint:verify
