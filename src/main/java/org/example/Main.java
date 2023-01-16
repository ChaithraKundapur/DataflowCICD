package org.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.bigquery.TableRowJsonCoder;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
// import org.apache.beam.sdk.io.jdbc.JdbcIO;
// import org.example.MyOptions;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import org.apache.beam.sdk.PipelineResult;



public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static TableSchema schema;
    public static TableSchema mySchema;
    public static  String maxCreatedDate;
    public static String newMaxDate;
    

    public static void main(String[] args) {
   


        //PipelineOptionsFactory.register(MyOptions.class);
        MyOptions options = PipelineOptionsFactory.fromArgs(args)
                                    .withValidation()
                                    .as(MyOptions.class);
        Pipeline p2 = Pipeline.create(options);
        p2.apply(TextIO.read().from("gs://dataeng01/Mytext"));
        p2.run();
        


    }
}
