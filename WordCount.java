import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class WordCount {

  public static void main(String[] args) throws Exception {
    // Check if the correct number of command-line arguments is provided
    if (args.length != 2) {
      System.out.printf("Usage: WordCount <input dir> <output dir>\n");
      System.exit(-1);
    }

    // Create a new Hadoop Job
    Job job = new Job();

    // Set the main class for the job (this class itself) for Hadoop to identify the jar file
    job.setJarByClass(WordCount.class);

    // Set a descriptive name for the job
    job.setJobName("Word Count");

    // Set the input and output paths for the job based on the command-line arguments
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    // Specify the Mapper and Reducer classes for the job
    job.setMapperClass(WordMapper.class);
    job.setReducerClass(SumReducer.class);

    // Set the data types of the output key and value of the Mapper and Reducer
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    // Submit the job for execution and wait for its completion
    boolean success = job.waitForCompletion(true);

    // Exit the program with an appropriate exit code (0 for success, 1 for failure)
    System.exit(success ? 0 : 1);
  }
}
