# Comp305_Project_Group19

Our Problem : Decrypting efficiently the text found in Cappadocia
We have parts of the key to how to convert the letter and a small list of word pairs containing the original and new founded words.
We should convert all the letters in the first word to the parallel letter in the second word with the given translations.
There can be more than one translation or no translation for a letter.
Lengths of words should be equal. 

Our algorithm constructs a graph with adding each pair of transitions as a directed edge. This graph is represented as an adjacency list. (x number of edges in total)
The array in the adjacency list holds the integer casted value of the corresponding letter to be able to work with char data type.
The Algorithm:
Construct graph
Do the following for each word pair (y word pairs in total): If continue ends without printing no, print yes.
  If lengths are different, print no.
  Else, do the following for each letter pair (letters that have the same index);
    If same, continue.
    Else: do breadth first search to see if the letter from the first word can be transitioned to letter from the second word.
      If a connections is found, continue.
      Else: print no.
