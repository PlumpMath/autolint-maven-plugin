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

- `command` is the command to run. Defaults to `autolint` on the path. This is useful
  if you don't want to globally install autolint on a build server, but would rather bundle
  it with the project.

Autolint also requires [node](http://nodejs.org/) to be available on the path.

## Running the plugin

    mvn autolint:verify

## License

Copyright (c) 2013 Magnar Sveen

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
