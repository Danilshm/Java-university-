# A functional interface: 
## One abstract job
- Interfaces describe a behaviour contract. A functional interface has exactly one abstract method.
#### The contract
- The method signature tells us the input and output.
#### The shortcut
- A lambda can provide the implementation when Java knows the target interface.
#### Familiar example
- Comparator<T'> has compare(T, T) → int.
## Code 
```
@FunctionalInterface
interface PlayRule {

    boolean shouldKeep(Song song);
}
// One abstract method = one behaviour
PlayRule upbeatOnly =

    song -> song.getDuration() < 240;
```

# A lambda needs a target type
- A lambda is not floating around with a standalone type: the expected functional interface gives it meaning.
### Input
- Parameter types must match the abstract method.
### Output
- The body must return a compatible result—or return nothing for a void method.
### Code
```
Predicate<Song> shortTrack =

    song -> song.getDuration() < 240;

// Predicate<Song>.test(Song) -> boolean

boolean keep = shortTrack.test(

    new Song("Awara Hoon", "Mukesh", 189)

);
```
## Treat behaviour like data
- Instead of passing only a number or object, you can pass a rule that another method uses later.
### Ordinary argument
- Pass a value: 240, "Mukesh", or a Song.
### Behaviour argument
- Pass a condition, transformation or action.
### Callback
- The receiving method decides when to invoke the supplied behaviour.
### Code 
```
Predicate<Song> underFourMinutes =
    s -> s.getDuration() < 240;

playlist.stream()

        .filter(underFourMinutes)

        .forEach(System.out::println);
```
## Lambda anatomy: input → action → result
### Parameters
- What arrives at the behaviour.
### Arrow →
- Separates input from implementation.
### Body 
- One expression, or a block of statements.
### Code
```
// Full form

(Song s) -> {

    return s.getDuration() >= 240;

}

// Read it aloud:

// "Given a song, is it at least 4 minutes?"
```
## Less syntax, same meaning
- Java can infer parameter types from the target interface. A single parameter can omit parentheses.
### Full
- (Song s) -> { return s.getDuration() < 240; }
### Shorter
- s -> s.getDuration() < 240
### Void action
- s -> System.out.println(s.getTitle())
### Code
```
Predicate<Song> shortTrack =

    (Song s) -> {

        return s.getDuration() < 240;

    };

Predicate<Song> sameRule =

    s -> s.getDuration() < 240;
```
## Closures: a lambda can remember a value
### Allowed
- Read a local variable that is never reassigned.
### Not Allowed
- Reassign a captured local variable inside or outside the lambda.
### Scope 
- Lambdas do not create a new local-variable scope in the same way as an inner class.
## Choose a lambda by matching the contract
- The interface's single abstract method tells you the required parameters and return type.
### Predicate<T'>
- T → boolean  
- Question: should this song stay?
### Consumer<T'>
- T → void  
- Action: print this song
### Function<T,R>
- T → R  
Transformation: Song → title.
### Code
```
// Read the target type first

Predicate<Song> keep = s -> s.getDuration() < 240;

Consumer<Song> show = s -> System.out.println(s);

Function<Song, String> title = s -> s.getTitle();
```
## Predicate: filter the playlist
- A Predicate answers a yes/no question. Stream.filter keeps elements for which test(...) returns true.
### Input
- One Song at a time.
### Decision 
- true → keep it; false → discard it from this result.
### Code
```
Predicate<Song> shortTrack =

    s -> s.getDuration() < 240;

List<Song> shortSongs = playlist.stream()

    .filter(shortTrack)

    .toList();

// Sample data: Jimmy Jimmy Jimmy Aaja, Awara Hoon
```
## Consumer: do something with each song
- Consumer<T'> accepts a value and returns no result. It is designed for actions.
### Input
- One Song.
### Action 
- Print it, log it, or update a display.
### No return
- The functional method accept(T) returns void.
### Code
```
Consumer<Song> printSong =

    s -> System.out.println(

        s.getTitle() + " — " + s.getArtist()

    );

playlist.forEach(printSong);
```

## Where can a lambda live?
- A lambda can appear directly in a method call or be assigned to a variable with an explicit functional-interface type.
### Inline 
- Quick rule used once.
### Named variable 
- A rule you want to reuse or explain clearly.
### Code 
```
// Method invocation context

playlist.stream()

    .filter(s -> s.getDuration() < 240);

// Assignment context

Predicate<Song> shortTrack =

    s -> s.getDuration() < 240;
```
## Name it once. Reuse it everywhere.
- Duplicating the same lambda makes later changes harder. Give reusable behaviour a meaningful name.
### Less duplication 
- One definition to update.
### Clear intent
- shortTrack says more than a long inline condition.
### Code
```
Predicate<Song> shortTrack =

    s -> s.getDuration() < 240;

List<Song> shortSongs = playlist.stream()

    .filter(shortTrack).toList();

long shortCount = playlist.stream()

    .filter(shortTrack).count();
```
## Primitive specialisations: avoid boxing
- Generic interfaces use reference types. Primitive specialisations can avoid converting between a primitive and its wrapper.
### Generic form 
- Predicate<Integer'> receives an Integer.
### Primitive form 
- IntPredicate receives an int.
### Why care?
- It can avoid boxing/unboxing in suitable code; choose it when it fits the API.
### Code
```
Predicate<Integer> genericEven =

    i -> i % 2 == 0;

IntPredicate primitiveEven =

    i -> i % 2 == 0;

System.out.println(primitiveEven.test(100)); // true
```
## Primitive predicates: same question, primitive input
- Use the specialisation that matches the primitive input type.
### IntPredicate 
- int → boolean
### LongPredicate
- long → boolean
### DoublePredicate 
- double → boolean
```
IntPredicate even = i -> i % 2 == 0;

System.out.println(even.test(100)); // true

IntPredicate odd = i -> i % 2 != 0;

System.out.println(odd.test(100));  // false
```

