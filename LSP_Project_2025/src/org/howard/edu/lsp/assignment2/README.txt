Name: Karis Lewis
 * 
 * AI Usage Requirement: 
 * 	I used AI (ChatGPT) in this assignment when I was confused on which direction to take in terms of transforming the data.
 * For example, after changing the variables with if statements I was unsure how to append the data back to the transform.csv. 
 * I knew variables needed to be used, but I tried using just variables I received the error: "The method append(CharSequence, int, int) in the type OutputStreamWriter is not applicable for the arguments (String, String, Double, String, String)"
 * After trying to format the append, I used ChatGPT to help me come up with a solution. My prompt was (I want to use java eclipse FileWriter writer & append to a csv but how do I use variables from my while loop)?
 * It taught me to format a string, and pass that to the writer, which I then modified to fit this situation.
 * Another issue I ran into was the Category not being read correctly, therefore the price was not being changed. I looked up ways to compare strings and used contains & equals, then found that the if statement would only work with contains.
 * After identifying the issue I asked ChatGPT what the issue would be, and the output was that my string has extra characters before or after the string I was expecting. With that I found the trim method and applied that to my code.
 * 
 * 
 * Documentation of External Sources: 
 * External Source Usage: 
 * Link: https://www.youtube.com/watch?v=Ag-JPiwp1Oo&t=410s
 * Usage: Used approach to learn how to read and write CSV files with java; adapted to transform read csv file and write to a new csv file.
 * 
 * 
 * Assumptions: 
 * Assuming that the correct information has been entered into the products csv file (ie. price is a number, categories are spelled correctly) 
 * 
 * Design Rationale: 
 * Created variables equal to either null or 0 at the start so that I could have the try statements
 * Knew I had to use readline and take string (which can function as array) and set up variables for each header in order to access the data to perform transformations
 * Used if statements to define the criteria 
 * added a few catch statements for errors 
 Added statement in ETL to check if readline is null, if it is null then there is nothin written in the header file (technically would not cause an error), so then the transform csv should just be empty as well.
 * 
 * Tested: 
 * I tested the solution by running it multiple times, that included deleting the products csv and making sure i received an error message.
 * deleting the transform csv and making sure the correct output showed 
 * Deleting the rows from the products csv, to ensure the transform csv only read the header
 * 
 * 