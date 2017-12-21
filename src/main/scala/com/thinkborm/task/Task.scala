package com.thinkborm.task

import com.thinkborm.properties.TaskProperties
import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired

trait Task extends Serializable {
  @Autowired
  @transient
  var taskProperties: TaskProperties = _

  @Autowired
  @transient
  var spark: SparkSession = _

  def doTask()

  def setSpark(ss: SparkSession) : this.type= {
    spark = ss
    this
  }
}
