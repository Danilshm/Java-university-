# List, set, map
- Why use it?
	- Reusable structures and useful operations - less code to write.
## List
- Order matters
- Duplicates are allowed
- Access by position 
- Example:
	- ["Math", "Java", "Math"]
- Java example
```
List<String> modules = new ArrayList<>();
modules.add("Math");
modules.add("java");
```
### ArrayList vs LinkedList
#### **ArrayList**
- Like numbered seats in a row
- Fast access item 25 directly
- Middle insertions/removals may shift later items
```
List<String> names = new ArrayList<>();
```
#### **LinkedList**
- Like a chain of connected links
- Insertions/removals can be convenient once at the position 
- Finding item 25 requires traveling through nodes
```
List<String> names2 = new LinkedList<>();
```
#### **Simple rule**
- frequent indexed access - often ArrayList
- Lots of edits near known positions - consider LinkedList

## Set — keep only unique items
- If the same person scans their ticket twice, you still want one attendee entry.
```
Set<String> attendees = new HashSet<>();
attendees.add("Amina");
attendees.add("Leo");
```
- A Set prevents duplicates. A HashSet does not promise a particular iteration order.
### How does HashSet check duplicates?
1) Hash Code
- A quick way to decide which bucket to check.
2) Bucket
- Objects with matching hash codes may land in the same bucket.
3) equals()
- Java checks equality to determine whether an equal element is already present.
### TreeSet
- TreeSet needs elements that can be compared (Comparable) or a Comparator supplied.
- You want no duplicate entries and a predictable sorted order.
```
Set<String> names = new TreeSet<>();
names.add("Zara");
names.add("Ari");
names.add("Mika");
// Iteration: Ari, Mika, Zara
```
## Map - connect a key to a value 
- Keys must be unique. Values may repeat. Adding an existing key replaces its mapped value.
```
Map<String, Integer> scores = new HashMap<>();

scores.put("Amina", 92);

scores.put("Leo", 84);

int mark = scores.get("Amina");
```
Name → phone number
Student ID → student record
Product code → price