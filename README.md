## DFDL Schema: envelope-payload example

This is an _assembly schema_ which glues together several _component schemas_. 

These components are a tcp message header schema (tcpMessage), a second header schema 
(mil-std-2045), and a 
payload schema(PCAP). 

This idiom, where an envelope or header is used in conjunction with a payload, yet the two are 
defined separately, illustrates how they can be mixed and matched, and reused without 
copying and modifying either of them.
This provides a useful example of what we call DFDL _schema composition_ where an _assembly_
_schema_ is built up from other _component schemas_.

The component schemas are defined and testable in isolation. 
This schema includes tests of the schemas when assembled together. 

An additional wrinkle is that the PCAP DFDL schema uses yet another component schema (ethernetIP),
so the PCAP schema is both itself an assembly schema (which assembles PCAP file structure with 
ethernetIP as the schema for the captured packets in the file), and is also a 
component for this envelope-payload schema. 

Furthermore, the ethernetIP schema defines and uses a Daffodil _layer plugin_ to compute 
the IPv4 packet checksum.
This requires that the jar file containing that layer plugin code class files is on the classpath. 

## Using this DFDL Schema at the Daffodil Command Line Interface(CLI)

Setup of the class path for a schema with all these components is difficult, but fortunately
we can get the *sbt* tool to do the work for us.

Executing this shell script (on linux) will define the `DAFFODIL_CLASSPATH` that the CLI needs:

    export DAFFODIL_CLASSPATH=$(sbt -batch -error "export fullClasspath")

## Built-In Self Test Using 'sbt'

This schema implements the best practice of having Built-In Self Test (BIST).
Typing this command at the command shell will run internal tests. 

    sbt test

Messages are written to the console showing the success/failure of the tests.

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

This software is copyright (c) 2024-2025, Owl Cyber Defense.

It is licensed for your use under the terms of the ASF v2.0 license. See the LICENSE file 
for further details.

# Release Notes

## Version 1.1.1 (2024-10-22)

Updated to use latest version of each component, and to match
the recommended DFDL Schema Style, and to use Daffodil v4.0.0.
