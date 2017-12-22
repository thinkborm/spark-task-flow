package com.thinkborm.task

import com.thinkborm.properties.TaskProperties
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired

trait Task extends Serializable { self =>
  @Autowired
  @transient
  var taskProperties: TaskProperties = _

  @Autowired
  @transient
  var spark: SparkSession = _

  protected object taskImplicits extends SQLImplicits {
    protected override def _sqlContext: SQLContext = self.spark.sqlContext
  }


  def doTask()

  def setSpark(ss: SparkSession) : this.type= {
    spark = ss
    this
  }
}
