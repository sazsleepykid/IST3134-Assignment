import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    // Convert the input Text value into a regular Java String
    String line = value.toString();

    // Split the line into individual words using regular expression "\W+" which matches non-word characters
    // For example, it will split "Hello, world!" into ["Hello", "world"]
    for (String word : line.split("\\W+")) {
      // Check if the word has a non-zero length (i.e., it's not an empty string)
      if (word.length() > 0) {
        // Emit the word as a key and the value 1 to represent its occurrence (initial count)
        context.write(new Text(word), new IntWritable(1));
      }
    }
  }
}
