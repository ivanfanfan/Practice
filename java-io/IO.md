# I/O Streams
    A Stream is a sequence of data.
    A program uses an input stream to read data from a source, one item at a time
    A program uses an output stream to write data to a destination, one item at time.

## Byte Stream
    the int variable holds a byte value in its last 8 bits 0·255

## Character Streams
    the int variable holds a character value in its last 16bits,0~65535
    Character stream that use byte streams.
    byte-to-character bridge: InputStreamReader and OutputStreamWriter

---

## Buffered Streams
    BufferdInputStream
    BufferdOutputStream
    BufferedReader
    BufferedWriter
---
    Flushing Buffered Streams:
* It offen makes sense to write out a buffer at critical points, without
waiting for it to fill. This is known at flushing the buffer.
## Scanning and Formatting
**Scanner** API breaks input into individual tokens associated with
bits of data. By default, a scanner uses white space to separate tokens.
**formatting** API assembles data into nicely formatted, human-readable form.
- Stream objects that implement formatting are instances of either **PrintWriter**,
a character stream class, or **PrintStream**, a byte stream class.
 - 3.141593, +00000003.1415926536

| %                      | 1$             | +0    | 20    | .10       |f|
|------------------------|----------------|-------|-------|-----------|---|
| begin format specifier | argument index | flags | width | precision |conversion|
- Precision. For floating point values, this is the mathematical precision of the formatted value.
- width. The minimum width of the formatted value.


## I/O from the Command Line
## Data Streams

    Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values. 
All data streams implement either the DataInput interface or the DataOutput interface. 
## Object Streams