package com.thinkborm.configuration

import com.thinkborm.properties.TaskProperties
import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}


@Configuration
class SparkConfiguration {

  @Autowired
  @transient
  var taskProperties: TaskProperties = _

  @Bean
  def spark(): SparkSession = {
    val spark = SparkSession
      .builder()
      .appName(this.taskProperties.getName)
      .enableHiveSupport()
      .config("spark.master", "yarn")
      //      .config("spark.dynamicAllocation.enabled", "false")
      .getOrCreate()
    //    sqlContext.setConf("spark.sql.inMemoryColumnarStorage.compressed", "true")
    //    sqlContext.setConf("spark.sql.parquet.compression.codec", "gzip")
    //    sqlContext.setConf("spark.sql.inMemoryColumnarStorage.batchSize", "10000")
    //    sqlContext.setConf("spark.sql.autoBroadcastJoinThreshold", (10 * 1024 * 1024).toString)
    //    spark.conf
    spark
  }
}
