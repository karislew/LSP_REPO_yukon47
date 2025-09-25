## Prompt 1:  For code how do you work on making it more object oriented?

Response:
 
Great question — making code more object-oriented (OO) is really about shifting from a procedural mindset (“functions acting on data”) to an OO mindset (“objects encapsulating both state and behavior”). Here’s a breakdown of how you can approach it:

Principles of Object-Oriented Design

Encapsulation – Group related data (attributes) and behaviors (methods) into classes.

Abstraction – Expose only what’s necessary, hide the implementation details.

Inheritance – Reuse and extend functionality by creating subclasses.

Polymorphism – Write flexible code that can work with different types of objects through shared interfaces.

## Prompt 2: Can you go into more detail about abstraction, polymorphism, encapsulation and inheritance?

Response:

Encapsulation – “Bundling data and behavior”
What it means:

You keep state (data) and the methods that operate on it together inside a class.
You control how the data is accessed (hiding internal details and exposing only what’s necessary).

Abstraction – “Hiding details, exposing only essentials”
What it means:
You design your classes to focus on what they do, not how they do it.
Users of your class shouldn’t need to know the underlying implementation.

Inheritance – “Is-a relationships”
What it means:
A class (child) can inherit properties and behavior from another class (parent).
This allows code reuse and hierarchical relationships.

Polymorphism – “Many forms, one interface”
What it means:
Different classes can be used interchangeably if they share the same interface.
The same method name can have different behaviors depending on the object.

## Prompt 3: can you show me examples of how OO is used in java

Response: 

Encapsulation in Java
Encapsulation means private fields + public getters/setters (control access to data).

Abstraction in Java
Abstraction usually comes from abstract classes or interfaces.

Inheritance in Java
Java uses the extends keyword.

Polymorphism in Java
Different classes implement the same method → can be used interchangeably.

## Prompt 4: what are javadocs ?

Response: 

Javadocs are the official documentation system in Java. They let you write special comments in your code that can be automatically turned into nicely formatted HTML documentation.
 What are they exactly?
Javadoc comments start with /** ... */ (not just /* ... */).
They are placed above classes, methods, constructors, or fields.
They describe what the code does, its parameters, return values, exceptions, etc.

The javadoc tool (bundled with the JDK) reads these comments and generates documentation pages.

## Prompt 5: help me brainstorm ways in which I can make the following code more object oriented

Response: 

Separate Data from Transformation
Right now, your Product object both stores data and knows how to transform itself (transform()). That’s fine for small projects, but in bigger systems, it can lead to “fat” model classes.
Encapsulation With Getters/Setters

Your current class has private fields, but no getters/setters. To follow best practice in Java:
Abstraction for File IO

Right now, your ETLPipeline class knows how to read, transform, and write products. You could abstract that with CsvReader / CsvWriter. (Looks like you’re already moving in that direction).

That gives you flexibility if you later want to:
Switch to JSON or a database.

Add new data sources without changing the pipeline.

## Prompt 6: I previously wrote this code, can you help brainstorm ways in which I can make it more object oriented?:

Response: 

Add getters/setters for encapsulation.

Break transform() into smaller methods.

Extract transformation rules into strategies/polymorphism if you want flexibility.

Use inheritance if you expect different product types.
Override toString() for readability/debugging.


## Prompt 7: do I have to keep generating if I update have doc comments? and how do I review javadocs. also is there a way to undo the generation (eclipse)

Response: 

Do you have to keep generating Javadocs if you update comments?
Yes. Javadocs are static HTML files generated from the code. If you update the Javadoc comments in your .java files, those changes won’t automatically appear in the generated docs  you’ll need to regenerate them.
Think of it like compiling code: if you change your .java files, you recompile. If you change doc comments, you regenerate Javadocs.













