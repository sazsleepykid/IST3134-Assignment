import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
    int wordCount = 0; // Initialize a variable to hold the total count of occurrences for the current word.

    // Iterate through the values associated with the current key (word).
    for (IntWritable value : values) {
      wordCount += value.get(); // Accumulate the counts by adding up the individual IntWritable values.
    }

    // Emit the key (word) along with the total word count as the output.
    context.write(key, new IntWritable(wordCount));
  }
}
