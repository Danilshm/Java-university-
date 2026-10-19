## Collection vs Stream 
- A **collection** store data, for example a List of student names.
- A **stream** describes processing on data from a source
- **Collection**: the items on your shelf 
- **Stream**: the process that selects and changes those items 
- A **stream** does not normally store a new collection after every step.
- <font color="#ff0000">Memory trick</font>: collection = storage; stream = processing
## What is the Streams API?
- Introduced in Java 8
- Supports functional-style operations on sequences of elements
- Works well with lambda expressions
- Let you describe what you want to do, rather than writing every loop
## Why use Stream 
- **Declares code**: state the goal clearly
- **Common operations**: filter, map, reduce and more
- **Pipelines: chain** several steps together
- **Lazy evaluation**: work can wait until a result is needed
- **Short-circuiting**: stop when enough information is available.
- I**nternal iteration**: the stream manages traversal for you
- Processing logic is **separated** from iteration logic 
- **Parallel streams** can use multiple processor cores
- **Readable pipelines** can make data-processing intent easier to see
- Streams are useful, but they are not automatically faster in every situation.
## 3 parts of a pipeline
- **Source**
	- where the data comes from, such as a List or array
- **Intermediate**
	- zero or more processing steps, such as filter or map
- **Terminal**
	- the operation that produces a result, such as count or collect
## Intermediate vs terminal operations
- <font color="#ff0000">Intermediate</font> operations return another stream, so you can chain them 
	- Examples: filter(),map(), sorted()
- <font color="#ff0000">Terminal</font> operations produce a result or perform an action 
	- Examples: count(), collect(), forEach()
- A terminal operation triggers processing; that stream cannot then be reused.
## Lazy evaluation
- **Intermediate** operations normally do not process data immediately
- They describes the steps that should happen **later**
- **Processing** begins when a terminal operation is called.
- This can avoid work that is not needed
- *Think of writing a recipe versus actually cooking it.*