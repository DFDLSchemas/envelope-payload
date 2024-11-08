## DFDL Schema: envelope-payload example

This is an _assembly schema_ which glues together several _component schemas_. 

These are a tcp message header schema, a second header schema, mil-std-2045, and a payload schema, PCAP. 

This idiom, where an envelope or header is used in conjunction with a payload, and the two are defined separately, 
illustrates how they can be mixed and matched, and reused without copying and modifying either of them. 

The component schemas are defined and testable in isolation separately. 

This schema includes tests of the three when combined. 

An additional wrinkle is that the PCAP DFDL schema uses yet another component schema, ethernetIP.dfdl.xsd, so the PCAP 
schema it both itself an assembly schema, and a component for this schema. 

Furthermore, the ethernetIP schema defines and uses a Daffodil _layer plugin_ to compute the IPv4 packet checksum.
This requires that the jar file containing that layer plugin code class files is on the classpath. 

## Using this DFDL Schema at the Daffodil Command Line Interface(CLI)

Setup of the class path for a schema with all these components is difficult, but fortunately
we can get the *sbt* tool to do the work for us.

Executing this shell script (on linux) will define the `DAFFODIL_CLASSPATH` that the CLI needs:

    export DAFFODIL_CLASSPATH=$(sbt -batch -error "export fullClasspath")

## Using this DFDL Schema with the Daffodil VSCode Extension 

Setup of the launch.json for a schema with all these components is difficult. 

This project includes a `.vscode/launch.json` file which can be used as a template or to run a 
simple test under the VSCode Daffodil debugger. 

This assumes all 5 github DFDLSchemas projects:

- envelope-payload
- tcpMessage
- mil-std-2045
- PCAP
- ethernetIP

are `git` cloned into adjacent peer directories so that relative paths 
used in the `.vscode/launch.json` can navigate between the different schemas. 

The jar for the ethernetIP schema's Daffodil layer plugin is assumed to appear in the `lib_managed`
directory, which is populated by issuing an `sbt` command in the envelope-payload root directory such as:

    sbt test

or 
    sbt updateClassifiers


## Copyright and Licensing

This software is copyright (c) 2024, Owl Cyber Defense.

It is licensed for your use under the terms of the ASF v2.0 license. See the LICENSE file 
for further details.
