# Mission 
- Read data from files and write data to files
- Choose text or binary storage for the job 
- Understand Java I/O classes and how they work together
- Recognize exceptions and choose a sensible response.
# Text vs Binary: two ways to store data 
- Text stores readable characters, such as the characters '4' and '2'
- Binary stores raw bytes, such as the bytes representing an int value 42 
- Binary can represent primitive values or complete objects efficiently.
# Worked example
```
public void setDayNumber(int day) throws TemStampException{
if(day<0 || day>366) {
	throw. new TimeStampException("Day must be between 0 and 366: " + day);
	}
}
```
# Readers and Writers
- **Readers and Writer** are abstract base classes for character streams.
- **FileReader and File Writer** connect character processing to files 
- BufferedReader and BufferedWriter add buffering 
- PrintWriter offers convenient print() and println() methods
- Use these when the file contains text 
# InputStream and OutputStream
- InputStream and OutputStream are abstract byte-stream classes.
- FileInputStream and FileOutputStream connect byte streams to files 
- Byte streams are useful for raw binary 
# Delimiters: how Scanner splits input 
- A Delimiter defines where one token ends and another begins. 
- The source example uses angle brackers and new lines as delimiters
- For <Fred'> <Bloogs'>, the tokens can be Fred and Bloggs.
# A missing file 
- Approach 1: declare the checked exception using throws. 
- Approach 2: catch FileNotFoundException and decide what to show or do
- throws passes responsibility to the caller; it does not itself recover from the failure.
- try-catch lets this method respond to the failure 
- The right choice depends on which method can make the best decision.
# ObjectOutputStream: the wrapper chain 
- FIleOutputStream connects to the destination file.
- ObjectOutputStream wraps it and adds writeObject()
# One object vs a sequence of objects 
- For one object, writeObject() once and readObject() once
- For several objects, write each object in a loop 
- The source example writes null after the sequence as a stopping marker 
- The reading loop stops when it reads that null marker 
# ObjectInputStream
- FileInputStream connects to the saved file 
- ObjectInputStream wraps it and adds readObject() 
- readObject() returns a general Object value 
- Cast to the excepted type only when the saved data is compatible 
# Files utility 
- Files.writeString(path,text) writes text to a path
- Files.readString(path) reads text from a path
- Files.readAllString(path)
### Files utility: bytes and paths
- Files.readAllBytes(path) reads file contents as a byte array 
- Files.write(path, bytes) writes bytes to a path
## Files.lines() and resource safety
- FIles.lines(path) provides a stream of lines.
- The stream may keep the file open while it is being used
- Try-with-resources ensures the stream is closed.
- The pipeline can filter lines and print only matches 
- Handle IOException if opening or closing the file fails
# Exception
## Checked exceptions; compiler ask you to decide 
- A checked exception ust be caught or declared
- IOException is a common example in file work.
## Unchecked exceptions: common programming problems 
- NumberFormatException can occur when text cannot be parsed as a number 
- NullPointerException can occur when code uses a null reference incorrectly
  indexOutOfBoundsException
## Exception hierarchy: Throwable
- The source diagram shows Throwable at the top of the hierarchy
- Error and Exception are separate branches under Throwable
## What belongs inside try?
- Put the operations that may throw the exception inside 
## finally and cleanup 
- finally runs after try/catch whether an exception occurs or not, under normal control flow.
- It has traditionally been used to close resources.
- Closing can itself throw and IOException, so cleanup 
## Try-with-resources vs manual close 
- Manual close can be forgotten when an exception interrupts the code 
- A finally block improves cleanup reliability but adds nesting
- try-with-resources closes declared resources automatically
## Throws or catch: choose the right layer 
- Catch when this method can recover or provide a meaningful response 
- Declare throws when the caller should decide what to do 
- A catch block that merely hides the error may make debugging harder