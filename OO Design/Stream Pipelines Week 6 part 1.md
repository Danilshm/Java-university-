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
## Short-circuiting
- Some terminal operations can ddcide the answer before reading every element
- findFirst() stops when it finds the first matching element.
- anyMatch() same like findFirst but you can apply rules on it
- allMatch()
	- do all words contain the letter 't'?
	- The->yes; cat->yes; sat->yes
## Stateful vs stateless operations
- **Stateless**: map() and filter() can process each element independently 
- **Stateful**:distinct() may need to remember earlier values
- **Stateful**: sorted() needs to see all input before it can produce sorted output. 
- **stateful** operations can require extra memory or more processing 
- A pipeline of stateless operations is often easier to process in one pass.
## Why sorted() changes the flow 
- Example: filter words containing 'a', then sort, then uppercase the first result
- The filter may inspect every input words first 
- Sorting needs the complete set of surviving words
## Avoid interfering with the source 
- Do not modify the source collection while the pipeline is processing it 
- Changing the source during processing can cause errors on unpredictable behaviour 
- Prefer operations that return results rather than mutate the source

## Slicing:limit() and skip()
- limit(3) keeps at most the first three elements
- skip(3) ignores the first 3 elements and keeps the rest
## Mapping: map()
- map(fuction) applies a transformation to each element 
- Example
	- words.map(n->w.toUpperCase())
	- names.map(n->n.length())
## Peeking for debugging  
- peek() lets you inspect elements as they pass through a pipeline 
- it can print values before and after a filter or map 
- Useful for understanding what each stage receives 
- peek() runs only when the pipeline is actually consumed
- Do not use peek() as the main place for important program logic.