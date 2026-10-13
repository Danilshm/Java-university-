# Comparable vs Comparator
### Comparable<T'>  •  “My natural order”
Implemented by the type being compared
- Defines compareTo(...)
- Usually one natural ordering
- Example: the order defined by Song.compareTo(...)
## Comparator<T'>  •  “Use this rule”
- Separate object or behaviour
- Defines compare(a, b).
- Supports many custom orderings
- Example: by title, duration, or artist
### What does compare(a, b) return?
- Negative number(like -1). a<b. a should appear before b.
- Zero. They are equal.
- Positive number(like +1). a>b. a should appear after b.
---
### Code
```
public void sortPlaylist(Comparator<Song> comparator) {

    songlist.sort(comparator);
    
}
```
# Four ways to supply the same behaviour
## TOP-LEVEL CLASS
- Named + reusable
- Best when several classes need the same rule.
### Code
- A separate class file. Other classes can reuse it.
- Use it
	- playlist.sortPlaylist(new SongDurationComparator());
- Why choose it?
	- The class has a name and can be reused from multiple places.
```
public class SongDurationComparator

        implements Comparator<Song> {

    public int compare(Song s1, Song s2) {

        return Integer.compare(

            s1.getDuration(), s2.getDuration()); // shortest first

    }

}
```
## NAMED INNER CLASS
- Named + scoped to an outer class
- Useful when the rule belongs to one class.
### Code
- A named class nested inside the class that uses it.
- Scope
	- The named inner class belongs to the outer class; it is not a general-purpose top-level type.
- Reuse
	- You can create and use it more than once within the outer class.
```
public class PlayListApp {

    // main / demo code ...

    private class SongDurationReverseComparator

            implements Comparator<Song> {

        public int compare(Song a, Song b) {

            return Integer.compare(

                b.getDuration(), a.getDuration()); // longest first

        }

    }

}
```
#### A useful distinction: inner vs local
- Both are nested, but the place where you declare them changes their scope.

- Named inner class
	- Declared directly inside another class, but outside a method.
	- Can be used by methods of the outer class (subject to access).
- Local class
	- Declared inside a method or block.
	- Available only within that method/block after its declaration.
## ANONYMOUS CLASS
- No class name; defined where used
- Useful for a one-off implementation.
### Code 
- No class name: create the implementation exactly where you need it.
- Why “anonymous”?
	- There is no declared class name such as ArtistComparator.
- When useful?
	- When the implementation is only needed at this point in the code.
```
playlist.sortPlaylist(new Comparator<Song>() {

    public int compare(Song a, Song b) {

        return a.getArtist().compareTo(

            b.getArtist());

    }

});
```
## LAMBDA
- Compact behaviour
- Usually preferred for a one-method interface.
### Code 
- A compact way to provide behaviour for a functional interface.
```
playlist.sortPlaylist(

    (a, b) -> a.getArtist().compareTo(b.getArtist())

);

```
### Why lambdas work: functional interfaces
- A functional interface has exactly one abstract method to implement.
- Comparator<T'>
	- One abstract method:
	- int compare(T a, T b)
	- A lambda supplies this method’s behaviour.
## Ascending ↔ descending
- You can reverse a Comparator instead of rewriting the comparison logic.
```
Comparator<Song> byArtist =

    (a, b) -> a.getArtist().compareTo(b.getArtist());
    
    playlist.sortPlaylist(byArtist.reversed());
```
## Where does naturalOrder() fit?
- The lab’s Functional Interfaces section revisits sorting through Comparator’s built-in methods.
```
songlist.sort(Comparator.naturalOrder());

songlist.sort(Comparator.reverseOrder()); // same thing but reversed
```