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
         <skip>false</skip>
       </configuration>
     </plugin>

- `rootDirectory` is the location that contains your autolint.js config file.
- `skip` can be set to true if linting should be skipped in certain environments.

You also need to have `autolint` available on path.

## Running the plugin

    mvn autolint:verify
