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
