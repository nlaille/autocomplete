# Autocomplete

You are given a list of keywords below. Write code that will offer up to 4 suggested

“auto­complete” based on the letters typed (not case sensitive). Similar to Google

Autocomplete (example below), except that results must be in order vs. Google ranked

keywords.

Informations : [link](ex004-autocomplete.pdf)

# Usage

Simple autocomplete on file
```
$ gradle runSimple -Pfile=input/sample1.txt -Pquery=Prog
```

Indexed autocomplete on file
```
$ gradle runIndexed -Pfile=input/sample1.txt -Pquery=Prog
```


# Test

To test

```
$ gradle test
```