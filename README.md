## DFDL Schema: envelope-payload example

This is an _assembly schema_ which glues together three _component schemas_. 

These are a tcp header schema, a second header schema, mil-std-2045, and a payload schema, PCAP. 

This idiom, where an envelope or header is used in conjunction with a payload, and the two are defined separately, 
illustrates how they can be mixed and matched, and reused without copying and modifying either of them. 

The component schemas are defined and testable in isolation separately. 

This schema includes tests of the three when combined. 

An additional wrinkle is that the PCAP DFDL schema uses yet another component schema, ethernetIP.dfdl.xsd, so the PCAP 
schema it both itself an assembly schema, and a component for this schema. 


## Copyright and Licensing

This software is copyright (c) 2024, Owl Cyber Defense.

It is licensed for your use under the terms of the ASF v2.0 license. See the LICENSE file 
for further details.
