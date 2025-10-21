Question 1 Reflection: 

AI Resources: 

I used AI to format my response to this question to ensure it was well written. I prompted with the given question and my response, and asked how it sounded. I edited the response as I saw fit.

prompt: 

a) Should a well-designed class have high or low cohesion? Explain and defend your answer. (5 pts.) A well-designed class should have high cohesion as each class becomes easier to comprehend. High cohesion improves code’s maintainability, readability and testability. b) Based on your analysis, discuss—only if you believe changes are needed—how you would reorganize or redesign the class to improve its structure. Your answer should (1) identify the class as having high, low or perfect cohesion and (2) describe a general approach to refactoring the class. If you believe the class already has good cohesion, justify why no changes are necessary. (15 pts) The class shown has low cohesion as the class performs various amounts of unrelated tasks such as GPA calculation, CSV exporting, email formatting etc. That also means the class does not perform a single responsibility. A general approach to refactoring the class would be to break the class into smaller, focused classes that serve a singular purpose. For example, GPACalculator class would handle only grades and GPA related calculations. EmailFormatting class would manage all email message templates and formatting. DateFormatter would focus on formatting dates. Each class would follow a similar format, and perform only related actions. how does this sound

Response: 
a. A well-designed class should have high cohesion because it focuses on a single, well-defined responsibility, making the class easier to understand, maintain, and test.

Your answer is clear and communicates the key points, but it can be slightly polished for flow and clarity. Here's a refined version that keeps your content intact while improving readability:

In addition to AI I used this article - https://medium.com/@tenigada/unleashing-the-power-of-maintainable-code-a-guide-to-high-cohesion-and-low-coupling-b99c520e07b0  
to get a better understanding of high cohesion. 


Question 3 Reflection: 

AI Resources: 
I asked AI to analyze and refine my answer to these questions. I prompted with the questions and my original response. 

prompt: 

Explain in detail why the current structure does or does not support this. (10 pts.) The current structure does not support this well. For you to be able to change the trim level at any point, this would a fixed value from the start. To change the trim you would have to create a new trim object in each subclass. Describe how to refactor the structure to allow trim-level change for a car to dynamically change. Hint: How would you modify Car to use composition to solve the problem? (10 pts.) To allow trim-level change for a car to dynamically change, you could make a class called TrimLevel.

How does this sound?

Response: 

Your response communicates your experience clearly, but it could be polished for readability, grammar, and flow. Here's a refined version that keeps your points intact while making it smoother and more professional.

The current structure does not support dynamic trim-level changes because trim levels are represented as subclasses of Car. 
To allow trim levels to change dynamically, Car can use composition by holding a TrimLevel object instead of relying on subclasses.

Question 5 Reflection: 

AI Resources: 
I asked ChatGPT to refine my answer to this. I provided my original paragraphs and constructed my new paragraph based on the feedback received. 

prompt: 

how does this sound: How have you used AI to support your learning or programming in this course? What benefits or limitations did you encounter? Looking ahead, how do you expect AI to influence the way you solve problems academically or professionally? Your answer should be 1–2 well-developed paragraphs. I have used AI to support my learning/programming within this course plenty of times. Since the professor has encouraged the use of AI, I use it to help me answer questions for my assignments. Prompting with the question of that specific assignment then having AI expand on the answer whenever I get stuck on a problem. I believe AI is a great educational tool when you put the time in to learn, it is beneficial as it saves a lot of time while doing my coursework and I am easily able to receive detailed answers whenever I get stuck. However one of the limitations is that AI, does have an effect if you don’t put in that effort to learn. In some cases you can’t fully understand each topic especially if you are in a rush for a response. On top of that you don’t always know when AI is correct, and should often try to double check. In the future, I do not want to rely on AI to solve problems for me initially, but I believe I will use it to check my work, or help me whenever I get stuck.

Response: 

Your response communicates your experience clearly, but it could be polished for readability, grammar, and flow. Here's a refined version that keeps your points intact while making it smoother and more professional.


