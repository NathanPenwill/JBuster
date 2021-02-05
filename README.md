# JBuster
A rapid, multithreaded directory brute forcer written in Java
## Usage
```
java -jar JBuster-1.0.0.jar https://example.com/
```
Then, create a `.txt` file named `dirs.txt` and list out the directories you want to attempt

e.g.
```
index.html
robots.txt
favicon.ico
```
JBuster will then ping each of directories to see if they exist, then log the results in console and save them to `results.txt`
### Optional arguments
- Custom dirs.txt path
- Custom results.txt path

e.g.
```
java -jar JBuster-1.0.0.jar https://example.com/ directories.txt directoryresults.txt
```
