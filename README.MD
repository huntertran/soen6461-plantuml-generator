Deliverable 3:

Analysis and Design
On the one hand, the PADL meta-model allows describing models of (object-oriented) programs. The POM extension to PADL allows computing metric values of various metrics on PADL models (and their constituents, mostly padl.kernel.IFirstClassEntity).

On the other hand, “PlantUML is a component that allows to quickly write : […] class diagrams” (See https://plantuml.com/).

Analyze, design, and implement a `Visitor` that generates a textual description of any PADL model. The description should include `padl.kernel.IFirstClassEntity` (and possibly all `padl.kernel.IEntity`) as nodes. The arcs between nodes should describes the different relations between entities (see `padl.kernel.IRelationship` and its sub-interfaces). The description should conform to the syntax and semantics of https://plantuml.com/classdiagram so that PlantUML can be called on this description. Demonstrate your implementation by providing textual description of some PADL model as well as the corresponding PlantUML-generated class diagrams.

Meeting notes:

1. Find the starting point of POM (maybe investigating the POM Tests)
2. Setup the project

Things we need to know about this project (ask the questions):
1. How to use the tools?
2. What kind of program we need to create (a console program / an extension to the Ptidej UI Viewer Standalone Swing)
3. Do we need to add visitor pattern the the tools that we will create?
4. Should we go through padl.kernel.IFirstClassEntity (and possibly all padl.kernel.IEntity) and padl.kernel.IRelationship and its sub-interfaces and write accept methods for these interfaces or are we wrong?

Questions and answered by professor Yann:

> 1. For how many PADL models do we have to design the visitor?

Actually, this question can make a lot of sense or no sense at all wink The Visitor that must be build should handle all the constituents of the PADL meta-model (hence, not a set of particular models) and all the elements of the PlantUML language. On the other hand, it is a problem of mapping between PADL constituents and PlantUML elements, which is not necessarily (certainly) a bijection so some compromise will be necessary.

> 2. Is there just 1 visitor we have to design that can produce the textual description for all the models?

Yes, most likely one Visitor will be enough.

> 3. We're not able to run the code, so how can we be sure of the syntax?

I don't know what code is the problem here but we are not compilers wink

> 4. We have to generate the comments in Plant UML by feeding in just the visitor?

Yes.