## Function and BiFunction: transform values
- Function takes one input; BiFunction takes two. Both return a result.
### Function<T,R>
- One input → one result.
### BiFunction<T,U,R>
- Two inputs → one result.
### Code
```
Function<Integer, Integer> addFive =

    x -> x + 5;

BiFunction<Integer, Integer, Integer> add =

    (x, y) -> x + y;

System.out.println(addFive.apply(7)); // 12

System.out.println(add.apply(4, 3)); // 7
```
## More useful building blocks
- UnaryOperator is a Function where input and output types are the same.
### UnaryOperator<Double'>
- double value in → double value out (wrapper type here).
### Predicate<Song'>
- Tests a song condition.
### Consumer<Song'>
- print
### Code
```
UnaryOperator<Double> squared = x -> x * x;

Predicate<Song> startsWithM =

    s -> s.getTitle().startsWith("M");

Consumer<Song> printDuration =

    s -> System.out.println(s.getDuration());
```
## Call the functional method
- A functional interface variable behaves like an object with a method: apply, test, accept or get.
### apply()
- Function / BiFunction / Operator
### test()
- Predicate
### accept()
- Consumer
## Or pass the function to another method
- Streams accept functional interfaces so they can apply your behaviour to elements.
### map(Function)
- TRansfrom each element
### filter(Predicate)
- Keep matching elements.
### anyMatch(Predicate)
- Ask whether at least one element matches.
### Code
```
List<String> titles = playlist.stream()

    .map(Song::getTitle)

    .toList();

boolean hasShortSong = playlist.stream()

    .anyMatch(s -> s.getDuration() < 200);
```
## Stream.of: create a tiny test dataset
- Small streams are useful for checking behaviour before applying it to a full collection.
### Numbers
- Stream.of(1, 2, 3, 4, 5)
### Strings
- Stream.of("apple", "pear", "banana")
### Songs 
- Stream.of(songA, songB, songC)
### Code
```
Stream.of("Jimmy Jimmy Jimmy Aaja",

            "Awara Hoon",

            "Zooby Zooby")

    .filter(title -> title.length() < 12)

    .forEach(System.out::println);
    
```
## From a fixed rule to a reusable rule
- Hard-coding a letter makes a predicate inflexible. A Function can create a predicate for whichever letter is supplied.
### Fixed
- startsWithM only checks M.
### Configurable
- startsWith("J") or startsWith("Z") creates a new rule.
### Code
```
Function<String, Predicate<Song>> startsWith =

    letter -> song -> song.getTitle().startsWith(letter);

Predicate<Song> startsWithJ = startsWith.apply("J");

Predicate<Song> startsWithZ = startsWith.apply("Z");
```
## Higher-order functions: functions that work with functions
- A method is higher-order when it accepts a function, returns one, or both.
### Pass one in 
- stream.filter(predicate)
### Return one 
- startsWith("M") returns a Predicate<Song'>.
### Compose
- Combine smaller behaviours to build richer behaviour.
## What does listMap do?
- It applies the supplied Function to each input element and collects the results in a new list.
### Input
- List<String'>: apple, kiwi, banana
### Rule
- s -> s.length()
### Output 
- List<Integer'>: 5, 4, 6
### Code
```
static <T, R> List<R> listMap(

        List<T> list, Function<T, R> f) {

    List<R> result = new ArrayList<>();

    for (T item : list) {

        result.add(f.apply(item));

    }

    return result;

}

// listMap(words, s -> s.length())
```
## Method references: when the lambda just forwards
- If a lambda only calls an existing method with the same input and output, a method reference may be clearer.
### Lambda
- song -> song.getDuration()
### Method reference
- Song::getDuration
### Rule of thumb
- Use it when no extra transformation is needed.
### Code
```
ToIntFunction<Song> duration =

    Song::getDuration;

// Equivalent lambda:

// song -> song.getDuration()
```
## Three kinds of method references
- Read the reference around `::`: the left side tells you the class or object; the right side names the method.
### Static method 
- Integer::parseInt
### Arbitrary object's instance method
- String::length
### Existing object's instance method
- System.out::println
### Code
```
// Static method

Function<String, Integer> parse = Integer::parseInt;

// Instance method on the incoming object

ToIntFunction<String> length = String::length;

// Existing object

Consumer<Song> show = System.out::println;
```
## Follow the parameters
- Method references work when Java can map the functional method's parameters to the referenced method.
### Static
- Both inputs are passed to the static method.
### Arbitrary instance
- First input is the target object; remaining inputs become method arguments.
### Existing instance
- Inputs are passed to the already named object’s method.
### Code
``` 
// (x, y) -> Integer.compare(x, y)

BiFunction<Integer, Integer, Integer> cmp =

    (x, y) -> Integer.compare(x, y);

// Method reference version uses a compatible

// functional type such as Comparator<Integer>:

Comparator<Integer> comparator = Integer::compare;
```