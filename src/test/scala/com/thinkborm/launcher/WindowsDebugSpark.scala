package com.thinkborm.launcher

import com.thinkborm.configuration.SparkConfiguration
import com.thinkborm.properties.TaskProperties
import com.thinkborm.task.TestTask
import org.apache.spark.sql.SparkSession
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.{ComponentScan, Import, PropertySource}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
/**
  * Created by zhouxianwei on 2017/12/8.
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringBootTest
@Import(Array(classOf[SparkConfiguration]))
@ComponentScan(basePackages = Array("com.thinkborm"))
//@PropertySource(Array("file:/the/file/location/thinkborm.properties"))
@PropertySource(Array("classpath:properties/thinkborm.properties"))
@EnableConfigurationProperties(Array(classOf[TaskProperties]))
class WindowsDebugSpark {
  System.setProperty("hadoop.home.dir", "e:/hadoop/winutils")
  val spark = SparkSession
      .builder()
      .appName(s"test_spark")
//            .enableHiveSupport()
      .config("spark.sql.warehouse.dir", "/data/spark-warehouse")
      .config("spark.master", "local")
      //      .config("spark.some.config.option", "some-value")
      .getOrCreate()
  spark.sparkContext.setLogLevel("INFO")
  @Test
  def test() = {
    new TestTask().setSpark(spark).doTask()
  }

}
