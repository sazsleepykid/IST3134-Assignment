**MapReduce Word Count Assignment**
This repository contains a simple implementation of the MapReduce programming model using Java and Python. The example focuses on a word count task, which is a common introductory problem in learning MapReduce. 
The project is structured to demonstrate how to set up and execute a MapReduce job in Hadoop, as well as a Python implementation for comparison.

**Project Structure**
-WordMapper.java: The Mapper class takes input text data, breaks it into words, and outputs key-value pairs where the key is a word and the value is 1.
-SumReducer.java: The Reducer class takes key-value pairs produced by the Mapper, sums the counts for each word, and outputs the total occurrences of each word.
-WordCount.java: This is the main class that sets up the Hadoop job and initiates the MapReduce process. It specifies input and output paths and the Mapper and Reducer classes.
python-mapreduce.ipynb: A Jupyter notebook that implements the word count logic in Python, reading data from a CSV file, performing the map and reduce functions, and displaying the output.

**Requirements**
To run the Java code, you will need:
**Java 8 or higher**
Hadoop 2.x or higher_

To run the Python notebook, you will need:
**Python 3.x**
Jupyter Notebook
Pandas library_

**Running the Java Code**
Compile the Java code:
_javac -cp `hadoop classpath` WordMapper.java SumReducer.java WordCount.java

Create a jar of the compiled classes:
__jar cf wc.jar *.class_

Run the MapReduce job:
_hadoop jar wc.jar WordCount /path/to/input /path/to/output_

Running the Python Notebook
Open the notebook in Jupyter:
_jupyter notebook python-mapreduce.ipynb_
Run the cells in the notebook to perform the word count.

License
This project is open source and available under the MIT License.

