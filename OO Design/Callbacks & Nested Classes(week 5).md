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
### Code
```
public void sortPlaylist(Comparator<Song> comparator) {

    songlist.sort(comparator);
    
}
```
