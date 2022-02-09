package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class mapreduce {

	public static class salesMapper extends Mapper<Object, Text, Text, Text> {

		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			if (value.toString().contains("기준_년_코드"))  //Column Name Delete
				return;

			String[] columns = value.toString().split(","); //CSV 구분자 설정
			// 칼럼별 변수 설정
			String Year = columns[0];
			String Quarter = columns[1];
			String Commercial = columns[2];
			String Service = columns[3];
			String Quarter_sales = columns[4];
			String Weekday_sales = columns[5];
			String Weekend_sales = columns[6];
			String mon_sales = columns[7];
			String tue_sales = columns[8];
			String wed_sales = columns[9];
			String thu_sales = columns[10];
			String fri_sales = columns[11];
			String sat_sales = columns[12];
			String sun_sales = columns[13];
			String sales_0006 = columns[14];
			String sales_0611 = columns[15];
			String sales_1114 = columns[16];
			String sales_1417 = columns[17];
			String sales_1721 = columns[18];
			String sales_2124 = columns[19];

			String Store_count = columns[20];
			context.write(new Text(Year + " " + Quarter + " " + Commercial + " " + Service), //key
					new Text(Quarter_sales + "_" + Weekday_sales + "_" + Weekend_sales + "_" + mon_sales + "_"
							+ tue_sales + "_" + wed_sales + "_" + thu_sales + "_" + fri_sales + "_" + sat_sales + "_"
							+ sun_sales + "_" + sales_0006 + "_" + sales_0611 + "_" + sales_1114 + "_" + sales_1417
							+ "_" + sales_1721 + "_" + sales_2124 + "_" + Store_count)); //value

		}
	}

	// 리듀스
	public static class salesReducer extends Reducer<Text, Text, Text, Text> {

		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			//집계 데이터를 만들기 위한 변수 선언
			double Quarter_sales_sum = 0;
			double Weekday_sales_sum = 0;
			double Weekend_sales_sum = 0;
			double mon_sales_sum = 0;
			double tue_sales_sum = 0;
			double wed_sales_sum = 0;
			double thu_sales_sum = 0;
			double fri_sales_sum = 0;
			double sat_sales_sum = 0;
			double sun_sales_sum = 0;
			double sales_0006_sum = 0;
			double sales_0611_sum = 0;
			double sales_1114_sum = 0;
			double sales_1417_sum = 0;
			double sales_1721_sum = 0;
			double sales_2124_sum = 0;
			int Store_count = 0;
			//칼럼별 매출 집계하기
			for (Text value : values) {
				String[] split_value = value.toString().split("_");
				Quarter_sales_sum += Double.parseDouble(split_value[0]);
				Weekday_sales_sum += Double.parseDouble(split_value[1]);
				Weekend_sales_sum += Double.parseDouble(split_value[2]);
				mon_sales_sum += Double.parseDouble(split_value[3]);
				tue_sales_sum += Double.parseDouble(split_value[4]);
				wed_sales_sum += Double.parseDouble(split_value[5]);
				thu_sales_sum += Double.parseDouble(split_value[6]);
				fri_sales_sum += Double.parseDouble(split_value[7]);
				sat_sales_sum += Double.parseDouble(split_value[8]);
				sun_sales_sum += Double.parseDouble(split_value[9]);
				sales_0006_sum += Double.parseDouble(split_value[10]);
				sales_0611_sum += Double.parseDouble(split_value[11]);
				sales_1114_sum += Double.parseDouble(split_value[12]);
				sales_1417_sum += Double.parseDouble(split_value[13]);
				sales_1721_sum += Double.parseDouble(split_value[14]);
				sales_2124_sum += Double.parseDouble(split_value[15]);
				Store_count += Integer.parseInt(split_value[16]);
			}
			context.write(key,
					new Text((int) Quarter_sales_sum + "_" +(int) Weekday_sales_sum + "_" +(int) Weekend_sales_sum + "_"
							+(int) mon_sales_sum + "_" +(int) tue_sales_sum + "_" +(int) wed_sales_sum + "_" +(int) thu_sales_sum + "_"
							+(int) fri_sales_sum + "_" +(int) sat_sales_sum + "_" +(int) sun_sales_sum + "_" +(int) sales_0006_sum + "_"
							+(int) sales_0611_sum + "_" +(int) sales_1114_sum + "_" +(int) sales_1417_sum + "_" +(int) sales_1721_sum + "_"
							+(int) sales_2124_sum + "_" +(int) Store_count)); // 집계 데이터
//			context.write(key,
//					new Text(String.format("%f", Quarter_sales_sum) + "_" + String.format("%f", Weekday_sales_sum)));

		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Sales Main");
		job.setJarByClass(salesmain.class);
		job.setMapperClass(salesMapper.class);
		job.setCombinerClass(salesReducer.class);
		job.setReducerClass(salesReducer.class);
		job.setOutputKeyClass(Text.class); //output되는 hdfs의 key : 문자열 선언
		job.setOutputValueClass(Text.class); //output되는 value의 key : 문자열 선언 - 추후에 long형으로 변환 예정
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}
}
